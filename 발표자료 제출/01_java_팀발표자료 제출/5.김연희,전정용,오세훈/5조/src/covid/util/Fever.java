package covid.util;

public class Fever {
	private double temperature1;
	private double temperature2;
	
	public Fever() {}
	public Fever(double temperature1, double temperature2) {
		this.temperature1 = temperature1;
		this.temperature2 = temperature2;
	}
	public double getTemperature1() {
		return temperature1;
	}
	public void setTemperature1(double temperature1) {
		this.temperature1 = temperature1;
	}
	public double getTemperature2() {
		return temperature2;
	}
	public void setTemperature2(double temperature2) {
		this.temperature2 = temperature2;
	}
	
	@Override
	public String toString() {
		return "오전 온도 : " + temperature1 + ", 오후 온도 : " + temperature2;
	} 
}
