package edu.mu.storemanager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StockManagerSingleton {
	
	public StockManagerSingleton() {
		
	}
	
	private String inventoryFilePath = "Homework3CS3330/src/files/inventory.csv";



	public boolean initializeStock() {
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
				
				//creating MediaProduct object based on type
				MediaProduct product = null;
				if(type.equals("CD")) {
					//product = new CDRecordProduct(title, price, year, genre);
					System.out.println(type + ", " + title + ", " + price + ", " + year + ", " + genre);
				}
				else if(type.equals("Vinyl")) {
					//product = new VinylRecordProduct(title, price, year, genre);
					System.out.println(type + ", " + title + ", " + price + ", " + year + ", " + genre);
				}
				else if(type.equals("Tape")) {
					//product = new TapeRecordProduct(title, price, year, genre);
					System.out.println(type + ", " + title + ", " + price + ", " + year + ", " + genre);
				}
				else {
					System.out.println(type + ", " + title + ", " + price + ", " + year + ", " + genre);
				}
				
				
				
				
			}
			
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
	
		
		
		return true;
		
	}

}