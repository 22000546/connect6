package connect6;

public class Utils {
	
	public static String getTurnToString(int n) {
		String str = "";
		if(n == 1) {
			str = "흑";
		} else if(n == 2) {
			str = "백";
		}
		
		return str;
	}

}
