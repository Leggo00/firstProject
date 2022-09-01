<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<script type="text/javascript">
	function testajax(){  
		var url = "${pageContext.request.contextPath}/board/test";
		var paramData = {
				"msg" : "testMsg"
		};
		
		$.ajax({
			url : url,
			data :  paramData,
			dataType : 'json',
			type : 'POST',
			success : function(result){
				console.log(result);	
				console.log("성공");	
				var htmls = "";
				//<input type="button"  id="test" name="test" onclick="testajax();"  value="ajax button">
				htmls += '<div>성공하였습니다</div><br>'; //스크립트 연결시 '' 쓰기
				htmls += '<div>======<h2>뇸=뇽뇨뇨요뇨뇸뇸뇸 > _<</h2>======</div><br>';
				htmls += '<input type="button"  id="test" name="test" onclick="testajax();"  value="ajax button"><br>';
				//선택요소를 다른것으로 바꿈.
				$('#divtest').replaceWith(htmls);
			},
			error : function(result){
				var htmls = "";
				htmls += '<div>실패!</div><br>'; //스크립트 연결시 '' 쓰기
				$('#divtest').replaceWith(htmls);
				console.log(result);	
				console.log("실패");	
			}
		});
		
		
	}	

	function validate(){
		alert("띠용 전송하기 유효성 검사");
		console.log("전송하기- 유효성 검사");
		var f= document.f;
		
		if (!f.title.value){
			alert("제목을 입력하세요.");
			f.title.focus();
			return false;
		}
		//document.f.title = >  document.getElementByID("")  //아이디 부여해주면. 이렇게바꿈
		return true;
	}	

</script>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<%@ include file="include/head.jsp" %>
<%@ include file="include/plug_in.jsp" %>
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
    	<div id="divtest">
    		<input type="button"  id="test" name="test" onclick="testajax();"  value="ajax button">
    	</div>
    
    
    
      <div class="box-header">
         <h3 class="box-title">게시판 글쓰기</h3>
      </div>
   
      <form role="form" name="f" method="post" onsubmit="return validate();">
         <div class="box-body">
            <div class="form-group">
               <label>제목</label> <input type="text"
                  name='title' id='title' class="form-control" placeholder="제목을 입력하세요">
            </div>
            <div class="form-group">
               <label>내용</label>
               <textarea class="form-control" name="content" rows="3"
                  placeholder="내용을 입력하세요"></textarea>
            </div>
   
            <div class="form-group">
               <label>작성자</label> <input type="text" name="id" class="form-control"  
                  value="${user.name }" readonly>
            </div>
         </div>
   
         <div class="box-footer">
            <button type="submit" class="btn btn-primary">작성완료</button>
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