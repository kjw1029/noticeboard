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

import jdbc.DBCPInit;

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
		String sql = "SELECT * FROM board ORDER BY Time DESC";
		List<Board> list = new ArrayList<Board>();
		try (Connection conn = DBCPInit.getConnection();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int write(Board board) {
		String sql = "INSERT INTO Board (Title, Board_content, Time) VALUES (?,?,?)";
		try (Connection conn = DBCPInit.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getBoard_content());
			stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(Integer boardId) {
		String sql = "DELETE FROM Board WHERE Board_Id = ?";
		try (Connection conn = DBCPInit.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, boardId);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int update(Board board) {
		String sql = "UPDATE board SET Title = ?, Board_content = ?, Time = ? WHERE Board_Id = ?";
		try (Connection conn = DBCPInit.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getBoard_content());
			stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			stmt.setInt(4, board.getBoard_Id());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
    // 특정 ID의 게시글을 가져오는 메서드 추가
    public Board get(int boardId) {
        String sql = "SELECT * FROM board WHERE Board_Id = ?";
        try (Connection conn = DBCPInit.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, boardId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int Board_Id = rs.getInt("Board_Id");
                    int User_Id = rs.getInt("User_Id");
                    String Title = rs.getString("Title");
                    String Board_content = rs.getString("Board_content");
                    String Time = rs.getString("Time");
                    return new Board(Board_Id, User_Id, Title, Board_content, Time);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // 게시글이 없을 경우 null 반환
    }
	
}
