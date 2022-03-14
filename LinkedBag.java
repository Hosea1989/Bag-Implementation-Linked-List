

public class LinkedBag < T > implements BagInterface < T >
{
    private Node <T> head;   // reference to first node
    private int numberOfEntries;  // how many items are in the bag

    public LinkedBag (){
        // need to fill it
        head = null;
        numberOfEntries = 0;
    }// end default constructor


    // @param T a data entry to add in the list
    // @result return true if you add it successfully
    @Override
    public boolean add(T newEntry) {
//need to fill it
        Node <T> newNode = new Node <T> (newEntry); // Create a new node using NewEntry
        newNode.setNextNode(head);
        head = newNode;
        numberOfEntries++;
      return true;
    }


    @Override
    public void clear() {
        while (!isEmpty())
            remove();
    }

    // @param : an Entry to figure out if it is inside the list
    // @result : return true if the entry is in the list, false otherwise
    @Override
    public boolean contains(T anEntry)
    {
        if ( getReferenceTo(anEntry) != null ){
            return true;
        }
        else return false;
    }

    // Implementations of the public methods declared in BagInterface go here.
    // @result the current numberOfEntries
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    // @param : an Entry to count the number of occurrences
    // @result : return the number of occurrences.
    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency=0;
        int counter =0;

        Node p=head;

        while (counter < numberOfEntries) {
            if (anEntry.equals(p.getData()))
                frequency++;

            counter++;
            p=p.getNextNode();
        }

        return frequency;
    }

    @Override
    public boolean isEmpty() {
        if (head==null)
            return true;
        else return false;
    }

    @Override
    public boolean isFull()
    {
        return false;
        // as long as Java virtual machine create a new node (i.e. your computer memory is not full), it is not full.
    }

    // remove the 1st item in the list
    // @result return the data entry removed, return null if the list is empty
    @Override
    public T remove() {
        T result = null;
        if(!isEmpty()){
            result = head.getData();
            head = head.getNextNode();
            numberOfEntries--;
        }
        return result;

//need to fill it
    }

    // remove the item in the list whose data is anEntry
    // @param an Entry to remove.. Please note that the entry could be at any place in the list
    // @result return true if you remove the entry successfully, false otherwise
    @Override
    public boolean remove(T anEntry) {
        boolean result=false;
        Node p=getReferenceTo(anEntry); // find a reference to the node which has the data entry

        if (p!=null) {
            p.setData(head.getData());  //nodeN.data=head.data;
            remove();    // remove the first item in the list
            result=true;
        }
        return result;
    }

    // copy the data entries in the list into the array
    // @result : return the array
    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];

        Node p=head;

        for (int index=0;  index < numberOfEntries ; index++ ) {
            result[index] = (T) p.getData();
            p=p.getNextNode();
        }
        return result;
    }

    // @param : an Entry to locate
    // @result : return the reference to the entry if you found the entry, or null if not found
    private Node getReferenceTo (T anEntry) {
        boolean found = false;
        Node p = head;

        while (true){

            if (p == null) break;
            if (found) break;
            if (anEntry.equals(p.getData()))
                found = true;
            else
                p = p.getNextNode();
        }
//need to fill it
        return p;
    }



} // end LinkedBag
