<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Physical 확인</title>
</head>
<body>
  <h1>신체 검사 확인 페이지입니다</h1>

  <h3>귀하의 신체검사 결과</h3>
  <ul>
    <li>이름 : ${param.inputName}</li>
    <li>나이 : ${param.inputAge}</li>
    <li>성별 : ${param.inputGender}</li>
    <li>키 : ${param.inputHeight}</li>
    <li>몸무게 : ${param.inputWeight}</li>
  </ul>

  <c:if test="${param.inputWeight > 80}">
    <h3>비만입니다</h3>
  </c:if>

  <c:if test="${param.inputWeight <= 80}">
    <h3>정상 체중입니다</h3>
  </c:if>

  <c:if test="${param.inputWeight <= 40}">
    <h3>저체중입니다</h3>
  </c:if>


</body>
</html>