package generics_1;

import java.util.ArrayList;

public class GenericStack2<E> extends ArrayList{

	public GenericStack2() {
		
	}
	
	public int getSize() {
		return this.size();
	}

	public E peek() {
		return (E)this.get(getSize() - 1);
	}

	public void push(E o) {
		this.add(o);
	}

	public E pop() {
		E o = (E) this.get(getSize() - 1);
		this.remove(getSize() - 1);
		return o;
	}

	public boolean isEmpty() {
		return this.isEmpty();
	}

	@Override
	public String toString() {
		return "stack: " + this.toString();
	}
}
