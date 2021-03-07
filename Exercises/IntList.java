public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if(this.rest == null){
			return 1;
		}else{
			return 1+this.rest.size();
		}
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this.rest;
		int i = 0;
		while(true){
			if(p == null){
				return i+1;
			}
			if(p != null){
				p = p.rest;
				i++;
			}
		}
	}

	/** Returns the ith value in this list.*/
	public int get(int i) {
		if(i == 0){
			return this.first;
		}else{
			return this.rest.get(i-1);
		}
	}
	/**Exercise 2.2.1 addFirst() */
	public IntList addFirst(int x){
		/** 
		this.rest = this;
		这么写会有问题
		注意this和rest都是指针（而不是内容），rest指向自身首先就把内容丢掉了
		会在后面的iterativeSize里形成套娃的问题
		*/
		IntList temp = new IntList(x,this); 
		return temp;
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = L.addFirst(5);

		System.out.println(L.iterativeSize());
		System.out.println(L.get(0));
		System.out.println(L.size());

	}
} 