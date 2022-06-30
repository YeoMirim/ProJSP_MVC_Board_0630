 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 목록</title>
</head>
<body>

	<h2>게시판 글 리스트</h2>
	<hr>
	
	<table border="1" cellpadding="0" cellspacing="0">
		<tr bgcolor="lightgray" align="center">
			<td>번호</td>
			<td width="400">제목</td>
			<td>글쓴이</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr> 
		<!-- var은 arraylist안에서 뽑아낸 하나의 객체 이름을 지정해줌 -->
		<c:forEach items="${list}" var="bdto">
			<tr>
				<td align="center">${bdto.bid} </td>
				<td>${bdto.btitle} </td>
				<td align="center">${bdto.bname} </td>
				<td align="center">${bdto.bdate} </td>
				<td align="center">${bdto.bhit} </td>
			</tr>
		</c:forEach>
		<tr align="right">
			<td colspan="5">
				<input type="button" value="글쓰기" onclick="location.href='write_view.do'">
			</td>
		</tr>
	</table>
	
</body>
</html>