<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/tld.inc"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录失效页面</title>
<script type="text/javascript"
src="<c:url value='/st/js/jquery.min.js'/>"></script>
</head>
<body>
<!-- 登录失效后在iframe中的页面,改页面作用请求父级页面的跳转登录页方法 -->
	<script type="text/javascript">
		$(function() {
			parent.toLoginPage();
		});
	</script>

</body>
</html>
