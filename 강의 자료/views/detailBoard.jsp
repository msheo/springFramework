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
	 
	<h1 align="center">글 상세</h1>
	<div class="container" >
		<div class="row">
			<div class="col-sm-offset-2 col-sm-8">
				<form>
				<input type="hidden" name="seq" value="${board.seq }" />
				<table class="table table-striped table-bordered">
					<tbody>
						<tr>
							<td>글 제목</td>
							<td>${board.title }</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td>${board.writer }</td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea class="form-control" name="content" rows="5" readonly>${board.content }</textarea></td>
						</tr>
						<tr>
							<td>등록일</td>
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
				</form>
				
				<div align="center">
					<a href="/" class="btn btn-primary">목록</a>
					<a href="/updateForm?seq=${board.seq }" class="btn btn-warning">수정</a> 
					<a onclick="return confirm('정말로 삭제하겠습니까?')"  href="/deleteBoard?seq=${board.seq }" class="btn btn-danger">삭제</a> 
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>