package training;

public class TwoOptionsRoom implements Room {
	private String welcomeMessage;
	private String optionA;
	private String optionB;
	private Room roomA;
	private Room roomB;
	
	
	/* (non-Javadoc)
	 * @see training.Room#getWelcomeMessage()
	 */
	@Override
	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	/* (non-Javadoc)
	 * @see training.Room#setWelcomeMessage(java.lang.String)
	 */

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	/* (non-Javadoc)
	 * @see training.Room#getOptions()
	 */
	@Override
	public String getOptions() {
		// TODO Auto-generated method stub
		
		
		return "A: "+ getOptionA()+"\n"+"B: "+ getOptionB();
	}

	/* (non-Javadoc)
	 * @see training.Room#nextRoom(java.lang.String)
	 */
	@Override
	public Room nextRoom(String response) {
	Room nextRoom;
		if(response.startsWith("A")){
			nextRoom = this.getRoomA();
		}else if (response.startsWith("B")){
			nextRoom = this.getRoomB();
		}else{
			nextRoom = this;
		}
		return nextRoom;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public Room getRoomA() {
		return roomA;
	}

	public void setRoomA(Room roomA) {
		this.roomA = roomA;
	}

	public Room getRoomB() {
		return roomB;
	}

	public void setRoomB(Room roomB) {
		this.roomB = roomB;
	}

}
