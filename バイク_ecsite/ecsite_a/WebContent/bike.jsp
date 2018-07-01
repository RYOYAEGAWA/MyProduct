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

<body>
<s:include value="Header.jsp"></s:include>

		<div id="main">
			<h3>BUY BIKE</h3>


			<!-- メーカー表示機能 -->
	<s:form action="MakerSearchAction">
	<tr>
		<td>
		<select name="sortMaker" onchange="submit(this.form)">
			<option value="0" selected="selected">メーカー選択</option>
			<option value="kawasaki">カワサキ</option>
			<option value="yamaha">ヤマハ</option>
			<option value="harley-davidson">ハーレー</option>
		</select>
		</td>
	</tr>
	</s:form>


	<p><a href='<s:url action="ProductPageAction"/>'>検索のリセット</a></p>


	<!-- 商品検索機能 -->
	<s:form action="SearchAction">
	<tr>
		<td><s:textfield name="searchWord" value=""/><s:submit class="button" value="検索"/></td>
	</tr>
	</s:form>

	<!-- 商品テーブル -->
<div class="item-table">

	<table>
	<s:form action="BuyItemAction">

<!-- カテゴリソート① -->
	<s:if test="session.sortMaker=='kawasaki'">
	<s:iterator value="session.MakerList">

			<div class="item_description">

			<img class="image" style="width:150px; height:100px;" src="<s:property value='image_file_path'/>" >

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
			<s:property value="MakerName" /><br>

			<%-- <span>在庫:</span>
			<s:if test="item_stock>0">
				<s:property value="item_stock"/>
			</s:if> --%>
		<%-- 	<s:else>
				<span class="error-message">品切れ</span>
			</s:else> --%>


			<br>

			<span>購入個数:</span>

				<div class="select-box">
				<select name="count">
					<option value="0" selected="selected">-</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				</div>

			<s:else>
				<select name="count">
					<option value="0" selected="selected">0</option>
				</select>
			</s:else>

			</div>

	</s:iterator>
	</s:if>

<!-- カテゴリソート② -->
	<s:elseif test="session.sortMaker=='yamaha'">
	<s:iterator value="session.MakerList">


			<div class="item_description">


			<img class="image" style="width:150px; height:100px;" src="<s:property value='image_file_path'/>" >

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
			<s:property value="MakerName" /><br>

			<br>

			<span>購入個数:</span>

				<div class="select-box">
				<select name="count">
					<option value="0" selected="selected">-</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				</div>

			<s:else>
				<select name="count">
					<option value="0" selected="selected">0</option>
				</select>
			</s:else>

			</div>

	</s:iterator>
	</s:elseif>


<!-- カテゴリソート③ -->
	<s:elseif test="session.sortMaker=='harley-davidson'">
	<s:iterator value="session.MakerList">


			<div class="item_description">


			<img class="image" style="width:150px; height:100px;" src="<s:property value='image_file_path'/>" >

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
			<s:property value="MakerName" /><br>


			<br>

			<span>購入個数:</span>

				<div class="select-box">
				<select name="count">
					<option value="0" selected="selected">-</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				</div>

			<s:else>
				<select name="count">
					<option value="0" selected="selected">0</option>
				</select>
			</s:else>



			</div>

	</s:iterator>
	</s:elseif>


<!-- カテゴリソートしない時の表示 -->
	<s:else>
	<s:iterator value="session.AllItem">


			<div class="item_description">

			<img class="image" style="width:150px; height:100px;" src="<s:property value='image_file_path'/>" >

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
			<s:property value="MakerName" /><br>
			<br>

			<span>購入個数:</span>

					<div class="select-box">
					<select name="count">
						<option value="0" selected="selected">-</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
			</div>

				<s:else>
					<select name="count">
						<option value="0" selected="selected">0</option>
					</select>
				</s:else>
			</div>

	</s:iterator>
	</s:else>
	<br>
	<br>

					<tr>
							<td>
									<span>支払い方法</span>
							</td>
							<td>
									<input type="radio" name="pay" value="1" checked="checked">現金払い
									<input type="radio" name="pay" value="2">クレジットカード
							</td>
					</tr>
					<tr>
							<td>
									<s:submit value="購入"/>
							</td>
					</tr>


</s:form>
</table>

</div>
</div>
</body>
</html>