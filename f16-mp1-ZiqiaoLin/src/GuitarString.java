import java.util.*;


public class GuitarString {
	Queue<Double> RingBuffer = new LinkedList<Double>();
	private final int SAMPLING_RATE = 44100;
	 GuitarString ( double frequency ) throws IllegalArgumentException{
		long desiredCapacity = Math.round(SAMPLING_RATE/frequency);
		if(frequency > 0 && desiredCapacity >= 2){
			for(int i = 0; i < desiredCapacity; i ++)
				RingBuffer.add ((double) 0);
		}else{
			throw new IllegalArgumentException();
		}
	}
	 GuitarString( double[] init) throws IllegalArgumentException{
		if( init.length >= 2 ){
			for( double content : init ){
				RingBuffer.add(content);
			}
		}else{
			throw new IllegalArgumentException();

		}
		
	}
	public void pluck(){//not quite sure what the question mean replace or remove and then add?
		for(int i = 0; i <= RingBuffer.size(); i++){
			RingBuffer.remove();
			RingBuffer.add((Math.random() - 0.5));
		}
		
	}

	public void tic(){//how many times to tic
		final double ENERGY_DECAY_FACTOR = 0.996;
		double firstSample = RingBuffer.peek();
		RingBuffer.remove();
		double secondSample = RingBuffer.peek();
		RingBuffer.add((firstSample+secondSample) / 2 * ENERGY_DECAY_FACTOR);
	}
	public double sample(){
		return RingBuffer.peek();
	}
}
