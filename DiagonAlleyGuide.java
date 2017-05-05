
//Name:Nicolle Rosa
//Section:11H5
//Description: Diagon Alley shopping list

import java.util.Scanner;

public class DiagonAlleyGuide {
	// Takes the dollar input and returns number of galleons to add.
	public static int exchangeGalleons(double USD) {
		int knuts = (int) (USD / .1);
		int sickles = (knuts / 29);
		int galleons = (sickles / 17);
		return galleons;
	}

	// Takes the dollar input and returns number of sickles to add.
	public static int exchangeSickles(double USD) {
		double knuts = (USD / .1);
		double totalSickles = (int) (knuts / 29);
		int galleons = (int) (totalSickles / 17);
		int sickles = (int) totalSickles - (galleons * 17);
		return sickles;
	}

	// Takes the dollar input and returns number of knuts to add.
	public static int exchangeKnuts(double USD) {
		double totalKnuts = (int) (USD / .1);
		int knuts = (int) totalKnuts % 29;
		return knuts;
	}

	// Prints out your balance. Singularity is noted.
	public static void balance(int galleon, int sickle, int knut) {
		System.out.println("You have " + galleon + " Galleons, " + sickle + " Sickles, and " + knut + " Knuts.");
	}

	// Checks if you have enough money to purchase desired item.
	public static boolean enoughMoney(int galleon, int sickle, int knut, int cost) {
		int trueMoney = (galleon * 17 * 29) + (sickle * 29) + (knut);
		int resultingValue = trueMoney - cost;
		if (resultingValue >= 0) {
			return true;
		} else {
			return false;
		}
	}

	// Displays the main menu to the output window.
	public static void mainMenu() {
		System.out.println("");
		System.out.println("Main Menu:");
		System.out.println("1. Gringotts Bank");
		System.out.println("2. List of Supplies");
		System.out.println("3. Shoppes");
		System.out.println("4. Leave");
		System.out.println("");
		System.out.println("Selection: ");
	}

	// Displays the bank menu.
	public static void gringottsMenu() {
		System.out.println("");
		System.out.println("Gringotts Bank");
		System.out.println("1. Exchange Money");
		System.out.println("2. Check Balance");
		System.out.println("3. Exit");
		System.out.println("");
		System.out.println("Selection: ");
	}

	// Displays the shop menu.
	public static void shoppes() {
		System.out.println("");
		System.out.println("Shoppes");
		System.out.println("1. Broomstix");
		System.out.println("2. Second-Hand Robes");
		System.out.println("3. Olivanders");
		System.out.println("4. Flourish and Blotts");
		System.out.println("5. Potage's Cauldron Shop");
		System.out.println("6. Exit");
		System.out.println("");
		System.out.println("Selection: ");
	}

	// Displays the list of items currently in inventory.
	public static void inventoryList(boolean[] array) {

		if (array[0] == true) {
			System.out.println("Broom");
		}
		if (array[1] == true) {
			System.out.println("School robes");
		}
		if (array[2] == true) {
			System.out.println("Wand");
		}
		if (array[3] == true) {
			System.out.println("The Standard Book of Spells");
		}
		if (array[4] == true) {
			System.out.println("A History of Magic");
		}
		if (array[5] == true) {
			System.out.println("Magical Drafts and Potions");
		}
		if (array[6] == true) {
			System.out.println("Cauldron");
		}

	}

