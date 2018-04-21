package training;

public class Inch implements Length {

	private double value;
	
	
	
	public Inch(double value) {
		
		this.value = value;
	}

	public Inch(Meter meter){
		this.value =meter.getValue() /0.0254;
	}
	
	@Override
	public Meter toMeter() {
		// TODO Auto-generated method stub
		return new Meter(value * 0.0254);
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value)+" inches";
	}
	
	

}
