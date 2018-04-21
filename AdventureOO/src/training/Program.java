package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

	public static void main(String[] args) throws IOException {
		// szobak letrehozasa
		Room currentRoom = Room.createRooms();
		
		
		// ismeteld
		
		while (true){
			//aktualis szoba udvozless
			System.out.println(currentRoom.getWelcomeMessage());
			// opciok kiirasa 
			System.out.println(currentRoom.getOptions());
	
		 //valasztas beolvasasa
			String response = readLine();
			currentRoom = currentRoom.nextRoom(response);
			
		// atlepes az uj szobaba
	
	}
	}

	private static String readLine() throws IOException {
		BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(System.in));
		return bufferedReader.readLine();
	}

}
