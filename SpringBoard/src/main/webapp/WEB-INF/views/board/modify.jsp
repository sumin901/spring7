<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<h1>/board/modify.jsp</h1>


<!-- 글쓰기 폼태그 시작-->
<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">ITWILL 게시판</h3>
	</div>


	<form role="form" method="post">
		<input type="hidden" name="bno" value="${boardVO.bno }">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">작성자</label>
				 <input type="text" class="form-control" id="exampleInputEmail1" name="writer"
				        value="${boardVO.writer }" \>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">제  목</label>
				 <input type="text" class="form-control" id="exampleInputEmail1" name="title"
				        value="${boardVO.title }" >
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">내  용</label>
				<textarea class="form-control" rows="3" name="contents" >${boardVO.contents }</textarea>
			</div>
			
			<div class="box-footer">
				<button type="submit" class="btn btn-warning">저장하기</button>
				<button type="button" class="btn btn-danger">삭제하기</button>
				<button type="button" class="btn btn-primary">목록으로</button>
			</div>

		</div>
	</form> 

	
</div>

<!-- 본문보기 끝 -->

<script>

	$(document).ready(function() {
		
		// 목록 버튼 클릭 시 목록으로 페이지 이동
		$(".btn-primary").click(function() {
			location.href="/board/listAll";
		});
		
	});

</script>

<%@ include file="../include/footer.jsp"%>
