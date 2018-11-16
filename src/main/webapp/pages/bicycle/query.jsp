<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>query</title>


</head>
<body>
	
		<table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">	
			<tr>
				<td>单车型号</td>
				<td><input id="bicycleName" name="bicycleName" class="easyui-textbox" data-options="width:180" /></td>
			</tr>				
			<tr>
				<td>单车类型</td>
				<td><input id="bicycleType" name="bicycleType" class="easyui-combobox" data-options="width:180,editable:false,valueField:'id', textField:'text' ,
					url:'${pageContext.request.contextPath}/type/getType',
					method:'post',
					animate:true,
					lines:true				
				" /></td>				
			</tr>		

				
		</table>		
			
</body>
</html>