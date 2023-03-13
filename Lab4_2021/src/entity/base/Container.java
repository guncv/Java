package entity.base;

import java.util.ArrayList;

public abstract class Container extends Item {

	private ArrayList<Ingredient> content;
	private int maxCapacity;
	private int capacity;

	//Constructor
	protected Container(String name, int capacity) {
		super(name);
		content = new ArrayList<Ingredient>();
		maxCapacity = capacity;
		setCapacity(capacity);
	}
	
	//Method
	public abstract boolean verifyContent(Ingredient i);
	
	public boolean addContent(Ingredient i) {
		if(verifyContent(i)) {
			if(capacity<=0) {
				return false;
			}
			content.add(i);
			capacity-=1;
			return true;
		}
		return false;
	}
	
	public void clearContent() {
		content.clear();
		capacity = maxCapacity;
	}
	
	public boolean isEmpty() {
		return capacity == maxCapacity;
	}
	
	public void transferContent(Container c) {
		ArrayList<Ingredient> otherContent = c.getContent();
		
		if (otherContent.size()>capacity) {return;} //Overloaded, cannot transfer
		
		for(Ingredient i:otherContent) {
			if(!this.verifyContent(i)) {
				//One of the element is not compatible, do not transfer
				return;
			}
			this.addContent(i);
		}
		c.clearContent();
		
	}
	
	@Override
	public String toString() {
		return this.getName()+" "+content;
	}
	
	//setter
	public void setContent(ArrayList<Ingredient> content) {
		this.content = content;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity>maxCapacity?maxCapacity:capacity;
	}

	//getter
	public int getMaxCapacity() {
		return maxCapacity;
	}


	public int getCapacity() {
		return capacity;
	}
	
	public ArrayList<Ingredient> getContent(){
		return content;
	}
}