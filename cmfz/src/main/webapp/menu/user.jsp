<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<script type="text/javascript">
    $(function () {
        var myChart = echarts.init(document.getElementById('statistics_china'));
        option = {
            title: {
                text: '持名法州APP活跃用户',

                left: 'left'
            },
            xAxis: {
                type: 'category',
                data: ['7天', '15天', '30天', '90天', '半年', '一年']
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: [120, 200, 150, 80, 70, 110, 130],
                type: 'bar'
            }]
        };
        myChart.setOption(option);
        $.ajax({
            url:'${pageContext.request.contextPath }/count/user.do',
            type : "POST",
            dataTye:"JSON",
            success:function (data) {
                myChart.setOption({
                    series: [{
                        data: data,
                        type: 'bar'
                    }]
                })
            }
        })

    })



</script>













<div id="statistics_china" style="width: 100%;height: 100%;margin-top: 30px;margin-left: 30px">

</div>
