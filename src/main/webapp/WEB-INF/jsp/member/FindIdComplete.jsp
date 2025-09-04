<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/template/header.do" charEncoding="utf-8">
	<c:param name="title" value="아이디찾기"/>
	<c:param name="css" value="/asset/member/css/login.css"/>
	<c:param name="commonCssUseAt" value="Y"/>
</c:import>

<h2 class="icon1">아이디 찾기</h2>
<p class="mB20">아래의 사용자 확인 방법 중 하나를 선택하여 회원가입 시 등록한 정보를 입력해주세요.</p>

<div class="bg-area">
    <p class="bg-txt">
        <c:out value="${result.userNm}"/>님의 아이디는 <em><c:out value="${result.emplyrId}"/></em>입니다.<br />
    </p>
    <div class="btn-cont">
        <a href="/member/findPassword.do" class="btn spot btn_chpw">비밀번호 찾기</a>
        <a href="/login/login.do" class="btn">로그인</a>
    </div>
</div>

<script>
function checkForm(){
	if(!$("#userNm").val()){
		alert("회원명을 입력해주세요.");
		return false;
	}else if(!$("#passwordCnsr").val()){
		alert("비밀번호 정답을 입력해주세요.");
		return false;
	}
}

</script>

<c:import url="/template/footer.do" charEncoding="utf-8"/>