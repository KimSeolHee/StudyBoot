<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Index</title>
    <link href="/css/test.css" rel="stylesheet" />
    <script defer src="/js/test.js"></script>
  </head>
  <body>
    <c:import url="./temp/boot.jsp"></c:import>
    <div>
      <c:choose>
        <c:when test="${not empty member}">
        	<h3>${member.name}님 환영합니다.</h3>
          <a href="./member/logout">로그아웃</a>
        </c:when>
        <c:otherwise>
          <a href="./member/login">로그인</a>
          <a href="./member/join">회원가입</a>
        </c:otherwise>
      </c:choose>
    </div>
    <div style="margin-top: 140px">
      <img
        src="/images/2.jpeg"
        style="border-radius: 120px; display: block; margin: 0 auto"
      />
      <h1>명탐정 코난🕵️‍♀️</h1>
      <a
        href="./board/list"
        style="
          display: block;
          text-align: center;
          font-size: 50px;
          text-decoration: none;
          color: black;
        "
        >QNA</a
      >
      <a
        href="./member/join"
        style="font-size: 30px; text-decoration: none; color: black"
        >👩‍💻회원가입</a
      >
      <a
        href="./member/login"
        style="font-size: 30px; text-decoration: none; color: black"
        >🔒로그인</a
      >
      <div class="d-flex justify-content-center">
        <div>
          <img
            alt=""
            src="/file/qna/51ed7ee5-e7aa-4f60-9033-2ff195c1c562_7.jpg"
          />
        </div>
        <div>
          <img
            alt=""
            src="/file/qna/96b38c06-fc31-4172-926b-f87a1402e15e_8.jpg"
          />
        </div>
      </div>
      <button id="btn">BUTTON</button>
      <button class="btns">BUTTONS</button>
      <button class="btns">BUTTONS</button>
      <button class="btns">BUTTONS</button>
    </div>
  </body>
</html>
