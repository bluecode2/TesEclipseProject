<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Involved</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function search() {
		document.forms[0].currSearchField.value = document.forms[0].searchField.value;
		document.forms[0].currSearchValue.value = document.forms[0].searchValue.value;

		changePage(1);
	}
</script>
</head>
<body>
	<html:form action="/projectInvolved" method="post">

		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/include/title.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/include/toolbar.jsp"></jsp:include>
		
		<html:hidden name="projectInvolvedForm" property="task" />
		<html:hidden name="projectInvolvedForm" property="selectedId" />
		<html:hidden name="projectInvolvedForm" property="currSearchField" />
		<html:hidden name="projectInvolvedForm" property="currSearchValue" />
		<html:hidden property="currPage" name="projectInvolvedForm"/>
		
		<div class="container">
			<div class="divSearch form-group has-info" style="float: right;">
				<table>
					<tr>
						<td>Search by</td>
						<td style="padding-left: 15px;">
						<html:select
								name="projectInvolvedForm" property="searchField"
								styleId="selSearchField" styleClass="form-control">
								<option value="projectCode">Project Code</option>
								<option value="projectName">Project Name</option>
							</html:select></td>
						<td style="padding-left: 15px"><html:text
								name="projectInvolvedForm" property="searchValue"
								styleClass="form-control" /></td>
						<td style="padding-left: 15px"><button type="button"
								onclick="search();" id="btnSearch" class="btn btn-info btn-icon"
								title="Back">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button></td>
					</tr>
				</table>
			</div>

			<div class="divContent">
				<table class="table table-striped table-bordered table-hover"
					cellspacing="0" style="margin-top: 10px;" width="100%"
					class="tableContent">
					<thead class="panel panel-info">
						<tr>
							<td class="align-center">Project Code</td>
							<td class="align-center">Project Name</td>
							<td class="align-center">Estimate Date</td>
							<td class="align-center">Actual Date</td>
							<td class="align-center">Project Manager</td>
							<td class="align-center">Department Name</td>
							<td class="align-center">Progress</td>
							<td class="align-center">Member</td>
							<td class="align-center">View Task</td>
							<td class="align-center"></td>
						</tr>
					</thead>
					<tbody>
						<logic:notEmpty name="projectInvolvedForm" property="listOfProjectInvolved">
							<logic:iterate id="proj" name="projectInvolvedForm" property="listOfProjectInvolved">
								<tr>
								<html:hidden property="projectStatus" name="proj" styleClass="hdnProjStatus"/>
								<html:hidden property="projectProgress" name="proj" styleClass="hdnProjProg"/>
									<td><bean:write name="proj" property="projectCode" /></td>
									<td><a href="#" class="text-info"
										   onclick="getProjDesc('<bean:write name="proj" property="projectDesc" />');"	data-target="#projDesc">
											<bean:write name="proj" property="projectName" /></a></td>
									<td><bean:write name="proj" property="estStartDateInString" /> to 
										<bean:write name="proj" property="estEndDateInString" /></td>
									<td><bean:write name="proj" property="actStartDateInString" /> to 
										<bean:write name="proj" property="actEndDateInString" /></td>
									<td><bean:write name="proj" property="employeeName" /></td>
									<td><bean:write name="proj" property="deptName" /></td>
									<td><bean:write name="proj" property="statusCaption" /> : 
										<bean:write name="proj" property="projectProgress" />%</td>
									<%-- <td><a href="#" class="text-info"
										   onclick="toTask('toMember','<bean:write name="proj" property="projectId" />');">
											Member</a></td>
									<td><a href="#" class="text-info"
										   onclick="toTask('toTask','<bean:write name="proj" property="projectId" />');">
											Task</a></td> --%>
									<%-- <td align="center">
									
									<a href="#" onclick="actionForm('firstBtn','<bean:write name="proj" property="projectId" />','<bean:write name="proj" property="projectName" />','<bean:write name="proj" property="projectStatus" />','<bean:write name="proj" property="projectProgress" />');"
										><span class="firstBtn"
											aria-hidden="true" id="firstBtn" ></span></a> &nbsp; 
									<a href="#"	onclick="actionForm('edit','<bean:write name="proj" property="projectId" />');"
										title="Edit"><span class="secondBtn"
											aria-hidden="true"></span></a> &nbsp; 
									<a href="#" onclick="actionForm('thirdBtn','<bean:write name="proj" property="projectId" />','<bean:write name="proj" property="projectName" />','<bean:write name="proj" property="projectStatus" />');"
										><span class="thirdBtn"
											aria-hidden="true" id="thirdBtn"></span></a>
									</td> --%>
								</tr>
							</logic:iterate>
						</logic:notEmpty>
						<logic:empty name="projectInvolvedForm" property="listOfProjectInvolved">
							<tr>
								<td colspan="10" align="center" style="padding: 10px">No
									Data Found</td>
							</tr>
						</logic:empty>
					</tbody>
				</table>
				<jsp:include page="/WEB-INF/jsp/include/pagination.jsp"></jsp:include>
			</div>

		</div>
		<html:hidden name="projectInvolvedForm" property="currPage" />
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</html:form>
</body>
</html>