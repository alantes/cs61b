/**Exercise 2.2.2 
 * A rather contrived exercise to test your understanding of when
    nested classes may be made static. This is NOT an example of good
    class design, even after you fix the bug.

    The challenge with this file is to delete the keyword static the
    minimum number of times so that the code compiles.

    Guess before TRYING to compile, otherwise the compiler will spoil
    the problem.*/
public class Government {
	private int treasury = 5;

	private void spend() {
		treasury -= 1;
	}

	private void tax() {
		treasury += 1;
	}

	public void report() {
		System.out.println(treasury);
	}

	public static Government greaterTreasury(Government a, Government b) {
		if (a.treasury > b.treasury) {
			return a;
		}
		return b;
	}

	public static class Peasant {
		public void doStuff() {
			System.out.println("hello");			
		}
	}

	public class King {
		public void doStuff() {
			spend();			
		}
	}

	public class Mayor {
		public void doStuff() {
			tax();			
		}
	}

	public class Accountant {
		public void doStuff() {
			report();			
		}
	}

	public class Thief {
		public void doStuff() {
			treasury = 0;			
		}
	}

	public static class Explorer {
		public void doStuff(Government a, Government b) {
			Government favorite = Government.greaterTreasury(a, b);
			/**加static的好处是nested class没必要存储一份reference指向outer class；
			 * 这一nested class没有直接从outer class中获取其methods和variables，而是重新调用了Government.
			 * 因此没必要在类中存储指向outer class的reference
			 * 另外课程中说的：
			 * If the nested class has no need to use any of the *instance* methods or variables of SLList, 
			 * you may declare the nested class static, as follows.
			 *  */
			System.out.println("The best government has treasury " + favorite.treasury);			
		}
	}
}