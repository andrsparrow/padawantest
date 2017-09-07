package by.pht.test1;

public class Petal {

	private String shape;
	private String color;

	public String getColor() {
		return color;
	}	   	   
	   	   
	@Override
	public String toString() {
		return "Petal shape=" + shape;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Petal(String shape, String color) {

		this.shape = shape;
		this.color = color;
	}

	public Petal(String color) {

		this.shape = "oval";
		this.color = color;
	}

}
