package textEditing;

import java.util.ArrayList;
import java.util.List;

public class TextEditingComposite implements TextEditingComponentI{
	
	private String name;
	private List<TextEditingComponentI> componentList;
	
	public TextEditingComposite(String name) {
		this.componentList = new ArrayList<TextEditingComponentI>();
		this.name = name ;
	}
	
	public void addComponent(TextEditingComponentI componenet) {
		this.componentList.add(componenet);
	}

	@Override
	public void doAction(String text) {
			System.out.println(name+"/");
			for(TextEditingComponentI component : componentList) {
				component.doAction(text);
			}		
	}
	
}
