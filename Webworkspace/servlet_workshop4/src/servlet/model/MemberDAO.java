package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import servlet.error.DuplicateSSNException;
import servlet.error.RecordNotFoundException;

public interface MemberDAO {
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection co)throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection co)throws SQLException;
	
	void registerMember(MemberVO vo) throws SQLException, DuplicateSSNException;
	ArrayList<MemberVO> showAllMember() throws SQLException;
	MemberVO findById(String id) throws SQLException, RecordNotFoundException;
	
	
}
