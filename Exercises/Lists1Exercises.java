public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        IntList Q = new IntList(L.first,L.rest);
        IntList l = L;
        IntList q = Q;
        while(true) {
          if(l.rest == null){
            q.first = l.first + x;
            return Q;
            /**注意不能return q，因为此时q = Q.rest.rest.... */
          } else {
            q.first = l.first + x;
            q = q.rest;
            l = l.rest;
          }
        }        
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
      IntList l = L;
      while(true) {
        if(l.rest == null){
          l.first = l.first + x;
          return L;
        } else {
          l.first = l.first + x;
          l = l.rest;
        }
      }
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        //System.out.println(L.size());
        //System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        System.out.println(L.get(1));
        System.out.println(incrList(L, 0).rest.first);  
        System.out.println(dincrList(L, 3).rest.first);
      
    }
}