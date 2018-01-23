package hackerhank.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_tag_extractor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String regex = "<(.+)>([^<]+)</\\1>";
        Pattern p = Pattern.compile(regex);
        String line = in.nextLine();
		while(in.hasNext()){
			boolean valid = false;
			line = in.nextLine();
			Matcher m = p.matcher(line);
			while (m.find()) {
				System.out.println(m.group(2));
				valid = true;
			}
			
			if(!valid) {
				System.out.println("None");
			}
		}
	}
}
