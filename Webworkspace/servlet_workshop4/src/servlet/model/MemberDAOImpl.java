package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.error.DuplicateSSNException;
import servlet.error.RecordNotFoundException;

public class MemberDAOImpl implements MemberDAO{
	private static MemberDAOImpl dao = new MemberDAOImpl();
	
	private MemberDAOImpl() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
		}
	}
	
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn =DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("Database Connection......");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection co) throws SQLException {
		if(ps!=null) ps.close();
		if(co!=null) co.close();	
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection co) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, co);	
	}
	
	public boolean isExist(String id, Connection conn)throws SQLException {
		//있는지 없는지 존재유무 확인...
		
		String sql ="SELECT id FROM member WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,id);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}	

	@Override
	public void registerMember(MemberVO vo) throws SQLException, DuplicateSSNException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			
			if(!isExist(vo.getId(), conn)) { // 없다면
			String query = "INSERT INTO member(id, password, name, address) VALUES(?,?,?,?);";
			ps = conn.prepareStatement(query);
		
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddr());
			
			System.out.println(ps.executeUpdate()+" 명 INSERT OK....addCustomer()...");	
			}else {
				throw new DuplicateSSNException(vo.getId()+" 은 이미 존재합니다...");
			}
		}finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<>();
		conn = getConnection();
		String query=  "SELECT * FROM member";
		
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		
		closeAll(rs, ps, conn);
		return list;
	}

	@Override
	public MemberVO findById(String id) throws SQLException, RecordNotFoundException {
		
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		MemberVO vo=null;
		
		try {
			conn = getConnection();
			
			if(isExist(id, conn)) { // 있다면
				
				String query=  "SELECT * FROM member where id=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, id);
				
				rs = ps.executeQuery();
				if(rs.next()) {
					vo =  new MemberVO(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("address"));
				}
				
			}else {
				throw new RecordNotFoundException(id +"는 존재하지않습니다.");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return vo;
	}
}
