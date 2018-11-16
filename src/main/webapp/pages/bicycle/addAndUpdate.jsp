<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>


</head>
<body>
	<form id="bicycle-form" method="GET">
		<table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">

			<input type="hidden" name="bicycleId" value="">
			<input type="hidden" name="bicyclecode" value="">

			<tr>
				<td>单车名</td>
				<td><input  name="bicycleName" id="bicycleName" class="easyui-textbox" data-options="required:true,width:180" /></td>
			</tr>
			<tr>
				<td>供应商</td>
				<td><input  name="publish" class="easyui-textbox" data-options="required:true,width:180" /></td>
			</tr>


		
			<tr>
				<td>类别</td>
				<td><input  name="bicycleType" class="easyui-combobox" data-options="required:true,width:180, editable:false,valueField:'id', textField:'text' ,
					url:'${pageContext.request.contextPath}/type/getType',
					method:'post',
					animate:true,
					lines:true
				" /></td>
			</tr>

			<tr>
				<td>数量：</td>
				<td>
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',onClick:function(){
					var i = $('#nowcount').numberbox('getValue');
					$('#nowcount').numberbox('setValue',parseInt(i)-1);
					}" ></a>
					<input name="nowcount" id="nowcount"
						   class="easyui-numberbox"
						   data-options="required:true,width:180" />
					<a href="javascript:void(0)" class="easyui-linkbutton"
					   data-options="iconCls:'icon-add',onClick:function(){
					var i = $('#nowcount').numberbox('getValue');
					$('#nowcount').numberbox('setValue',parseInt(i)+1);
					}" ></a>
				</td>
			</tr>
			


		
			
				
		</table>		
			
	</form>	
</body>
</html>