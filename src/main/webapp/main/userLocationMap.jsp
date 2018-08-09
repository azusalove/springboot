<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/china.js"></script>
<script type="text/javascript">
    $(function () {
        var myChart = echarts.init(document.getElementById('myTabs_userMap'));
        var option = {
            title: {
                text: 'cmfz用户分布图',
                subtext: '纯属虚构',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['男', '女']
            },
            visualMap: {
                min: 0,
                max: 2500,
                left: 'left',
                top: 'bottom',
                text: ['高', '低'],           // 文本，默认为数值文本
                calculable: true
            },
            toolbox: {
                show: true,
                orient: 'vertical',
                left: 'right',
                top: 'center',
                feature: {
                    mark: {show: true},
                    dataView: {show: true, readOnly: false},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            }
        };
        myChart.setOption(option);
        $.ajax({
            url: "${pageContext.request.contextPath}/user/showUserMapCountBySex",
            dataType: "json",
            success: function (data) {
                myChart.setOption({
                    series: [
                        {
                            name: "男",
                            type: "map",
                            mapType: "china",
                            roam: false,
                            label: {
                                normal: {
                                    show: false
                                },
                                emphasis: {
                                    show: true
                                }
                            },
                            data: data.male
                        },
                        {
                            name: "女",
                            type: "map",
                            mapType: "china",
                            label: {
                                normal: {
                                    show: false
                                },
                                emphasis: {
                                    show: true
                                }
                            },
                            data: data.female
                        }
                    ]
                });
            }
        });
    });
</script>
<div id="myTabs_userMap" style="width: 600px;height:400px;"></div>
