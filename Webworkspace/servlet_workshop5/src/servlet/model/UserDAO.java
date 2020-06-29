package servlet.model;

import java.sql.SQLException;
import java.util.ArrayList;

import servlet.error.DuplicateSSNException;

public interface UserDAO {
	public void registerBook(BookVO book) throws SQLException, DuplicateSSNException;
	public ArrayList bookList() throws SQLException;
}
