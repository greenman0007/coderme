<#import "common/spring.ftl" as spring> 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<#include "common/header.ftl">
</head>
<body>
	<div id="wrapper">
		<#include "common/body.ftl">

		<div id="page">
			<div id="content">
			    <#if msg?exists>
				  		<div class="alert">
						  <button type="button" class="close" data-dismiss="alert">&times;</button>
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