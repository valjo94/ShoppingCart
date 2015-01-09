import java.util.Scanner;

public class Main extends Shop {
	private static Scanner scan;

	public static void main(String[] args) {
		Shop shop = new Shop();
		shop.createDummyItems();

		int option = 0;
		scan = new Scanner(System.in);

		while (option != 5) {
			printMenu();
			option = scan.nextInt();

			String nameToGet;
			int quantityToGet;
			switch (option) {
			case 1:
				shop.printCatalogOfItems();
				break;
			case 2:
				System.out.println("Type in item name without spaces.");
				nameToGet = scan.next();

				System.out.println("Type in quantity of the item.");
				quantityToGet = scan.nextInt();

				if (shop.isItemInCatalog(nameToGet)) {
					Item i = shop.getItem(nameToGet);
					shop.shoppingCart.addItemToCart(i, quantityToGet);
				} else {
					System.out.println("No such item.");
				}
				break;
			case 3:
				System.out
						.println("Type in item name of the item you want to remove(without spaces).");
				nameToGet = scan.next();
				System.out
						.println("Type in quantity to be removed( 0 for all).");
				quantityToGet = scan.nextInt();

				if (quantityToGet == 0) {
					shop.removeFromCart(nameToGet);
				} else {
					shop.removerFromCart(nameToGet, quantityToGet);
				}

				break;
			case 4:
				shop.shoppingCart.printCart();
				break;
			case 5:
				System.out.println("Exit clicked.");
				break;
			default:
				System.out.println("\nInvalid Selection\n");
				break;

			}
		}
	}
}
