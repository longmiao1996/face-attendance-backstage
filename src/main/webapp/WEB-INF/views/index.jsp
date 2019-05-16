<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<script type="text/javascript">
$(window).ready(function() {
	$(".b_upload").click(function(){
		var image_p=$(".img_p").attr("src");
		var id=$(".number").val();
		var name=$(".name").val();
		var array = ["1", "2"];
		//alert(image_p);
		$.ajax({
			type : 'POST', 
			url : "http://localhost:8080/springBoot/sign_over",
			data : {
				id_m:25
				//"options":array,
			},
			dataType : "json",
			success : function(msg) {
				alert(typeof(msg));
				alert("sdaf");
				 if (msg) {
					alert("匹配成功");
					window.location.href = 'index';
				} else {
					alert("匹配失败");
					window.location.href = 'login';
				} 
			},
			error:function(msg){
				alert("error");
			}
		});
	});
	$(".test").click(function(){
		window.location.href = 'options';
	})
});
</script>
<style>
.outside {
	width: 800px;
	height: 500px;
	position: absolute;
	border-radius: 15px;
	box-shadow: 4px 4px 25px #888888;
}

.leftside {
	width: 400px;
	height: 500px;
	float: left;
	background: #FF4937;
	border-radius: 15px 0 0 15px;
}

.rightside {
	width: 400px;
	height: 500px;
	float: right;
	background: #FFFFFF;
	border-radius: 0 15px 15px 0;
}

.photo {
	width: 200px;
	height: 200px;
	border: dotted;
	border-color: #FFFFFF;
	border-radius: 100px;
	margin: 50px auto;
}

.b_upload {
	background-color: rgba(255, 255, 255, 0.1);
	border: 1px solid;
	border-color: #FFFFFF;
	color: white;
	padding: 15px 42px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 20px;
	border-radius: 25px;
	margin: 50px 0px 50px 118px;
}

.b_upload:active {
	transform: scale(0.95);
	box-shadow: 0px 0px 25px #FF8C80;
}

.h1_sign {
	font-weight: bolder;
	text-align: center;
	margin: 50px auto;
}

.p_mes {
	text-align: center;
}

.number {
	width: 250px;
	height: 40px;
	font-size: 20px;
	margin: 50px auto;
}

.name {
	width: 250px;
	height: 40px;
	font-size: 20px;
	margin: 50px auto;
}

.b_sign {
	background-color: rgba(255, 73, 55, 0.9);
	border: 1px solid;
	border-color: #FFFFFF;
	color: white;
	padding: 15px 42px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 20px;
	border-radius: 25px;
	margin-left: 140px;
}

.b_sign:active {
	transform: scale(0.95);
	box-shadow: 0px 0px 25px #FF8C80;
}
.img_p {
			width: 195px;
			height: 195px;
		}
</style>
<body>
<form method="post">
	<div class="outside">
		<div class="leftside">
			<div class="photo">
			<img src="C:\Users\17604\Pictures\证件照\zp\1寸.jpg" name="image" class="img-circle img_p"/>
			</div>
			<button class="b_upload">手动上传</button>
		</div>
		<div class="rightside">
			<h1 class="h1_sign">签到</h1>
			<p class="p_mes">与会人员信息</p>
			<input type="text" class="form-control number" id="number" name="id"
				placeholder="工号"> 
			<input type="text"
				class="form-control name" id="name" name="name" placeholder="姓名">
			<button class="b_sign">签到</button>
			<button class="b_sign test">test</button>
		</div>
	</div>
	</form>
</body>


</html>