<#import "common/spring.ftl" as spring> 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<#include "common/header.ftl">

	<script type="text/javascript">
		function reloadVerifyCode()
		{
			var xmlhttp;
			if (window.XMLHttpRequest)
			{
			  // code for IE7+, Firefox, Chrome, Opera, Safari
			  xmlhttp=new XMLHttpRequest();
			}
			else
			{
			   // code for IE6, IE5
			   xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange=function()
			  {
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {
			    document.getElementById("verifyCodeImage").innerHTML.src="./mydemo/getVerifyCodeImage";
			    }
			  }
			xmlhttp.open("GET","./mydemo/getVerifyCodeImage",true);
			xmlhttp.send();
		}
	</script>
</head>
<body>
	<div id="wrapper">
		<#include "common/body.ftl">

		<div id="page">
			<div id="content">
			    <#if msg?exists>
				  		<div class="alert">
						  <button type="button" data-dismiss="alert">&times;</button>
						  <strong>Warning!</strong> ${msg}.
						</div>
				</#if>
				<div class="post">
				    <form action="/blog-web/login" method="post">
					    <table>
					    	<tr>
					    		<td><label>用户名：</label></td>
					    		<td><input type="text" name="userName" placeholder="userName"/></td>
					    	</tr>
					    	<tr>
					    		<td><label>密码：</label></td>
					    		<td><input type="password" name="passWord" placeholder="passWord"></td>
					    	</tr>
					    	<tr>
					    	    <td>验证：</td>
					    	    <td><input type="text" name="verifyCode"/>&nbsp;&nbsp;  
                                <img id="verifyCodeImage" onclick="reloadVerifyCode()" src="./mydemo/getVerifyCodeImage"/><br/>    </td> 
					    	</tr>
					    	<tr >
					    		<td ><button type="submit">登陆</button></td>
					    		<td ><a href="/blog-web/register">注册</a></td>
					    	</tr>
					    </table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>