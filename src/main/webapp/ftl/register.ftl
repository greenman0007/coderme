<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册到coderme的博客</title>
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
			    <form action="/blog-web/register" method="post">
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
					    	<td cosplan='2'><button type="submit">注册</button></td>
					    </tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>