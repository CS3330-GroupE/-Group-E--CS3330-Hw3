package edu.mu.storemanager;

//base class (parent)
public class MediaProduct{
	
	protected String type;
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	
	// Base Constructor
	public MediaProduct(String type, String title, double price, int year, Genre genre) {
        this.type = type;
		this.title = title;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }
	
    // Copy constructor
    public MediaProduct(MediaProduct copy) {
    	this.type = copy.type;
        this.title = copy.title;
        this.price = copy.price;
        this.year = copy.year;
        this.genre = copy.genre;
    }

	
	//setters and getters
    public String getType() {
    	return type;
    }
    
    public void setType(String type) {
    	this.type = type;
    }
    
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	//subclass
	class VinylRecordProduct extends MediaProduct{
		public VinylRecordProduct(String type, String title, double price, int year, Genre genre) {
			super(type,title, price, year, genre);
		 }
		//copy constructor 
		public VinylRecordProduct(VinylRecordProduct copy) {
			super(copy);
		}
	}
	//subclass
	class CDRecordProduct extends MediaProduct{
		public CDRecordProduct(String type, String title, double price, int year, Genre genre) {
			super(type, title, price, year, genre);
		 }
		//copy constructor
		public CDRecordProduct (CDRecordProduct copy) {
			super(copy);
		} 
	}
	//subclass
	class TapeRecordProduct extends MediaProduct{
		public TapeRecordProduct(String type, String title, double price, int year, Genre genre) {
			super(type, title, price, year, genre);
		 }//copy constructor
		public TapeRecordProduct(TapeRecordProduct copy) {
			super(copy);
		}
	}
	
	//toString method 
	@Override
	public String toString() {
		return "MediaProduct [type=" + type + ", title=" + title + ", price=" + price + ", year=" + year + ", genre="
				+ genre + "]";
	}
	
}