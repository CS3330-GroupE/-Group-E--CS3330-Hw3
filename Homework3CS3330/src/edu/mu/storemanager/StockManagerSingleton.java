package edu.mu.storemanager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
		
		System.out.println("Attempting to read inventory file.\n");
		try {
			//check if file exists
			File file = new File(inventoryFilePath);
			if(!file.exists()) {
				System.out.println("Inventory file does not exist\n");
				return false;
			}
			
			System.out.println("Inventory file exists!\n");
			
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
				addItem(mediaObj);
			}
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	//prints the given array's elements
	public void printListOfMediaProduct(ArrayList<MediaProduct> array){
		for (MediaProduct elements : array) {
			System.out.println(elements);
		}
	}
	
	
	//adds item to the stock
	public boolean addItem(MediaProduct Product) {
		//if statement tests if the method was successful
		if(stock.add(Product)) {
			return true;
		};
		
		return false;
	}
	
	//removes item from the stock
	public boolean removeItem(MediaProduct Product) {
		
		//if statement tests if the method was successful
		if(stock.remove(Product)) {
			return true;
		};
		
		return false;
	}
	
	//method to return the arraylist 
	public ArrayList <MediaProduct> productList() {
		return stock;
	}

	//Get media products below a given maxPrice
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice){
		//create array
		ArrayList<MediaProduct> mediaProductsCheaperThan = new ArrayList<>();
			
			//iterates through mediaProduct, compares Price, adds matching products to array
			for (MediaProduct product : stock) {
				if (product.getPrice() < maxPrice) {
					mediaProductsCheaperThan.add(product);
				}
			}

	return mediaProductsCheaperThan;
	}
	
	//method to access the inventory and make a new array of CD object copies. 
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList) {
		
		//initialized array
	    ArrayList<CDRecordProduct> cdProductList = new ArrayList<>();
			//loops through elements in given inventory and compares type names and if equals, makes a new object, which is then cloned and added to CD array
		    for (MediaProduct elements : productList) {
				
		    	//conditional to check type strings
		    	if (elements.getType().equals("CD")) {
					
		    		//makes new obj
		    		CDRecordProduct originalCDobj = new CDRecordProduct(elements.getType(), elements.getTitle(), elements.getPrice(), elements.getYear(), elements.getGenre());
					
		    		//makes copy and adds to array
		    		cdProductList.add(new CDRecordProduct(originalCDobj));
					
					//this can be removed just for testing
					System.out.println(originalCDobj.getType());
				}
			}
		    
			return cdProductList;
		}

	//gets vinyl media products as array list
	public ArrayList<VinylRecordProduct>getVinylRecordList(ArrayList<MediaProduct> productList){
		//create array
		ArrayList<VinylRecordProduct> vinylRecordsList = new ArrayList<>();
		
		//iterates through mediaProduct, compares Price, adds matching products to array
		for (MediaProduct product : productList) {
			if (product.getType().equals("Vinyl")) {
				//creates new object for matches
	    		VinylRecordProduct VRList = new VinylRecordProduct(product.getType(), product.getTitle(), product.getPrice(), product.getYear(), product.getGenre());
	    		//adds new object to list
				vinylRecordsList.add(new VinylRecordProduct(VRList));
			}
		}

    	return vinylRecordsList;
	}

	//gets tape record media products as array list
	public ArrayList<TapeRecordProduct>getTapeRecordList(ArrayList<MediaProduct> productList){
		//create array
				ArrayList<TapeRecordProduct> tapeRecordsList = new ArrayList<>();
				
				//iterates through mediaProduct, compares Price, adds matching products to array
				for (MediaProduct product : productList) {
					if (product.getType().equals("Tape")) {
						//creates new object for matches
			    		TapeRecordProduct TRList = new TapeRecordProduct(product.getType(), product.getTitle(), product.getPrice(), product.getYear(), product.getGenre());
			    		//adds new object to list
						tapeRecordsList.add(new TapeRecordProduct(TRList));
					}
				}

		    return tapeRecordsList;
		}
	
	
    //will update price of given item
    public boolean updateItemPrice(MediaProduct product, double newPrice) {
       
    	boolean updateStatus = false;
    	
    	//this will write items into stock
    	for(MediaProduct elements : stock) {
            if(product.equals(elements)) {
                elements.setPrice(newPrice);
                updateStatus = true;
            }; 
        }
    	
    	//this loop will check to see if the above loop changes price correctly
    	for(MediaProduct elements : stock) {
    		if(product.equals(elements) && elements.getPrice() != newPrice) {
    			updateStatus = false;
    		}
    	}
    	
    	
        //will return false if above statement fails, true otherwise
        return updateStatus;
    }

	//Saves updated inventory back to CSV file
    public boolean saveStock() {
    	try (FileWriter writer = new FileWriter(inventoryFilePath)) {
            //write each product to the file in CSV format
            for (MediaProduct product : stock) {
            	//Bluhm reference https://www.geeksforgeeks.org/java-string-format-method-with-examples/
                writer.write(String.format("%s,%s,%.2f,%d,%s%n", product.getType(), product.getTitle(), product.getPrice(), product.getYear(), product.getGenre()));
            }
            System.out.println("Save successful!");
            return true;
        }
    	//error catching
    	catch(IOException error) {
    		System.out.println("Save unsuccessful");
            error.printStackTrace();
            return false;
	}
    }	
}
