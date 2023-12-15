<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<h1>/board/listAll.jsp</h1>

${result }

<script>
	// JSP(java) >> JSTL,EL >> HTML >> Javascript
	var result = "${result}";
	if(result == "CREATED") {
		alert("글쓰기 완료");
	}
</script>

<div class="box-header with-border">
	<h3 class="box-title">Bordered Table</h3>
</div>


<div class="box-body">
	<table class="table table-bordered">
		<tbody>
			<tr>
				<th style="width: 10%">번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th style="width: 20%">작성일자</th>
				<th>조회수</th>
			</tr>
			
		<c:forEach var="bvo" items="${bList }">
			<tr>
				<td>${bvo.bno }</td>
				<td>
					<a href="/board/read?bno=${bvo.bno }">${bvo.title }</a>
				</td>
				<td>${bvo.writer }</td>
				<td>
				<fmt:formatDate value="${bvo.regdate }" dateStyle="short"/>
				</td>
				<td><span class="badge bg-red">${bvo.viewcnt }</span></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>


<div class="box-footer clearfix">
	<ul class="pagination pagination-sm no-margin pull-right">
		<li><a href="#">«</a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">»</a></li>
	</ul>
</div>




<%@ include file="../include/footer.jsp"%>