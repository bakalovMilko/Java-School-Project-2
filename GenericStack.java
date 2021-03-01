package generics_1;

public class GenericStack<E> {
	private int size=0;
	private Object[] list = (E[]) new Object[3];

	public GenericStack() {
		
	}
	
	public int getSize() {
		return list.length;
	}

	public E peek() {
		if(size>0){
			return (E) list[size-1];
		}
		else{
			return null;
		}
	}

	public void push(E o) {
		if(size==list.length){
			Object[] workList = (E[]) new Object[2*size];
			System.arraycopy(list, 0, workList, 0, size);
			workList[size] = o;
			list = workList;
		}
		else {
			list[size] = o;
		}
		size++;
	}

	public E pop() {
		if(size>0){
			E o = (E) list[size-1];
			list[size-1] = null;
			size--;
			return o;
		}
		else{
			return null;
		}
	}

	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public String toString() {
		return "stack: " + list.toString();
	}
}
