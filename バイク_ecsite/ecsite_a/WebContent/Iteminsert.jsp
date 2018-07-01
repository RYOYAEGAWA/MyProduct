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
		<title>バイク商品一覧</title>
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
		width: 100%;
		height: 80px;
		background-color: black;
		} */

		#main {
		width: 100%;
		height: 500px;
		text-align: center;
		}

		/* #footer {
		width: 100%;
		height: 80px;
		background-color: black;
		clear: both;
		} */

	</style>

</head>


<s:include value="Header.jsp"></s:include>
<body>



	<h3>ITEM INSERT</h3>

	<div class="main-content">
		<p>追加する商品の情報を入力してください。</p>

		<div class="push"></div>

		<table>
		<s:form method="post" action="ItemInsertAction">
			商品名<br>
			<input type="text" name="ItemName"/><br><br>

			値段<br>
			<input type="text" name="ItemPrice"/><br><br>
			

			スタイル<br>
			
			<input type="text" name="ItemStyle"/><br><br>

			排気量<br>
			<input type="text" name="ItemEngine_cc"/><br><br>

			メーカー<br>
			<input type="text" name="ItemMakerName"/><br><br>

			画像パス<br>
			<input type="text" name="ImageFilePath"/><br><br>

			<div class="push"></div>

		<s:submit class="button" value="商品を追加する"/>
		</s:form>

		</table>
	</div>

	<div class="push"></div>

	<div id="text-link">
		<p><a href='<s:url action="GoMasterPageAction"/>'>管理画面に戻る場合はこちら</a><br></p>
		<p><a href='<s:url action="LogoutAction"/>'>ログアウトする場合はこちら</a></p>
	</div>





</body>
</html>