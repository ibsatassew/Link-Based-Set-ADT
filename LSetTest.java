/**
 *  Testing Set ADT - Linked List
 */
public class LSetTest 
{
    public static void main(String args[]) 
   {
      Set<Integer> A = new LSet<Integer>();  
      A.insert(2); 
      A.insert(3); 
      A.insert(5); 
      A.insert(7); 
      A.insert(11); 
      A.insert(13); 
      A.insert(17); 
      A.insert(19); 
      A.insert(23);                         

      Set<Integer> B = new LSet<Integer>();  
      B.insert(1); 
      B.insert(3); 
      B.insert(6); 
      B.insert(8); 
      B.insert(9); 
      B.insert(11); 
      B.insert(12); 
      B.insert(17); 
      B.insert(19); 
      B.insert(23); 
      B.insert(24); 
      B.insert(25);       
      System.out.println("A has " + A.size() + " elements: " + A);
      System.out.println("B has " + B.size() + " elements: " + B);
      System.out.println("The union of A and B = " + A.union(B));
      System.out.println("The intersection of A and B = " + A.intersect(B));
      System.out.println("The difference of A and B = " + A.diff(B));
      System.out.println("The symmetric difference of A and B = " + A.symDiff(B));
    } 
}
