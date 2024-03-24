<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="noticeboard.Board.Board,noticeboard.Board.BoardService" %>
<%@ page import="java.io.*,java.util.*" %>

<%
    // Form에서 전송된 데이터 받기
    int boardId = Integer.parseInt(request.getParameter("boardId"));

    // BoardService 객체 생성
    BoardService boardService = new BoardService();
    
    // 글 삭제 메서드 호출
    int result = boardService.deleteBoard(boardId);

    if(result > 0) {
        response.sendRedirect("boardList"); // 성공 시 목록 페이지로 이동
    } else {
        out.println("글 삭제에 실패했습니다.");
    }
%>
