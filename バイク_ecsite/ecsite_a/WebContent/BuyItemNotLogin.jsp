<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="Content-Style-Type" content="text/css" />
		<meta http-equiv="Content-Script-Type" content="text/javascript" />
		<meta http-equiv="imagetoolbar" content="no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<title>BuyItem画面</title>

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
<body>
<s:include value="Header.jsp"></s:include>
		<div id="header">
				<div id="pr">
				</div>
		</div>
		<div id="main">
				<div id="top">
				<p>BuyItem</p>
				</div>
		<div>

		<table>
		<%-- <s:form action="BuyItemAction"> --%>

          <!-- 商品情報取得 -->
		<s:iterator value="session.AllItem">




			<div class="item_description">
			<img class="image" style="width:300px; height:250px;" src="<s:property value='image_file_path'/>" >

			<br><br>

			<span>車種名:</span>
			<s:property value="itemName" /><br>

			<span>値段:</span>
			<s:property value="itemPrice" /><span>円</span><br>

			<span>スタイル:</span>
			<s:property value="style" /><br>

			<span>排気量:</span>
			<s:property value="engine_cc" /><span>cc</span><br>

			<span>メーカー:</span>
			<s:property value="makerName" /><br>

			<%-- <span>購入個数:</span>

					<div class="select-box">
					<select name="count">
						<option value="0" selected="selected">-</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
			</div> --%>

				<%-- <s:else>
					<select name="count">
						<option value="0" selected="selected">0</option>
					</select>
				</s:else> --%>
			</div>



	</s:iterator>

		</table>

			<div id="text-link">
		<p><a href='<s:url action="GoLoginAction" />'>商品を購入する場合はこちらからログインしてください。</a></p>
		<p><a href='<s:url action="GoHomeAction" />'>Homeへ戻る場合はこちら</a></p>
			</div>

		</div>
	</div>
	<div id="footer">
			<div id="pr">
			</div>
	</div>



</body>
</html>