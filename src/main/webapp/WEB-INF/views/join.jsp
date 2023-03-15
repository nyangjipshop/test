<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ page session="false" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<style>
   table{
   }
   th{
      text-align : right;
      background-color : pink; 
   }
</style>
<%@ include file="include/head.jsp" %>
<%@ include file="include/plug_in.jsp" %>
<head>
   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<script>



$(function(){
	
	$(".idtest").click(function () {
	    $("#idtest").attr("value","2");
	});
	
	$(".btn-primary").click(function () {
	    var tel1	= document.getElementById("tel1").value;
	    var tel2	= document.getElementById("tel2").value;
	    var tel3	= document.getElementById("tel3").value;
	    
	    $("#tel").attr('value',tel1+"-"+tel2+"-"+tel3);
	});
	
	$("#tel").click(function () {
	    var tel1	= document.getElementById("tel1").value;
	    var tel2	= document.getElementById("tel2").value;
	    var tel3	= document.getElementById("tel3").value;
	    
	    $("#tel").attr('value',tel1+"-"+tel2+"-"+tel3);
	});
	
	$("#password").keyup(function () {
		var password	= document.getElementById("password").value;
		var password2	= document.getElementById("password2").value;
		
		if(password==password2){
			$("#pass2").text("비밀번호가 일치합니다.<br>");
		}else{
			$("#pass2").text("비밀번호가 일치하지 않습니다.<br>");
		}
	});
	
	$("#password2").keyup(function () {
		var password	= document.getElementById("password").value;
		var password2	= document.getElementById("password2").value;
		
		if(password==password2){
			$("#pass2").text("비밀번호가 일치합니다.");
		}else{
			$("#pass2").text("비밀번호가 일치하지 않습니다.");
		}
	});
	
	$("#date").datepicker();
	
	$.datepicker.setDefaults({
		  dateFormat: 'yy-mm-dd',
		  prevText: '이전 달',
		  nextText: '다음 달',
		  changeYear: true ,
          changeMonth: true ,
		  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		  dayNames: ['일', '월', '화', '수', '목', '금', '토'],
		  dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
		  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		  showMonthAfterYear: true,
		  yearSuffix: '년'
		});
	
	
})

function validation(){
	var expid		= /^[a-zA-Z0-9]{8,15}$/;
	var expemail	= /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
	var exptel		= /^[0-9]{3}[-\s\.]?[0-9]{3,4}[-\s\.]?[0-9]{4}$/;
	var exppass 	= /^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,16}$/;
	
	var id			= document.getElementById("id").value;
	var idtest		= document.getElementById("idtest").value;
	var pass		= document.getElementById("password").value;
	var pass1		= document.getElementById("password2").value;
	var tel			= document.getElementById("tel").value;
	var email		= document.getElementById("email").value;
	
	if(idtest==1){
		alert("아이디 중복체크를 해주세요!");
		return false;
	}
	if(expid.test(id)==false){
		alert("아이디는 8~15자리 영문대소문자와 숫자로만 구성해 주세요!");
		return false;
	}
	if(exppass.test(pass)==false){
		alert("비밀번호는 8~16자리 영문대소문자와 숫자,특수문자로 구성해 주세요!");
		return false;
	}
	if(pass!=pass1){
		alert("비밀번호와 비밀번호 확인란이 일치하지 않습니다!");
		return false;
	}
	if(expemail.test(email)==false){
		alert("이메일 형식에 맞지 않습니다.");
		return false;
	}
	if(exptel.test(tel)==false){
		alert("전화번호 입력이 잘못되었습니다.");
		return false;
	}
	
}

</script>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  
  <%@ include file="include/main_header.jsp" %>
  
  <!-- Left side column. contains the logo and sidebar -->

  <%@ include file="include/left_column.jsp" %>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Page Header
        <small>Optional description</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">
      <div class="box-header">
         <h3 class="box-title">회원가입 작성</h3>
      </div>
      <form class="box-body" role="form" name="f" method="post" onsubmit="return validation()">
		아이디<br>
		<input type="text" id="id" name="id" class=form-control placeholder="아이디를 입력해주세요." style="width:200px;">
		<input type="hidden" id="idtest" name="idtest" class=form-control value="1" style="width:200px;" readonly>
		<button type="button" class="bnt idtest">중복확인</button>
      	<br>
      	<label>이름</label>
      	<input type="text" id="name" name="name" class=form-control placeholder="이름을 입력해주세요." style="width:200px;">
      	
      	<label>비밀번호</label>
      	<input type="text" id="password" name="password" class=form-control placeholder="비밀번호를 입력해주세요." minlength="8" maxlength="15" style="width:300px;">
      	<font id="pass1" name="pass1" size="2"></font>
      	<label>비밀번호 확인</label>
      	<input type="text" id="password2" name="password2" class=form-control placeholder="비밀번호를 입력해주세요." minlength="8" maxlength="15" style="width:300px;">
      	<font id="pass2" name="pass2" size="2"></font>
      	<br>
      	핸드폰번호<br>
      	<select id="tel1" name="tel1" class=form-control style="width:80px;">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="018">018</option>
		</select>-
      	<input type="text" id="tel2" name="tel2" class=form-control maxlength="4" style="width:80px;">-
      	<input type="text" id="tel3" name="tel3" class=form-control maxlength="4" style="width:80px;">
      	<input type="hidden" id="tel" name="tel" value="" class=form-control  style="width:200px;" readonly>
      	<br>
      	<label>성별</label><br>
      	남 <input type='radio' id="sex" name="sex" valeu="남">
      	여 <input type='radio' id="sex" name="sex" valeu="여"><br>
      	<div>
      	<label>자기소개</label>
      	<textarea id="con" name="con" class=form-control cols="30" rows="7" style="width:400px;"></textarea>
      	<label>생년월일</label>
      	<input type="text" id="date" name="date" class=form-control style="width:200px;">
      	<label>이메일</label>
      	<input type="text" id="email" name="email" class=form-control style="width:400px;">
      	</div>
      <div class="box-footer">
         <button type="submit"class="btn btn-primary">회원가입 저장</button>
      </div>
      </form>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <%@ include file="include/main_footer.jsp" %>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane active" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="pull-right-container">
                    <span class="label label-danger pull-right">70%</span>
                  </span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

</body>
</html>