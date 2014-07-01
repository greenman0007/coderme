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
							<p>This is <strong>Rain on Leaves </strong>, a free, fully standards-compliant CSS template designed by FreeCssTemplates<a href="http://www.nodethirtythree.com/"></a> for <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.  The picture in this template is from <a href="#">PDPhoto.org</a>. This free template is released under a <a href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attributions 2.5</a> license, so you’re pretty much free to do whatever you want with it (even use it commercially) provided you keep the links in the footer intact. Aside from that, have fun with it :)</p></div>
				</div>
				</#list>
			</div>
			<!-- end #content -->
		    <div id="sidebar">
		        <ul>
					<li>
						<h2>用户信息</h2>
						<p>welclome,${userName?if_exists}</p>
					</li>
				</ul>
		</div>
	</div>
</body>
</html>