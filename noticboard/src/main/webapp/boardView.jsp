<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 및 댓글</title>
</head>
<body>
    <p><strong>게시글 ID:</strong> ${board.board_Id}</p>
    <p><strong>제목:</strong> ${board.title}</p>
    <p><strong>내용:</strong> ${board.board_content}</p>
    <p><strong>작성일:</strong> ${board.time}</p>

    <hr>

    <h2>댓글 목록</h2>
    <table border="1">
        <tr>
            <th>댓글 ID</th>
            <th>게시글 ID</th>
            <th>작성자 ID</th>
            <th>작성일</th>
            <th>내용</th>
        </tr>
        <c:forEach var="comment" items="${comments}">
            <tr>
                <td>${comment.comment_Id}</td>
                <td>${comment.board_Id}</td>
                <td>${comment.user_Id}</td>
                <td>${comment.time}</td>
                <td>${comment.board_Commnet}</td>
            </tr>
        </c:forEach>
    </table>

    <hr>

    <h2>댓글 작성</h2>
    <form method="post">
        <input type="hidden" name="boardId" value="${board.board_Id}">
        <label for="userId">작성자 ID:</label>
        <input type="text" id="userId" name="userId"><br>
        <label for="comment">댓글 내용:</label><br>
        <textarea id="comment" name="comment" rows="4" cols="50"></textarea><br>
        <input type="submit" value="댓글 작성">
    </form>
</body>
</html>
