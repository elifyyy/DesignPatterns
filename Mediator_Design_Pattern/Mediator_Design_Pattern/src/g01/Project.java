package g01;

import java.util.ArrayList;
import java.util.Date;

public class Project {
	
	private String name;
	private String desc;
	private Date startDate;
	private ArrayList<Activity> activities;
	
	
	public Project( String name, String desc, Date startDate) {
		setName(name);
		setDesc(desc);
		setStartDate(startDate);
		setActivities();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public void setActivities() {
		this.activities = new ArrayList<Activity>();
	}
	public void addActivity(int number, String desc, Date startDate) {
		Activity activity = new Activity(number, desc, startDate);
		this.activities.add(activity);
	}
	public Activity findActivity(int num) {
		for(int i = 0; i < this.getActivities().size();  i++ ) {
			if( this.getActivities().get(i).getNumber() == num) {
				return  this.getActivities().get(i);
			}
		}
		return null;
	}	
	
	public void removeActivity(Activity act) {
		this.getActivities().remove(act);
	}
	
	public int calcProjectDuration() {
		int projectDuration = 0;
		for(int i = 0; i < this.getActivities().size();  i++ ) {
			Activity act = this.getActivities().get(i);
			projectDuration = projectDuration + act.calcActivityDuration();
		}
		return projectDuration;
	}
	public boolean isDeliverable() {
		if (activities.size() != 0) {
			for(Activity act: activities) {
				if(!act.isDeliverable()) {
					return false;
				}
			}
			return true;
		}
		else {
			return true;
		}
	}
}
