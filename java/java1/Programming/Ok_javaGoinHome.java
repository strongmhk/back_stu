import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class Ok_javaGoinHome {

	public static void main(String[] args) {
		
		String id = "JAVA APT 302";
		
		// Elevator call
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1); // 위로 올라가게 1층으로 엘베 보내~
		
		// Security off
		Security mySecurity = new Security(id);
		mySecurity.off(); // 보안 해제
		
		// Light on
		Lighting hallLamp = new Lighting(id + " / Hall Lamp");
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(id + " / floorLamp");
		floorLamp.on();
		
		
		//

	}

}
