/*
 * Implementation of a simple stack for HtmlTags.
 * You should implement this class.
 */

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack {
	// An ArrayList to hold HtmlTag objects.
	private ArrayList<HtmlTag> stack_internal;
	//private Stack<HtmlTag> tag = new Stack<HtmlTag>();
	/*
	 * Create an empty stack.
	 */
	public MyStack( ) {
		this.stack_internal = new ArrayList<HtmlTag>( );
	}

	/*
	 * Push a tag onto the top of the stack.
	 */
	public void push( HtmlTag tag ) {
		this.stack_internal.add(tag);
	}

	/*
	 * Removes the tag at the top of the stack.
	 * Should throw an exception if the stack is empty.
	 */
	public HtmlTag pop( ) {
		int topOfIndex = this.stack_internal.size() - 1;
		HtmlTag removedItem;
		if(this.stack_internal.isEmpty()){
			throw new EmptyStackException();
		}else{
			removedItem = this.stack_internal.get(topOfIndex);
			this.stack_internal.remove(topOfIndex);
		}
		return removedItem;
	}

	/*
	 * Looks at the object at the top of the stack but
	 * does not actually remove the object.
	 * Should throw an exception if the stack is empty.
	 */
	public HtmlTag peek( ) {
		int topOfIndex = this.stack_internal.size() - 1;
		HtmlTag topItem;
		if(this.stack_internal.isEmpty()){
			throw new NullPointerException("Stack Is Empty");
		}else{
			topItem = this.stack_internal.get(topOfIndex);
		}
		return topItem;
	}

	/*
	 * Tests if the stack is empty.
	 * Returns true if the stack is empty;
	 * false otherwise.
	 */
	public boolean isEmpty( ) {
		return this.stack_internal.isEmpty();
	}
}
