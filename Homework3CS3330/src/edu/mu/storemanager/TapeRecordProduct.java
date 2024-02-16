package edu.mu.storemanager;

//subclass
class TapeRecordProduct extends MediaProduct{
	
	public TapeRecordProduct(String type, String title, double price, int year, Genre genre) {
		super(type, title, price, year, genre);
	}
	
	//copy constructor
	public TapeRecordProduct(TapeRecordProduct copy) {
		super(copy.getType(),copy.getTitle(),copy.getPrice(), copy.getYear(), copy.getGenre());
	}
}