	// Displays the list of items that are needed.
	public static void needList(boolean[] array) {
		if (array[0] == false) {
			System.out.println("Broom");
		}
		if (array[1] == false) {
			System.out.println("School robes");
		}
		if (array[2] == false) {
			System.out.println("Wand");
		}
		if (array[3] == false) {
			System.out.println("The Standard Book of Spells");
		}
		if (array[4] == false) {
			System.out.println("A History of Magic");
		}
		if (array[5] == false) {
			System.out.println("Magical Drafts and Potions");
		}
		if (array[6] == false) {
			System.out.println("Cauldron");
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Diagon Alley!");
		int choice;
		// inventory items
		boolean hasBroom = false;
		boolean hasRobes = false;
		boolean hasWand = false;
		boolean hasSpells = false;
		boolean hasMagic = false;
		boolean hasPotions = false;
		boolean hasCauldron = false;
		boolean[] inventory = { hasBroom, hasRobes, hasWand, hasSpells, hasMagic, hasPotions, hasCauldron };
		inventoryList(inventory);
		int galleons = 0;
		int sickles = 0;
		int knuts = 0;
		double USD;
		do {
			mainMenu();
			choice = input.nextInt();
			if (choice > 4 || choice < 1) {
				System.out.println("Invalid entry!");
			}
			if (choice == 1) {
				int bankChoice;
				do {
					gringottsMenu();
					bankChoice = input.nextInt();
					if (bankChoice > 3 || bankChoice < 1) {
						System.out.println("Invalid entry!");

					}
					if (bankChoice == 1) {
						System.out.println("How much would you like to exchange?");
						System.out.println("USD: ");
						USD = input.nextDouble();
						if (USD < 0) {
							System.out.println("Transaction failed!");
							System.out.println("Input cannot be negative!");
						} else {
							galleons = exchangeGalleons(USD);
							sickles = exchangeSickles(USD);
							knuts = exchangeKnuts(USD);
							System.out.println("Transaction Complete!");
						}
					}
					if (bankChoice == 2) {
						balance(galleons, sickles, knuts);
					}
				} while (bankChoice != 3);
			}

			if (choice == 2) {
				System.out.println("Inventory:");
				inventoryList(inventory);
				System.out.println("");
				System.out.println("Need:");
				needList(inventory);
			}
			if (choice == 3) {
				int shopChoice;

				do {
					shoppes();
					shopChoice = input.nextInt();
					if (shopChoice > 6 || shopChoice < 1) {
						System.out.println("Invalid entry!");
					}
					int shopSelection;
					// Broomstix
					if (shopChoice == 1) {
						do {
							int cost = 1 * 29 * 17;
							System.out.println("Broomstix");
							System.out.println("1. Buy Broom for 1 Galleon");
							System.out.println("2. Exit");
							System.out.println("Selection: ");
							shopSelection = input.nextInt();
							if (shopSelection < 1 || shopSelection > 2)
								System.out.println("Invalid entry!");
							if (shopSelection == 1
									&& (enoughMoney(galleons, sickles, knuts, cost) == false || inventory[0])) {
								System.out.println("Transaction failed!");
							}
							if (shopSelection == 1 && inventory[0]) {
								System.out.println("You already have this!");
							}
							if (shopSelection == 1 && enoughMoney(galleons, sickles, knuts, cost) == false) {
								System.out.println("You do not have enough money!");
							}
							if (shopSelection == 1 && enoughMoney(galleons, sickles, knuts, cost)
									&& inventory[0] == false) {
								int moneyKnuts = (galleons * 17 * 29) + (sickles * 29) + (knuts);
								int resultingValue = moneyKnuts - cost;
								double resultingUSD = resultingValue * .1;
								galleons = exchangeGalleons(resultingUSD);
								sickles = exchangeSickles(resultingUSD);
								knuts = exchangeKnuts(resultingUSD);
								System.out.println("Transaction successful!");
								inventory[0] = true;
							}

						} while (shopSelection != 2);
					}
					// Second-hand Robes
					if (shopChoice == 2) {
						do {
							int cost = 12 * 29;
							System.out.println("Second-Hand Robes");
							System.out.println("1. Buy School robes for 12 Sickles");
							System.out.println("2. Exit");
							System.out.println("Selection: ");
							shopSelection = input.nextInt();
							if (shopSelection < 1 || shopSelection > 2)
								System.out.println("Invalid entry!");
							if (shopSelection == 1
									&& (enoughMoney(galleons, sickles, knuts, cost) == false || inventory[1])) {
								System.out.println("Transaction failed!");
							}
							if (shopSelection == 1 && inventory[1]) {
								System.out.println("You already have this!");
							}
							if (shopSelection == 1 && enoughMoney(galleons, sickles, knuts, cost) == false) {
								System.out.println("You do not have enough money!");
							}
							if (shopSelection == 1 && enoughMoney(galleons, sickles, knuts, cost)
									&& inventory[1] == false) {
								int moneyKnuts = (galleons * 17 * 29) + (sickles * 29) + (knuts);
								int resultingValue = moneyKnuts - cost;
								double resultingUSD = resultingValue * .1;
								galleons = exchangeGalleons(resultingUSD);
								sickles = exchangeSickles(resultingUSD);
								knuts = exchangeKnuts(resultingUSD);
								System.out.println("Transaction successful!");
								inventory[1] = true;
							}

						} while (shopSelection != 2);
					}
					// Ollivander's
					if (shopChoice == 3) {
						do {
							int cost = 29 * 7;
							System.out.println("Olivanders");
							System.out.println("1. Buy Wand for 7 Sickles");
							System.out.println("2. Exit");
							System.out.println("Selection: ");
							shopSelection = input.nextInt();
							if (shopSelection < 1 || shopSelection > 2)
								System.out.println("Invalid entry!");
							if (shopSelection == 1
									&& (enoughMoney(galleons, sickles, knuts, cost) == false || inventory[2])) {
								System.out.println("Transaction failed!");
							}
							if (shopSelection == 1 && inventory[2]) {
								System.out.println("You already have this!");
							}
							if (shopSelection == 1 && enoughMoney(galleons, sickles, knuts, cost) == false) {
								System.out.println("You do not have enough money!");
							}
							if (shopSelection == 1 && enoughMoney(galleons, sickles, knuts, cost)
									&& inventory[2] == false) {
								int moneyKnuts = (galleons * 17 * 29) + (sickles * 29) + (knuts);
								int resultingValue = moneyKnuts - cost;
								double resultingUSD = resultingValue * .1;
								galleons = exchangeGalleons(resultingUSD);
								sickles = exchangeSickles(resultingUSD);
								knuts = exchangeKnuts(resultingUSD);
								System.out.println("Transaction successful!");
								inventory[2] = true;
							}

						} while (shopSelection != 2);
					}
					// Flourish and Blotts
					if (shopChoice == 4) {
						do {
							int costSpells = 5 * 29;
							int costMagic = (3 * 29) + 12;
							int costPotions = 27;
							System.out.println("Flourish and Blotts");
							System.out.println("1. Buy The Standard Book of Spells for 5 Sickles");
							System.out.println("2. Buy A History of Magic for 3 Sickles and 12 Knuts");
							System.out.println("3. Buy Magical Drafts and Potions for 27 Knuts");
							System.out.println("4. Exit");
							System.out.println("Selection: ");
							shopSelection = input.nextInt();
							if (shopSelection < 1 || shopSelection > 4)
								System.out.println("Invalid entry!");
							// The Standard Book of Spells
							if (shopSelection == 1
									&& (enoughMoney(galleons, sickles, knuts, costSpells) == false || inventory[3])) {
								System.out.println("Transaction failed!");
							}
							if (shopSelection == 1 && inventory[3]) {
								System.out.println("You already have this!");
							}
							if (shopSelection == 1 && enoughMoney(galleons, sickles, knuts, costSpells) == false) {
								System.out.println("You do not have enough money!");
							}
							if (shopSelection == 1 && enoughMoney(galleons, sickles, knuts, costSpells)
									&& inventory[3] == false) {
								int moneyKnuts = (galleons * 17 * 29) + (sickles * 29) + (knuts);
								int resultingValue = moneyKnuts - costSpells;
								double resultingUSD = resultingValue * .1;
								galleons = exchangeGalleons(resultingUSD);
								sickles = exchangeSickles(resultingUSD);
								knuts = exchangeKnuts(resultingUSD);
								System.out.println("Transaction successful!");
								inventory[3] = true;
							}

							// A History of Magic
							if (shopSelection == 2
									&& (enoughMoney(galleons, sickles, knuts, costMagic) == false || inventory[4])) {
								System.out.println("Transaction failed!");
							}
							if (shopSelection == 2 && inventory[4]) {
								System.out.println("You already have this!");
							}
							if (shopSelection == 2 && enoughMoney(galleons, sickles, knuts, costMagic) == false) {
								System.out.println("You do not have enough money!");
							}
							if (shopSelection == 2 && enoughMoney(galleons, sickles, knuts, costMagic)
									&& inventory[4] == false) {
								int moneyKnuts = (galleons * 17 * 29) + (sickles * 29) + (knuts);
								int resultingValue = moneyKnuts - costMagic;
								double resultingUSD = resultingValue * .1;
								galleons = exchangeGalleons(resultingUSD);
								sickles = exchangeSickles(resultingUSD);
								knuts = exchangeKnuts(resultingUSD);
								System.out.println("Transaction successful!");
								inventory[4] = true;
							}

							// Magical Drafts and Potions
							if (shopSelection == 3
									&& (enoughMoney(galleons, sickles, knuts, costPotions) == false || inventory[5])) {
								System.out.println("Transaction failed!");
							}
							if (shopSelection == 3 && inventory[5]) {
								System.out.println("You already have this!");
							}
							if (shopSelection == 3 && enoughMoney(galleons, sickles, knuts, costPotions) == false) {
								System.out.println("You do not have enough money!");
							}
							if (shopSelection == 3 && enoughMoney(galleons, sickles, knuts, costPotions)
									&& inventory[5] == false) {
								int moneyKnuts = (galleons * 17 * 29) + (sickles * 29) + (knuts);
								int resultingValue = moneyKnuts - costPotions;
								double resultingUSD = resultingValue * .1;
								galleons = exchangeGalleons(resultingUSD);
								sickles = exchangeSickles(resultingUSD);
								knuts = exchangeKnuts(resultingUSD);
								System.out.println("Transaction successful!");
								inventory[5] = true;
							}

						} while (shopSelection != 4);
					}
					// Potage's
					if (shopChoice == 5) {
						do {

							int cost = 29 * 10;
							System.out.println("Potage's Cauldron Shop");
							System.out.println("1. Buy Cauldron for 10 Sickles");
							System.out.println("2. Exit");
							System.out.println("Selection: ");
							shopSelection = input.nextInt();
							if (shopSelection < 1 || shopSelection > 2)
								System.out.println("Invalid entry!");
							if (shopSelection == 1
									&& (enoughMoney(galleons, sickles, knuts, cost) == false || inventory[6])) {
								System.out.println("Transaction failed!");
							}
							if (shopSelection == 1 && inventory[6]) {
								System.out.println("You already have this!");
							}
							if (shopSelection == 1 && enoughMoney(galleons, sickles, knuts, cost) == false) {
								System.out.println("You do not have enough money!");
							}
							if (shopSelection == 1 && enoughMoney(galleons, sickles, knuts, cost)
									&& inventory[6] == false) {
								int moneyKnuts = (galleons * 17 * 29) + (sickles * 29) + (knuts);
								int resultingValue = moneyKnuts - cost;
								double resultingUSD = resultingValue * .1;
								galleons = exchangeGalleons(resultingUSD);
								sickles = exchangeSickles(resultingUSD);
								knuts = exchangeKnuts(resultingUSD);
								System.out.println("Transaction successful!");
								inventory[6] = true;
							}

						} while (shopSelection != 2);
					}
				} while (shopChoice != 6);
			}
			if (choice == 4) {
				boolean isInventoryFull = false;
				boolean isInventoryEmpty = true;
				for (int i = 0; i < inventory.length; i++) {
					if (inventory[i] == false) {
						isInventoryFull = false;
						break;
					} else {
						isInventoryFull = true;
					}
				}
				for (int i = 0; i < inventory.length; i++) {
					if (inventory[i] == true) {
						isInventoryEmpty = false;
						break;
					} else {
						isInventoryEmpty = true;
					}
				}
				if (isInventoryFull == false && isInventoryEmpty == false) {
					System.out.println("You are missing some items!");
					System.out.println("Missing:");
					needList(inventory);
					break;
				}

				if (isInventoryEmpty == true) {
					System.out.println("You have no supplies!");
					break;
				}
				if (isInventoryFull == true) {
					System.out.println("Have a nice day!!");
					break;
				}
			}
		} while (choice < 4 || choice > 1);

	}
}
