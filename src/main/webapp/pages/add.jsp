<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
<script type="text/javascript" 
	src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	function add(){
		$.ajax({
			url: '${pageContext.request.contextPath }/user/add',
			type: 'post',
			data:$("#user").serialize(),
			dataType:'json',
			success:function(data){
				if(data.flag == "success"){
					alert(data.msg);
				}
			}
		});
	}

</script>
</head>
<body>

	<form id="user">
		姓名<input type="text" name="name" />
		密码<input type="text" name="password"/>
		<br />
		<input type="button" value="新增" onclick="add()"/>
	</form>


</body>
</html>