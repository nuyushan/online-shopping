<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-首页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet" type="text/css" href="css/orderdetail.css">
</head>
<body>
	<!--顶部-->
	<div class="top">
    	<div class="top_center">
            <ul class="top_bars">
            	<li><a href="#">退出</a>|</li>
                <li><a href="#">我的订单<span class="jt_down"></span></a>|</li>
                <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
                <li><a href="#">网站导航<span class="jt_down"></span></a></li>
            </ul>
        </div>
    </div>
    <!--头部-->
    <div class="header3">
        <a href="#"><img src="images/logo.png"></a>
        <div class="h3_center">
            <div class="search_box">
                <input type="text"/>
                <span>搜索</span>
            </div>

        </div>

    </div>
    <!--头部导航-->
    <div class="nav_top">
    	<div class="nav_top_center">
            <div>
                订单详情
            </div>
        </div>
    </div>

    <!--内容-->
    <div class="container4">
        <div class="shop_detail">商品购物清单</div>
        <table>
            <!-- <thead>
                <tr>
                    <th>序号</th>
                    <th>订单编号</th>
                    <th>订单金额</th>
                    <th>订单状态</th>
                    <th>付款方式</th>
                    <th>操作</th>
                </tr>
            </thead> -->
            <tbody>
            <c:forEach items="${orderLines }" var="orderLine" varStatus="status">
           		 <tr>
                    <td>${status.index+1 }</td>
                    <td>${orderLine.book.name }</td>
                    <td>价格：<span>${orderLine.book.price }</span></td>
                    <td>数量：<span>${orderLine.num }</span></td>
                    <td>小计：<span>${orderLine.cost }</span></td>
                    
                </tr>
            </c:forEach>
               <!--  <tr>
                    <td>1</td>
                    <td>corejava</td>
                    <td>价格：<span>35</span></td>
                    <td>数量：<span>35</span></td>
                    <td>小计：<span>35*35</span></td>
                    
                </tr>
				<tr>
                    <td>2</td>
                    <td>第二本书</td>
                    <td>价格：<span>35</span></td>
                    <td>数量：<span>35</span></td>
                    <td>小计：<span>35*35</span></td>
                </tr> -->
                <tr>
                    <td colspan="5" class="count">合计：<span>${cost }</span></td>
                </tr>
            </tbody>
        </table>

    </div>
    <!--脚部-->
    <div class="footer3">
    	<div class="f3_top">
        	<div class="f3_center">
                <div class="ts1">品目繁多 愉悦购物</div>
                <div class="ts2">正品保障 天天低价</div>
                <div class="ts3">极速物流 特色定制</div>
                <div class="ts4">优质服务 以客为尊</div>
            </div>
        </div>
        <div class="f3_middle">
        	<ul class="f3_center">
            	<li class="f3_mi_li01">
                	<h1>购物指南</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>配送方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>支付方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>售后服务</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>服务保障</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li06">
                	<h1>客服中心</h1>
                    <img src="images/qrcode_jprj.jpg" width="80px" height="80px">
                    <p>抢红包、疑问咨询、优惠活动</p>
                </li>
            </ul>
        </div>
         <div class="f3_bottom">
        	<p class="f3_links">
                <a href="#">关于我们</a>|
                <a href="#">联系我们</a>|
                <a href="#">友情链接</a>|
                <a href="#">供货商入驻</a>
           	</p>
            <p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司 </p>
          	<img src="images/police.png">
        </div>
    </div>

</body>
</html>
