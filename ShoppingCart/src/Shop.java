import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Shop {
	List<Item> catalogList;
	ShoppingCart shoppingCart;



	public List<Item> getCatalogList() {
		return catalogList;
	}

	Shop() {
		catalogList = new ArrayList<Item>();
		shoppingCart = new ShoppingCart();
	}

	void addItem(Item item) {
		catalogList.add(item);
	}

	void removeItem(String name) {
		for (Item currentItem : catalogList) {
			if (name.equals(currentItem.getName())) {
				catalogList.remove(currentItem);
			}
		}
	}

	void createDummyItems() {
		List<Product> products = new ArrayList<Product>();
		List<Service> services = new ArrayList<Service>();

		Product p = new Product("stol", "mebeli za kuhnqta", 24.0, "China",
				"20/11/1994");
		Product p1 = new Product("masa", "mebeli za kuhnqta", 69.9, "Japan",
				"02/05/1994");
		Product p2 = new Product("shkaf", "mebeli", 28.6, "Germany",
				"13/07/1997");
		Product p3 = new Product("parket", "podova nastilka", 32.7, "Sweden",
				"17/02/1999");
		Product p4 = new Product("sekciq", "mebeli", 47.0, "Moldova",
				"28/03/2003");
		Product p5 = new Product("leglo", "mebeli za spalnqta", 23.0,
				"Rio De Janeiro", "20/11/1995");

		products.add(p);
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);

		for (int i = 3; i > 0; i--) {

			Service s;
			if (i % 3 == 0) {
				s = new Service("montaj", "montaj na mebeli", 15.5,
						ServicePaymentTypes.HOURLY);
			} else if (i % 3 == 1) {
				s = new Service("dostavka", "dostavka do doma", 20.0,
						ServicePaymentTypes.FIXED);
			} else {
				s = new Service("remont", "remont i poddrujka na mebel", 17.4,
						ServicePaymentTypes.HOURLY);
			}
			services.add(s);
		}
		int counterProducts = 0;
		int counterServices = 0;
		for (int i = 0; i < 9; i++) {
			if (i % 3 != 0) {
				catalogList.add(products.get(counterProducts));
				counterProducts++;
			} else {
				catalogList.add(services.get(counterServices));
				counterServices++;
			}
		}
	}

	public void printCatalogOfItems() {
		for (Item currentItem : catalogList) {
			currentItem.printItem();
			System.out.println();
		}
		System.out.println();
	}

	protected static void printMenu() {
		System.out.println("\nMenu Options:");
		System.out.println("1: Catalog Of Items;");
		System.out.println("2: Add Item;");
		System.out.println("3: Remove Item;");
		System.out.println("4: Show Cart;");
		System.out.println("5: Exit");

	}

	protected Item getItem(String itemName) {
		for (Item currentItem : catalogList) {
			if (currentItem.getName().equals(itemName)) {
				return currentItem;
			}
		}
		System.out.println("Item Not Found");
		return null;
	}

	protected boolean isItemInCatalog(String itemName) {

		boolean check = false;
		for (Item currentItem : catalogList) {
			if (currentItem.getName().equals(itemName)) {
				check = true;
			}
		}
		return check;
	}

	private boolean isItemInCart(String itemName) {
		boolean check = false;
		for (Entry<Item, Integer> entry : shoppingCart.cartItems.entrySet()) {
			Item currentItem = entry.getKey();
			if (currentItem.getName().equals(itemName)) {
				check = true;
			}
		}
		return check;
	}

	protected void removerFromCart(String nameToGet, int quantityToGet) {
		if (isItemInCart(nameToGet)) {
			changeQuantityOfItem(nameToGet, quantityToGet);
		} else {
			System.out.println("No such item in cart.");
		}
	}

	private void changeQuantityOfItem(String nameToGet, int quantityToGet) {
		if (quantityToGet >= 0) {
			Iterator<Entry<Item, Integer>> it = shoppingCart.cartItems
					.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Item, Integer> pairs = (Entry<Item, Integer>) it
						.next();
				Item i = (Item) pairs.getKey();
				if (i.getName().equals(nameToGet)) {
					if ((int) pairs.getValue() >= quantityToGet) {
						pairs.setValue((int) pairs.getValue() - quantityToGet);
					} else {
						removeFromCart(nameToGet);
					}
					break;
				}
			}
		} else {
			System.out
					.println("Invalid input. (Quantity must be a non negative number)");
		}

	}

	protected void removeFromCart(String nameToGet) {
		Iterator<Entry<Item, Integer>> it = shoppingCart.cartItems.entrySet()
				.iterator();
		while (it.hasNext()) {
			Map.Entry<Item, Integer> pairs = (Entry<Item, Integer>) it.next();
			Item i = (Item) pairs.getKey();
			if (i.getName().equals(nameToGet)) {
				break;
			}
		}
		if (isItemInCart(nameToGet)) {
			it.remove();
		} else {
			System.out.println("No such item in cart.");
		}

	}

	

}
