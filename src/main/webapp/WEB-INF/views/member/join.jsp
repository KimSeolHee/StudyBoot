<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
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
  	<form:form modelAttribute="memberVO" method="POST">
<%--     <form action="./join" method="POST" id="join_form"> --%>
      <h3>회원가입</h3>
      <label>ID</label>
      <form:input path="id" cssClass="form-control" id="id"/>
<!--       <input type="text" name="id" id="id" /> -->
       <div id="id_text">
      <form:errors path="id" id="id_text"></form:errors>       
       </div>
      <div><label>PW</label></div>
      <form:password path="pw" cssClass="form-control" id="pw"/>
<!--       <input type="password" name="pw" id="pw" /> -->
      <div id="pw_text"></div>
      <label>PW확인</label>
      <form:password path="pwCheck" cssClass="from-control" id="pw"/>
<!--       <input type="password" name="pw" id="pwCheck" /> -->
	<form:errors path="pw"></form:errors>
<!--       <div id="pw2_text"></div> -->
      <label>NAME</label>
      <input type="text" name="name" id="name" />
      <div id="name_text">
      ${name}
      </div>
      <label>EMAIL</label>
      <form:input path="email"/>
      <form:errors path="email"></form:errors>
<!--       <input type="text" name="email" id="email" />
      <div id="email_text"></div> -->
      <form:input path="age"/>
      <form:errors path="age"></form:errors>
      
      <form:input path="birth"/>
      <form:errors path="birth"></form:errors>
      
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
      <button id="s_btn" type="submit">가입하기</button>
      <button id="test" type="button">Post Test</button>
      <button id="test2" type="button">Ajax Get Test</button>
      <button id="test3" type="button">Ajax Post Test</button>
<%--     </form> --%>
    </form:form>
  </body>
</html>
