import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class Ok_javaGoinHomeinput {

	public static void main(String[] args) {  // 여기서 args는 사용자로부터 입력받은 매개변수(parameter)
		String id = args[0];
		String bright = args[1];
		
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
		
		DimmingLights moodLamp = new DimmingLights(id+" moodLamp");
		moodLamp.setBright(Double.parseDouble(bright));
		moodLamp.on();
		
		//

	}

}
