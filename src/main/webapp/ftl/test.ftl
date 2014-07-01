<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>coderme blog-web</title>
    </head>
    <body>
    Hello,  <@shiro.principal property="name" />, how are you today?  
     <@shiro.hasRole name="admin">
     ${request.contextPath} 
     </@shiro.hasRole> 
     ${request.getContextPath()}
     <table border="0" cellpadding="3" cellspacing="1" width="100%" align="center" style="background-color: #b9d8f3;">
		  <tr style="text-align: center; COLOR: #0076C8; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
			<td><font size="2">Free memory</td>
			<td><font size="2">Max memory</td>
			<td><font size="2">Totle memory</td>
			<td><font size="2">Available Processors</td>
		  </tr>
		  <tr bgcolor='#F4FAFF'>
			<td nowrap="nowrap" align="center">${freeMem?if_exists}</td>
			<td align="center">${maxMem?if_exists}</td>
			<td align="center">${totleMem?if_exists}</td>
			<td align="center">${availPros?if_exists}</td>
		  </tr>
	  </table>
    </body>
</html>
        