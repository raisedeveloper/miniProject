<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/_head.jspf" %>
	<style>
		td, th { text-align: center; }
		
	</style>
	<script>
		function deleteFunc(inum) {
			$('#deleteInum').val(inum);
			$('#deleteModal').modal('show');
		}
	</script>
</head>
<body>
	<%@ include file="../common/_top.jspf" %>
	
	<div class="container" style="margin-top:px">
		<div class="row">
			<%@ include file="../common/_aside.jspf" %>
			 
			<div class="col-9">
				<h3><strong class="me-5">사용자 목록</strong>
					<span style="font-size:16px"><a href="/mp/mini/user/register"><i class="fa-solid fa-user-plus"></i> 사용자 가입</a></span>
				</h3>
				<hr>
				<div class="row">
					<div class="col-1"></div>
					<div class="col-10">
						<table class="table">
							<tr><th>장비 번호</th><th>카테고리</th><th>장비 이름</th><th>장비 설명</th><</tr>
							<c:forEach var="equip" items="${equipList}">
							<tr>
								<td>${equip.inum}</td>
								<td>${equip.category}</td>
								<td>${equip.ename}</td>
								<td>${equip.eContent}</td>
								
							</tr>
							</c:forEach>
						</table>
						<%-- ** pagination --%>
						<%-- 반복되는 거 찾아서 반복문 사용하기 --%>
						<ul class="pagination justify-content-center mt-4">
							<li class="page-item"><a class="page-link" href="#"><i class="fa-solid fa-less-than"></i></a></li>
							<c:forEach var="page" items= "${pageList}">
								<li class="page-item ${currentUserPage eq page ? 'active' : ''}">
									<a class="page-link" href="/mp/mini/equipment/list?page=${page}">${page}</a>
								</li>
							</c:forEach>
							
			
							<li class="page-item"><a class="page-link" href="#"><i class="fa-solid fa-greater-than"></i></a></li>
						</ul>						
					</div>
					<div class="col-1"></div>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="../common/_bottom.jspf" %>
	
	
</body>
</html>