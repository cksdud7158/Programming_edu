package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import util.DataSourceManager;

public class ItemDAO {
	private DataSource ds;
	
	private static ItemDAO dao = new ItemDAO();
	private ItemDAO() {
		// 공장을 하나 받아옴
		
		ds= DataSourceManager.getInstance().getConnection();
	}
	public static ItemDAO getInstance() {
		return dao;
	}
	
	//공통적인 로직 ... connection, closeALl()
	public Connection getConnection() throws SQLException{
		System.out.println("디비 연결 성공");
		return ds.getConnection();
		
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}
	
	//가변적인 로직 
	public ArrayList<Item> getAllItem() throws SQLException{
		ArrayList<Item> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query="select * from item";
			
			ps= conn.prepareStatement(query);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
			System.out.println(list);
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public Item getItem(int itemNumber) throws SQLException{
		Item item= null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = getConnection();
			/*String query1 ="select count from item where item_id=?";
			ps= conn.prepareStatement(query1);
			ps.setInt(1, itemNumber);
			ResultSet rs1= ps.executeQuery();
			if(rs1.next()) {
				count =rs1.getInt("count");
			}
			
			count++;
			System.out.println("11111-----"+count);*/
			String query2="update item set count=count+1 where item_id=?";
			ps= conn.prepareStatement(query2);
			ps.setInt(1, itemNumber);
			System.out.println(ps.executeUpdate());
			
			String query3="select * from item where item_id=?";
			ps= conn.prepareStatement(query3);
			ps.setInt(1, itemNumber);
			rs= ps.executeQuery();
			
			if(rs.next()){
				item = new Item(itemNumber, rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
			
			System.out.println("비즈니스 로직 :::::"+item);
			
		} finally {
			closeAll(rs, ps, conn);
		}
		return item;
	}
	
	
}























