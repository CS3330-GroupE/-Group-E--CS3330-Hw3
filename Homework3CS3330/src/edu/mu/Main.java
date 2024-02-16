package edu.mu;
import java.util.ArrayList;

import edu.mu.storemanager.*;


public class Main {
	
	public static void main(String[] args) {
		
		StockManagerSingleton stock = StockManagerSingleton.getInstance();
		stock.initializeStock();
		
		//Will remove just using to display the array
		stock.printListOfMediaProduct(stock.productList());
		
		
		//test variables
		String testName = "Metallica";
		String testAlbum = "Kill em' All";
		int testYear = 1983;
		double testPrice = 24.99;
		double newPrice = 20.99;
		
		//test product
		MediaProduct testProduct = new MediaProduct(testName, testAlbum, testPrice, testYear, Genre.ROCK);
		
		//tests method to see if working properly
		if(stock.addItem(testProduct)) {
			System.out.print("\nSuccess!\n\n");
			stock.printListOfMediaProduct(stock.productList());
		};
		
		 //tests method to see if working properly
        if(stock.updateItemPrice(testProduct, newPrice)){
            System.out.print("\nSuccess!\n\n");
            //shows method works
            stock.printListOfMediaProduct(stock.productList());
        }
        else{
            System.out.print("\nFAILED!");
        };
		
		//shows method works
		stock.printListOfMediaProduct(stock.productList());
		
		//tests method to see if working properly
		if(stock.removeItem(testProduct)){
			System.out.print("\nSuccess!\n\n");
		};
		
		//shows method works
		stock.printListOfMediaProduct(stock.productList());
		
		//calls method to create array of CD products from the inventory
		//currently displays all objects in the arrays type to test method success
		stock.getCDRecordsList(stock.productList());

		//test getMediaProductBelowPrice
		ArrayList<MediaProduct> MPCheaperThan = new ArrayList<>();
		MPCheaperThan = stock.getMediaProductBelowPrice(15);

        	for (MediaProduct product : MPCheaperThan) {
            		System.out.println(product);
        	}
		
        	stock.getMediaProductBelowPrice(15);

		

		//test getVinylRecordList
        	for (MediaProduct line1 : stock.getVinylRecordList(stock.productList())) {
            		System.out.println(line1);
        	}
        
        	stock.getVinylRecordList(stock.productList());

		//test getTapeRecordList
        	for (MediaProduct line : stock.getTapeRecordList(stock.productList())) {
            		System.out.println(line);
        	}
        
        	stock.getTapeRecordList(stock.productList());

		//saveStock
        	stock.saveStock();
        	
        
	}
}
