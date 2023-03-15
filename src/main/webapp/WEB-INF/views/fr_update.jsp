<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ page session="false" %>
<!DOCTYPE html>

<html>
<!-- head -->
<%@ include file="include/head.jsp" %>
<!-- head end -->

<body>
<!-- Main Header -->
  <!-- header -->
<%@ include file="include/header.jsp" %>
<!-- header end -->
<!-- hero -->
<%@ include file="include/hero.jsp" %>
<!-- hero end --> 
<div>

    <!-- Main content -->
    <section>
		<div>
			<h3>게시판 글수정</h3>
		</div>
		<form role="form" method="post">
		<div>
			<div class="form-group">
				<label>제목</label> <input type="text"
					name='title' class="form-control"  value="${board.b_title}">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" name="content" rows="3">${board.b_content}</textarea>
			</div>

			<div class="form-group">
				<label>작성자</label> <input type="text"
					name="id" class="form-control"  
					readonly="readonly"  value="${board.u_p_id}">
			</div>
			<!-- 수정에 사용할 글번호 -->
			<input type="hidden" name="b_p_bno" value="${board.b_p_bno}" />
		</div>

		<div>
			<button type="submit" class="btn btn-primary">수정완료</button>
		</div>
	</form>
		
    </section>
    <!-- /.content -->
  </div>


<!-- Footer Section Begin -->
<%@ include file="include/footertest.jsp" %>
<!-- Footer Section End -->

<!-- Js Plugins -->
<%@ include file="include/plug_in.jsp" %>   

</body>
</html>