package entity.base;

public abstract class Ingredient extends Item{

	private boolean isEdible;
	
	//Constructor
	protected Ingredient(String name) {
		super(name);
		setEdible(false);
	}

	//setter
	public void setEdible(boolean isEdible) {
		this.isEdible = isEdible;
	}	

	//getter
	public boolean isEdible() {
		return isEdible;
	}

}

