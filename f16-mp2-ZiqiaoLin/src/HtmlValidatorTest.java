import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import org.junit.Test;


public class HtmlValidatorTest {

	@Test
	/**
	 * test two constructors. The first constructor is to test initialized constructors
	 * 
	 */
	public void testInitializedConstructor(){
		HtmlValidator test1 = new HtmlValidator();
		Queue<HtmlTag> temp = test1.getTags();
		assertEquals(0 , temp.size());
		/**
		 * The second constructor is to test constructor with input value
		 */
		temp.offer(new HtmlTag("html") );
		temp.offer(new HtmlTag("xml") );
		temp.offer(new HtmlTag("area") );
		test1 = new HtmlValidator(temp);
		assertEquals(temp,test1.getTags());
	}
	
	@Test
	/**
	 * the method is to test addTags method
	 */
	public void  testAddTags(){
		Queue <HtmlTag> checkingList = new LinkedList<HtmlTag>();  //expected list
		HtmlTag tag1 = new HtmlTag("html");       // create two valid tags
		HtmlTag tag2 = new HtmlTag("br");     
		HtmlValidator test = new HtmlValidator();  
		test.addTag(tag1);      // try to add first tag into the test
		checkingList.offer(tag1);  
		assertEquals(checkingList , test.getTags());  // test getTags method 
		test.addTag(tag2);  // try to add other tag into the test
		checkingList.offer(tag2);  
		assertEquals(checkingList , test.getTags() );// compare expected list and the list returned from getTags
	}
	
	@Test
	/**
	 * this method is to test validate method in HtmlValidator class
	 * 
	 * @throw IOEception
	 * 
	 */
	public void testValidate() throws IOException{
		for(int i = 1; i < 8; i++){      // for loop to test all validated cases 
			String output = "testcases/expected_output_" + i + ".txt";
			String test = "testcases/test"+ i +".html";
			String expected_output = fileAccess(output);
			String test_output = fileAccess(test);
			Queue <HtmlTag> temp =  (HtmlTag.tokenize(test_output));
			HtmlValidator c = new HtmlValidator(temp);
			assertEquals(expected_output, c.validate());
		}
	}
	
	@Test
	/**
	 * this method it to test getTags method. Actually this method is kind of useless
	 * because getTags method and addTags method they can be tested in the same one
	 */
	
	public void testGetTags(){
		Queue <HtmlTag> checkingList = new LinkedList<HtmlTag>(); //expected list
		HtmlTag tag1 = new HtmlTag("hr");     //create two valid tags
		HtmlTag tag2 = new HtmlTag("frame");
		HtmlValidator test = new HtmlValidator();
		test.addTag(tag1);   //add one tag first and try to getTags test and  addTags method
		checkingList.offer(tag1);
		assertEquals(checkingList , test.getTags());
		test.addTag(tag2);  // add another tag and test getTags and addTags method again
		checkingList.offer(tag2);
		assertEquals(checkingList , test.getTags() );  // compare expected list and the list returned from getTags
	}
	
	/**
	 * this method is to read the filename and return all the content in one string
	 * which will be convenient for our test for validate method
	 * Acknowledge: google from http://javarevisited.blogspot.ca/2015/02/how-to-read-file-in-one-line-java-8.html
	 * @param filename from testcases
	 * @return string type with all content inside 
	 * @throws IOException
	 */
	public String fileAccess(String filename) throws IOException{
		List<String> lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8); 
		StringBuilder sb = new StringBuilder(1024); 
		for (String line : lines) {
			sb.append(line + "\n"); 
		} 
		String fromFile = sb.toString(); 
		return fromFile;
	}
	
	@Test
	
	public void removeAllTest(){
		HtmlValidator test1 = new HtmlValidator();
		Queue<HtmlTag> temp = new LinkedList<HtmlTag>();
		HtmlTag tag1 = new HtmlTag("hr");     //create two valid tags
		HtmlTag tag2 = new HtmlTag("frame");
		HtmlTag tag3 = new HtmlTag("frame");
		test1.addTag(tag1);
		test1.addTag(tag2);
		test1.addTag(tag3);
		test1.removeAll("frame");
		temp.offer(tag1);
		assertEquals(temp,test1.getTags());
	}
	
	@Test(expected = IllegalArgumentException.class)
		public void testExceptions() throws IllegalArgumentException{
		HtmlValidator test1 = new HtmlValidator();
		String element = null;
		test1.removeAll(element);
		HtmlTag tag = null;
		test1.addTag(tag);
		Queue <HtmlTag> nothing = new LinkedList<HtmlTag>();
		HtmlValidator test2 = new HtmlValidator(nothing);
	}
}
