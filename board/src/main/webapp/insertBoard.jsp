<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 등록</h2> 
	<form action="insertBoardOK.jsp" method="post" enctype="multipart/form-data">
		글제목: <input type="text" name="title" size="30"><br> 
		작성자: <input type="text" name="writer" size="20"><br>
		글암호: <input type="password" name="pwd" size="20"><br>
		글내용:<br>
		 <textarea rows="10" cols="80" name="content"></textarea><br>
		첨부파일: <input type="file" name="uploadFile"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>