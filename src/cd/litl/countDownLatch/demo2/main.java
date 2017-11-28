package cd.litl.countDownLatch.demo2;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VideoConference conference = new VideoConference(9);
		
		Thread conferenceThread = new Thread(conference);
		
		conferenceThread.start();
		
		for (int i = 0; i < 9; i++) {
			
			Participant participant = new Participant(conference, "participant" + i);
			
			Thread participantThread = new Thread(participant);
			
			participantThread.start();
		}
	}

}
