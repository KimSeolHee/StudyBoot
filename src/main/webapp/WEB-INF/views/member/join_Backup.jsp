<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <c:import url="../temp/boot.jsp"></c:import>
    <script defer src="/js/util.js"></script>
    <script defer src="/js/add.js"></script>
  </head>
  <body>
    <form action="./join" method="POST" id="join_form">
      <h3>회원가입</h3>
      <label>ID</label>
      <input type="text" name="id" id="id" />
      <div id="id_text"></div>
      <label>PW</label>
      <input type="password" name="pw" id="pw" />
      <div id="pw_text"></div>
      <label>PW확인</label>
      <input type="password" name="pw" id="pwCheck" />
      <div id="pw2_text"></div>
      <label>NAME</label>
      <input type="text" name="name" id="name" />
      <div id="name_text"></div>
      <label>EMAIL</label>
      <input type="text" name="email" id="email" />
      <div id="email_text"></div>
      <div>
        <div>모두동의하기</div>
        <div><input type="checkbox" id="all" /></div>
        <div>
          동의1<input type="checkbox" class="check" />
          <div>약관1</div>
          동의2<input type="checkbox" class="check" />
          <div>약관2</div>
          동의3<input type="checkbox" class="check" />
          <div>약관3</div>
        </div>

        <div>
          <select name="" id="s1">
            <option value="">1</option>
            <option value="">2</option>
          </select>
          <button id="s1Add" type="button">Add</button>
        </div>
      </div>
      <button id="s_btn" type="button">가입하기</button>
      <button id="test" type="button">Post Test</button>
      <button id="test2" type="button">Ajax Get Test</button>
      <button id="test3" type="button">Ajax Post Test</button>
    </form>
  </body>
</html>
