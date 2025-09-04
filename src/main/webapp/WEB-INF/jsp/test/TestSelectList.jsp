<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko" >
<title>데이터 가져오기</title>
<link href="/css/common.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
table(border-collapse: collapse;)
th(font-weight:bold;)
th, td(padding:5px;)
a(text-decoration:underline:margin:5px;)
</style>
</head>
<body>
게시물 총 수 : <c:out value="${paginationInfo.totalRecordCount}"/>건

<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>관리</th>
		</tr>
	</thead>
	<tbody>
			<c:forEach var="result" items="${resultList}">
				<tr>
					<td>
						<c:out value="${result.testId}"/>
					</td>
					<td>
						<c:url var="viewUrl" value="/test/select.do">
							<c:param name="testId" value="${result.testId}"/>
						</c:url>
						<a href="${viewUrl}">
							<c:out value="${result.testCtgry}"/>
							<c:out value="${result.testSj}"/>
						</a>
					</td>
					<td>
						<c:out value="${result.testNm}"/>
					</td>
					<td>
						<fmt:formatDate value="${result.testFrstRegistPnttm}" pattern="yyyy-MM-dd"/></td>
					</td>
					<td>
						<c:url var="delUrl" value="/test/delete.do">
							<c:param name="testId" value="${result.testId}"/>
						</c:url>
						<a href="${delUrl}" class="btn-del">삭제</a>
					</td>
				</tr>
			</c:forEach>
	</tbody>
</table>
<div id="paging_div">
<ul class="paging_align">
	<c:url var="pageUrl" value="/crud/selectList.do?"/>
	<c:set var="pagingParam"><c:out value="${pageUrl}"/></c:set>
	<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="${pagingParam}"/>
</ul>
</div>

<button type="button" id="btn-reg" data-href="/test/testRegist.do">등록하기</button>
<script>
$("#btn-reg").click(function(){
	location.href = $(this).data("href");
});

$(".btn-del").click(function(){
	if(!confirm("삭제하시겠습니까?")){
		return false;
	}
});
</script>
</body>
</html>