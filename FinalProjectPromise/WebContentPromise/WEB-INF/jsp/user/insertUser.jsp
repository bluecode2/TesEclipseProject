<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<html:form action="/users" method="post">

		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/include/title.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/include/toolbar.jsp"></jsp:include>

		<div class="container">
			<div class="divSearch form-group has-info" style="float: left;">
				<table>
				
					<tr align="left">
						<td>User Role ID</td>
						<td style="padding-left:15px;">
							<html:text property="uBean.userRoleId" styleClass="form-control"></html:text>
						</td>
					</tr>
					<tr align="left">
						<td>Employee ID</td>
						<td style="padding-left:15px;">
							<html:text property="uBean.employeeId" styleClass="form-control"></html:text>
						</td>
					</tr>
					<tr align="left">
						<td>User Name</td>
						<td style="padding-left:15px;">
							<html:text property="uBean.username" styleClass="form-control"></html:text>
						</td>
					</tr>
					<tr align="left">
						<td>Password</td>
						<td style="padding-left:15px;">
							<html:text property="uBean.password_user" styleClass="form-control" styleId="password1"></html:text>
						</td>
					</tr>
					<tr align="left">
						<td>Re-Type Password</td>
						<td style="padding-left:15px;">
							<html:text property="uBean.password_user" styleClass="form-control" styleId="password2"></html:text>
						</td>
					</tr>
				</table>
			</div>

		</div>

		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>

	</html:form>
</body>
</html>