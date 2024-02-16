package edu.mu.storemanager;

//subclass
public class VinylRecordProduct extends MediaProduct{
		
	public VinylRecordProduct(String type, String title, double price, int year, Genre genre) {
		super(type,title, price, year, genre);
	}
		
	//copy constructor 
	public VinylRecordProduct(VinylRecordProduct copy) {
		super(copy.getType(),copy.getTitle(),copy.getPrice(), copy.getYear(), copy.getGenre());
	}
}

