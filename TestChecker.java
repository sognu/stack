package assignStackSymbol;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**@author Chad Miller
 * 
 * Class implements 14 JUnit tests of BalancedSymbolChecker.
 */
public class TestChecker {
	//actual message.
	private String msg;
	//expected message.
	private String expected;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class1.java");
			expected = "ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void test2() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class2.java");
			expected = "ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void test3() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class3.java");
			expected = "No errors found. All symbols match.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void test4() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class4.java");
			expected = "ERROR: File ended before closing comment.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}

	
	@Test
	public void test5() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class5.java");
			expected = "ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void test6() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class6.java");
			expected = "No errors found. All symbols match.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void test7() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class7.java");
			expected = "ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void test8() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class8.java");
			expected = "ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void test9() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class9.java");
			expected = "ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void test10() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class10.java");
			expected = "ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void test11() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class11.java");
			expected = "ERROR: Unmatched symbol at the end of file. Expected }.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void test12() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class12.java");
			expected = "No errors found. All symbols match.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void test13() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class13.java");
			expected = "No errors found. All symbols match.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void test14() {
		try {
			msg = BalancedSymbolChecker.checkFile("A6_example/Class14.java");
			expected = "No errors found. All symbols match.";
			assertEquals(expected, msg);
		}
		catch (FileNotFoundException e) {
			
		}
	}
}
