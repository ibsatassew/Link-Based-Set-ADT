/**
*
* Implementation of Set ADT using linked lists
*
* @author 
*
*/

class LSet<E> implements Set<E> {
   private Link<E> head;         // pointer to list header
   private Link<E> tail;         // pointer to last element
   protected Link<E> curr;       // access to current element
   int cnt;                      // size of list

   LSet (int size){
      this(); 
   }   

   LSet () {
      curr = tail = head = new Link<E>(null); 
      cnt = 0;
   }
   /** 
   /** @return true if item is in this set; false otherwise. */
   public boolean contains (E item) {
      curr = head;
      for(int i = 0; i<size(); i++) {
         if (item.equals(curr.next().element())){
            return true;
       }
       curr = curr.next();
     }
          return false;
     }
   

   /** @return true if this set is empty; false otherwise. */
   public boolean isEmpty() {
      if(head == null) { return true;}
      return false;
   }

   /** @return the number of elements in this set. */
   public int size() {return cnt;}

   /** Insert an element at the current location. 
      @param item The element to be inserted. */
   public void insert(E item) {
      curr.setNext(new Link<E>(item, curr.next()));   
      if (tail == curr) tail = curr.next();  // New tail
         cnt++; 
      }

   /** @return The data element of the item at position i. */
   public E getValue(int i) {
      curr = head;
      
      if(curr == null){return null;}
      for(int j = 0; j<=i; j++) 
      {
         curr = curr.next();
      }
      return curr.element();
   }

   /** Compute the union of two sets.
      @param S another set
      @return the union of this set with S.
   */
   public Set<E> union(Set<E> S) {
      Set<E> union = new LSet<E>();
      curr = head;
   	for(int i = 0; i<size(); i++){
   		union.insert(curr.next().element());
         curr = curr.next();
   		}
   	
   	for(int i = 0; i<S.size(); i++) {
   		if(!contains(S.getValue(i))){
   			 union.insert(S.getValue(i));
   		} 
   	}
   	return union;
   } 

   /** Compute the intersection of two sets.
      @param S another set
      @return the intersection of this set with S.
   */
   public Set<E> intersect(Set<E> S){
      Set<E> intersect = new LSet<E>();
   	for(int i = 0; i<S.size(); i++) {
   		if(contains(S.getValue(i))){
   			intersect.insert(S.getValue(i));
   		} 
   	}
   	return intersect;
   } 

   /** Compute the difference of two sets.
      @param S another set
      @return the difference of this set with S.
   */
   public Set<E> diff(Set<E> S) {
      Set<E> diff = new LSet<E>();
      curr = head;
    for(int i = 0; i<size(); i++) {
      if(!S.contains(curr.next().element())){
         diff.insert(curr.next().element());
      }
      curr = curr.next();
   }
   
    return diff;

  }


   /** Compute the symmetric difference of two sets using the diff method.
      @param S another set
      @return the symmetric difference of this set with S.
   */
  public Set<E> symDiff(Set<E> S) {
   Set<E> symDiff = new LSet<E>();
   symDiff = diff(S);
   for(int i = 0; i<S.size(); i++) {
      if(!contains(S.getValue(i))){
        symDiff.insert(S.getValue(i));
  
      }
   }
   return symDiff;
  }
  /** Another approach to compute the symmetric difference of two sets using the union and intersect methods.
      @param S another set
      @return the symmetric difference of this set with S. */

   /** 
      public Set<E> symDiff(Set<E> S){
   Set<E> symDiff = new LSet<E>();
   Set<E> myUnion = new LSet<E>();
   Set<E> myIntersect = new LSet<E>();
   myUnion = union(S);
   myIntersect = intersect(S);
   for(int i = 0; i<myUnion.size(); i++) {
      if(!myIntersect.contains(myUnion.getValue(i))){
        symDiff.insert(myUnion.getValue(i));
      }
   }
   return symDiff;
}
*/

 /** @return a string that contains all elements in this set */
	public String toString()
  {
    StringBuffer out = new StringBuffer((size() + 1) * 4);

    curr = head.next();
    out.append("< ");
    while(curr != null) {
      out.append(curr.element());
      out.append(" ");
      curr = curr.next();
    }
    out.append(">");
    return out.toString();
  }
}
