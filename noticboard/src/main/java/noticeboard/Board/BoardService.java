package noticeboard.Board;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.DBCPInit;

public class BoardService {
	private BoardDAO dao = BoardDAO.getInstance();
	
	 public List<Board> getAllBoards() {
	        return dao.getAll();
	    }
	
    public int writeBoard(Board board) {
        int result = 0;
        try (Connection conn = DBCPInit.getConnection()) {
            conn.setAutoCommit(false); 

            result = dao.write(board); 

            conn.commit(); // 작업 성공 시 커밋
        } catch (SQLException e) {
            e.printStackTrace();
            // 트랜잭션 종료 후 에러 처리
            // 여기서 롤백은 try-with-resources 문이 자동으로 처리합니다.
        }
        return result;
    }
    
    public int updateBoard(Board board) {
        int result = 0;
        try (Connection conn = DBCPInit.getConnection()) {
            conn.setAutoCommit(false); // 트랜잭션 시작

            result = dao.update(board); // DAO에 작업 위임

            conn.commit(); // 작업 성공 시 커밋
        } catch (SQLException e) {
            e.printStackTrace();
            // 트랜잭션 종료 후 에러 처리
            // 여기서 롤백은 try-with-resources 문이 자동으로 처리합니다.
        }
        return result;
    }
    
    public int deleteBoard(Integer boardId) {
        return dao.delete(boardId);
    }

}
