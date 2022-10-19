<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- jquery -->
<script
  type="text/javascript"
  src="//code.jquery.com/jquery-3.6.0.min.js"
></script>
<!-- include summernote css/js-->
<link
  href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
  rel="stylesheet"
/>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../temp/boot.jsp"></c:import>
<section class="container">

		<form action="./add" method="post" enctype="multipart/form-data">
			
			<div class="mt-4" style="text-align: center;"><h1 style="font-family:cursive; color: #d2691e; border: solid 3px #d2691e; border-radius: 15px; width: 250px; margin: 0 auto; padding: 0.2em;">글작성하기</h1></div>
			
			<div class="mt-3">
				<div style="text-align: center">
					<label class="p-3" for="exampleFormControlInput1" style="font-family:cursive; font-size: 30px;">글제목</label>
					<input type="text" name="title" placeholder="제목을 입력하시오." style="display: block; margin:0 auto; width:70%; padding: 0.5em; border-radius: 10px;"/>
				</div>
				<div style="text-align: center"><label class="p-3" for="exampleFormControlInput1" style="font-family:cursive; font-size: 30px;">글내용</label></div>
	            <textarea
	              name="contents"
	              class="form-control mt-1"
	              id="contents"
	            ></textarea>
	            <div class="d-flex justify-content-between">
	            	<div class="mt-2">
	            		<input type="file" name="files"/>
	            		<input type="file" name="files"/>
	            	</div>
	            	<div class="d-flex">
		            	<label class="mt-3 me-2" for="exampleFormControlInput1" style="font-family:cursive; font-size: 20px;">작성자</label>
						<input class="mt-2" name="writer" type="text" placeholder="작성자는 뉘신지" style="display: block; width:220px;"/>
					</div>
	            </div>
        	</div>
        	<div class="d-flex justify-content-end mt-2"><button class="btn btn-outline-info" style="margin: 0 auto; width: 100%;">작성하기</button></div>
			<a href="./list" style="text-decoration: none;" class="btn btn-outline-danger mt-2">👈뒤로가기</a>
		</form>
	
</section>
<script type="text/javascript">
  $("#contents").summernote({
    height: 400,
    minHeight: null,
    maxHeight: null,
    focus: true,
  });
</script>
</body>
</html>