import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ShoppingCart {
	HashMap<Item, Integer> cartItems;

	ShoppingCart() {
		cartItems = new HashMap<Item, Integer>();
	}

	void addItemToCart(Item newItem, int quantity) {
		if (cartItems.containsKey(newItem)) {
			for (Entry<Item, Integer> entry : cartItems.entrySet()) {
				if (entry.getKey() == newItem) {
					entry.setValue(entry.getValue() + quantity);
				}
			}

		} else {
			cartItems.put(newItem, quantity);
		}
	}

	public void printCart() {
		if (cartItems.isEmpty()) {
			System.out.println("Empty cart.");
		} else {
			Iterator<Entry<Item, Integer>> it = cartItems.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Item, Integer> pairs = (Entry<Item, Integer>) it
						.next();
				if (pairs.getValue() == 0) {
					it.remove();
				} else {
					pairs.getKey().printItem();
					System.out.println(", Quantity: " + pairs.getValue());
				}
			}
		}
	}
}
