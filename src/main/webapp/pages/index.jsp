<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/easyui/include.jsp" %>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/index.js"></script>
    <title>图书管理系统</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true" >
    <div data-options="region:'north',split:true" style="height:80px;">
        <div style="float:right;margin-right:20px;line-height: 65px;
    	">
    		<span>
    			欢迎你
    		</span>

        </div>


    </div>



    <div data-options="region:'west',title:'菜单',split:true,width:270">
        <div id="aa" class="easyui-accordion" data-options="fit:true">
            <div title="图书信息管理" style="overflow:auto;padding:10px;">
                <ul class="easyui-tree">
                    <li><a class="opts" url="/book/list" >所有图书</a></li>
                    <li><a class="opts" >其他</a></li>

                </ul>

            </div>
            <div title="借阅信息管理" style="padding:10px;">
                <ul class="easyui-tree">
                    <li><a class="opts" url="/book/list1">借阅信息</a></li>
                    <li><a class="opts" url="/book/list2">未还信息</a></li>

                </ul>
            </div>
            <div title="Title3">
                content3
            </div>
        </div>
    </div>
    <div data-options="region:'center'">
        <div id="content" class="easyui-tabs" data-options="fit:true">



        </div>
    </div>
</div>

</body>
</html>
