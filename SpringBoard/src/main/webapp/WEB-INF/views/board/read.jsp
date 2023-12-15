<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<h1>/board/read.jsp</h1>

<!-- 글쓰기 폼태그 시작-->
<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">ITWILL 게시판</h3>
	</div>


	<form role="form" method="post">
		<input type="hidden" name="bno" value="${boardVO.bno }">
	</form> 
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">작성자</label>
				 <input type="text" class="form-control" id="exampleInputEmail1" name="writer"
				        value="${boardVO.writer }" readonly="readonly"\>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">제  목</label>
				 <input type="text" class="form-control" id="exampleInputEmail1" name="title"
				        value="${boardVO.title }" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">내  용</label>
				<textarea class="form-control" rows="3" name="contents" readonly="readonly">${boardVO.contents }</textarea>
			</div>

		</div>

		<div class="box-footer">
		
			<button type="button" class="btn btn-warning">수정하기</button>
			<button type="button" class="btn btn-danger">삭제하기</button>
			<button type="button" class="btn btn-primary">목록으로</button>
		</div>
	
</div>

<!-- 본문보기 끝 -->

<script>

	$(document).ready(function() {
		
		// 목록 버튼 클릭 시 목록으로 페이지 이동
		$(".btn-primary").click(function() {
			location.href="/board/listAll";
		});
		
		var formObj = $('form[role="form"]'); // 태그 자체도 객체다
		
		// 수정 버튼 클릭 시, 글 번호 정보를 submit
		// 이동하는 페이지 주소 변경, 전달방식 변경 (POST->GET)
		
		$(".btn-warning").click(function() {
			formObj.attr("action","/board/modify");
			formObj.attr("method","GET");
			formObj.submit();
		});
		
	});

</script>

<%@ include file="../include/footer.jsp"%>
