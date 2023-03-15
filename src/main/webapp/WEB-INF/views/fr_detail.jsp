<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page session="false" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<!-- head -->
<%@ include file="include/head.jsp" %>
<!-- head end -->

<script>
/*
	$(function(){
		//메인 버튼을 눌렀을 때 처리
		// location.href : 버튼 클릭 시에 넘어 갈 정보
		// Controller와 연결지어서 찾아가기
		$(".btn-success").click(function(){
			location.href="/nyangjipshop";
		});
		//목록 버튼을 눌렀을 때 처리
		$(".btn-primary").click(function(){
			location.href="board_dto/freelist?bno=" + ${board.bno};
		});
		//삭제 버튼을 눌렀을 때 처리
		$(".btn-danger").click(function(){
			location.href="delete?bno=" + ${board.bno};
		});
		//수정 버튼을 눌렀을 때 처리
		$(".btn-warning").click(function(){
			// 팝업창
			alert("???");
			location.href="board_dto/fr_update?bno=" + ${board.bno};
		});
		//댓글작성 버튼을 눌렀을 때 처리
		$(".btn-info").click(function() {
			location.href = "reply?bno=" + ${board.bno};
		});
	})
*/
</script>

<body>
  <!-- Main Header -->
  <!-- header -->
<%@ include file="include/header.jsp" %>
<!-- header end -->
<!-- hero -->
<%@ include file="include/hero.jsp" %>
<!-- hero end --> 

    <!-- Main content --> 
			<div>
				<h3>상세보기</h3>
			</div>
			<div>
				<div>
					<label>제목</label> <input type="text" name="b_title"
						class="form-control" value="${board.b_title}" readonly="readonly" />
				</div>

				<div>
					<label>내용</label>
					<textarea name="b_content" rows="5" readonly="readonly"
						class="form-control">${board.b_content}</textarea>
				</div>

				<div>
					<label>작성자</label> <input type="text" name="u_p_id"
						class="form-control" value="${board.u_p_id}" readonly="readonly" />
				</div>
			</div>


		<div>
			<button type="button" onclick="location.href='${contextPath}/nyangjipshop'"
			class="btn btn-success">메인</button>
			<button type="button" onclick="location.href='${contextPath}/board_dto/fr_update?b_p_bno=${board.b_p_bno}'" 
			class="btn btn-warning">수정</button>
			<button class="btn btn-danger">삭제</button>
			<button type="button" onclick="location.href='${contextPath}/board_dto/freelist'"
			class="btn btn-primary">목록</button>
			<button class="btn btn-info">댓글작성</button>
		</div>
		<!--  
		<div>
		         <div>
		         <table>
		         <tr>
		         <td rowspan="2" width="70%">
		         <textarea class="form-control" name="rememo" id="rememo" placeholder="댓글을 입력하세요"></textarea>
		         </td>
		         <td><input type="text" name="rewriter" id="rewriter" placeholder="댓글작성자"></td>
		         </tr>
		         <tr>
		            <td><button type="button" id="btnReplySave">저장</button></td>
		         </tr>
		      </table>
		         
		         </div>
		      </div>
		      <hr><p></p>
		-->
    <!-- Footer Section Begin -->
   <%@ include file="include/footertest.jsp" %>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <%@ include file="include/plug_in.jsp" %>   
    

<!-- ./wrapper -->

</body>
</html>