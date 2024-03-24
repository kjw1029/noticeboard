package comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBCPInit;

public class CommentDAO {
    private static CommentDAO instance = new CommentDAO();

    public static CommentDAO getInstance() {
        return instance;
    }

    private CommentDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 모든 댓글 가져오기
    public List<Comment> getAll() {
        String sql = "SELECT * FROM comment";
        List<Comment> list = new ArrayList<>();
        try (Connection conn = DBCPInit.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int commentId = rs.getInt("Comment_Id");
                int boardId = rs.getInt("Board_Id");
                int userId = rs.getInt("User_Id");
                String time = rs.getString("Time");
                String boardComment = rs.getString("Board_Commnet");

                Comment comment = new Comment(commentId, boardId, userId, time, boardComment);
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 특정 게시글의 댓글 가져오기
    public List<Comment> getByBoardId(int boardId) {
        String sql = "SELECT * FROM comment WHERE Board_Id = ?";
        List<Comment> list = new ArrayList<>();
        try (Connection conn = DBCPInit.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, boardId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int commentId = rs.getInt("Comment_Id");
                    int userId = rs.getInt("User_Id");
                    String time = rs.getString("Time");
                    String boardComment = rs.getString("Board_Commnet");

                    Comment comment = new Comment(commentId, boardId, userId, time, boardComment);
                    list.add(comment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 댓글 작성
    public int write(Comment comment) {
        String sql = "INSERT INTO comment (Board_Id, User_Id, Time, Board_Commnet) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBCPInit.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, comment.getBoard_Id());
            stmt.setInt(2, comment.getUser_Id());
            stmt.setString(3, comment.getTime());
            stmt.setString(4, comment.getBoard_Commnet());

            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 댓글 삭제
    public int delete(int commentId) {
        String sql = "DELETE FROM comment WHERE Comment_Id = ?";
        try (Connection conn = DBCPInit.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, commentId);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
