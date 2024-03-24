<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
</head>
<body>
    <h1>게시글 목록</h1>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용 일부분</th>
            <th>작성일</th>
        </tr>
        <c:forEach var="board" items="${boards}">
            <tr>
                <td>${board.board_Id}</td>
                <!-- 제목을 클릭하면 자세한 내용을 보여주는 페이지로 이동 -->
                <td><a href="boardView.jsp?boardId=${board.board_Id}" style="display: block;">${board.title}</a></td>
                <!-- 글 내용을 클릭하면 자세한 내용을 보여주는 페이지로 이동 -->
                <td><a href="boardView.jsp?boardId=${board.board_Id}" style="display: block;">${board.board_content.length() > 50 ? board.board_content.substring(0, 50) : board.board_content}</a></td>
                <td>${board.time}</td>
            </tr>
        </c:forEach>
    </table>
     <hr>
	<form action="write.jsp" method="post">
		<input type="submit" value="작성">
	</form>
</body>
</html>
