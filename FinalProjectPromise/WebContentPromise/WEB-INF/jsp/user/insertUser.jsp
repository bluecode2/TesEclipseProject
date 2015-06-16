<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Entry</title>
<script type="text/javascript">
	function onBtnBackClick() {
		location.href = "users.do";
	}

	function onBtnSaveClick() {
		alert(document.forms[0].task.value);
		/* document.forms[0].task.value = "save";
		document.forms[0].submit(); */
	}
	
	function onLoadForm(){
		if (document.forms[0].task.value == "add"){
			document.getElementById('newPassword').style.display = 'none';
			document.getElementById('oldPassword').style.display = 'none';
		}
		else if (document.forms[0].task.value == "Edit"){
			document.getElementById('newPassword').style.display = 'block';
			document.getElementById('oldPassword').style.display = 'block';
		}
	}
	
</script>
</head>
<body onload="onLoadForm();">
	<html:form action="/users" method="post" >

		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/include/title.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/include/toolbar.jsp"></jsp:include>
		
		<html:hidden name="userForm" property="task"/>

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
					<tr align="left" id="oldPassword">
						<td>Old Password</td>
						<td style="padding-left:15px;">
							<input type="password" id="oldPass" Class="form-control" />
						</td>
					</tr>
					<tr align="left">
						<td><label id="newPassword">New</label> Password</td>
						<td style="padding-left:15px;">
							<input type="password" id="newPass" Class="form-control" />
						</td>
					</tr>
					<tr align="left">
						<td>Re-Type Password</td>
						<td style="padding-left:15px;">
							<input type="password" id="reNewPass" Class="form-control" />
						</td>
					</tr>
				</table>
			</div>

		</div>

		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>

	</html:form>
</body>
</html>