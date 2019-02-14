<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Spring MVC 게시판</title>
</head>
<body>

	<c:import url="header.jsp"></c:import>
	 
	<h1 align="center">글 쓰기</h1>
	<div class="container">
		<div class="row col-sm-offset-2 col-sm-8">
		<form action="/insertBoard" method="post" >
			<table class="table table-striped table-bordered">
				<tbody>
					<tr>
						<td>글 제목</td>
						<td><input type="text" class="form-control" name="title" maxlength="50"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" class="form-control" name="writer" maxlength="50"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea class="form-control" name="content" rows="5"></textarea></td>
					</tr>
				
				</tbody>
			</table>
			
			<div align="center">
				<input type="submit" class="btn btn-primary" value="등록">
				<a href="/" class="btn btn-default">취소</a>
			</div>
		</form>
		</div>
	</div>
</body>
</html>