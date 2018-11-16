<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>


</head>
<body>
	<form id="order-form" method="GET">
		<table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">

			<input type="hidden" name="id" value="">
			<input type="hidden" name="orderId" value="">

			<tr>
				<td>单车名</td>
				<td><input  name="bicyclecode" class="easyui-combobox" data-options="required:true,width:180, editable:false,valueField:'id', textField:'text' ,
					url:'${pageContext.request.contextPath}/bicycle/getbicyclecodeAndbicycleName',
					method:'post',
					animate:true,
					lines:true
				" /></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input  name="uName" class="easyui-textbox" data-options="required:true,width:180" /></td>
			</tr>
			<tr>
			<td>手机</td>
			<td><input  name="uTel" class="easyui-textbox" data-options="required:true,width:180" /></td>
			</tr>


			<tr>
				<td>开始时间</td>
				<td><input id="useTime" name="useTime" class="easyui-datebox" data-options="width:180" /></td>
			</tr>


		</table>

	</form>
</body>
</html>