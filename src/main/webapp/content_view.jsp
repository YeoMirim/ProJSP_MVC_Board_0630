<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 내용 보기</title>
</head>
<body>

	<h2>글 내용 보기</h2>
	<hr>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify.do" method="post">	
			<input type="hidden" name="bid" value="${contentView.bid }"> <!-- 히든속성으로 값을 숨김 -->
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="btitle" size="60" value="${contentView.btitle }">
				</td>		
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bname" size="60" value="${contentView.bname }"></td>		
			</tr>
			<tr>
				<td>게시일</td>
				<td>${contentView.bdate }</td>		
			</tr>
			<tr>
				<td>조회수</td>
				<td>${contentView.bhit }</td>		
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="bcontent">${contentView.bcontent }</textarea></td>		
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글수정"> &nbsp;&nbsp;
					<input type="button" value="글목록" onclick="location.href='list.do'"> &nbsp;&nbsp;
					<a href="delete.d?bid=${contentView.bid }" >글삭제</a>
				</td>		
			</tr>
		</form>
	</table>

</body>
</html>