package noticeboard.Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;


public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	private BoardDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Board> getAll() {
		String sql = "SELECT * FROM board";
		List<Board> list = new ArrayList<Board>();
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "roo", "root");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				int Board_Id = rs.getInt("Board_Id");
				int User_Id = rs.getInt("User_Id");
				String Title = rs.getString("Title");
				String Board_content = rs.getString("Board_content");
				String Time = rs.getString("Time");
				
				list.add(new Board(Board_Id, User_Id, Title, Board_content, Time));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int write(Board board) {
		String sql = "INSERT INTO Board (User_Id, Title, Board_content,Time) VALUES (?,?,?,?)";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "roo", "root");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, board.getUser_Id());
			stmt.setString(2, board.getTitle());
			stmt.setString(3, board.getBoard_content());
			stmt.setString(4, board.getTime());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(Integer no) {
		String sql = "DELETE FROM Board WHERE Post_ID = ?;";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "roo", "root");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, no);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int update(Board board) {
		String sql = "UPDATE board SET Title = ?, Board_content = ? Time = ? WHERE id = ?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "roo", "root");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getBoard_content());
			stmt.setString(3, new Timestamp(new Date().getTime()).toString());
			stmt.setInt(4, board.getUser_Id());
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
