package assignStackSymbol;

import java.util.NoSuchElementException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**@author Chad Miller
 * 
 *Class implements JUnit tests of MyStack.
 */
public class TestMyStack extends TestCase{
	
    //a populated stack.
	private MyStack<Integer> populated;
	//an empty stack.
	private MyStack<Integer> emptyStack;

	@Before
	public void setUp() throws Exception {
		populated = new MyStack<Integer>();
		
		for (int i=0; i<10; i++)
			populated.push(i);
		
		emptyStack = new MyStack<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClear() {
		
		populated.clear();
		assertEquals(0, populated.size());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(emptyStack.isEmpty());
		assertFalse(populated.isEmpty());
	}

	@Test
	public void testPeek() {
		assertEquals(9, (int) populated.peek());
		
		try {
			emptyStack.peek();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof  NoSuchElementException);
		}
	}

	@Test
	public void testPop() {
		for (int i=0, j=9; i<populated.size(); j--)
			assertEquals(j, (int) populated.pop());
		
		
		try {
			populated.pop();
			fail();
		}
		catch (Exception e) {
			assertTrue(e instanceof  NoSuchElementException);
		}
	}

	@Test
	public void testPush() {
		emptyStack.push(1);
		assertEquals(1, (int) emptyStack.peek());
	}

	@Test
	public void testSize() {
		assertEquals(0, emptyStack.size());
		assertEquals(10, populated.size());
	}

}
