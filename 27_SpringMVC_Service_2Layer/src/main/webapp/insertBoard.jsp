<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록(insertBoard.jsp)</title>
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
	<h1>글 등록(insertBoard.jsp)</h1>
	<p><a href="logout.do">logout</a></p>
	<hr>
	<form action="insertBoard.do" method="post">
	<table>
		<tr>
			<th width="70">제목</th>
			<td>
				<input type="text" name="title" size="30">
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="writer">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" rows="10" cols="40"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="center">
				<input type="submit" value="새 글 등록">
			</td>
		</tr>
	</table>	
	</form>
	
	<p><a href="getBoardList.do">글 목록 가기</a></p>   <!-- getBoardList.jsp로 경로 지정하면 변경된 거 반영x -->
</div>
</body>
</html>