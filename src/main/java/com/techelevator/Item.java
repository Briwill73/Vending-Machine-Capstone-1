package com.techelevator;

public class Item {

	private String name;
	private String saying;
	private String typeOfItem;
	private String slotNumber;
	private int stockAmount;
	private double itemCost;

	// may need actual item type variables

	// constructor
	public Item(String slotNumber, String name, double itemCost, String typeOfItem, int stockAmount) {
		this.slotNumber = slotNumber;
		this.name = name;
		this.itemCost = itemCost;
		this.typeOfItem = typeOfItem;
		this.stockAmount = stockAmount;
		saying = "";
	}


	
	
	// 
	@Override
	public String toString() {
		return slotNumber + " |" + name + " |" + itemCost + " |" + stockAmount;
	}

	public String selectProductToString() {
		return slotNumber + " |" + name + " |" + itemCost;
	}
// -----------------------
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSaying() {
		if(slotNumber.contains("A")) {
			saying = "Crunch Crunch, Yum!";
		} 
		else if(slotNumber.contains("B")) {
			saying = "Munch Munch, Yum!";
		}
		else if(slotNumber.contains("C")) {
			saying = "Glug Glug, Yum!";
		}
		else if(slotNumber.contains("D")) {
			saying = "Chew Chew, Yum!";
		}
		else {
			saying = "Enjoy!";
		}
		return saying;
	}
	

	public void setSaying(String saying) {
		
	}

	public String getTypeOfItem() {
		return typeOfItem;
	}

	public void setTypeOfItem(String typeOfItem) {
		this.typeOfItem = typeOfItem;
	}

	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	public int getStockAmount() {
		
		return stockAmount;
	}

	public int setStockAmount(int stockAmount) {
		
		return this.stockAmount = stockAmount;
	}
	
	public void removeAStock() {
		stockAmount -= 1;
	}

	public double getItemCost() {
		return itemCost;
	}

	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}

}
