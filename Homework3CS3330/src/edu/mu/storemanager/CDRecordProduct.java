package edu.mu.storemanager;

//subclass
class CDRecordProduct extends MediaProduct{
	public CDRecordProduct(String type, String title, double price, int year, Genre genre) {
		super(type, title, price, year, genre);
	 }
	//copy constructor
	public CDRecordProduct (CDRecordProduct copy) {
		super(copy.getType(),copy.getTitle(),copy.getPrice(), copy.getYear(), copy.getGenre());
	} 
}

