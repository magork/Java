package training;

public class Room {
	private String welcomeMessage;
	private String optionA;
	private String optionB;
	private Room roomA;
	private Room roomB;
	
	public static Room createRooms(){
		Room room0 =new Room();
		room0.welcomeMessage ="Beszeled a java nyelvet?";
		room0.optionA = "Igen";
		room0.optionB ="Nem";
		Room room1 =new Room();
		room1.welcomeMessage ="Egy bug all veled szembe. Mivel tamadsz?";
		room1.optionA = "Kodolas";
		room1.optionB ="Teszt";
		Room room2 =new Room();
		room2.welcomeMessage ="A bug megszunt, de egy agressziv juzer tamad haturol!";
		room2.optionA = "Nem vitatkozom vele!";
		room2.optionB ="Vitatkozom vele!"; //
		Room room3 =new Room();
		room3.welcomeMessage ="Nyertel, gratulunk!";
		room3.optionA = "Uj jatek";
		
		room0.roomA = room1;
		room0.roomB = room0;
		room1.roomA = room1;
		room1.roomB = room2;
		room2.roomA = room3;
		room2.roomB = room0;
		room3.roomA = room0;
		
		return room0;
		
	}

	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	public String getOptions() {
		// TODO Auto-generated method stub
		
		
		return "A: "+ optionA+"\n"+"B: "+ optionB;
	}

	public Room nextRoom(String response) {
	Room nextRoom;
		if(response.startsWith("A")){
			nextRoom = this.roomA;
		}else if (response.startsWith("B")){
			nextRoom = this.roomB;
		}else{
			nextRoom = this;
		}
		return nextRoom;
	}

}
