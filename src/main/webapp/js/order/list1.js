$(function() {

    //初始化列表
    $("#order-list1").datagrid({
        //工具栏
        toolbar : '#order-list-toolbar',
        //远程访问后台请求 并返回数据信息
        url : contextPath + "/order/querycount",
        //请求类型
        method : 'post',
        //是否显示斑马线
        striped : true,
        //加载信息
        loadMsg : '正在玩命加载，请稍等...',
        //分页工具栏
        pagination : true,
        //显示行号
        rownumbers : true,
        //当前页
        pageNumber : 1,
        //每页记录数
        pageSize : 5,
        //每页记录数列表
        pageList : [5,6,7],
        //自适应
        fit : true,
        //列自适应
        fitColumns : true,
        //列 接收后台响应的json信息
        columns : [[


            {title:"时间",field:"date",align:'center',width:50},
            {title:"公路自行车",field:"a",align:'center',width:50},
            {title:"山地自行车",field:"b",align:'center',width:50},
            {title:"折叠自行车",field:"c",align:'center',width:50},
            {title:"旅行自行车",field:"d",align:'center',width:50}



        ]]

    });

});









