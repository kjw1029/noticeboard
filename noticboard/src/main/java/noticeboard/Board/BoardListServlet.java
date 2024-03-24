package noticeboard.Board;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import noticeboard.Board.Board;
import noticeboard.Board.BoardDAO;

@WebServlet("/")
public class BoardListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 요청된 URL이 게시글 상세 내용을 보여주는 URL인지 확인합니다.
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        if (requestURI.contains("boardView.jsp")) {
            // 게시글 상세 내용을 보여주는 URL이라면, 해당 게시글의 ID를 파라미터로 받아옵니다.
            String[] uriParts = requestURI.split("/");
            String boardIdStr = uriParts[uriParts.length - 1]; // view 뒤의 파라미터가 게시글 ID입니다.
            int boardId = Integer.parseInt(boardIdStr);
            System.out.println();
            // 해당 게시글을 가져옵니다.
            Board board =  BoardDAO.getInstance().get(boardId);

            // JSP 페이지로 데이터를 전달하기 위해 request 객체에 데이터를 설정합니다.
            request.setAttribute("board", board);
            // JSP 페이지로 포워딩합니다.
            request.getRequestDispatcher("boardView.jsp").forward(request, response);
        } else {
            // 게시글 목록을 가져와서 boardList.jsp로 포워딩합니다.
    		List<Board> boards = BoardDAO.getInstance().getAll();

    		// JSP 페이지로 데이터를 전달하기 위해 request 객체에 데이터를 설정합니다.
    		request.setAttribute("boards", boards);
    		// JSP 페이지로 포워딩합니다.
    		request.getRequestDispatcher("boardList.jsp").forward(request, response);
        }
    }
}
