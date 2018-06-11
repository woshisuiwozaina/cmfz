<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-edit',
        text: "专辑详情",
        handler: function () {
            var row = $("#album").treegrid("getSelected")
            if(row==null){
                alert("请选中专辑");
            }else{
                if(row.size==null){
                    var date1 = formatDate(row.createDate);
                    row.createDate=date1;
                    $("#album_dialog").dialog("open");
                    $("#album_ff").form("load", row);
                    $("#img").prop("src", row.img);

                }else{
                    alert("请先选专辑！！！")
                }
            }

        }
    }, '-', {
        iconCls: 'icon-help',
        text: "添加专辑",
        handler: function () {
            $("#ablum_add").dialog("open");
        }
    }, '-', {
        iconCls: 'icon-help',
        text: "添加章节",
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            if(row==null){
                alert("请选中行");
            }else{
                if(row.size==null){
                    $("#chapter_dialog").dialog("open");
                    $("#pid").textbox("setValue", row.id);
                }else{
                    alert("请先选专辑！！！")
                }
            }
        }
    }, '-', {
        iconCls: 'icon-help',
        text: "下载音频",
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            location.href = "${pageContext.request.contextPath}/album/down.do?url=" + row.url + "&name=" + row.name;
        }
    }]

    $(function () {
        $('#album').treegrid({
            url:'${pageContext.request.contextPath}/album/all.do',
            idField:'id',
            treeField:'name',
            fitColumns:true,
            toolbar:toolbar,
            onDblClickRow: function (row) {
                $("#album_paly").dialog("open");
                $("#audio").prop("src",row.url)
            },
            fit:true,
            columns:[[
                {field:'name',title:'名字',width:80 ,align:'center'},
                {field:'size',title:'大小',width:60,align:'center'},
                {field:'url',title:'下载路径',width:60,align:'center'},
                {field:'time1',title:'时长',width:60,align:'center'}

            ]]
        });

    })

    function formatDate(date, format) {
        if (!format)
            format = "yyyy-MM-dd";
        date = new Date(parseInt(date));
        var dict = {
            "yyyy" : date.getFullYear(),
            "M" : date.getMonth() + 1,
            "d" : date.getDate(),
            "H" : date.getHours(),
            "m" : date.getMinutes(),
            "s" : date.getSeconds(),
            "S" : date.getMilliseconds(),
            "MM" : ("" + (date.getMonth() + 101)).substr(1),
            "dd" : ("" + (date.getDate() + 100)).substr(1),
            "HH" : ("" + (date.getHours() + 100)).substr(1),
            "mm" : ("" + (date.getMinutes() + 100)).substr(1),
            "ss" : ("" + (date.getSeconds() + 100)).substr(1)
        };
        return format.replace(/(y+|M+|d+|H+|s+|m+|S)/g, function(a) {
            return dict[a]
        })
    }
</script>

<table id="album"></table>

<div id="album_dialog" class="easyui-dialog" title="专辑详情" style="width:800px;height:400px;"
     data-options="iconCls:'icon-man',resizable:true,modal:true , closed:true">

    <form id="album_ff" method="post">
        <div>
            <label for="name">名称:</label>
            <input class="easyui-validatebox" id="name" type="text" name="name" readonly="true" style="border:none"/>
        </div>
        <div>
            <label for="count">集数:</label>
            <input class="easyui-validatebox" type="text" id="count" name="count" readonly="true" style="border:none"/>
        </div>
        <div>
            <label for="createDate">创作时间:</label>
            <input class="easyui-validatebox" type="text" id="createDate" name="createDate" readonly="true" style="border:none"/>
        </div>
        <div>
            <label for="author">作者:</label>
            <input class="easyui-validatebox" type="text" id="author" name="author" readonly="true" style="border:none"/>
        </div>
        <div>
            <label for="broadCast">播音:</label>
            <input class="easyui-validatebox" type="text" id="broadCast" name="broadCast" readonly="true" style="border:none"/>
        </div>
        <div>
            <label for="brief">专辑:</label>
            <input class="easyui-validatebox" type="text" id="brief" name="brief" readonly="true" style="border:none"/>
        </div>
        <div>
            <label for="img">封面:</label>
            <img id="img" src="" style="border:none"/>
        </div>
    </form>

</div>

<%-- 专辑的添加 --%>
<div id="ablum_add" class="easyui-dialog" title="专辑添加" style="width:400px;height:200px;"
     data-options="iconCls:'icon-add',resizable:true,modal:true , closed:true,buttons:[{
				text:'保存',
				handler:function(){
             <%--   $('#ablum_add_form').form('submit', {
                 url:'${pageContext.request.contextPath}/album/insert.do',
                 success:function(data){

                      $('#ablum_add').window('close');
                      $('#album').datagrid('reload');
                  }
                 })--%>
                $('#ablum_add_form').form('submit', {
                    url:'${pageContext.request.contextPath}/album/insert.do',
                    onSubmit: function(){
                         var isValid = $(this).form('validate');
                         return isValid;
                        },
                        success:function(data){
                                $('#album').treegrid('reload');
                                $('#ablum_add').window('close');
                        }
                });

				}
			},{
				text:'清空',
				handler:function(){
				$('#ablum_add_form').form('clear');
				}
			}]">

    <form id="ablum_add_form" method="post" enctype="multipart/form-data">
        <div>
            name:
            <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
        </div>
        <div>
            count:
            <input class="easyui-validatebox" type="text" name="count" data-options="required:true" />
        </div>
        <div>
            broadCast:
            <input class="easyui-validatebox" type="text" name="broadCast" data-options="required:true" />
        </div>
        <div>
            createDate:
            <input   name="createDate" type= "text" class= "easyui-datebox" required ="required"> </input>
        </div>
        <div>
            score:
            <input class="easyui-validatebox" type="text" name="score" data-options="required:true" />
        </div>
        <div>
            author:
            <input class="easyui-validatebox" type="text" name="author" data-options="required:true" />
        </div>
        <div>
            brief:
            <input class="easyui-validatebox" type="text" name="brief" data-options="required:true" />
        </div>
        <div>
            img:
            <input class="easyui-filebox" name="img1" style="width:300px">
        </div>
    </form>

</div>

<%-- 章节的添加  --%>

<div id="chapter_dialog" class="easyui-dialog" title="章节的添加" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                  $('#chapter_ff').form('submit', {
                    url:'${pageContext.request.contextPath}/album/add.do',
                    onSubmit: function(){
                         var isValid = $(this).form('validate');
                         return isValid;
                        },
                        success:function(data){
                                $('#album').treegrid('reload');
                                $('#chapter_dialog').window('close');
                        }
                    });
				}
			},{
				text:'清空',
				handler:function(){
				    $('#chapter_ff').form('clear');
				}
			}]">
    <form id="chapter_ff" method="post" enctype="multipart/form-data">
        <div>
            <label for="pid">id:</label>
            <input class="easyui-textbox" value="0" name="pid" id="pid" readonly="true"/>
        </div>
        <div>
            <label for="cname">name:</label>
            <input class="easyui-textbox" value="0" name="cname" id="cname" />
        </div>
        <div>
            <label for="mp3">上传:</label>
            <input class="easyui-filebox" id="mp3" name="mp3"/>
        </div>

    </form>


</div>

<div id="album_paly" class="easyui-dialog" title="播放" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <audio id="audio" src="" controls="controls" autoplay="autoplay"></audio>

</div>