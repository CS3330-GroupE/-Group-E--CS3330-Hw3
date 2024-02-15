package edu.mu;
import edu.mu.storemanager.Genre;
import edu.mu.storemanager.MediaProduct;
import edu.mu.storemanager.StockManagerSingleton;


public class Main {
	
	public static void main(String[] args) {
		
		StockManagerSingleton stock = StockManagerSingleton.getInstance();
		stock.initializeStock();
		
		//Will remove just using to display the array
		stock.displayStock();
		
		
		//test variables
		String testName = "Metallica";
		String testAlbum = "Kill em' All";
		int testYear = 1983;
		float testPrice = (float) 24.90;
		
		//test product
		MediaProduct testProduct = new MediaProduct(testName, testAlbum, testPrice, testYear, Genre.ROCK);
		
		//tests method to see if working properly
		if(stock.addItem(testProduct)) {
			System.out.print("\nSuccess!\n\n");
		};
		
		//shows method works
		stock.displayStock();
		
		//tests method to see if working properly
		if(stock.removeItem(testProduct)){
			System.out.print("\nSuccess!\n\n");
		};
		
		//shows method works
		stock.displayStock();
	}

}
