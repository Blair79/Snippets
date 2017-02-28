package openCSV;

import com.opencsv.bean.CsvBindByName;

public class CarBean {

	@CsvBindByName
	private int Id;

	@CsvBindByName
	private String Name;

	@CsvBindByName
	private int Price;

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int Price) {
		this.Price = Price;
	}

	@Override
	public String toString() {
		return "CarBean{" + "Id=" + Id + ", Name=" + Name + ", Price=" + Price + '}';
	}
}