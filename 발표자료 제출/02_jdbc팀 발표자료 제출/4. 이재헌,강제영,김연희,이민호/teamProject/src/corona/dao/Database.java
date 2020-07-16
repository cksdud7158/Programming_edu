package corona.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import corona.exception.DuplicateSSNException;
import corona.exception.RecordNotFoundException;
import corona.vo.Hospital;
import corona.vo.Infectee;
import corona.vo.Person;
import corona.vo.Visit;

public class Database implements DatabaseTemplate {
	/* ====================  드라이버 로딩 ====================================*/
	public Database(String serverIp) throws ClassNotFoundException {
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("Drive Loading Success..");
	}
	/* ====================  공통로직 ====================================*/
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("Database Connection......");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		closeAll(ps, conn);
		if(rs!=null) rs.close();
	}
	
	/* ====================  비지니스로직 ====================================*/
	// 각 로직마다 번호를 매겨서 검색에 편안하게 하겠습니다. 템프릿 보고 해당 번호를 검색하시면 될 거에요
	
	//B1 : Person 테이블에 추가
	@Override
	public void addPeople(Person p) throws SQLException, DuplicateSSNException {
		Connection conn = getConnect();
		PreparedStatement ps = null;
		String sql = "SELECT ssn FROM person WHERE ssn=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, p.getSsn());
		ResultSet rs = ps.executeQuery();
		try {
			if (!rs.next()) {
				sql = "INSERT INTO person(ssn, name, address1, address2, age, gender, test_condition, isolation, country) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, p.getSsn());
				ps.setString(2, p.getName());
				ps.setString(3, p.getAddress1());
				ps.setString(4, p.getAddress2());
				ps.setInt(5, p.getAge());
				ps.setString(6, p.getGender());
				ps.setString(7, p.getTest_condition());
				ps.setString(8, p.getIsolation());
				ps.setString(9, p.getCountry());
				System.out.println(ps.executeUpdate() + "명 추가되었습니다.");
			} else {
				throw new DuplicateSSNException();
			}
		} finally {
			closeAll(rs, ps, conn);
		}
	}
	
	//B2 : 일일확진자수 조회
	@Override
	public int todayInfectee() throws SQLException {
		// 일일확진자수
		Connection conn = getConnect();
		String sql = "SELECT COUNT(in_hospital) FROM infectee WHERE in_hospital = curdate()";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int num = 0;
		try {
			if (rs.next()) {
				num = rs.getInt("COUNT(in_hospital)");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return num;
	}

	// B3 : 일일완치자수
	@Override
	public int todayTreated() throws SQLException {
		// 일일완치자수
		Connection conn = getConnect();
		String sql = "SELECT COUNT(treatDate) FROM infectee WHERE treatDate = curdate()";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int num = 0;
		try {
			if (rs.next()) {
				num = rs.getInt("COUNT(treatDate)");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return num;
	}

	// B4 : 일일사망자
	@Override
	public int todayDeath() throws SQLException {
		// 일일 사망자수
		Connection conn = getConnect();
		String sql = "SELECT COUNT(deathDate) FROM infectee WHERE deathDate = curdate()";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int num = 0;
		try {
			if (rs.next()) {
				num = rs.getInt("COUNT(deathDate)");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return num;
	}

	// B5 : 누적확진자
	@Override
	public int totalInfectee() throws SQLException {
		// 누적확진자
		Connection conn = getConnect();
		String sql = "SELECT COUNT(infectee_num) FROM infectee";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int num = 0;
		try {
			if (rs.next()) {
				num = rs.getInt("COUNT(infectee_num)");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return num;
	}

	// B6 : 누적완치자s
	@Override
	public int totalTreated() throws SQLException {
		// 누적완치자
		Connection conn = getConnect();
		String sql = "SELECT COUNT(treatDate) FROM infectee";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int num = 0;
		try {
			if (rs.next()) {
				num = rs.getInt("COUNT(treatDate)");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return num;
	}

	// B7 : 누적사망자
	@Override
	public int totalDeath() throws SQLException {
		// 누적사망자
		Connection conn = getConnect();
		String sql = "SELECT COUNT(deathDate) FROM infectee";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int num = 0;
		try {
			if (rs.next()) {
				num = rs.getInt("COUNT(deathDate)");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return num;
	}

	// B8 : 누적사망률
	@Override
	public float totalDeathRate() throws SQLException {
		// 누적사망률
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int totalDeathRate = 0;

		try {
			conn = getConnect();
			String query = "select count(deathDate)*100/count(infectee_num) totalDeathRate from infectee";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			if (rs.next()) {
				totalDeathRate = rs.getInt("totalDeathRate");
			}

		} finally {
			closeAll(rs, ps, conn);
		}

		return totalDeathRate;
	}
	
	// B9 : 치료중인원수
	@Override
	public int treating() throws SQLException {
	// 치료중인원수
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int treating = 0;

		try {
			conn = getConnect();
			String query = "select (count(in_hospital)-count(treatDate)-count(deathDate)) treating from infectee";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			if (rs.next()) {
				treating = rs.getInt("treating");
			}

		} finally {
			closeAll(rs, ps, conn);
		}

		return treating;
	}
	
	// B10 : 누적검사수
	@Override
	public int totalTest() throws SQLException {
		// 누적검사수
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int treatDate = 0;

		try {
			conn = getConnect();
			String query = "select count(test_condition) test_condition from person;";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			if (rs.next()) {
				treatDate = rs.getInt("test_condition");
			}

		} finally {
			closeAll(rs, ps, conn);
		}

		return treatDate;
	}
	
	// B11 : 누적검사완료수
	@Override
	public int totalTestDone() throws SQLException {
		// 누적 검사 완료수
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int totalTestDone = 0;
		try {

			conn = getConnect();
			String query = "select count(datediff(now(), test_condition)) totalTestDone from person where datediff(now(), test_condition) > 2";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			if (rs.next()) {
				totalTestDone = rs.getInt("totalTestDone");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return totalTestDone;
	}

	// B12 : 누적확진률 : 누적확진수/누적검사완료수 * 100
	@Override
	public float totalInfecteeRate() throws SQLException {
		// 누적확진률
		float totalInfecteeRate;
		return totalInfectee() * 100 / totalTestDone();
	}

	// B13 : 지역발생확진자 
	@Override
	public int localInfectee() throws SQLException {
	// 지역발생확진자
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int localInfectee = 0;
		try {

			conn = getConnect();
			String query = "select count(infectee_num) localInfectee from infectee where Infection_route = '지역'";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			if (rs.next()) {
				localInfectee = rs.getInt("localInfectee");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return localInfectee;
	}
	
	// B14 : 해외발생확진자수
	@Override
	public int foreignInfectee() throws SQLException {
		// 해외발생확진자수
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int foreignInfectee = 0;
		try {

			conn = getConnect();
			String query = "select count(infectee_num) foreignInfectee from infectee where Infection_route = '해외'";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			if (rs.next()) {
				foreignInfectee = rs.getInt("foreignInfectee");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return foreignInfectee;
	}

	// B15 : 광역시도별확진자
	@Override
	public int infecteeInCertainCity(String address1) throws SQLException {
		// 시도별확진자
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int infecteeInCertainCity = 0;

		try {
			conn = getConnect();
			String query = "select count(infectee_num) infecteeInCertainCity  from infectee, person where infectee.person_ssn = person.ssn and person.address1 = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, address1);
			rs = ps.executeQuery();

			if (rs.next()) {
				infecteeInCertainCity = rs.getInt("infecteeInCertainCity");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return infecteeInCertainCity;
	}

	//B16 : 시구군별 확진자 
	@Override
	public int infecteeInCertainCity(String address1, String address2) throws SQLException {
		// 시도별확진자
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int infecteeInCertainCity = 0;

		try {
			conn = getConnect();
			String query = "select count(infectee_num) infecteeInCertainCity  from infectee, person where infectee.person_ssn = person.ssn and person.address1 = ? and person.address2 = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, address1);
			ps.setString(2, address2);
			rs = ps.executeQuery();

			if (rs.next()) {
				infecteeInCertainCity = rs.getInt("infecteeInCertainCity");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return infecteeInCertainCity;
	}

	// B17 : 특정환자 동선 검색(지역 몇번 확진자)
	@Override
	public ArrayList<Visit> searchAllTrace(String address1, String address2, int num) throws SQLException {
		// 특정환자 동선 검색(지역 몇번 확진자)
		int infectee_num = certainCityInfecteeNumToInfecteeNum(address1, address2, num);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Visit> AllTrace = new ArrayList<>();

		try {
			conn = getConnect();
			String query = "select place.address, place.name, visits.visitDate, ifnull(visits.cleanDate, 0) cleanDate from visits, place where visits.address = place.address and infectee_num = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, infectee_num);
			rs = ps.executeQuery();

			while (rs.next()) {
				Visit visit = new Visit(rs.getString("address"), rs.getString("name"),
						certainCityInfecteeNumToSsn(address1, address2, num), rs.getString("visitDate"),
						rs.getString("cleanDate"));
				AllTrace.add(visit);
			}

		} finally {

		}
		return AllTrace;
	}
	//2안
	/* public ArrayList<Place> searchAllTrace(int num) throws SQLException,RecordNotFoundException { //확진자 조회라서 인자값 "int num"으로 수정합니다.
         Connection conn = null;
         PreparedStatement ps = null;
         ResultSet rs = null;
         ArrayList<Place> list = new ArrayList<>();
         try {
            conn=getConnect();
            if(isExistinInfecteeWithNum(num, conn)) {
                String query = "select p.address, p.name from infectee as i , place as p , visits as v where i.infectee_num = ? and i.infectee_num = v.infectee num and v.address = p.adress;";
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                
                while(rs.next()) {
                    list.add(new Place(rs.getString("address"),rs.getString("name")));
                }
                
            }else {
                throw new RecordNotFoundException("확진자가 아닙니다.");
            }
        } finally {
            closeAll(rs,ps,conn);
        }
        return list;
    }*/
	// B18 : 특정환자 동선 검색(ssn으로 검색)
		@Override
		public ArrayList<Visit> searchAllTrace(int ssn) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<Visit> AllTrace = new ArrayList<>();

			try {
				conn = getConnect();
				String query = "select place.address, place.name, visits.visitDate, ifnull(visits.cleanDate, 0) cleanDate from visits, place where visits.address = place.address and visits.infectee_num = (select infectee_num from infectee where Person_ssn = ?)";
				ps = conn.prepareStatement(query);
				ps.setInt(1, ssn);
				rs = ps.executeQuery();

				while (rs.next()) {
					Visit visit = new Visit(rs.getString("address"), rs.getString("name"), ssn, rs.getString("visitDate"),
							rs.getString("cleanDate"));
					AllTrace.add(visit);
				}

			} finally {

			}
			return AllTrace;
		}

		// B19 : 모든 방역 내역
	@Override
	public ArrayList<Visit> isCleaned() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Visit> AllTrace = new ArrayList<>();

		try {
			conn = getConnect();
			String query = "select place.address, place.name, infectee.person_ssn, visits.visitDate, ifnull(visits.cleanDate, 0) cleanDate from visits, place, infectee where visits.address = place.address and visits.infectee_num = infectee.infectee_num";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Visit visit = new Visit(rs.getString("address"), rs.getString("name"), rs.getInt("person_ssn"),
						rs.getString("visitDate"), rs.getString("cleanDate"));
				AllTrace.add(visit);
			}

		} finally {
			closeAll(rs, ps, conn);
		}

		return AllTrace;
	}
		
	// B20 : 특정 확진자가 간 곳의 방역 여부
	@Override
	public ArrayList<Visit> isCleaned(int ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Visit> AllTrace = new ArrayList<>();

		try {
			conn = getConnect();
			String query = "select place.address, place.name, visits.visitDate, ifnull(visits.cleanDate, 0) cleanDate from visits, place where visits.address = place.address and visits.infectee_num = (select infectee_num from infectee where Person_ssn = ?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, ssn);
			rs = ps.executeQuery();
			while (rs.next()) {
				Visit visit = new Visit(rs.getString("address"), rs.getString("name"), ssn, rs.getString("visitDate"),
						rs.getString("cleanDate"));
				AllTrace.add(visit);
			}

		} finally {
			closeAll(rs, ps, conn);
		}

		return AllTrace;
	}

	
	
	//B21 : Person 테이블 조회
	@Override
	public Person searchPeople(int ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person person = null;
		try {
			conn = getConnect();

			if (isExistinInfectee(ssn, conn)) {

				String query = "select person.ssn, person.name, person.address1, person.address2, person.age, person.gender, ifnull(person.intecter,0) intecter, ifnull(person.test_condition,0) test_condition, ifnull(person.isolation, 0) isolation, person.country, infectee.infectee_num, infectee.in_hospital, infectee.treatDate, infectee.deathDate, infectee.infection_route from person, infectee where person.ssn = infectee.person_ssn and person.ssn = ?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, ssn);
				rs = ps.executeQuery();
				if (rs.next()) {
					Infectee infectee = new Infectee(rs.getInt("ssn"), rs.getString("name"), rs.getString("address1"),
							rs.getString("address2"), rs.getInt("age"), rs.getString("gender"), rs.getInt("intecter"),
							rs.getString("test_condition"), rs.getString("isolation"), rs.getString("country"),
							rs.getInt("infectee_num"), rs.getString("infection_route"), rs.getString("in_hospital"),
							rs.getString("treatDate"), rs.getString("deathDate"), null, null);

					infectee.setAllTrace(searchAllTrace(ssn));
					infectee.setHospital(whereIsAInfectee(ssn));
					person = infectee;
				}

			} else {
				String query = "select ssn, name, address1, address2, age, gender, ifnull(intecter,0) intecter, ifnull(test_condition,0) test_condition, ifnull(isolation, 0) isolation, country from person where ssn = ?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, ssn);
				rs = ps.executeQuery();
				if (rs.next()) {
					person = new Person(rs.getInt("ssn"), rs.getString("name"), rs.getString("address1"),
							rs.getString("address2"), rs.getInt("age"), rs.getString("gender"), rs.getInt("intecter"),
							rs.getString("test_condition"), rs.getString("isolation"), rs.getString("country"));
				}
			}

		} finally {

		}

		return person;
	}

	@Override 
	// B22 : 국적조회(Person 테이블의 Country)
	public String searchForeigner(int ssn) throws SQLException,RecordNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String result = null;
        try {
            conn = getConnect();
            if(isExistinInfecteeWithNum(ssn, conn)) {
                String query = "select p.country from Person AS p,Infectee AS i where i.person_ssn = ? AND p.ssn = i.person_ssn";
                ps = conn.prepareStatement(query);
                ps.setInt(1, ssn);
                rs = ps.executeQuery();
                if(rs.next()) result = rs.getString("country");
            }else {
                throw new RecordNotFoundException("확진자가 아닙니다.");
            }
        } finally {
            closeAll(rs, ps, conn);
        }
        return result;
    }

	@Override
	// B23 : 특정확진자 조회(주소1,주소2,확진번호)
	public Infectee searchAInfectee(String address1, String address2, int num) throws SQLException,RecordNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Infectee infectee = new Infectee();
        try {
            conn = getConnect();
            if(isExistinInfecteeWithNum(num, conn)) {
                String query = "select * from Person AS p,Infectee AS i where i.infectee_num = ? and p.ssn = i.person_ssn AND p.address1 = ? AND p.address2 = ?";
                ps = conn.prepareStatement(query);
                ps.setString(1, address1);
                ps.setString(2, address2);
                ps.setInt(3, num);
                rs = ps.executeQuery();
                if(rs.next()) {
                    infectee.setSsn(rs.getInt("ssn"));
                    infectee.setName(rs.getString("name"));
                    infectee.setAddress1(rs.getString("address1"));
                    infectee.setAddress2(rs.getString("address2"));
                    infectee.setAge(rs.getInt("age"));
                    infectee.setGender(rs.getString("gender"));
                    infectee.setInfecter(rs.getInt("intecter"));
                    infectee.setTest_condition(rs.getString("test_condition"));
                    infectee.setIsolation(rs.getString("isolation"));
                    infectee.setCountry(rs.getString("country"));
                    infectee.setNum(rs.getInt("infectee_num"));
                    infectee.setInfectionRoute(rs.getString("Infection_route"));
                    infectee.setIn_hospital(rs.getString("in_hospital"));
                    infectee.setTreatDate(rs.getString("treatDate"));
                    infectee.setDeathDate(rs.getString("deathDate"));
                    infectee.setAllTrace(getTrace(rs.getInt("ssn")));
                    infectee.setHospital(whereIsAInfectee(num));
                }
            }else {
                throw new RecordNotFoundException("확진자가 아닙니다.");
            }
        } finally {
            closeAll(rs, ps, conn);
        }
        return infectee;
    }


	// B24 : 특정 확진자 조회(ssn)
	@Override
	public Infectee searchAInfectee(int ssn) throws SQLException,RecordNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Infectee infectee = new Infectee();
        try {
            conn = getConnect();
            if(isExistinInfecteeWithNum(ssn, conn)) {
                String query = "select * from Person AS p , Infectee AS i where i.person_ssn = ? and p.ssn = i.person_ssn";
                ps = conn.prepareStatement(query);
                ps.setInt(1, ssn);
                rs = ps.executeQuery();
                if(rs.next()) {
                    infectee.setSsn(rs.getInt("ssn"));
                    infectee.setName(rs.getString("name"));
                    infectee.setAddress1(rs.getString("address1"));
                    infectee.setAddress2(rs.getString("address2"));
                    infectee.setAge(rs.getInt("age"));
                    infectee.setGender(rs.getString("gender"));
                    infectee.setTest_condition(rs.getString("test_condition"));
                    infectee.setIsolation(rs.getString("isolation"));
                    infectee.setCountry(rs.getString("country"));
                    infectee.setNum(rs.getInt("infectee_num"));
                    infectee.setInfectionRoute(rs.getString("Infection_route"));
                    infectee.setInfecter(rs.getInt("intecter"));
                    infectee.setIn_hospital(rs.getString("in_hospital"));
                    infectee.setTreatDate(rs.getString("treatDate"));
                    infectee.setDeathDate(rs.getString("deathDate"));
                    infectee.setAllTrace(getTrace(rs.getInt("ssn")));
                    infectee.setHospital(whereIsAInfectee(rs.getInt("infectee_num")));
                }
            }else {
                throw new RecordNotFoundException("확진자가 아닙니다.");
            }
        } finally {
            closeAll(rs, ps, conn);
        }
        return infectee;
    }

	
	// B25 : 전체 확진자
	@Override
	public ArrayList<Infectee> searchAllInfectee() throws SQLException, RecordNotFoundException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Infectee> list = new ArrayList<>();
        try {
            conn = getConnect();
            String query = "select * from person as p,Infectee as i,hospital as h where p.ssn = i.person_ssn and i.hospital_code = h.code;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Infectee(rs.getInt("ssn"), 
                        rs.getString("name"), 
                        rs.getString("address1"), 
                        rs.getString("address2"), 
                        rs.getInt("age"), 
                        rs.getString("gender"), 
                        rs.getInt("intecter"),
                        rs.getString("test_condition"), 
                        rs.getString("isolation"), 
                        rs.getString("country"), 
                        rs.getInt("infectee_num"), 
                        rs.getString("Infection_route"), 
                        rs.getString("in_hospital"), 
                        rs.getString("treatDate"), 
                        rs.getString("deathDate"),
                        getTrace(rs.getInt("ssn")),
                        whereIsAInfectee(rs.getInt("infectee_num"))
                        ));
                        
            }
        } finally {
            closeAll(rs,ps,conn);
        }
        return list;
    }

	
	// B26 : 전체해외확진자
	@Override 
	public ArrayList<Infectee> searchAllForeignInfectee() throws SQLException, RecordNotFoundException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Infectee> list = new ArrayList<>();
        try {
            conn = getConnect();
            String query = "select * from person as p , Infectee as i ,hospital as h where p.ssn = i.person_ssn and i.hospital_code = h.code and p.country != '대한민국';";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                list.add(new Infectee(rs.getInt("ssn"), 
                        rs.getString("name"), 
                        rs.getString("address1"), 
                        rs.getString("address2"), 
                        rs.getInt("age"), 
                        rs.getString("gender"), 
                        rs.getInt("intecter"),
                        rs.getString("test_condition"), 
                        rs.getString("isolation"), 
                        rs.getString("country"), 
                        rs.getInt("infectee_num"), 
                        rs.getString("Infection_route"), 
                        rs.getString("in_hospital"), 
                        rs.getString("treatDate"), 
                        rs.getString("deathDate"),
                        getTrace(rs.getInt("ssn")),
                        whereIsAInfectee(rs.getInt("infectee_num")
                        )));
                        
            }
        } finally {
            closeAll(rs,ps,conn);
        }
        return list;
    }
	
	// B27 : 병원이름으로 병원 코드 조회
	@Override
	public int searchAHosipitalCode(String name) throws SQLException,RecordNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        int code = 0;
        ResultSet rs = null;
        try {
            conn = getConnect();
            if(isExistinHospitalWithName(name, conn)) {
                
                String query = "select code from hospital where name =?";
                ps = conn.prepareStatement(query);
                ps.setString(1, name);
                
                rs = ps.executeQuery();
                
                if(rs.next()) {
                    code = rs.getInt(1);
                }
            }else {
                throw new RecordNotFoundException("병원이름이 틀렸습니다.");
            }
        } finally {
            closeAll(ps,conn);
        }
        return code;
    }

	@Override 
	// B28 : 확진자가 입원한 병원 조회
	public Hospital whereIsAInfectee(int num) throws SQLException,RecordNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Hospital hospital = new Hospital();
        try {
            conn = getConnect();
                String query = "select h.code , h.name from Infectee AS i , Hospital AS h where i.infectee_num = ? AND i.Hospital_code = h.code";
                ps = conn.prepareStatement(query);
                ps.setInt(1, num);
                rs = ps.executeQuery();
                if(rs.next()) {
                hospital.setCode(rs.getInt("code"));
                hospital.setName(rs.getString("name"));
            }
        } finally {
            closeAll(rs,ps,conn);
        }
        return hospital;
    }

	@Override
	// B29 : 병원 내 모든 확진자 조회
	public ArrayList<Infectee> searchAllInfecteeInHospital(int code) throws SQLException,RecordNotFoundException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Infectee> list = new ArrayList<>();
        try {
            conn = getConnect();
            if(isExistinHospitalWithCode(code, conn)) {
            String query = "select * from person as p , infectee as i where i.hospital_code = ? and p.ssn = i.person_ssn;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, code);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Infectee(rs.getInt("ssn"), 
                        rs.getString("name"), 
                        rs.getString("address1"), 
                        rs.getString("address2"), 
                        rs.getInt("age"), 
                        rs.getString("gender"), 
                        rs.getInt("intecter"),
                        rs.getString("test_condition"), 
                        rs.getString("isolation"), 
                        rs.getString("country"), 
                        rs.getInt("infectee_num"), 
                        rs.getString("Infection_route"), 
                        rs.getString("in_hospital"), 
                        rs.getString("treatDate"), 
                        rs.getString("deathDate"),
                        getTrace(rs.getInt("ssn")),
                        whereIsAInfectee(rs.getInt("infectee_num")
                        )));
                }
            }
            else {
                throw new RecordNotFoundException("병원코드가 틀렸습니다.");
            }
        }finally {
            closeAll(rs, ps,conn);
        }
        return list;
    }

	@Override
	// B30 : 특정 확진자가 감염시킨 확진자 검색!
		public ArrayList<Infectee> searchInfectedPeopleByCertainPerson(int ssn) throws SQLException,RecordNotFoundException{
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        ArrayList<Infectee> list = new ArrayList<>();
	        try {
	            conn = getConnect();
	            if(isExistinInfectee(ssn , conn)) {
	                String query = "select * from person p, infectee i where ifnull(p.intecter,0) = ? AND p.ssn=i.Person_ssn";
	                ps = conn.prepareStatement(query);
	                ps.setInt(1, ssn);
	                rs=ps.executeQuery();
	                while(rs.next()) {
	                    list.add(new Infectee(rs.getInt("ssn"),
	                            rs.getString("name"),
	                            rs.getString("address1"),
	                            rs.getString("address2"),
	                            rs.getInt("age"),
	                            rs.getString("gender"),
	                            rs.getInt("intecter"),
	                            rs.getString("test_condition"),
	                            rs.getString("isolation"),
	                            rs.getString("country"),
	                            rs.getInt("infectee_num"),
	                            rs.getString("Infection_route"),
	                            rs.getString("in_hospital"),
	                            rs.getString("treatDate"),
	                            rs.getString("deathDate"),
	                            getTrace(rs.getInt("ssn")),
	                            whereIsAInfectee(rs.getInt("infectee_num")
	                            )));
	        }
	            }else{
	            throw new RecordNotFoundException();
	        }
	            }finally {
	            closeAll(rs, ps,conn);
	        }
	        return list;
	    }
	

	@Override
	// B31 : 특정 장소 방역 조회
	public ArrayList<Visit> isCleaned(String address) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Visit> v = new ArrayList<Visit>();
		
		try {
		conn = getConnect();
		String query = "SELECT cleanDate From visits WHERE address = ?";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, address);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			v.add(new Visit(rs.getString("cleanDate")));
		}
		}finally{
			closeAll(rs, ps, conn);
		}
		return v;
	}

	@Override
	// B32 : Person 테이블 수정
	public void updatePerson(Person p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "UPDATE person set name=?,address1=?,address2=?,age=?,gender=?,test_condition=?,intecter=?,isolation=?,country=? WHERE ssn=?";
			ps=conn.prepareStatement(query);
			
			ps.setString(1, p.getName());
			ps.setString(2, p.getAddress1());
			ps.setString(3, p.getAddress2());
			ps.setInt(4, p.getAge());
			ps.setString(5, p.getGender());
			ps.setString(6, p.getTest_condition());
			ps.setInt(7, p.getInfecter());
			ps.setString(8, p.getIsolation());
			ps.setString(9, p.getCountry());
			ps.setInt(10, p.getSsn());
			
			System.out.println(ps.executeUpdate()+" 명, 수정 완료");
			
		}finally {
			closeAll(ps, conn);
		}
		
	}
	
	@Override
	// B33 : 확진자 추가 + 입원 처리 + 방역도 : 입원날짜 넣기 
	public void addInfectee(int ssn, int code, String infectionroute, String date) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps =null;
		
		try {
			conn = getConnect();
			
			if(!isExistinInfectee(ssn, conn)) {//Infectee 테이블에 없다면
				String query = "INSERT INTO infectee(Person_ssn,Hospital_code , in_hospital, Infection_Route) VALUES(?, ?, ?, ?)";
				ps = conn.prepareStatement(query);
				
				ps.setInt(1, ssn);
				ps.setString(3, date);
				ps.setInt(2, code);
				ps.setString(4, infectionroute);
				
				System.out.println(ps.executeUpdate()+" 명 추가 ok...");
			}else {// 있다면
				throw new DuplicateSSNException("이미 확진자 명단에 있습니다.");
			}
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	// B34 : 완치 처리 -- 완치되면 자동 격리 해제(###Transaction ####)
	public void treatedInfectee(int ssn, String date) throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			conn.setAutoCommit(false);
			
			String query = "UPDATE infectee SET treatDate = ? WHERE Person_ssn =?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, date);
			ps.setInt(2, ssn);
			
			System.out.println(ps.executeUpdate()+" 명 완치");
			
			String query2 = "UPDATE Person SET isolation = '1999-12-31' WHERE ssn =?";
			ps = conn.prepareStatement(query2);
			
			ps.setInt(1, ssn);
			
			System.out.println(ps.executeUpdate()+" 명 격리해제");
			conn.commit();
			
		}catch(Exception e){
			System.out.println("=============완치처리는 했으나 격리해제 처리가 안 됐습니다.======================");
			conn.rollback();
		}finally {
			System.out.println("=============완치처리 후 정보 확인======================");
			
			String query3 = "SELECT p.ssn, i.treatDate, p.isolation FROM person p, infectee i WHERE ssn = ? AND  p.ssn=i.Person_ssn";
			ps = conn.prepareStatement(query3);
			ps.setInt(1, ssn);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("ssn")+", "+rs.getString("treatDate")+", "+rs.getString("isolation"));
			}
			conn.setAutoCommit(true);
			closeAll(ps, conn);
		}
		
		
	}
	@Override
	// B35 : 격리해제 : null = 격리된 적 없음. 2020년 이후 날짜 = 격리 중. '1999-12-31' = 격리해제
	public void NoMoreIsolation(int ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps =null;
		
		try {
			conn = getConnect();
			
			String query = "UPDATE Person SET isolation = '1999-12-31' WHERE ssn =?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, ssn);
			
			System.out.println(ps.executeUpdate()+" 명 격리해제");
		
		}finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
    // B36 : 사망 처리-- 사망하면 자동 격리 해제(###Transaction ####)
    public void setDeath(int ssn, String date) throws SQLException {
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs= null;
        try {
            conn = getConnect();
            conn.setAutoCommit(false);
            String query = "UPDATE infectee SET deathdate = ? WHERE Person_ssn =?";
            ps = conn.prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, ssn);
            System.out.println(ps.executeUpdate()+" 명 사망");
            String query2 = "UPDATE Person SET isolation = '1999-12-31' WHERE ssn =?";
            ps = conn.prepareStatement(query2);
            ps.setInt(1, ssn);
            System.out.println(ps.executeUpdate()+" 명 격리해제");
            conn.commit();
        }catch(Exception e){
            System.out.println("=============사망처리는 했으나 격리해제 처리가 안 됐습니다.======================");
            conn.rollback();
        }finally {
            System.out.println("=============사망처리 후 정보 확인======================");
            String query3 = "SELECT p.ssn, i.deathDate, p.isolation FROM person p, infectee i WHERE ssn = ? AND  p.ssn=i.Person_ssn";
            ps = conn.prepareStatement(query3);
            ps.setInt(1, ssn);
            rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getInt("ssn")+", "+rs.getString("deathDate")+", "+rs.getString("isolation"));
            }
            conn.setAutoCommit(true);
            closeAll(ps, conn);
        }
    }

	@Override
	// B37 : 동선 수정
	public void updateTrace(int num, String newaddress, String visitDate, String oldaddress) throws SQLException {
		Connection conn = null;
		PreparedStatement ps =null;
		
		try {
			conn = getConnect();
			
			String query = "UPDATE visits SET address = ? WHERE infectee_num =? AND visitDate = ? AND address=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, newaddress);
			ps.setInt(2, num);
			ps.setString(3, visitDate);
			ps.setString(4, oldaddress);
			
			System.out.println(ps.executeUpdate()+" 명,"+ "동선을"+ newaddress +"로 수정");

		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	// B38 : 방역하기 : visit, place clean
	public void doClean(int num, String address, String visitDate, String cleanDate) throws SQLException {
		Connection conn = null;
		PreparedStatement ps =null;
		
		try {
			conn = getConnect();
			
			String query = "UPDATE visits SET cleanDate = ? WHERE infectee_num =? AND address=? AND  visitDAte =?";
			ps = conn.prepareStatement(query);
			
			ps.setString(3, address);
			ps.setString(1, cleanDate);
			ps.setInt(2, num);
			ps.setString(4, visitDate);
			
			System.out.println(ps.executeUpdate()+" 곳 방역 완료");
		
		}finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	// B39 : 특정 지역 n번 확진자의 ssn을 리턴
	public int returnSsn(String address1, String address2, int num) throws SQLException {
		int ssn = 0;
		Connection conn = getConnect();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ssn FROM (SELECT address1, address2, ");
		sb.append("row_number() over(order by in_hospital ASC) no, ssn, in_hospital ");
		sb.append("FROM (SELECT infectee_num, Person_ssn, in_hospital FROM infectee) i, ");
		sb.append("(SELECT ssn, address1, address2 FROM person) p ");
		sb.append("WHERE Person_ssn = ssn AND address1 = ? AND address2 = ?) temp ");
		sb.append("WHERE no = ?");
		String sql = sb.toString();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, address1);
		ps.setString(2, address2);
		ps.setInt(3, num);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			ssn = rs.getInt("ssn");
		}
		return ssn;
	}

	@Override
	// B40 : ssn을 입력하고 동선 목록을 리턴
	public ArrayList<Visit> getTrace(int ssn) throws SQLException { 
		ArrayList<Visit> gtList = new ArrayList<>();
		Connection conn = getConnect();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT p.address, name, visitDate, cleanDate ");
		sb.append("FROM (SELECT address, visitDate, cleanDate FROM visits ");
		sb.append("WHERE infectee_num = (SELECT infectee_num FROM infectee WHERE Person_ssn = ?)) v, ");
		sb.append("(SELECT name, address FROM place) p ");
		sb.append("WHERE v.address = p.address");
		String sql = sb.toString();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, ssn);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			gtList.add(new Visit(rs.getString("p.address"), 
							rs.getString("name"), 
							ssn, 
							rs.getString("visitDate"), 
							rs.getString("cleanDate")));
		}
		return gtList;
	}
	
	// ljh_16
		// 특정 도시화자의 감염넘버를 ssn으로 바꿈/
		@Override
		public int certainCityInfecteeNumToSsn(String address1, String address2, int num) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			int ssn = 0;
			try {
				conn = getConnect();
				String query = "select row_number() over(order by infectee_num) certainCityInfecteeNum, Person_ssn from infectee, person where infectee.person_ssn = person.ssn and person.address1 = ? and person.address2 = ?";
				ps = conn.prepareStatement(query);
				ps.setString(1, address1);
				ps.setString(2, address2);
				rs = ps.executeQuery();
				while (rs.next()) {
					if (rs.getInt("certainCityInfecteeNum") == num) {
						ssn = rs.getInt("Person_ssn");
					}
				}
			} finally {
				closeAll(rs, ps, conn);
			}
			return ssn;
		}
		
		// ljh_17
		// 감염넘버를특정도시감염넘버로 바꿈
		@Override
		public int InfecteeNumToCertainCityInfecteeNum(int num) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			int CertainCitiyInfecteeNum = 0;
			try {
				conn = getConnect();
				String query = "select infectee_num, row_number() over(order by infectee_num) certainCityInfecteeNum from infectee, person where infectee.person_ssn = person.ssn and person.address1 = (select person.address1 from infectee, person where infectee.Person_ssn = person.ssn and infectee.infectee_num = ?) and person.address2 = (select person.address2 from infectee, person where infectee.Person_ssn = person.ssn and infectee.infectee_num = ?)";
				ps = conn.prepareStatement(query);
				ps.setInt(1, num);
				ps.setInt(2, num);
				rs = ps.executeQuery();
				while (rs.next()) {
					if (rs.getInt("infectee_num") == num) {
						CertainCitiyInfecteeNum = rs.getInt("certainCityInfecteeNum");
					}
				}
			} finally {
				closeAll(rs, ps, conn);
			}
			return CertainCitiyInfecteeNum;
		}
		
		// 특정도시감염넘버를총감연넘버로바꿈
		@Override
		public int certainCityInfecteeNumToInfecteeNum(String address1, String address2, int num) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			int InfecteeNum = 0;
			try {
				conn = getConnect();
				String query = "select row_number() over(order by infectee_num) certainCityInfecteeNum, infectee_num from infectee, person where infectee.person_ssn = person.ssn and person.address1 = ? and person.address2 = ?";
				ps = conn.prepareStatement(query);
				ps.setString(1, address1);
				ps.setString(2, address2);
				rs = ps.executeQuery();
				while (rs.next()) {
					if (rs.getInt("certainCityInfecteeNum") == num) {
						InfecteeNum = rs.getInt("infectee_num");
					}
				}
			} finally {
				closeAll(rs, ps, conn);
			}
			return InfecteeNum;
		}
		// B44 : 확진자 번호 유무 확인
		public boolean isExistinInfecteeWithNum(int num, Connection conn) throws SQLException {
			String sql = "SELECT infectee_num FROM infectee WHERE infectee_num=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, num);
	        ResultSet rs = ps.executeQuery();
	        return rs.next();
	    }

	
		// B45 : 병원코드 유무확인
		public boolean isExistinHospitalWithCode(int code, Connection conn) throws SQLException {
	        String sql = "SELECT code FROM hospital WHERE code=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, code);
	        ResultSet rs = ps.executeQuery();
	        return rs.next();
	    }

		
		// B46 : 병원이름 유무확인
		public boolean isExistinHospitalWithName(String name, Connection conn) throws SQLException {
	        String sql = "SELECT name FROM hospital WHERE name=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, name);
	        ResultSet rs = ps.executeQuery();
	        return rs.next();
	    }
		
		// B47 : 확진자 유무 확인
		public boolean isExistinInfectee(int ssn, Connection conn)throws SQLException {
			//Infectee 테이블에 있는지 없는지 존재유무 확인...
			String sql ="SELECT Person_ssn FROM infectee WHERE Person_ssn=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,ssn);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		}	
		
		
		@Override
		public ArrayList<Visit> searchAllTraceBySsn(int ssn) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<Visit> AllTrace = new ArrayList<>();

			try {
				conn = getConnect();
				String query = "select place.address, place.name, visits.visitDate, ifnull(visits.cleanDate, 0) cleanDate from visits, place where visits.address = place.address and visits.infectee_num = (select infectee_num from infectee where Person_ssn = ?)";
				ps = conn.prepareStatement(query);
				ps.setInt(1, ssn);
				rs = ps.executeQuery();

				while (rs.next()) {
					Visit visit = new Visit(rs.getString("address"), rs.getString("name"), ssn, rs.getString("visitDate"),
							rs.getString("cleanDate"));
					AllTrace.add(visit);
				}

			} finally {

			}
			return AllTrace;
		}
		
}