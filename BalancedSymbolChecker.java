package assignStackSymbol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**@author Chad Miller.
 *
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 */
public class BalancedSymbolChecker {		

    //represents a normal symbol.
	private static final char NORMAL = 'a';
	//a char array of opening symbols.
	private static final Character[] OPEN = {'(', '{', '['};
	//a char array of closing symbols.
	private static final Character[] CLOSED = {')', '}', ']'};
	//a set of open symbols.
	private static final HashSet<Character> open = new HashSet<Character>(Arrays.asList(OPEN));
	//a set of closed closed symbols.
	private static final HashSet<Character> closed = new HashSet<Character>(Arrays.asList(CLOSED));
	//opening symbols are matched to closing symbols.
	private static HashMap<Character, Character> symbolMatch = new HashMap<Character, Character>(); 

	/**
	 * Returns a message indicating whether the input file has unmatched
	 * symbols. (Use the methods below for constructing messages.) Throws
	 * FileNotFoundException if the file does not exist.
	 */
	public static String checkFile(String filename) throws FileNotFoundException {
		symbolMatch.put('(', ')');
		symbolMatch.put('[', ']');
		symbolMatch.put('{', '}');

		MyStack<Character> stack = new MyStack<Character>();
		Scanner s = new Scanner(new File(filename));

		int line = 0;
		int col = 0;
		char result = ' ';

		while(s.hasNextLine()){
			line++;			
			String str = s.nextLine();

			char[] symbols = str.toCharArray();

			// check for one line
			for (int i=0; i<symbols.length; i++) {
				col++;

				if (symbols[i]=='/') {
					// checking for line comment
					if (i<symbols.length-1 && symbols[i+1] == '/')
						// line comment --- skip checking the remaining of the line
						break;
					// checking for paragraph comment
					if (i<symbols.length-1 && symbols[i+1] == '*') {
						// paragraph comment 
						// skip checking the remaining of the paragraph
						// and find the closing "*/"
						int column = str.indexOf("*/");
						while (s.hasNextLine() && column == -1) {
							str = s.nextLine();
							column = str.indexOf("*/");
						}
						if (column == -1)
							return unfinishedComment();
						else 
							col = column;
					}						
				}

				if (symbols[i] == '\"') {
					// find the next "
					int column = str.substring(i+1).indexOf("\"")+(i+1);
					
					while ( column != -1 && symbols[column-1] == '\\' )
						// the " is escaped - find next one
						column = str.substring(column+1).indexOf("\"")+(column+1);
					
					/*
					if (column == -1) {
						// report error since " is not balanced
					}
					*/
					
					i = column+1;
					col = i+1;
				}

				
				if (symbols[i] == '\'') {
					// find the next "
					int column = str.substring(i+1).indexOf("\'")+(i+1);
					
					while ( column != -1 && symbols[column-1] == '\\' )
						// the " is escaped - find next one
						column = str.substring(column+1).indexOf("\'")+(column+1);
					
					/*
					if (column == -1) {
						// report error since " is not balanced
					}
					*/
					
					i = column+1;
					col = i+1;
				}

				result = checkSymbol(symbols[i], stack);

				if (result != NORMAL)
					return unmatchedSymbol( line, col, 
							symbols[i], result );
			}
			// end of checking the line

			col = 0;

		}				

		// finished reading file
		if(!stack.isEmpty())
			return unmatchedSymbolAtEOF(symbolMatch.get(stack.peek()));


		// everything is right
		return allSymbolsMatch();
	}

/**
 * Private helper method that checks symbol.
 * If symbol is normal and open it is pushed onto the stack.
 * If symbol is closed and matches top item on stack, stack is popped.
 * If stack is empty and unmatched closing symbol is found returns an empty char, 
 * otherwise returns the expected matching symbol of the unmatched closing symbol.
 * @return char
**/	private static char checkSymbol(char c, MyStack<Character> stack) {
		if (open.contains(c)) {
			stack.push(c);
			return NORMAL;
		}

		if (closed.contains(c)) {
			if( !stack.isEmpty() && c == symbolMatch.get(stack.peek()) ){
				stack.pop();				
			}
			else {
				if (stack.isEmpty()) return ' ';
				else return symbolMatch.get(stack.peek());
			}
		}

		return NORMAL;
	}

	/**
	 * Returns an error message for unmatched symbol at the input line and
	 * column numbers. Indicates the symbol match that was expected and the
	 * symbol that was read.
	 */
	private static String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected " + symbolExpected
				+ ", but read " + symbolRead + " instead.";
	}

	/**
	 * Returns an error message for unmatched symbol at the end of file.
	 * Indicates the symbol match that was expected.
	 */
	private static String unmatchedSymbolAtEOF(char symbolExpected) {
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
	}

	/**
	 * Returns an error message for a file that ends with an open /* comment.
	 */
	private static String unfinishedComment() {
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Returns a message for a file in which all symbols match.
	 */
	private static String allSymbolsMatch() {
		return "No errors found. All symbols match.";
	}
}
