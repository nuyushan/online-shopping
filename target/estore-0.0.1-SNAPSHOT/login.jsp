<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-登录页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
    var msg = '${msg}';
    if(msg){
    	alert(msg);
    }
</script>
</head>
<body>
	<div class="header1">
    	<a href="#">
        	<img src="images/logo.png">
        </a>
    </div>
    <div class="content1">	<!--背景颜色-->
    	<div class="c1_box1"><!--背景图片-->
        	<div class="login_box"><!--登陆框-->
            	<div class="center1">
        		<form action="loginServlet" method="post">
                	<h1>账号登陆</h1>
                    <h2>公共场所请不要泄露您的密码，以防止账号丢失
                    </h2>
                    <div class="si_box">
                    	<span class="usr_icon"></span>
                        <input type="text" name="name" value="tom"/>
                    </div>
                    <!--分割条-->
                    <div class="c10"></div>
                    <div class="si_box">
                    	<span class="pwd_icon"></span>
                        <input type="password" name="password" value="123"/>
                    </div>
                    <div class="fg_box">
                        <a class="treg" href="#">立即注册</a>
                    </div>
                    <div class="sub_box">
                    	<input type="submit" value="登陆"/>
                    </div>
                 </form>
                    <div>
                    	请使用合作网站账号登陆杰普电子商务网：
                    </div>
                    <div class="com_box">
                    	<span class="tencent"></span>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer1">
    	<div class="links">
        	<a href="#">关于我们</a>|
            <a href="#">联系我们</a>|
            <a href="#">友情链接</a>|
            <a href="#">关于我们</a>|
            <a href="#">联系我们</a>|
            <a href="#">友情链接</a>
        </div>
        <div>
        	沪ICP备1928832 杰普软件briup.com版权所有。
        </div>

        <img src="images/police.png">

    </div>
</body>
</html>
