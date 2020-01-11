
/**
 * EvanBirt_03 CS2050- EvanBirt_03 Class List
 * Evan Birt
 * Homework/Project #03
 * Windows 10, 15.6" laptop, IntelliJ IDEA
 * Turpitude - wickedness shamefulness
 * "The payoffs in showbiz seemed as random as a slot machine.", Kathie Lee Gifford. B. 1953
 *
 * @author Evan Birt
 * @version 2019.03.06
 */


// Class List
public class List<T> implements MyCollectionInterface<T> {
    private Node first;
    private Node last;
    private int size;

    // Constructor
    public List() {
        first = null;
        last = null;
        size = 0;
    } // End constructor


    /**
     * Adds a new entry to this collection
     *
     * @param newItem The object to be added to the collection
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newItem) {
        Node node1 = new Node(newItem, null);
        Node node2 = new Node(newItem, null);

        if (newItem == null) {
            throw new NullPointerException("The data for add() is null.");
        }

        if (!isEmpty()) {
            Node prev = last;
            last = node1;
            prev.next = last;
        } else {
            last = node2;
            first = last;
        }

        size++;
        return true;
    } // End add()
//****************************************************************************************************************

    /**
     * Removes one unspecified entry from the collection, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove() from an empty list.");
        }
        T entry = first.getData();
        first = first.next;
        size--;
        return entry;
    } // End remove()
//****************************************************************************************************************

    /**
     * Removes one occurrence of a given entry from this collection.
     *
     * @param anEntry The entry to be removed.
     * @return true if the removal was successful, false if not.
     */
    public boolean remove(T anEntry) {
        boolean result = true;

        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove() from and empty list.");
        }

        Node previous = first;
        Node current = first;

        while (current.next != null) {
            if (current.data.equals(anEntry)) {
                previous.next = current.next;
                size--;
                result = true;
                break;
            }
            previous = current;
            current = previous.next;
        }
        return result;
    } // End remove()
    //****************************************************************************************************************

    /**
     * Removes all entries from this collection.
     */
    public void clear() {
        size = 0;
        first = null;
        last = null;
    } // End clear()
    //****************************************************************************************************************

    /**
     * Gets the current number of entries in this collection.
     *
     * @return The integer number of entries currently in the collection.
     */
    public int getCurrentSize() {
        return size;
    } // End getCurrentSize()
    //****************************************************************************************************************

    /**
     * Check to see if the collection is empty.
     *
     * @return True if the collection is empty, or false if not.
     */
    public boolean isEmpty() {
        return (first == null);
    } // End isEmpty
    //****************************************************************************************************************

    /**
     * Counts the number of times a given entry appears in this collection.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the collection.
     */
    public int getFrequencyOf(T anEntry) {
        int anEntryFrequency = 0;
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty. Frequency is 0");
        }

        Node current = first;
        while (current.next != null || current == last) {
            if (current.data.equals(anEntry)) {
                // remove the last remaining element
                anEntryFrequency++;
            } // End if
        } // End while
        return anEntryFrequency;
    } // End getFrequencyOf()
    //****************************************************************************************************************

    /**
     * Tests whether this collection contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the collection contains anEntry, or false if not.
     */

    public boolean contains(T anEntry) {
        Node startPtr = first;
        boolean a = false;

        if (!isEmpty()) {
            while (startPtr.getLink() != null) {
                if (startPtr.getData().equals(anEntry)) {
                    a = true;
                    break;
                }
                startPtr = startPtr.getLink();
            }
        }
        return a;
    } // End contains()


    //****************************************************************************************************************

    /**
     * Retrieves all entries that are in this collection.
     *
     * @return A newly allocated array of all the entries in the collection.
     * Note: If the collection is empty, the returned array is empty.
     */
    @SuppressWarnings("unchecked") //### Added to suppress return statement warning
    public T[] toArray() {

        Object[] outputArray = new Object[size];  //### Create an Object, not T array
        Node ptr = this.first;
        Node tmp;

        for (int i = 0; i < size; i++) {
            outputArray[i] = ptr.getData();
            tmp = ptr.getLink();
            ptr = tmp;
        }
        return (T[]) outputArray;  //### Cast the returning array as type T
    } // End toArray()


    private class Node {
        private T data;
        private Node next;

        // Constructor
        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        } // End constructor

        private Node getLink() {
            return next;
        } // EndLink()

        private T getData() {
            return data;
        } // End getData()
    } // End class Node
} // End LinkedList
