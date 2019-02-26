package g01;

//TODO Deliverable class� eklenebilir

import java.util.Date;

public class Task {

	private int number;
	private String desc;
	private Date startDate;
	private int hours;
	private Resource resource;
	private boolean deliverable;

	public Task(int number, String desc, Date startDate, int hours) {
		setNumber(number);
		setDesc(desc);
		setStartDate(startDate);
		setHours(hours);
		// the default value of the deliverable is false
		setDeliverable(false);
		
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource r) {
		this.resource = r;
	}
	
	public void setDeliverable(boolean b) {
		this.deliverable = b;
	}
	public boolean isDeliverable() {
		return this.deliverable;
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
	public void updateHours(int hours) {
		this.setHours(hours);
	}
	public void assignResource(Resource r) {
		setResource(r);
	}
	public void unAssignResource() {
		setResource(null);
	}
}
