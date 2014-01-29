package assignStackSymbol;

import assignDblyLinkedList.MyLinkedList;
import java.util.NoSuchElementException;

/*** @author Chad Miller
 *
 * Represents a generic stack (last in, first out).
 * Class is implemented through an instance of MyLinkedList.
 * @param <E>
 *            -- the type of elements contained in the stack
 */
public class MyStack<E> {

    //instance of MyLinkedList. 
	private MyLinkedList<E> stack;

	//construct an empty stack.
	public MyStack() {
		stack = new MyLinkedList<E>();
	}

	/**
	 * Removes all of the elements from the stack.
	 */
	public void clear() {
		stack.clear();
	}

	/**
	 * Returns true if the stack contains no elements.
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * Returns the item at the top of the stack without removing it from the
	 * stack. Throws NoSuchElementException if the stack is empty.
	 */
	public E peek() throws NoSuchElementException {
		return stack.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack. Throws
	 * NoSuchElementException if the stack is empty.
	 */
	public E pop() throws NoSuchElementException {
		return stack.removeFirst();
	}

	/**
	 * Pushes the input item onto the top of the stack.
	 */
	public void push(E item) {
		stack.addFirst(item);
	}

	/**
	 * Returns the number of items in the stack.
	 */
	public int size() {
		return stack.size();
	}
}
