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
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

		<title>BuyItemConfirm画面</title>

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

		#header {
		width: 100%;
		height: 80px;
		background-color: black;
		}

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
	<script type="text/javascript">
			function submitAction(url) {
				$('form').attr('action', url);
				$('form').submit();
			}
	</script>


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
				<s:form>


			<s:iterator value="session.list">
			<s:if test="count !=0">

				<dl class="buy-item-list">

					<dd>
					<img class="image" style="width:150px; height:100px;" src="<s:property value='image_file_path'/>" ><br>

					商品名:
					<s:property value="itemName" /><br><br>

					値段:
					<s:property value="itemPrice" /><span>円</span><br>

					スタイル:
					<s:property value="style" /><br>

					排気量:
					<s:property value="engine_cc" /><span>cc</span><br>

					メーカー:
					<s:property value="makerName" /><br>

					購入個数:
					<s:property value="count" /><span>個</span><br>

					</dd>
				</dl>
				<br>

			</s:if>
		</s:iterator>

		<dl class="buy-item-confirm">
					<dd>
						支払い方法:
						<s:property value="session.pay" />
					</dd>
					<dd>

							合計金額:
							<s:property value="session.totalPrice_a"/><span>円</span>

<!--
						<s:if test="AllItem.size()>1">
							合計金額1:
							<s:property value="session.totalPrice_a"/><span>円</span>
						</s:if>
						<s:else>
							合計金額2:
							<s:property value="session.total_price"/><span>円</span>
						</s:else>
-->
					</dd>
				</dl>
								<tr>
								<td><input type="button" value="戻る"
									onclick="submitAction('HomeAction')" /></td>
								<td><input type="button" value="完了"
										onclick="submitAction('BuyItemConfirmAction')" /></td>
								</tr>
					</s:form>
				</div>


<div>
<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
<p>マイぺージは<a href='<s:url action="MyPageAction" />'>こちら</a></p>
</div>


		</div>
		<div id="footer">
			<div id="pr">
			</div>
		</div>

 </body>
</html>
