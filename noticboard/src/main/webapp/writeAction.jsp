<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="noticeboard.Board.Board,noticeboard.Board.BoardService" %>
<%@ page import="java.io.*,java.util.*" %>

<%
    // Form에서 전송된 데이터 받기
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    // 현재 날짜 및 시간 설정
    Date date=java.util.Calendar.getInstance().getTime();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String time = formatter.format(date);

    // Board 객체 생성
    Board board = new Board(0, 0, title, content, time);

    // BoardService 객체 생성
    BoardService boardService = new BoardService();
    
    // 글 작성 메서드 호출
    int result = boardService.writeBoard(board);

    if(result > 0) {
        response.sendRedirect("boardList"); // 성공 시 목록 페이지로 이동
    } else {
        out.println("글 작성에 실패했습니다.");
    }
%>
