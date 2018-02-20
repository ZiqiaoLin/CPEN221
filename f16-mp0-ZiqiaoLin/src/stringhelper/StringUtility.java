package stringhelper;

/** An instance contains static methods for assignment A2 */
public class StringUtility {

    /* Consult the methods that are declared in class String.
     * Visit docs.oracle.com/javase/8/docs/api/java/lang/String.html. 
     * Some important methods are charAt, length(), trim, substring, 
     * indexOf, isEmpty, lastIndexOf, startsWith, endsWith, split.
     */

    /** Return true iff str is a palindrome: it reads the same 
     * backwards and forwards.
     *
     * Examples: For str = "", return true
     *           For str = "ab", return false
     *           For str = "aba", return true.
     *           For str = "abba", return true.
     *           For str = "Madam, I'm Adam", return false.
     *           For str = "MadamImAdam", return false.
     *           For str = "madamimadam", return true.  
     * 
     * @param str is not null
     * @return true if str is a palindrome and false otherwise
     */
    public static boolean isPalindrome(String str) {
        // Do not visit each character of the string more than once 
        // each.
        
        // TODO: Implement this method
    	boolean judge=true;
        for(int i=0;i<str.length()/2;i++){
        	if(str.charAt(i)!=str.charAt(str.length()-1-i)){
        		judge=false;
        		break;
        	}
        }
        return judge;
    }

    /**  Return the number of times query occurs as a substring of 
     * mainString (the different occurrences may overlap).
     * Precondition:    query is not null and
     *                  query is not the empty string "".
     * Examples: For src = "ab", query = "b", return 1.
     *           For src = "Luke Skywalker", query = "ke", return 2.
     *           For src = "abababab", query = "aba", return 3.
     *           For src = "abc", query = "", return 4 
     *
     * @param src is not null and neither is it the empty string
     * @return a count of the number of times query appears in 
     *          mainString
     */
    public static int countOccurrences(String mainString, String query) 
    {
        // TODO: Implement this method
    	int count=0;
    	for(int i=0;i<mainString.length()-query.length()+1;i++){
    		boolean judge=true;
    		for(int j=0;j<query.length();j++){
    			if(mainString.charAt(i+j)!=query.charAt(j)){
    				judge=false;
    				break;
    			}
    		}
    		if(judge){
    			count++;
    		}
    	}
        return count;
    }

    /** 
     * Suppose a string represents somebody's full name. 
     * The first word in the string is the first name, 
     * the last word is the last name, and any words in between are 
     * middle names. The string may have an arbitary amount of 
     * whitespace (blank spaces) between words and at the beginning or 
     * the end. Return a string that is a nicely formatted name in the 
     * format Lastname, Firstname [Middle Initials]. In the string that 
     * this method returns, the first character of the last name, the 
     * first character of the first name and the middle initials must be
     * capitalized; all other characters must be in lower case.

     * Some examples:
     * sathish gopalakrishnan should result in Gopalakrishnan, Sathish
     * Matei Radu Ripeanu should result in Ripeanu, Matei R.
     * John Ronald reuel Tolkien should result in Tolkien, John R. R.
     * Arvind should result in Arvind (this is a special case when there
     * is only one word in the string) */
    
    public static String formatName(String nameStr) {
        /* As you know, String is a class. An object of class String is
         * immutable -- you cannot change the sequence of chars that it
         * contains. However, you can create new strings by catenating 
         * together parts of the original string.
         *
         * You do not need to use loops. This task can be solved by
         * selecting appropriate methods in the String class and then
         * using if statements.
         */
         
        // TODO: Implement this method
        	String[] spilt=nameStr.split(" ");
        	String lastName=spilt[spilt.length-1].substring(0,1).toUpperCase()+spilt[spilt.length-1].substring(1);
        	String firstName=spilt[0].substring(0,1).toUpperCase()+spilt[0].substring(1);
        	String name="";
        	if(spilt.length==1){
        		name=spilt[0].substring(0,1).toUpperCase()+spilt[0].substring(1);
        		return name;
        	}
        	if(spilt.length-2>0){
        		String middleName="";
        		for(int i=1;i<spilt.length-1;i++){
        			middleName=middleName+" "+spilt[i].substring(0,1).toUpperCase()+".";
        			name=lastName+", "+firstName+middleName;
        		}
        	}else{
        		name=lastName+", "+firstName;
        	}

            return name;
        }

    /** Return true iff s1 and s2 are anagrams of each other.
     * An anagram of a string is another string that has the same
     * characters, but possibly in a different order. 
     * Like other methods of this class, this method too is
     * case-sensitive, so 'a' and 'A' are considered different 
     * characters.
     *
     * Examples: For s1 = "mary", s2 = "army", return true.
     *           For s1 = "tom marvolo riddle", 
     *               s2 = "i am lordvoldemort", return true.
     *           For s1 = "tommarvoloriddle", 
     *               s2 = "i am lordvoldemort", return false.
     *           For s1 = "foo", s2 = "bar", return false.  
     * 
     * @param s1 and s2 are not null
     * @return true if s2 is an anagram of s1, and false otherwise
     */
    public static boolean anagrams(String s1, String s2) {
        // TODO: Implement this method
    	boolean judge=true;
    	int[] letters=new int[256];
    	if(s1.length()!=s2.length()){
    		judge=false;
    	}
    	for(int i=0;i<s1.length();i++){
    		letters[(int)(s1.charAt(i))]++;
    	}
    	for(int i=0;i<s2.length();i++){
    		if(letters[s2.charAt(i)]==0){
    			judge=false;
    			break;
    		}else{
    			letters[s2.charAt(i)]--;
    		}
    	}
    	for(int i=0;i<256;i++){
    		if(letters[i]!=0){
    			judge=false;
    			break;
    		}
    	}
    	return judge;
    	
        
        // You do not need to use iteration/recursion.
        // Hint: how can a sequence of characters be uniquely ordered
        // You might need to first convert the string to an array of
        // characters, and then use a function from class [`Arrays`](http://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html).
    }


    /** An encoding of the string `aaassddddffg` is the string 
     * `3a2s4d2f1g`. Along these lines, `zzz56yyy` would be encoded as 
     * `3z15163y`. Assuming this encoding method, an encoded string is 
     * a *sequence* of digit-character pairs. Implement a method to 
     * decode a string (given the encoded version). 
     * (What should you do if a string is not in the correct format? 
     * For now, assume that all test strings will conform to the 
     * expected format.)
     * 
     * @param encstr Is in the appropriate encoded format
     * @return a String that has been decoded from the special format
     */
    public static String decode(String encstr) {
        /* To produce the integer that is in String encstr use function
         * Integer.parseInt(s1). Remember that a character c is not a 
         * String, and to change c into a String you may have to 
         * catenate it with the empty String.
         * This function will probably need a nested loop
         */
    	String decodeStr="";
    	for(int i=0;i<encstr.length();i=i+2){
    		int count=encstr.charAt(i+1)-48;
    		for(int j=1;j<=count;j++){
    			decodeStr+=encstr.charAt(i+1);
    		}
    		
    	}
        return decodeStr;
    }
}
