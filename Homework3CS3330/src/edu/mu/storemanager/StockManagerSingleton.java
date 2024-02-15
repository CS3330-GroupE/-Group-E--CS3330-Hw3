package edu.mu.storemanager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Singleton class to prevent leaks
public class StockManagerSingleton {
	
	private static StockManagerSingleton singleton_instance = null; 
	private String inventoryFilePath = "Homework3CS3330/src/files/inventory.csv";

	
	private StockManagerSingleton() {
	
	}
// Hatfield Reference: https://www.geeksforgeeks.org/singleton-class-java/
    public static synchronized StockManagerSingleton getInstance()
    {
        if (singleton_instance == null) {
            singleton_instance = new StockManagerSingleton();
        }
        return singleton_instance;
    }


//creates an arraylist with a dynamic capacity
    ArrayList<MediaProduct> stock = new ArrayList<>();
    

	public boolean initializeStock() {
		
		System.out.println("Attempting to read inventory file.");
		try {
			//check if file exists
			File file = new File(inventoryFilePath);
			if(!file.exists()) {
				System.out.println("Inventory file does not exist");
				return false;
			}
			
			System.out.println("Inventory file exists!");
			
			Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
			
			//skipping first line of file (not actual data)
			if(fileIn.hasNextLine()) {
				fileIn.nextLine();
			}
			
			
			while(fileIn.hasNextLine()) {
				String inventoryFileLine = fileIn.nextLine();
				String[] inventoryData = inventoryFileLine.split(","); //splitting line up at commas
				
				//Type,Title,Price,Year,Genre -> order of data in each line
				String type = inventoryData[0];
				String title = inventoryData[1];
				double price = Double.parseDouble(inventoryData[2]);
				int year = Integer.parseInt(inventoryData[3]);
				Genre genre = Genre.valueOf(inventoryData[4]);
				
				//creating MediaProduct objects and adding to array
				MediaProduct mediaObj = new MediaProduct(type,title,price,year,genre);
				stock.add(mediaObj);
			}
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
	
		
		
		return true;
		
	}
	//temp to display items in inventory
	public void displayStock() {
		for (MediaProduct elements : stock) {
			System.out.println(elements);
		}
	}
	
}