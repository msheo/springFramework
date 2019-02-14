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

	<h1 align="center">글 목록</h1>
		 
	<div class="container">
		<div class="row">
			<form class="navbar-right form-inline" action="/" method="get">
				<div class="form-group abs-right sub-button">
					<select class="form-control" name="searchCondition">
						<option value="TITLE">제목
						<option value="CONTENT">내용
					</select>
				</div>
				<div class="form-group abs-right sub-button">
					<input name="searchKeyword" class="form-control" type="text" value="${searchKeyword }" />
				</div>
				<div class="form-group abs-right sub-button">
					<input class="btn btn-primary" type="submit" value="검색" />
				</div>
	  		</form>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${boardList}" var="article" >
				  		<tr onclick="location.href='/getBoard?seq=${article.seq }'" style="cursor:pointer;">
				  			<td>
				  				<c:out value="${article.seq }" />
				  			</td>
				  			<td>
				  				<c:out value="${article.title }" />
				  			</td>
				  			<td>
				  				<c:out value="${article.writer }" />
				  			</td>
				  			<td>
				  				<fmt:parseDate var="parseDate" value="${article.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
				  				<fmt:formatDate value="${parseDate }" pattern="yyyy-MM-dd HH:mm"/>
				  			</td>
				  			<td>
				  				<c:out value="${article.cnt }" />
				  			</td>
				  		</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div align="center">
				<a href="/writeForm" class="btn btn-primary">등록</a>
			</div>
		</div>
	</div>
</body>
</html>