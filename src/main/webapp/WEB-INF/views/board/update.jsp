<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
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
    <script defer src="/js/writer.js"></script>
  </head>
  <body>
    <c:import url="../temp/boot.jsp"></c:import>
    <section class="container">
      <form action="./update" method="post" enctype="multipart/form-data">
        <div class="mt-4" style="text-align: center">
          <h1
            style="
              font-family: cursive;
              color: #d2691e;
              border: solid 3px #d2691e;
              border-radius: 15px;
              width: 250px;
              margin: 0 auto;
              padding: 0.2em;
            "
          >
            글수정
          </h1>
        </div>

        <div class="mt-3">
          <div style="text-align: center">
            <label
              class="p-3"
              for="exampleFormControlInput1"
              style="font-family: cursive; font-size: 30px"
              >글제목</label
            >
            <input
              type="text"
              name="title"
              value="${qnaVO.title}"
              style="
                display: block;
                margin: 0 auto;
                width: 70%;
                padding: 0.5em;
                border-radius: 10px;
              "
            />
          </div>
          <div style="text-align: center">
          <input name="num" value="${qnaVO.num}" style="display: none"/>
            <label
              class="p-3"
              for="exampleFormControlInput1"
              style="font-family: cursive; font-size: 30px"
              >글내용</label
            >
          </div>
          <textarea
            name="contents"
            class="form-control mt-1"
            id="contents"
          ></textarea>
          <div class="d-flex justify-content-between">
            <div class="mt-2" id="files">
            <c:forEach items="${qnaVO.qnaFileVOs}" var="fileVO">
            ${fileVO.oriName}<button type="button" class="deleteFile btn btn-outline-danger" data-file-num="${fileVO.fileNum}">X</button>
            </c:forEach>
            </div>
          </div>
          <div></div>
          <div>
            <button type="button" class="btn btn-outline-info" id="fileAdd">
              fileAdd
            </button>
          </div>
        </div>
        <div class="d-flex justify-content-end mt-2">
          <button
            class="btn btn-outline-info"
            style="margin: 0 auto; width: 100%"
          >
            작성하기
          </button>
        </div>
        <a
          href="./list"
          style="text-decoration: none"
          class="btn btn-outline-danger mt-2"
          >👈뒤로가기</a
        >
      </form>
    </section>
    <script src=""></script>
    <script type="text/javascript">
      $("#contents").summernote({
        height: 400,
        minHeight: null,
        maxHeight: null,
        focus: true,
      });
      $("#contents").summernote('code','${qnaVO.contents}');
      
      count = ${qnaVO.qnaFileVOs.size()}
    </script>
  </body>
</html>
