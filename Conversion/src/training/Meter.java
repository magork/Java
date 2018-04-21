package training;

public class Meter  implements Length{

	private double value;
	
	public Meter(Meter meter){
		this.value = meter.value;
	}
	
	public Meter(double value) {
		super();
		this.value = value;
	}

	@Override
	public Meter toMeter() {
		
		return this;
	}

	@Override
	public double getValue() {
		
		return value;
	}

	@Override
	public String toString(){
		return String.valueOf(value)+" m";
	}
	

}
