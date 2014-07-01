<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>coderme的博客</title>
<#include "common/header.ftl">
</head>
<body>
	<div id="wrapper">
		<#include "common/body.ftl">
		<div id="page">
			<div id="content">
			    <#list textList as article>
				<div class="post">
						<h2 class="title">
							<a href="#">${article.title?if_exists}</a>
						</h2>
						<p class="meta">Posted by 
							<a href="#">${article.writer?if_exists}</a> on March 10, 2008
								&nbsp;&bull;&nbsp; 
							<a href="#" class="comments">Comments (64)</a> &nbsp;&bull;&nbsp; 
							<a href="#" class="permalink">Full article</a> &nbsp;&bull;&nbsp;
							KeyWord:<a href="#" class="comments">${article.keyWord?if_exists}</a>
						</p>
						<div class="entry">
							<p>This is <strong>Rain on Leaves </strong>,  
							<br/>
							request.contextPath:
							<@shiro.hasRole name="admin">
						     ${request.contextPath} 
						     </@shiro.hasRole> 
						     <br/>
						     request.getContextPath:
						     ${request.getContextPath()}</p></div>
				</div>
				</#list>
			</div>
			<!-- end #content -->
		    <div id="sidebar">
		    	<strong>功能</strong>
		    	<hr/>
		        <ul>
		        	<@shiro.authenticated>
					<li>
							<p>
							          欢迎,<strong>${userName?if_exists}</strong> (by request),<@shiro.principal property=null />(by shiro)
							    <@shiro.user> 
								 <a href="./login/logout"> 退出</a>
								</@shiro.user>
						    </p>
					</li>
					</@shiro.authenticated>
					<li>
						<@shiro.notAuthenticated>
							<a href="./login" style="font-size: 14px;">登陆</a>
						</@shiro.notAuthenticated>
					</li>
					<li>
						<@shiro.notAuthenticated>
							<a href="./login" style="font-size: 14px;">注册</a>
						</@shiro.notAuthenticated>
					</li>
				</ul>
				<br/>
				<strong>文章分类</strong>
				<hr/>
				<ul>
					<li>
						<a href="http://blog.coderme.cn/?cat=15" title="查看DB下的所有文章">DB</a>
						
					</li>
					<li>
						<a href="http://blog.coderme.cn/?cat=9" title="查看JAVA下的所有文章">JAVA</a>
					</li>
					<li>
						<a href="http://blog.coderme.cn/?cat=14" title="查看linux下的所有文章">linux</a>
					</li>
					<li>
						<a href="http://blog.coderme.cn/?cat=10" title="查看WebSite下的所有文章">WebSite</a>
					</li>
					<li>
						<a href="http://blog.coderme.cn/?cat=1" title="查看未分类下的所有文章">未分类</a>
					</li>
					<li>
						<a href="http://blog.coderme.cn/?cat=13" title="查看项目管理下的所有文章">项目管理</a>
					</li>
				</ul>
				
		    </div>
	</div>
</body>
</html>