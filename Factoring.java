/*
 * Factor any two numbers of X sizes and find and output the shared factors of the numbers
 */
package factoring;

/**
 *
 * @author super
 */
import java.util.*;
public class Factoring
{

    public static void main(String[] args) 
    {
      // declare vars
    Integer x=0, y=0; 

    ArrayList<Integer> xFac,yFac,sameFac = new ArrayList<Integer>(); 
    
    //everything through "Scanner in..."" to "in.close" handles entry from console and will end program if user enters "stop"
       
       Scanner in=new Scanner(System.in);
       
      // while (in.nextLine().toLowerCase() != "stop") {
        
       
       System.out.println("Enter Integer 1");
       try 
       {
         x=in.nextInt();
       } 
       catch (Exception e) 
       { 
        System.out.println("Please Enter an Integer");
       }
      
       System.out.println("please enter Integer 2");
             try 
        {
        y=in.nextInt();
       } 
            catch (Exception e) 
       { 
        System.out.println("Please Enter an Integer");
       }
      
      //Next two lines populate the array list 
      xFac=facts(x);
      yFac=facts(y);
      
      //print the inital factors 
      printFac(xFac,x);
      printFac(yFac,y);

      //Get the union
       sameFac=facCompair(xFac, yFac);

      //print the same factors
      //todo fix formatting
      System.out.printf("the shared factors of %d and %d are [",x,y);
      for (int i = 0; i < sameFac.size(); i++) {
        System.out.printf("%d,",sameFac.get(i));
      }
      System.out.printf("]%n");

      //clear the arrays for the next instance
      xFac.clear();
      yFac.clear();
      sameFac.clear();

    //}

    //close scanner
      in.close();

      //end of program msg
      System.out.println("End of program");
    }

    /*
     * find the factors for num a
     *
     * returns an array list of all factors 
     */
    public static ArrayList<Integer> facts(Integer a)
        {
            ArrayList<Integer> factors = new ArrayList<Integer>();
            for(int i=1;i<=a/2;i++)
                {
                    if(a%i==0)                                 
                    if(!factors.contains(i)&&!factors.contains(a%i)) //todo roll this into last line
                        {
                        factors.add(a/i);
                        factors.add(i);
                        }
                }
                Collections.sort(factors);
            return factors;
        }
    
/*
 * prints the array of factors and adds nice formatting around it 
 * 
 * eg: if x=4 this method will print "The Factors for 4 are [1,2,4]"
 * 
 * todo fix formatting
 * todo make this return string
 */
  public static void printFac(ArrayList<Integer>facList, Integer num)
  {
    System.out.printf("The Factors for %d are[",num);

        for (Integer i : facList) 
        {
            System.out.printf("%d,",i);
        }
    System.out.printf("]%n");
  }

/*
 * Find the union of the two arrays of factors and return an array list of the union
 */
  public static ArrayList<Integer> facCompair( ArrayList<Integer>xList,ArrayList<Integer>yList) 
  {
    ArrayList<Integer> samefac= new ArrayList<Integer>();

    for (Integer i : yList) 
    {
      if(xList.contains(i))
      samefac.add(i);
    }
    Collections.sort(samefac);
    return samefac;
  } 
}