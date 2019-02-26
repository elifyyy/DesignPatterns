package g01;

public abstract class Person extends Resource{
	private String name;
	public Person(String name,int id) {
		super(id);
		setName(name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

}
