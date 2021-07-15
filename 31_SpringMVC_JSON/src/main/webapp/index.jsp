<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
    <!--jQurey import (CDN 방식)-->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function getJsonBoardListData(){
    alert("getJsonBoardListData() 실행~");
    $.ajax("getJsonBoardList.do", {
       type : "get", 
       dataTyoe : "json", 
       success : function(data){
          alert("성공~~");
          console.log(data);
          let dispHtml = "<ul>";
          $.each(data, function(index, obj){
        	  dispHtml += "<li>";
        	  dispHtml += this.seq + ", ";
        	  dispHtml += this.title + ", ";
        	  dispHtml += this["writer"] + ", ";
        	  dispHtml += this["regdate"] + ", ";
        	  dispHtml += obj["cnt"];
        	  dispHtml += "</li>";
          });
          dispHtml += "</ul>";
          $("#listDisp").html(dispHtml);
       }, 
       error : function(){
          alert("실패!!!")
       }
    });
 }
</script>
</head>
<body>
<div id="container">
	<h1>게시판 프로그램(index.jsp)</h1>
	<hr>
	<p>
		<a href="login.do">로그인 페이지로 이동(GET)</a>
	</p>
	<hr>
	<p><a href="javascript:getJsonBoardListData()">JSON 데이터 가져오기(BoardList)</a></p> <!-- getJsonBoardListData() 함수 호출 -->
	<p><a href="javascript:getJsonBoardData()">JSON 데이터 하나 가져오기(Board)</a></p> <!-- getJsonBoardData() 함수 호출 -->
	<hr>
	<div id="listDisp">
		<ul>
			<li>데이터 가져와서 출력하기</li>
		</ul>
	</div>
</div>
<script>
	function getJsonBoardData() {
		alert("getJsonBoardData() 실행 ~");
		//let vo = {seq : 1};
		let vo = {};
		vo.seq = 1;
		console.log(vo);
		console.log(JSON.stringify(vo)); //stringify: 자바스크립트 객체를 문자열로 변환
		
		$.ajax("getJsonBoard.do",{
			type:"post",
			data:JSON.stringify(vo),
			dataType: "json",
			contentType: "application/json",
			success: function(data){
	            alert("성공~~!!");
	            console.log(data);
	            let dispHtml = "<ul><li>";
	            dispHtml += data.seq + ", "
	            dispHtml += data.title + ", ";
	            dispHtml += data["writer"] + ", ";
	            dispHtml += data["regdate"] + ", ";
	            dispHtml += data["cnt"] + ", ";
	            dispHtml += "</li></ul>"
	            
	            $("#listDisp").html(dispHtml);

			},
			error: function() {
				alert("실패!!!");
			}
		}); 
	}
</script>
</body>
</html>
