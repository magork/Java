package training;

public interface Room {

	String getWelcomeMessage();

	String getOptions();

	Room nextRoom(String response);

}