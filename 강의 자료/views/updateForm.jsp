<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Spring MVC 게시판</title>
</head>
<body>
	
	<c:import url="header.jsp"></c:import>
	
	<h1 align="center">글 수정</h1>
	<div class="container">
		<div class="row col-sm-offset-2 col-sm-8">
		<form action="/updateBoard" method="post">
			<input type="hidden" name="seq" value="${board.seq }" />
			<table class="table table-striped table-bordered">
				
				<tbody>
					<tr>
						<td>글 제목</td>
						<td><input type="text" class="form-control" name="title" maxlength="50" value="${board.title }"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" class="form-control" name="writer" maxlength="50" value="${board.writer }"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea class="form-control" name="content" rows="5">${board.content }</textarea></td>
					</tr>
					<tr>
						<td>작성일</td>
						<td>
							<fmt:parseDate var="parseDate" value="${board.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
			  				<fmt:formatDate value="${parseDate }" pattern="yyyy-MM-dd HH:mm"/>
						</td>
					</tr>
					<tr>
						<td>조회수</td>
						<td>${board.cnt }</td>
					</tr>
				</tbody>
			</table>
			
			<div align="center">
				<input type="submit" class="btn btn-warning" value="수정">
				<a href="/getBoard?seq=${board.seq }" class="btn btn-default">취소</a>
			</div>
		</form>
		</div>
	</div>

</body>
</html>