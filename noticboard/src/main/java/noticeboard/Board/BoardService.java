package noticeboard.Board;

public class BoardService {
	private BoardDAO dao = BoardDAO.getInstance();
	public int insert(Board board) {
		return dao.write(board);
	}
	public int delet(Integer no) {
		int result = dao.delete(no);
		return result;
	}

}
