public abstract class Item {
	String name;
	String description;
	int quantity;
	
	abstract String getName();
	
	Item(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public abstract void printItem();

}
