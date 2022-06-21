<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-注册页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
    var msg = '${msg}';
    if(msg){
    	alert(msg);
    }
    
    $(function(){
    	//true -->用户名可用
    	//false-->用户名不可用
    	var falg = false;
    	//console.log($("#name"));
    	//console.log($("#name").val());
    	
    
    	$("#name").on("blur",function(){
    		var name = $("#name").val();
    		if(name && name.trim()){
    			$.ajax({
        			type:"get",
        			url:"checkNameServlet",
        		    data:"name="+name,
        		    dataType:"text",
        		    success:function(result){
        		    	//alert(result);
        		    	/* console.log(result);
        		    	console.log('用户名可用');
        		    	console.log('用户名可用' == result.trim()); */
        		    	if('用户名可用' == result.trim()){
        		    		falg = true;
        		    	}else{
        		    		falg = false;
        		    	}
        		    	$("#show-result").html(result);
        		    }
        		});
    		}
    		
    	});
    	console.log($("form"));
        $("form").on("submit",function(){
        	if($("#name").val() && $("#password").val()){
        		console.log($("#name").val());
        		console.log($("#password").val());
        		if(falg){
        			return true;
        		}
        		alert("用户名不可用，先不用提交了");
        		return false;
        	} 
        	//alert("用户名和密码不能为空");
        	return false;
        });
    });
    
    
    
</script>
</head>
<body>
	<div class="container2">
    	<div class="header2">
        	<div>
            	<a href="#"><img class="logo" src="images/logon_register.png"></a>
            </div>
            <div>
            	<ul class="tabs">
                	<li class="phone current"><a href="#">用户注册，请将信息填写完整</a></li>
                </ul>
            </div>
            <div class="tlg">
            	已有账号 <a href="login.html">登陆</a>
            </div>
        </div>
        <div class="content2">
			<form action="registerServlet" method="post">
            <ul class="reg_box">
                <li>
                    <span><b>*</b>用户名：</span>
                    <input id="name" type="text" name="name"/>
                    <span id="show-result" style="width: 150px;padding-left: 15px;text-align:left;"></span>
                </li>
               <li>
                    <span><b>*</b>密码：</span>
                    <input id="password" type="password" name="password"/>
                </li>
                <li>
                    <span><b>*</b>邮编：</span>
                    <input type="text" name="zipCode"/>
                </li>
                <li>
                    <span><b>*</b>地址：</span>
                    <input type="text" name="address"/>
                </li>
                <li>
                    <span><b>*</b>电话：</span>
                    <input type="text" name="telephone"/>
                </li>
                <li>
                    <span><b>*</b>电子邮箱：</span>
                    <input type="text" name="email"/>
                </li>
            </ul>
            <p>
                <input type="checkbox" checked/>
                 我已阅读并同意
                <a href="#">用户注册协议</a>
            </p>
            <input class="btn_submit" type="submit" value="立即注册"/>
           </form>
        </div>
   	</div>
</body>
</html>
    