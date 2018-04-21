package training;

public class FinalRoom implements Room {

	private Room nextRoom;
	
	public FinalRoom(TwoOptionsRoom nextRoom) {
		// TODO Auto-generated constructor stub
		this.nextRoom = nextRoom;
		
	}

	@Override
	public String getWelcomeMessage() {
		// TODO Auto-generated method stub
		return "Nyertel gratulalunk";
	}

	@Override
	public String getOptions() {
		// TODO Auto-generated method stub
		return "UJ jatek";
	}

	@Override
	public Room nextRoom(String response) {
		// TODO Auto-generated method stub
		return nextRoom;
	}
	

}
