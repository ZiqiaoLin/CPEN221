import java.util.*;
/*
 * This is the HtmlValidator class.
 * You should implement this class.
 */
public class HtmlValidator {
	 Queue<HtmlTag> validator;
	 
	 /**
	  * initialized constructor with empty queue
	  */
			 
	public HtmlValidator(){
		this.validator = new LinkedList<HtmlTag>();
	}
	
	/**
	 *  initialized constructor with Queue type tags
	 *  @param a list of tags like <html> or <br> no matter open tags or closing tag
	 *  @throws an IllegalArgumentException with the tags queue is null
	 *  effects: create a HtmlValidator which is exactly same as the inputs
	 */
	
	
	public HtmlValidator(Queue<HtmlTag> tags){
		if( tags == null )
			throw new IllegalArgumentException("The Tags Queue is null");
		validator = new LinkedList<HtmlTag>(tags);
	}
	
	
	/**
	 * addTag method is to add HtmlTag into the object
	 * @param HtmlTag tag
	 * @throws IllegalArgumentException which the tag is null
	 */
	
	
	public void addTag (HtmlTag tag){
		if( tag == null)
			throw new IllegalArgumentException("The tag is null");
		validator.offer(tag);
	}
	
	/**
	 * getTags method 
	 * @return the all the HtmlTag type tags inside the object 
	 */
	public Queue<HtmlTag> getTags(){
		return validator;
	}
	
	/**
	 * removeAll method is to remove all target tag no matter which is open or close.
	 * @param element which is the content of the tag
	 * @throws IllegalArgumentException if the element is null
	 */
	
	public void removeAll(String element){
		if( element == null)
			throw new IllegalArgumentException("The element is null");
		HtmlTag openElement = new HtmlTag(element);
		HtmlTag closeElement = new HtmlTag(element , false);
		while(validator.contains(closeElement) || validator.contains(openElement)){  //a loop to check whether validator still have certain element
			validator.remove(openElement);	
			validator.remove(closeElement);
		}
	}
	
	/**
	 *validate method is to validate the tag element to a formal string type
	 *@throws ERROR unexpected tag
	 *@throws ERROR unclosed tag
	 *@return String type with formal type of validateTags
	 */
	
	public String validate(){
		String validatedTags = "";
		MyStack  temTags = new MyStack ();
		int numOfIndentation = 0;
		while(!validator.isEmpty()){  //checking whether the queue is empty, if not continue
			HtmlTag index = validator.poll(); // using index to represent the tag and removed the tag from queue
			if(index.isOpenTag() && !index.isSelfClosing()){
				for(int i =0; i< numOfIndentation; i++)
					validatedTags = validatedTags.concat("    ");//4 spaces adding 
				numOfIndentation ++;
				validatedTags = validatedTags + index.toString() + "\n";
				temTags.push(index);
			}
			
			if(!index.isOpenTag() && !index.isSelfClosing()){ // adding closed tag into string
				
				if(!temTags.isEmpty() && index.matches(temTags.peek())){  //check whether match the near
					numOfIndentation --; //minus the indentation for the opening tag 
					for(int i =0; i<numOfIndentation;i++){
						validatedTags = validatedTags.concat("    ");
					}
					validatedTags = validatedTags + index.toString() + "\n";
					temTags.pop();
				}else{
					validatedTags = validatedTags.concat("ERROR unexpected tag: ");
					validatedTags = validatedTags + index.toString() + "\n";
				}
			}
			if(index.isSelfClosing()){ //adding selfclosing tag into the string
				if(! index.isOpenTag()){
					validatedTags = validatedTags.concat("ERROR unexpected tag: ");
					validatedTags = validatedTags + index.toString() + "\n";
				}else{
					for(int i =0; i<numOfIndentation;i++)
						validatedTags = validatedTags.concat("    ");
					validatedTags = validatedTags + index.toString() + "\n"; 
				}
		    }
		}	
		while( ! temTags.isEmpty()){
			validatedTags = validatedTags.concat("ERROR unclosed tag: ");
			validatedTags = validatedTags + temTags.pop().toString() + "\n";
		}
				
		return validatedTags;
	}
	
}

