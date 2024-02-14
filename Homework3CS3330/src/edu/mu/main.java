package edu.mu;
import edu.mu.storemanager.StockManagerSingleton;

public class main {
	
	public static void main(String[] args) {
		
		StockManagerSingleton stock = new StockManagerSingleton();
		stock.initializeStock();
	}

}
