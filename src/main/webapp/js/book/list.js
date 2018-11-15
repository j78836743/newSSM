$(function() {

    //初始化列表
    $("#book-list").datagrid({
        //工具栏
        toolbar : '#book-list-toolbar',
        //远程访问后台请求 并返回数据信息
        url : contextPath + "/book/query",
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
        pageSize : 10,
        //每页记录数列表
        pageList : [10,20,30],
        //自适应
        fit : true,
        //列自适应
        fitColumns : true,
        //列 接收后台响应的json信息
        columns : [[
            {title:"主键ID",field:"id",checkbox:true},
            {title:"书名",field:"bookName",align:'center',width:50},
            {title:"出版社",field:"publish",align:'center',width:80},
            {title:"作者",field:"bookAuthor",align:'center',width:80},
            {title:"类别",field:"bookTypeName",align:'center',width:60},
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
        $("#book-dialog").dialog({
            title: '员工查询',
            width: 400,
            height: 280,
            closed: false,
            cache: false,
            href: contextPath + '/pages/book/query.jsp',
            modal: true ,
            buttons : [
                {
                    text : '查询',
                    iconCls : 'icon-search',
                    handler : function() {
                        //load方法会重新发送url属性和method属性
                        $("#book-list").datagrid("load",{
                            ename : $("#ename").textbox("getValue"),
                            did : $("#did").combotree("getValue"),
                            startTime : $("#startTime").datebox("getValue"),
                            endTime : $("#endTime").datebox("getValue")
                        });
                        //关闭查询窗口
                        $("#book-dialog").dialog("close");
                        $("#book-dialog").dialog("clear");
                    }
                }
            ]
        });
    },
    add : function(){
        $("#book-dialog").dialog({
            title: '增加',
            width: 400,
            height: 300,
            closed: false,
            cache: false,
            href: contextPath + '/pages/book/addAndUpdate.jsp',
            modal: true ,
            buttons:[
                {
                    text:'添加',
                    iconCls:'icon-add',
                    handler:function(){

                        $("#book-form").form("submit",{

                            url:contextPath + '/book/add',

                            onSubmit : function(p){
                                p.etoak = 'et1807';

                                return $("#book-form").form('validate');
                            },
                            success : function(result){
                                var data = $.parseJSON(result);
                                if(data.code == '200') {
                                    //关闭窗口
                                    $("#book-dialog").dialog("close");
                                    //清除窗口信息
                                    $("#book-dialog").dialog("clear");
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
        var rows = $("#book-list").datagrid("getSelections");
        var row = $('#book-list').datagrid('getSelected');

        if(rows.length != 1){
            alert("你选中了"+rows.length+"条，修改功能只能选一条");
        }else {

            $("#book-dialog").dialog({
                title: '修改',
                width: 400,
                height: 300,
                closed: false,
                cache: false,
                href: contextPath + '/pages/book/addAndUpdate.jsp',
                modal: true ,
                onLoad:function(){
                    $("#password").textbox('readonly');
                    $("#eno").textbox('readonly');
                    $('#cc').combotree('setValue', row.did);
                    $('#cc').combotree('setText', row.dname);
                    $('#book-form').form('load',{
                        id:row.id,
                        ename:row.ename,
                        password:row.password,
                        eno:row.eno,
                        job:row.job,
                        salary:row.salary,


                    });


                },
                buttons:[
                    {
                        text:'添加',
                        iconCls:'icon-add',
                        handler:function(){

                            $("#book-form").form("submit",{

                                url:contextPath + '/book/update',

                                onSubmit : function(p){
                                    p.etoak = 'et1807';

                                    return $("#book-form").form('validate');
                                },
                                success : function(result){

                                    $("#book-list").datagrid('reload');
                                    var data = $.parseJSON(result);
                                    if(data.code == '200') {

                                        //关闭窗口
                                        $("#book-dialog").dialog("close");
                                        //清除窗口信息
                                        $("#book-dialog").dialog("clear");
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

    }
};





