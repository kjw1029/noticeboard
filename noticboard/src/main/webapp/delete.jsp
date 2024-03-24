<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 삭제</title>
</head>
<body>
    <h1>글 삭제</h1>
    <form action="deleteAction.jsp" method="post">
        <input type="hidden" name="boardId" value="${param.boardId}">
        <p>정말로 삭제하시겠습니까?</p>
        <input type="submit" value="삭제">
    </form>
</body>
</html>
