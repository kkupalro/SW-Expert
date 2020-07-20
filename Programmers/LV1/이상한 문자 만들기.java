class Solution {
  public String solution(String s) {
	      String answer = "";
	      char c;
	      int idx = 0;
	      for(int i=0; i<s.length(); i++) {
	    	  c = s.charAt(i);
	    	  if(c == ' ') {
	    		  idx = 0;
	    	  } else {
	    		  idx +=1;
	    		  if(idx % 2 == 1) {
	    			  c = Character.toUpperCase(s.charAt(i));
	    		  } else {
	    			  c = Character.toLowerCase(s.charAt(i));
	    		  }
	    	  }
	    	  answer = answer + c;
	      }
	      return answer;
	  }
}
