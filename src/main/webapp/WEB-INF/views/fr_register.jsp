<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ page session="false" %>
<!DOCTYPE html>

<html lang="zxx">
<!-- head -->
<%@ include file="include/head.jsp" %>
<!-- head end -->
<body>
<!-- header -->
<%@ include file="include/header.jsp" %>
<!-- header end -->
<!-- hero -->
<%@ include file="include/hero.jsp" %>
<!-- hero end -->

   <!-- Main content -->
    <section>
    
		<form role="form" name="f" method="post">
			<div>
				<div>
					<label>제목</label> 
					<input type="text" name='b_title' id='b_title' placeholder="제목을 입력하세요">
				</div>
				<div>
					<label>내용</label>
					<textarea class="form-control" name="b_content" id="b_content" rows="3"
						placeholder="내용을 입력하세요"></textarea>
				</div>
				<div>
					<label>작성자</label> 
					<input type="text" name="u_p_id" readonly>
				</div>
			</div>
	
			<div>
				<button type="submit" class="btn btn-primary">작성완료</button>
			</div>
		</form>
    </section>
    <!-- /.content -->

    <!-- Footer Section Begin -->
   <%@ include file="include/footertest.jsp" %>
    <!-- Footer Section End -->
    <!-- Js Plugins -->
    <%@ include file="include/plug_in.jsp" %>

</body>

</html>