package training;

public class Foot extends BaseLength  {

	
	
	public Foot(double value) {
		this.value = value;
	}
	
	public Foot(Meter meter){
		this.value =meter.getValue() / 0.3048;
	}
	
	@Override
	public Meter toMeter() {
		// TODO Auto-generated method stub
		return new Meter(value * 0.3048);
	}


	

	@Override
	public String toString() {
		  return String.valueOf(value)+" ft";
	}

	
	
}
