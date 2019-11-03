package company;

// Codility from UnitedIncome

public class ConseqCharRemoving {
	
	 public static String solution(String s) {
		 if (s == null) return null;
		 
		 String result = s;
		 int i = 0;
		 while (i < result.length() - 2) {
			 char c0 = result.charAt(i);
			 char c1 = result.charAt(i + 1);
			 char c2 = result.charAt(i + 2);
			 
			 if (c0 == c1 && c0 == c2) {
				 String substringBegin = result.substring(0, i);
				 String substringEnd = result.substring(i+1);
				 result = substringBegin + substringEnd;
			 } else {
				 i++;
			 }
		 }
		 return result;
	 }
}
