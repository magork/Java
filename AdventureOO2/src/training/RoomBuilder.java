package training;

public class RoomBuilder {

	public static Room createRooms(){
		TwoOptionsRoom room0 =new TwoOptionsRoom();
		room0.setWelcomeMessage("Beszeled a java nyelvet?");
		room0.setOptionA("Igen");
		room0.setOptionB("Nem");
		
		TwoOptionsRoom room1 =new TwoOptionsRoom();
		room1.setWelcomeMessage("Egy bug all veled szembe. Mivel tamadsz?");
		room1.setOptionA("Kodolas");
		room1.setOptionB("Teszt");
		
		TwoOptionsRoom room2 =new TwoOptionsRoom();
		room2.setWelcomeMessage("A bug megszunt, de egy agressziv juzer tamad haturol!");
		room2.setOptionA("Nem vitatkozom vele!");
		room2.setOptionB("Vitatkozom vele!"); //
		
		FinalRoom finalRoom = new FinalRoom(room0);
		
		room0.setRoomA(room1);
		room0.setRoomB(room0);
		room1.setRoomA(room1);
		room1.setRoomB(room2);
		room2.setRoomA(finalRoom);
		room2.setRoomB(room0);
		
		
		return room0;
		
	}

}
