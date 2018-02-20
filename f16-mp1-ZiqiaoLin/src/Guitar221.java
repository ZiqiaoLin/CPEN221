// skeleton version of the class
import java.util.*;

public class Guitar221 implements Guitar {
    public static final String KEYBOARD =
        "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; // keyboard layout
    Map<Character,GuitarString> allStrings = new TreeMap<Character,GuitarString>();
    public Guitar221(){
    	double[] FREQUENCY = new double[KEYBOARD.length()];
    	for(int i = 0;i < KEYBOARD.length(); i++){
    		FREQUENCY[i] = 440 * Math.pow( 2, ((double) i - 24) / 12);
    	}
        for(int i = 0;i < KEYBOARD.length(); i++){
        	char string = KEYBOARD.charAt(i);
        	if(! allStrings.containsKey(string)){
        		GuitarString newString = new GuitarString(FREQUENCY[i]);
        		allStrings.put(string, newString);
        	}
        }

    }
    
    public void playNote(int pitch){
    	int index = pitch + 12;
    	if(index >= 0 && index < KEYBOARD.length() ){
    	allStrings.get(KEYBOARD.charAt(index)).pluck();
    	}
    }
    public void pluck(char key){
    	if(allStrings.containsKey(key)){
    		allStrings.get(key).pluck();
    	}else{
    		System.out.println("IllegalArgumentException");
    	}
    }
    public boolean hasString(char string){
    	return(allStrings.containsKey(string));
    }
    public double sample() {
    	double sumOfStrings = 0.0;
    	for(int i = 0;i < KEYBOARD.length();i++){
    		sumOfStrings += allStrings.get(KEYBOARD.charAt(i)).sample();
    	}
    	return sumOfStrings;
    }
    public void tic(){
    	for(int i = 0;i < KEYBOARD.length(); i++){
    		allStrings.get(KEYBOARD.charAt(i)).tic();
    	}
    }
    public int time() {
        return -1;  // not implemented
    }
}
