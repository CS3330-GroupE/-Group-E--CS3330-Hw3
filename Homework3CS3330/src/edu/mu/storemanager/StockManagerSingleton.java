package edu.mu.storemanager;
import java.io.File;

public class StockManagerSingleton {
	
	public StockManagerSingleton() {
		
	}
	
	private String inventoryFilePath = "Homework3CS3330/src/files/inventory.csv";



	public boolean initializeStock() {
		//check if file exists
		File file = new File(inventoryFilePath);
		if(!file.exists()) {
			System.out.println("Inventory file does not exist");
			return false;
		}
		
		System.out.println("Inventory file exists!");
	
		
		return false;
		
	}

}