<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Spring MVC Test</title>
  </head>
  <body>
  <div>
  	<form action="/user/login" method="post">
  		用户名：<input type="text" name="username" />
  		<br/>
  		密码：<input type="password" name="password" />
  		<br/>
  		<input type="submit" value="登录" />
  	</form>
  </div>
  </body>
</html>