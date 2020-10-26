package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;

/**************************************************************************************************************************
*  This is your Vending Machine Command Line Interface (CLI) class
*
*  It is the main process for the Vending Machine
*
*  THIS is where most, if not all, of your Vending Machine interactions should be coded
*  
*  It is instantiated and invoked from the VendingMachineApp (main() application)
*  
*  Your code vending machine related code should be placed in here
***************************************************************************************************************************/
import com.techelevator.view.Menu; // Gain access to Menu class provided for the Capstone

public class VendingMachineCLI {

	// Main menu options defined as constants

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_SALES_REPORT };
	
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private Menu vendingMenu; // Menu object to be used by an instance of this class

	private Menu purchaseMenu;

	public VendingMachineCLI(Menu vendingMenu, Menu purchaseMenu) { // Constructor - user will pas a menu for this class to use
		this.vendingMenu = vendingMenu;
		this.purchaseMenu = purchaseMenu;// Make the Menu the user object passed, our Menu
	}

	/**************************************************************************************************************************
	 * VendingMachineCLI main processing loop
	 * 
	 * Display the main menu and process option chosen
	 *
	 * It is invoked from the VendingMachineApp program
	 *
	 * THIS is where most, if not all, of your Vending Machine objects and
	 * interactions should be coded
	 *
	 * Methods should be defined following run() method and invoked from it
	 * @throws IOException 
	 *
	 ***************************************************************************************************************************/

	public void run() throws IOException {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setItemsInMachine(vendingMachine.restockingMachine());

		boolean shouldProcess = true; // Loop control variable

		while (shouldProcess) { // Loop until user indicates they want to exit

			String choice = (String) vendingMenu.getChoiceFromOptions(MAIN_MENU_OPTIONS); // Display menu and get choice

			switch (choice) { // Process based on user menu choice

			case MAIN_MENU_OPTION_DISPLAY_ITEMS:
				displayItems(vendingMachine); // invoke method to display items in Vending Machine
				break; // Exit switch statement

			case MAIN_MENU_OPTION_PURCHASE:
				purchaseItems(vendingMachine); // invoke method to purchase items from Vending Machine
				break; // Exit switch statement

			case MAIN_MENU_OPTION_EXIT:
				endMethodProcessing(vendingMachine); // Invoke method to perform end of method processing
				shouldProcess = false; // Set variable to end loop
				break; // Exit switch statement
				
			case MAIN_MENU_OPTION_SALES_REPORT:
				endMethodProcessing(vendingMachine); // Invoke method to perform end of method processing
				vendingMachine.createSalesReport();
				shouldProcess = false; // Set variable to end loop
				break; // Exit switch statement
			}
		}
		return; // End method and return to caller
	}

	/********************************************************************************************************
	 * Methods used to perform processing Main Menu Actions
	 ********************************************************************************************************/
	public void displayItems(VendingMachine vendingMachine) {
		for (Item item : vendingMachine.getItemsInMachine()) {
			System.out.println(item.toString());
		}
		// static attribute used as method is not associated with specific object
		// instance
		// Code to display items in Vending Machine
	}

	// -----------------------------------------------
	
	
	public void purchaseItems(VendingMachine vendingMachine) throws IOException { // static attribute used as method is not associated with specific object			
		boolean shouldProcess = true; // Loop control variable

		while (shouldProcess) { // Loop until user indicates they want to exit
			System.out.println("\nCurrent Balance is: " + vendingMachine.getCurrentBalance());
			String choice = (String)purchaseMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS); // Display menu and get																// choice
						
			switch (choice) { // Process based on user menu choice

			case PURCHASE_MENU_OPTION_FEED_MONEY:
			vendingMachine.feedMoney();	
			
				break; // Exit switch statement

			case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
				for (Item item : vendingMachine.getItemsInMachine()) {
					System.out.println(item.selectProductToString());
				}
			vendingMachine.productSelection();
				//purchaseItems(); // invoke method to purchase items from Vending Machine
				break; // Exit switch statement

			case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
				endMethodProcessing(vendingMachine); // Invoke method to perform end of method processing
				vendingMachine.givingChange();
				vendingMachine.auditReport();
				
				shouldProcess = false; // Set variable to end loop
				break; // Exit switch statement
			}
		}
	}
	

	public void endMethodProcessing(VendingMachine vendingMachine) {
		vendingMachine.getOutFile().close();
	//	vendingMachine.givingChange();
	//	System.out.println("Your change is: " + vendingMachine.getReturnChange());
/*******************
 * I MOVED THIS SYSTEM.OUT TO THE GIVE CHANGE METHOD AND INVOKED 
 * THE METHOD AT FINISH TRANSACTION
**************************/

		}
		
		
		// static attribute used as method is not associated with specific object
										// instance
		// Any processing that needs to be done before method ends
	}

