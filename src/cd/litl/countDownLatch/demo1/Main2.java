package cd.litl.countDownLatch.demo1;

public class Main2 {

	public static void main(String[] args) {  
        Videoconference conference = new Videoconference(9);  
        Thread threadConference = new Thread(conference);  
        threadConference.start();  
        for(int i=0;i<10;i++){  
            Participant p = new Participant(conference, "Participant"+i);  
            Thread t = new Thread(p);  
            t.start();  
        }  
    }
}
