/**
 * Implementation of bubblesort using linked lists.
 */

public class BubbleSortSinglyLinkedListImplementation {
    /**
     * Sorting with a linked list implementation. Only ints are allowed at this point in time.
     * Could make use of the compareable interface in order to allow other data-types to be
     * sorted.
     * @param list singly-linked list of int:s.
     */
    public void bubblesort(LinkedListImplementation list) {
        int R = list.getSize() - 2;
        boolean swapped = true;

        while ( R >= 0 && swapped) {
            Node current = list.getHead();
            Node nextNode = list.getHead().next;
            Node previous = null;
            swapped = false;

            for(int i = 0; i <= R; i++)
                if (current.data > nextNode.data) {
                    swapped = true;
                    swap(list, current, previous);
                    previous = nextNode;
                    nextNode = current.next;
                } else {
                    previous = current;
                    current = nextNode;
                    nextNode = nextNode.next;
                }
            R--;
        }
    }

    /**
     * Swaps two elements in a singly linked list.
     * This function's time complexity is constant.
     * @param list singly linked list
     * @param current "pointer"
     * @param previous "pointer"
     */
    public void swap(LinkedListImplementation list, Node current, Node previous){
        Node nextNode = current.next;
        if ( previous != null ) {
            Node temp = nextNode.next;
            previous.next = nextNode;
            nextNode.next = current;
            current.next = temp;
        }
        else{
            Node temp = nextNode.next;
            list.setHead(nextNode);
            nextNode.next = current;
            current.next = temp;
        }
    }

    /**
     * Node class used to achieve a basic singly list structure.
     */
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return this.data;
        }
    }

    /**
     * Basic implementation of a singly linked list using nodes.
     */
    class LinkedListImplementation {
        private Node head;
        private int size;
        private Node last;


        public  Node getHead(){
            return this.head;
        }

        public int getSize() {
            return size;
        }

        public void setHead(Node head){
            this.head = head;
        }

        public LinkedListImplementation(){
            this.head = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * This implementation of add makes sure the time complexity
         * is limited to a constant time.
         * @param data
         */
        public void add(int data) {
            Node oldlast = last;
            last = new Node(data);
            last.next = null;
            if (isEmpty()) head = last;
            else oldlast.next = last;
            size++;
        }

        /**
         * Placeholder printout method. Should probably be replaced with some
         * implementation of toString override instead.
         */
        public void printData() {
            Node currentNode = head;

            while(currentNode != null) {
                int data = currentNode.getData();
                System.out.print(data + ", ");
                currentNode = currentNode.next;
            }
            System.out.println();
        }
    }
}
