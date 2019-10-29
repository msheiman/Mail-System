package mail_bag;

public class MailCollection {
	private String[] stack;
	private int count;
	private final int FIRST_INDEX = 0;

	/**
	 * description: Creates constructor 
	 * parameters: int capacity 
	 * precondition: is called 
	 * postcondition: creates constructor and starts count 
	 * throws: none
	 */
	public MailCollection(int capacity) {
		this.stack = new String[capacity];
		this.count = 0;
	}

	/**
	 * description: add element to a stack 
	 * parameters: char element 
	 * precondition: if count is greater then length ensureCapacity 
	 * postcondition: add element, increase count 
	 * throws: none
	 */
	public void push(String element) {
		if (count == stack.length)
			ensureCapacity();

		stack[count] = element;
		count++;
	}

	/**
	 * description: increase size of array 
	 * parameters: none 
	 * precondition: is called
	 * postcondition: makes a bigger array 
	 * throws: none
	 */
	private void ensureCapacity() {
		String[] bArray = new String[1 + (stack.length * 2)];
		System.arraycopy(stack, FIRST_INDEX, bArray, FIRST_INDEX, stack.length);
		stack = bArray;
	}

	/**
	 * description: makes count at zero 
	 * parameters: none 
	 * precondition: is called
	 * postcondition: returns count is zero 
	 * throws: none
	 */
	public boolean isEmpty() {

		return (count == 0);
	}

	/**
	 * description: gets length of stack 
	 * parameters: none 
	 * precondition: is called
	 * postcondition: returns length of stack 
	 * throws: none
	 */
	public int length() {
		return stack.length;
	}

	/**
	 * description: takes element out of stack 
	 * parameters: none 
	 * precondition: is called 
	 * postcondition: returns element 
	 * throws: none
	 */
	public String pop() {
		String element = stack[--count];

		return element;
	}

	/**
	 * description: checks char at index 
	 * parameters: int i 
	 * precondition: is called
	 * postcondition: returns element at index 
	 * throws: none
	 */
	public String mailCheck(int i) {
		return stack[i];
	}

	/**
	 * description: looks at top of stack 
	 * parameters: none 
	 * precondition: is called
	 * postcondition: returns stack 
	 * throws: StackOverflowError("Stack is empty")
	 */
	public String peek() {
		if (isEmpty())
			throw new StackOverflowError("Stack is Empty");

		return stack[count - 1];
	}
}
