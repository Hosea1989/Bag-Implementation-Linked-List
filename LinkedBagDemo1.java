

public class LinkedBagDemo1
{
    public static void main (String [] args)
    {
        BagInterface < String > aBag = new LinkedBag < String > ();

        //TestCase1
        testToArray (aBag);  // you should print empty string here
        System.out.println  (" ");

        //TestCase2
        String [] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
        testAdd (aBag, contentsOfBag); // The content should have D A C A B D A
        System.out.println (" ");

        //TestCase3
        aBag.remove();  // The content should have A C A B D A
        testToArray (aBag);
        System.out.println (" ");

        //TestCase4
        aBag.remove ("A");  // The content should have C A B D A
        testToArray (aBag);
        System.out.println (" ");

        //TestCase5
        int numItems = aBag.getFrequencyOf ("A");
        System.out.println ("Number of A is " + numItems);  // how many "A" is there? 2
        System.out.println (" ");

        //TestCase6
        boolean result = aBag.contains ("Z");
        if (result){
            System.out.println ("\nitem is in the list...");
        }
        else System.out.println ("item is NOT in the list...");  // "item is not in the list" should be shown.


    } // end main


    // Tests the method add.
    private static void testAdd (BagInterface < String > aBag,
                                 String [] content)
    {
        System.out.print ("Adding to the bag: ");
        for (int index = 0 ; index < content.length ; index++)
        {
            aBag.add (content [index]);  //{"A", "D", "B", "A", "C", "A", "D"};
        }
        testToArray (aBag);
    } // end testAdd


    // Tests the method toArray while displaying the bag.
    private static void testToArray (BagInterface < String > aBag)
    {
        System.out.println ("The bag contains the following string(s):");
        Object [] bagArray = aBag.toArray ();
        for (int index = 0 ; index < bagArray.length ; index++)
        {
            System.out.print (bagArray [index] + " ");
        } // end for
        System.out.println ();
    } // end displayBag




} // end LinkedBagDemo1