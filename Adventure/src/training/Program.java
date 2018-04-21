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
			System.out.println(currentRoom.welcomeMessage);
			// opciok kiirasa 
			
			System.out.println("A: "+ currentRoom.optionA);
			
			System.out.println("B: "+ currentRoom.optionB);
		 //valasztas beolvasasa
			String response = readLine();
			
		// atlepes az uj szobaba
			if(response.startsWith("A")){
				currentRoom = currentRoom.roomA;
			}else if (response.startsWith("B")){
				currentRoom = currentRoom.roomB;
			}
	}
	}

	private static String readLine() throws IOException {
		BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(System.in));
		return bufferedReader.readLine();
	}

}
