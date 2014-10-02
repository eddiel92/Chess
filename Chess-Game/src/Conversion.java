
public class Conversion {
	//parses string then converts the input string into a 4 by 1 integer array which encode x,y coordinates of the start and end point respectively 
	public static int[] stringToIntArray(String a) {
		int[] outputArray;
		outputArray = new int[4];
		String[] split = a.split("\\s+");
		String initial_coordinate = split[0];
		String final_coordinate = split[2];
		
		String[] split_initial=initial_coordinate.split("(?!^)"); //"a7" from string "a7 to e5"
		String[] split_final=final_coordinate.split("(?!^)"); //"e5" from string "a7 to e5"
		
		//converts a to initial x-coordinate 0
		if (split_initial[0].equals("a")) {
			outputArray[0]=0;
		} else if (split_initial[0].equals("b")) {
			outputArray[0]=1;
		} else if (split_initial[0].equals("c")) {
			outputArray[0]=2;
		} else if (split_initial[0].equals("d")) {
			outputArray[0]=3;
		} else if (split_initial[0].equals("e")) {
			outputArray[0]=4;
		} else if (split_initial[0].equals("f")) {
			outputArray[0]=5;
		} else if (split_initial[0].equals("g")) {
			outputArray[0]=6;
		} else if (split_initial[0].equals("h")) {
			outputArray[0]=7;
		} 
		
		//converts 7 to initial y-coordinate 6
		outputArray[1]=Integer.parseInt(split_initial[1])-1;
		
		//converts e to final x-coordinate 4
		if (split_final[0].equals("a")) {
			outputArray[2]=0;
		} else if (split_final[0].equals("b")) {
			outputArray[2]=1;
		} else if (split_final[0].equals("c")) {
			outputArray[2]=2;
		} else if (split_final[0].equals("d")) {
			outputArray[2]=3;
		} else if (split_final[0].equals("e")) {
			outputArray[2]=4;
		} else if (split_final[0].equals("f")) {
			outputArray[2]=5;
		} else if (split_final[0].equals("g")) {
			outputArray[2]=6;
		} else if (split_final[0].equals("h")) {
			outputArray[2]=7;
		} 
		
		//converts 7 to y-coordinate 6
		outputArray[3]=Integer.parseInt(split_final[1])-1;
		
		return outputArray;
		
	}
}
