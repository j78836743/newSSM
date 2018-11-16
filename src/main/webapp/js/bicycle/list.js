$(function() {

    //初始化列表
    $("#bicycle-list").datagrid({
        //工具栏
        toolbar : '#bicycle-list-toolbar',
        //远程访问后台请求 并返回数据信息
        url : contextPath + "/bicycle/query",
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
            {title:"主键ID",field:"id",checkbox:true},
            {title:"单车编号",field:"bicyclecode",align:'center',width:50},
            {title:"单车型号",field:"bicycleName",align:'center',width:80},
            {title:"供应商",field:"publish",align:'center',width:80},
            {title:"单车类别",field:"bicycleTypeName",align:'center',width:60},
            {title:"剩余",field:"nowcount",align:'center',width:80,
                formatter:function(value,row,index){
                    //value表示当前列的值 员工职位信息
                    //row表示当前一行的数据信息  row.ename
                    //index表示行的下标   下标从0开始
                    if(value <= 10) {
                        return '<span style="color:red">'+ value + '</span>';
                    }
                    return value;
                }},

        ]]

    });

});


//操作事件
var eventObj = {
    query : function() {
        $("#bicycle-dialog").dialog({
            title: '查询',
            width: 400,
            height: 280,
            closed: false,
            cache: false,
            href: contextPath + '/pages/bicycle/query.jsp',
            modal: true ,
            buttons : [
                {
                    text : '查询',
                    iconCls : 'icon-search',
                    handler : function() {
                        //load方法会重新发送url属性和method属性
                        $("#bicycle-list").datagrid("load",{
                            bicycleName : $("#bicycleName").textbox("getValue"),
                            bicycleType: $("#bicycleType").combotree("getValue")
                        });
                        //关闭查询窗口
                        $("#bicycle-dialog").dialog("close");
                        $("#bicycle-dialog").dialog("clear");
                    }
                }
            ]
        });
    },
    add : function(){
        $("#bicycle-dialog").dialog({
            title: '增加',
            width: 400,
            height: 300,
            closed: false,
            cache: false,
            href: contextPath + '/pages/bicycle/addAndUpdate.jsp',
            modal: true ,
            buttons:[
                {
                    text:'添加',
                    iconCls:'icon-add',
                    handler:function(){

                        $("#bicycle-form").form("submit",{

                            url:contextPath + '/bicycle/add',

                            onSubmit : function(p){
                                p.etoak = 'et1807';

                                return $("#bicycle-form").form('validate');
                            },
                            success : function(result){
                                $("#bicycle-list").datagrid('reload');
                                var data = $.parseJSON(result);
                                if(data.code == '200') {
                                    //关闭窗口
                                    $("#bicycle-dialog").dialog("close");
                                    //清除窗口信息
                                    $("#bicycle-dialog").dialog("clear");
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
    update : function(){
        var rows = $("#bicycle-list").datagrid("getSelections");
        var row = $('#bicycle-list').datagrid('getSelected');

        if(rows.length != 1){
            alert("你选中了"+rows.length+"条，修改功能只能选一条");
        }else {

            $("#bicycle-dialog").dialog({
                title: '修改',
                width: 400,
                height: 300,
                closed: false,
                cache: false,
                href: contextPath + '/pages/bicycle/addAndUpdate.jsp',
                modal: true ,
                onLoad:function(){
                    $("#bicycleId").textbox('readonly');
                    $("#bicyclecode").textbox('readonly');
                    $("#bicycleName").textbox('readonly');
                    $("#nowcount").textbox('readonly');
                    $('#bicycle-form').form('load',{
                        bicycleId:row.bicycleId,
                        bicyclecode:row.bicyclecode,
                        bicycleName:row.bicycleName,
                        publish:row.publish,
                        bicycleType:row.bicycleType,
                        nowcount:row.nowcount,


                    });


                },
                buttons:[
                    {
                        text:'修改',
                        iconCls:'icon-add',
                        handler:function(){

                            $("#bicycle-form").form("submit",{

                                url:contextPath + '/bicycle/update',

                                onSubmit : function(p){
                                    p.etoak = 'et1807';

                                    return $("#bicycle-form").form('validate');
                                },
                                success : function(result){

                                    $("#bicycle-list").datagrid('reload');
                                    var data = $.parseJSON(result);
                                    if(data.code == '200') {

                                        //关闭窗口
                                        $("#bicycle-dialog").dialog("close");
                                        //清除窗口信息
                                        $("#bicycle-dialog").dialog("clear");
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

        }


    },
    remove : function(){
        var rows = $("#bicycle-list").datagrid("getSelections");
        var row = $('#bicycle-list').datagrid('getSelected');

        if(rows.length == 1){

            $.ajax({
                url: contextPath + '/bicycle/remove',
                type: "POST",
                dataType: "json",
                data: {
                    "id": row.bicycleId

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

                }

            });


        }else {

            alert("须选中1个");
        }



    }
};





