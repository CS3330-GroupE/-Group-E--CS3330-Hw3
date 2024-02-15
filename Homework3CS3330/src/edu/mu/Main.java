package edu.mu;
import edu.mu.storemanager.StockManagerSingleton;

public class Main {
	
	public static void main(String[] args) {
		
		StockManagerSingleton stock = StockManagerSingleton.getInstance();
		stock.initializeStock();
		
		//Will remove just using to display the array
		stock.displayStock();
	}

}
