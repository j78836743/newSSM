<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/easyui/include.jsp" %>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/order/list.js"></script>
    <title>Insert title here</title>
</head>
<body>
    <!-- 员工列表 -->
    <table id="order-list"></table>

    <div id="order-list-toolbar">
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="eventObj1.add();">租赁单车</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="eventObj1.acount();">统计今天</a>

    <div id="order-dialog" >
    </div>

</body>
</html>
