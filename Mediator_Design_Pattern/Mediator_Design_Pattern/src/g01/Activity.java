package g01;


import java.util.ArrayList;

//TODO Deliverable class� eklenebilir

import java.util.Date;

public class Activity {	
	private int number;
	private String desc;
	private Date startDate;
	private ArrayList<Task> tasks;
	public Activity(int number, String desc, Date startDate) {
		setNumber(number);
		setDesc(desc);
		setStartDate(startDate);
		setTasks();
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setTasks() {
		this.tasks = new ArrayList<Task>();
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public void addTask(int number, String desc, Date startDate, int hours){
		Task task = new Task(number,desc, startDate, hours);
		this.tasks.add(task);
	}
	public ArrayList<Task> getTasks() {
		return tasks;
	}
	public void updateNum(int num) {
		this.setNumber(num);
	}
	public void updateDesc(String desc) {
		this.setDesc(desc);
	}
	public void updateDate(Date date) {
		this.setStartDate(date);
	}
	public boolean isDeliverable() {
		if (tasks.size() != 0) {
			for(Task t: tasks) {
				if(!t.isDeliverable()) {
					return false;
				}
			}
			return true;
		}
		else {
			return true;
		}
	}
	public Task findTask(int num) {
		for(int i = 0; i < this.getTasks().size();  i++ ) {
			if( this.getTasks().get(i).getNumber() == num) {
				return  this.getTasks().get(i);
			}
		}
		return null;
	}	
	
	public void removeTask(Task t) {
		this.getTasks().remove(t);
	}
	
	public int calcActivityDuration() {
		int activityDuration = 0;
		for(int i = 0; i < this.getTasks().size();  i++ ) {
			Task t = this.getTasks().get(i);
			 activityDuration = activityDuration + t.getHours();
		}
		return activityDuration;
	}
}
