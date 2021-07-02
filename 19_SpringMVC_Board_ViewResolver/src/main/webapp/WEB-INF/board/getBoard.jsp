<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--WEB-INF 폴더는 클라이언트 쪽에서 접근할 수 없음 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세(getBoard.jsp)</title>
<style>
   #container { width: 700px; margin: 0 auto; }
   h1, p { text-align: center; }
   table { border-collapse: collapse; }
   table, th, td {
      border : 1px solid black;
      margin : 0 auto;
   }
   th { background-color: tomato; }
   .center, .center p{ text-align: center; }
</style>
</head>
<body>
<div id="container"> 
	<h1>게시글 상세(getBoard.jsp)</h1>
	<p><a href="logout.do">logout</a></p>
	<hr>
	<form action="updateBoard.do" method="post">
		<input type="hidden" name="seq" value="${board.seq }">
	<table>
		<tr>
			<th width="70">제목</th>
			<td>
				<input type="text" name="title" size="30" value="${board.title }">
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="writer" value="${board.writer }">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" rows="10" cols="40">${board.content }</textarea>
			</td>
		</tr>
		<tr>	
			<th>등록일</th>
			<td>${board.regdate }</td>
		</tr>
		<tr>	
			<th>조회수</th>
			<td>${board.cnt }</td>
		</tr>
		<tr>
			<td colspan="2" class="center">
				<input type="submit" value="글 수정">
			</td>
		</tr>
	</table>	
	</form>
	
	<p>
		<a href="insertBoard.jsp">글 등록</a>
		<a href="deleteBoard.do?seq=${board.seq }">글 삭제</a>
		<a href="getBoardList.do">글 목록</a>
	</p>   <!-- getBoardList.jsp로 경로 지정하면 변경된 거 반영x -->
</div>
</body>
</html>