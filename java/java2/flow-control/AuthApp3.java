
public class AuthApp3 {

	public static void main(String[] args) {
		String[][] users = {
				{"minhyung", "1111"},
				{"useong", "2222"},
				{"geunho", "3333"},
		};
		String inputId = args[0];
		String inputPass = args[1];
		boolean isLogined = false;
		int cnt = 0; // users 데이터베이스의 id와 password값과 비교해 일치하지않으면 증가시킴 -> cnt가 user.length와 같으면 입력한 id,pass값이 users안에 존재하지 않음 
		for(int i = 0; i < users.length; i++) {
			if(inputId.equals(users[i][0]) && inputPass.equals(users[i][1])) {
				isLogined = true;
				break;
			}
			else {
				cnt++;
			}
		}
		
		if(cnt == users.length) {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		} else if (isLogined){
			System.out.println("Hi, " + inputId);
		}
		
		
		
		
	}

}
