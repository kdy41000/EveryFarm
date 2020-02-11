<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../resources/css/admin/bootstrap.css">
	<link rel="stylesheet" href="../resources/css/admin/custom.css">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="../resources/js/admin/bootstrap.js"></script>
</head>
<body>
	<div class="container">
		<div class="container bootstrap snippet">
		    <div class="row">
		        <div class="col-xs-12">
		            <div class="portlet portlet-default">
		                <div class="portlet-heading">
		                    <div class="portlet-title">
		                    	<h4><i class="fa fa-circle text-green"></i>실시간 경매리스트</h4>
							</div>
							<div class="clearfix"></div>
						</div>	
						<div id="chat" class="panel-collapse collapse in">
							<div id="chatList" class="portlet-body chat-widget" style="overflow-y: auto; width: auto; height: 600px;">
							<!-- overflow:y 세로로 늘어날 수 있음 -->		
							</div>	 
								
								<!-- 내용부분 -->
								<div class="row"> 
									<div class="col-lg-12">
										<div class="media">
											<a class="pull-left" href="#"><img class="media-object img-circle" src="../resources/images/admin/icon.png" style="width: 50px;"></a>
											<div class="media-body">
												<h4 class="media-heading">홍길동
												<span class="small pull-right">2020년 02월 02일</span>
												</h4>
												<p>꿀사과 경매입니다. 많은 참여 부탁드립니다.</p>
											</div>
										</div>
									</div>
								</div>
								<hr>
								
								<!-- 입력부분 -->
								<div class="portlet-footer">
									<div class="row">
										<div class="form-group col-xs-4">
											<input style="height: 40px;" type="text" id="chatName"
												class="form-control" placeholder="이름" maxlength="20">
										</div>
									</div>
									<div class="row" style="height: 90px">
										<div class="form-group col-xs-10">
											<textarea rows="" cols="" style="height: 80px;" id="chatContent" 
											class="form-control" placeholder="메시지를 입력하세요." maxlength="100"></textarea>
										</div>
										<div class="form-group col-xs-2">
											<button type="button" class="btn btn-default pull-right" onclick="submitFunction();">전송</button>
											<div class="clearfix"></div>
										</div>
									</div>
								</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>