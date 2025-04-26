package tu.comsci.laptopadvisor.model;

import java.util.Objects;

public class Laptop {

    private Long id;

    private String brand;
    private String model;
    private String processor;
    private int ram;
    private int storage;
    private double price;    
    
    public Laptop() {

	}

	// Custom constructor without id
    public Laptop(String brand, String model, String processor, int ram, int storage, double price) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.price = price;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, id, model, price, processor, ram, storage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(id, other.id) && Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(processor, other.processor) && ram == other.ram && storage == other.storage;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + ", model=" + model + ", processor=" + processor + ", ram="
				+ ram + ", storage=" + storage + ", price=" + price + "]";
	}
        
}