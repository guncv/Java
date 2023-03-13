package entity.base;

public abstract class Item {
	private String name;

	//Constructor
	protected Item(String name) {
		this.name = name;
	}

	//Method	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			
			if(obj.getClass()!=String.class) {
				return false;
			}else {
				return name.equals(obj);
			}
			
		}
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String toString() {
		return name;
	}

	//setter	
	public void setName(String name) {
		this.name = name;
	}

	//getter
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

}