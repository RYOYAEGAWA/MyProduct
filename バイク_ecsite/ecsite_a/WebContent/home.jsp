<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="Content-Style-Type" content="text/css" />
		<meta http-equiv="Content-Script-Type" content="text/javascript" />
		<meta http-equiv="imagetoolbar" content="no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<title>Home画面</title>

		<style type="text/css">
			body {
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana, Helvetica, sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;
			}

			table {
			text-align:center;
			margin:0 auto;
			}

			#top {
			width:780px;
			margin:30px auto;
			border:1px solid #333;
			}

			/* #header {
			width:100%;
			height:80px;
			background-color:black;
			} */

			#main {
			width:100%;
			height:500px;
			text-align:center;
			margin-top:0px;
			}

			/* #footer {
			width:100%;
			height:80px;
			margin-bottom:0px;
			background-color:skyblue; */
			/* clear:both; */
			}
			/* #text-center {
			display: inline-block;
			text-align: center;
			} */

			/* .HomeImage{
			 display:block;
			 margin:0 auto;
			 height:10px;
			 width:10px;
			 float:left; */
			/* margin-top:0px; */
			/* margin-bottom:0px; */
			/* z-index:5; */
			/* align:middle; */

			}

		</style>

</head>
<body>
<s:include value="Header.jsp"></s:include>
		<!-- <div id="header">
			<div id ="pr">
			</div>
		</div> -->
		<div id="main">

			<div id="top">
				<h1>BIKE</h1>
			</div>

        <!-- 画像挿入 -->
			<div class="HomeImage">
			<div><img src="./image/Top_Bike.jpg"  height=70% width=70%></div>
			</div>

		</div>


			<div id="footer">
					<div id="pr">
					</div>
			</div>

</body>
</html>