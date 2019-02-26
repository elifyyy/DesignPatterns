package g01;

public abstract class Resource {
	private int resourceId ;
	public Resource(int id) {
		setResourceId(id);
	}
	public void setResourceId(int id) {
		this.resourceId=id;
	}
	public int getResourceId() {
		return this.resourceId;
	}

}
