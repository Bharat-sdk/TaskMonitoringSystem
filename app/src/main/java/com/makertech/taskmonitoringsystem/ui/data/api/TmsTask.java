package com.makertech.taskmonitoringsystem.ui.data.api;

import com.google.gson.annotations.SerializedName;

public class TmsTask{

	@SerializedName("alloted_to")
	private String allotedTo;

	@SerializedName("end_Date")
	private String endDate;

	@SerializedName("target_Date")
	private String targetDate;

	@SerializedName("year")
	private String year;

	@SerializedName("task_subject")
	private String taskSubject;

	@SerializedName("id")
	private String id;

	@SerializedName("category")
	private String category;

	@SerializedName("priority")
	private String priority;

	public void setAllotedTo(String allotedTo){
		this.allotedTo = allotedTo;
	}

	public String getAllotedTo(){
		return allotedTo;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setTargetDate(String targetDate){
		this.targetDate = targetDate;
	}

	public String getTargetDate(){
		return targetDate;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setTaskSubject(String taskSubject){
		this.taskSubject = taskSubject;
	}

	public String getTaskSubject(){
		return taskSubject;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setPriority(String priority){
		this.priority = priority;
	}

	public String getPriority(){
		return priority;
	}

	@Override
 	public String toString(){
		return 
			"ResponseItem{" + 
			"alloted_to = '" + allotedTo + '\'' + 
			",end_Date = '" + endDate + '\'' + 
			",target_Date = '" + targetDate + '\'' + 
			",year = '" + year + '\'' + 
			",task_subject = '" + taskSubject + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			",priority = '" + priority + '\'' + 
			"}";
		}
}