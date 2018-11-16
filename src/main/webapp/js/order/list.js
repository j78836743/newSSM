$(function() {

    //初始化列表
    $("#order-list").datagrid({
        //工具栏
        toolbar : '#order-list-toolbar',
        //远程访问后台请求 并返回数据信息
        url : contextPath + "/order/query",
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

            {title:"订单号",field:"orderId",align:'center',width:50},
            {title:"单车号",field:"bicyclecode",align:'center',width:50},
            {title:"用户名",field:"uName",align:'center',width:50},
            {title:"电话",field:"uTel",align:'center',width:50},
            {title:"使用时间",field:"useTime",align:'center',width:50},
            {title:"归还时间",field:"terTime",align:'center',width:50,
                formatter:function(value,row,index){

                    if(value == null) {
                        return '<span style="color:red">'+ '未归还' + '</span>';
                    }
                    return value;
                }},
            {title:"操作",field:"id",align:'center',width:50,
                formatter:function(value, row, index) {

                    if (value != null) {
                        return '<span class="icon_chakan"><a href="javascript:void(0);" class="easyui-linkbutton" onclick="eventObj1.ret(\'' + value + '\');" title="归还">归还</a></span>';
                    }
                }
            }

        ]]

    });

});


//操作事件
var eventObj1 = {

    add : function(){

        $("#order-dialog").dialog({
            title: '增加',
            width: 400,
            height: 300,
            closed: false,
            cache: false,
            href: contextPath + '/pages/order/addAndUpdate.jsp',
            modal: true ,
            buttons:[
                {
                    text:'借车',
                    iconCls:'icon-add',
                    handler:function(){

                        $("#order-form").form("submit",{

                            url:contextPath + '/order/add',

                            onSubmit : function(p){
                                p.etoak = 'et1807';

                                return $("#order-form").form('validate');
                            },
                            success : function(result){
                                var data = $.parseJSON(result);
                                if(data.code == '200') {
                                    //关闭窗口
                                    $("#order-dialog").dialog("close");
                                    //清除窗口信息
                                    $("#order-dialog").dialog("clear");
                                }

                                $.messager.show({
                                    title:'提示',
                                    msg:data.msg,
                                    timeout:5000,
                                    showType:'slide'
                                });

                            }
                        });
                    }
                }
            ]

        });

    },




    ret:function(i){
        $.ajax({
            url: contextPath + '/order/ret',
            type: "POST",
            dataType: "json",
            data: {
                "id": i

            },
            async: false,
            success: function(data) {
                $("#order-list").datagrid('reload');
                $.messager.show({
                    title:'提示',
                    msg:data.msg,
                    timeout:5000,
                    showType:'slide'
                });

            },
            error: function() {
                alert("error");
            }
        });
    },


    acount:function(){
        $.ajax({
            url: contextPath + '/order/acount',
            type: "POST",
            dataType: "json",

            async: false,
            success: function(data) {

                $.messager.show({
                    title:'提示',
                    msg:data.msg,
                    timeout:5000,
                    showType:'slide'
                });

            },
            error: function() {
                alert("error");
            }
        });
    }






};





