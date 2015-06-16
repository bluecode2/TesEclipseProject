package task;

import java.text.SimpleDateFormat;
import java.util.Date;

import common.Constant;

public class TaskBean {

	private Integer taskId;
	private Integer projectId;
	private Integer employeeId;
	private String 	genCodeId;
	private Integer updatedBy;
	private Integer createdBy;
	private String 	taskName;
	private Date 	estStartDate;
	private String 	estStartDateInString;
	private Date 	estEndDate;
	private String 	estEndDateInString;
	private Date 	actStartDate;
	private String 	actStartDateInString;
	private Date 	actEndDate;
	private String 	actEndDateInString;
	private Integer estMainDays;
	private Integer actmainDays;
	private String 	taskStatus;
	private Float 	taskProgress;
	private String 	remarks;
	private Date 	createDate;
	private String 	createDateInString;
	private Date 	updateDate;
	private String 	updateDateInString;
	
	SimpleDateFormat df = new SimpleDateFormat(Constant.StringFormat.dateFormat);

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getGenCodeId() {
		return genCodeId;
	}

	public void setGenCodeId(String genCodeId) {
		this.genCodeId = genCodeId;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getEstStartDate() {
		return estStartDate;
	}

	public void setEstStartDate(Date estStartDate) {
		this.estStartDate = estStartDate;
		
		if (estStartDate != null) {
			this.estStartDateInString = df.format(estStartDate.getTime());
		}
		else{
			this.estStartDateInString = "";
		}
	}

	public String getEstStartDateInString() {
		return estStartDateInString;
	}

	public void setEstStartDateInString(String estStartDateInString) {
		this.estStartDateInString = estStartDateInString;
		
		Date date = new Date();
		try {
			date = df.parse(estStartDateInString);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.estStartDateInString = "";
			date = null;
		}
		this.estStartDate = date;
	}

	public Date getEstEndDate() {
		return estEndDate;
	}

	public void setEstEndDate(Date estEndDate) {
		this.estEndDate = estEndDate;
		
		if (estEndDate != null) {
			this.estEndDateInString = df.format(estEndDate.getTime());
		}
		else{
			this.estEndDateInString = "";
		}
	}

	public String getEstEndDateInString() {
		return estEndDateInString;
	}

	public void setEstEndDateInString(String estEndDateInString) {
		this.estEndDateInString = estEndDateInString;
		
		Date date = new Date();
		try {
			date = df.parse(estEndDateInString);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.estEndDateInString = "";
			date = null;
		}
		this.estEndDate = date;
	}

	public Date getActStartDate() {
		return actStartDate;
	}

	public void setActStartDate(Date actStartDate) {
		this.actStartDate = actStartDate;
		
		if (actStartDate != null) {
			this.actStartDateInString = df.format(actStartDate.getTime());
		}
		else{
			this.actStartDateInString = "";
		}
	}

	public String getActStartDateInString() {
		return actStartDateInString;
	}

	public void setActStartDateInString(String actStartDateInString) {
		this.actStartDateInString = actStartDateInString;
		
		Date date = new Date();
		try {
			date = df.parse(actStartDateInString);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.actStartDateInString = "";
			date = null;
		}
		this.actStartDate = date;
	}

	public Date getActEndDate() {
		return actEndDate;
	}

	public void setActEndDate(Date actEndDate) {
		this.actEndDate = actEndDate;
		
		if (actEndDate != null) {
			this.actEndDateInString = df.format(actEndDate.getTime());
		}
		else{
			this.actEndDateInString = "";
		}
	}

	public String getActEndDateInString() {
		return actEndDateInString;
	}

	public void setActEndDateInString(String actEndDateInString) {
		this.actEndDateInString = actEndDateInString;
		
		Date date = new Date();
		try {
			date = df.parse(actEndDateInString);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.actEndDateInString = "";
			date = null;
		}
		this.actEndDate = date;
	}

	public Integer getEstMainDays() {
		return estMainDays;
	}

	public void setEstMainDays(Integer estMainDays) {
		this.estMainDays = estMainDays;
	}

	public Integer getActmainDays() {
		return actmainDays;
	}

	public void setActmainDays(Integer actmainDays) {
		this.actmainDays = actmainDays;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Float getTaskProgress() {
		return taskProgress;
	}

	public void setTaskProgress(Float taskProgress) {
		this.taskProgress = taskProgress;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
		
		if (createDate != null) {
			this.createDateInString = df.format(createDate.getTime());
		}
		else{
			this.createDateInString = "";
		}
	}
	
	public String getCreateDateInString() {
		return createDateInString;
	}
	
	public void setCreateDateInString(String createDateInString) {
		this.createDateInString = createDateInString;
		
		Date date = new Date();
		try {
			date = df.parse(createDateInString);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.createDateInString = "";
			date = null;
		}
		this.createDate = date;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		
		if (updateDate != null) {
			this.updateDateInString = df.format(updateDate.getTime());
		}
		else{
			this.updateDateInString = "";
		}
	}
	
	public String getUpdateDateInString() {
		return updateDateInString;
	}
	
	public void setUpdateDateInString(String updateDateInString) {
		this.updateDateInString = updateDateInString;
		
		Date date = new Date();
		try {
			date = df.parse(updateDateInString);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.updateDateInString = "";
			date = null;
		}
		this.updateDate = date;
	}
}
