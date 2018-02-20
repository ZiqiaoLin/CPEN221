import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class MyStackTest {

	@Test
	/**
	 * 
	 */
	public void pushAndPeekTest() {
		MyStack test = new MyStack();  // test object
		HtmlTag tag1 = new HtmlTag("hr");     //create two valid tags
		HtmlTag tag2 = new HtmlTag("frame");
		test.push(tag1);   // try to test push method of test object
		Stack <HtmlTag> expected_output = new Stack<HtmlTag>();
		expected_output.push(tag1);
		assertEquals(tag1, test.peek());  // test peek method
		test.push(tag2);  // try other time to test push method, and see whether it is stack
		assertEquals(tag2, test.peek());  // test peek method
	}
	
	
	@Test
	/**
	 * method to test isEmpty method of MyStack
	 */
    public void isEmptyTest(){
    	MyStack test = new MyStack();
    	assertTrue(test.isEmpty());
    }
	
	@Test
	/**
	 * method to test pop method 
	 */
	public void popTest(){
		MyStack test = new MyStack();
		HtmlTag tag1 = new HtmlTag("hr");     //create two valid tags
		HtmlTag tag2 = new HtmlTag("frame");
		test.push(tag1);  // push these two tags into test
		test.push(tag2);
		assertEquals(tag2,test.pop());  //test the top of element whether is poped
		assertEquals(tag1,test.peek());  // test the top element after poping whether is removed
	}
}
