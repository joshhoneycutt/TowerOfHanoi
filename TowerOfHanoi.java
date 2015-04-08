/* 
*  Author Name: Joshua Honeycuttt
*  Program: Tower of Hanoi, Program Assignment #1
*/ 
import java.util.*; 
public class TowerOfHanoi {

   /* Create public stack array
      Create public int to handle counting 
      Create public int to keep track of the total number of disks */
   public static Stack<Integer>[] tower = new Stack[4];
   public static int count = 0;
   public static int numberOfDisks;
 
   public static void main(String[] args) {
     
      Scanner scan = new Scanner(System.in);
      tower[1] = new Stack<Integer>();
      tower[2] = new Stack<Integer>();
      tower[3] = new Stack<Integer>();
      int disks = 0;
         
      // Asks user for the number of disks, checks to data
      do {         
          System.out.println("Enter number of disks");
          disks = scan.nextInt();
      } while (disks < 1 || disks > 10000);
      // Assigns the number of disks to public in public int
      numberOfDisks = disks;
      // Calls setUpTower method 
      setUpTower(disks);
  }
     
  // Function used to push disks into stack
  public static void setUpTower(int numberOfDisks){
      for (int i = numberOfDisks; i > 0; i--)
         tower[1].push(i);
         display();
         move(numberOfDisks, 1, 2, 3);
               
  }
     
   // Recursive function to move disks between towers
   public static void move(int numberOfDisks, int a, int b, int c) {
     if (numberOfDisks > 0) {            
         move(numberOfDisks-1, a, c, b);     
         int i = tower[a].pop();                                             
         tower[c].push(i);
         display();                  
         move(numberOfDisks-1, b, a, c);    
      }           
   }
     
    // Function to display towers
    public static void display() {
     
         for(int i = numberOfDisks - 1; i >= 0; i--) {
             String d1 = " ", d2 = " ", d3 = " ";
             try {
                 d1 = String.valueOf(tower[1].get(i));
             }
             catch (Exception e){
             }    
             try {
                 d2 = String.valueOf(tower[2].get(i));
             }
             catch(Exception e){
             }
             try {
                 d3 = String.valueOf(tower[3].get(i));
             }
             catch (Exception e){
             }
             System.out.println("  "+d1+"  |  "+d2+"  |  "+d3);
         }
         System.out.println("---------------");
         System.out.println("  A  |  B  |  C");
         System.out.println("Total number of moves "+count++);
         System.out.println("\n");     
     }
 }
