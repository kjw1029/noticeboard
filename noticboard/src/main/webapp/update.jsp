<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 수정</title>
</head>
<body>
    <h1>글 수정</h1>
    <form action="updateAction.jsp" method="post">
        <input type="hidden" name="boardId" value="${param.boardId}">
        제목: <input type="text" name="title" value="${param.title}"><br>
        내용: <textarea name="content">${param.content}</textarea><br>
        <input type="submit" value="수정">
    </form>
</body>
</html>
