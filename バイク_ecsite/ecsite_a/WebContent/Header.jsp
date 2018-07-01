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
		<title>header表示</title>

		<style type="text/css">
		.contents {
		height:50px;
		width:100%;
		background-color:skyblue;
		line-height:30px;
		}

		li{
		float:left;
		list-style:none;
		color:black;
		padding-right:30px;
		padding-top:10px;


		}

		</style>
</head>
<body>

<!-- ヘッダーのメニュー内容 -->
<header>
	<div class="contents">
		<ul>
			<li><a href='<s:url action="GoHomeAction"/>'>Home</a></li>
			<li><a href='<s:url action="GoLoginAction"/>'>Login</a></li>
			<li><a href='<s:url action="ProductPageAction"/>'>Product</a></li>
			<li><a href='<s:url action="MyPageAction"/>'>MyPage</a></li>
			<li><a href='<s:url action="LogoutAction"/>'>Logout</a></li>
		</ul>
	</div>
</header>





</body>
</html>