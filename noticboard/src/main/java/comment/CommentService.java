package comment;

import java.util.List;

public class CommentService {
    private CommentDAO commentDAO;

    public CommentService() {
        this.commentDAO = CommentDAO.getInstance();
    }

    // 모든 댓글 가져오기
    public List<Comment> getAllComments() {
        return commentDAO.getAll();
    }

    // 특정 게시글의 댓글 가져오기
    public List<Comment> getCommentsByBoardId(int boardId) {
        return commentDAO.getByBoardId(boardId);
    }

    // 댓글 작성
    public boolean writeComment(Comment comment) {
        int result = commentDAO.write(comment);
        return result == 1;
    }

    // 댓글 삭제
    public boolean deleteComment(int commentId) {
        int result = commentDAO.delete(commentId);
        return result == 1;
    }
}
