package LA1Q1;

//generic class
public class SinglyLinkedList <T>{
    /*For My Understanding on Node and Linked List
    Node is used to realize the list
    Node represents a link list
    Each element in Linked List is called Node
    Node contains two attributes, element and next, this is why we have two fields in generic Node class
     */
    //reference variables
    private Node<T> head = null;    //head node of the list (null if empty)
    private Node<T> tail = null;    //tail node of the list (null if empty)
    private int size = 0;           //will be used to keep track of number of nodes in the list

    //constructor without parameter
    public SinglyLinkedList(){
        //constructing an initially empty Linked List
    }
    //constructor with parameter
    public SinglyLinkedList(Node<T> head, Node<T> tail){
        //head of the linked list and tail of linked list
        this.head = head;
        this.tail = tail;
    }
    //getter method for field size
    public int getSize(){
        return size;
    }
    //method to check if the list is empty
    public boolean isEmpty(){
        return size ==0;
    }
    public String toString(){

        String resultString = "[";
        Node<T> resultNode = head;

        if(resultNode == null)
            return resultString + "]";

        while(resultNode.getNext() != null){
            //printing while the next element is not assigned to null, it'll add on to the string
            resultString += String.format("%s, ", resultNode.getElement());
            resultNode = resultNode.getNext();
        }

        resultString += String.format("%s]", resultNode.getElement());
        return resultString;
    }

    public T first() {
        if(isEmpty()) return null;
        return head.getElement();
    }
    public T last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

   //adding node at the head of the linked list and making a new head
    public void addFirst(T t){
        head = new Node<> (t, head);    //creating and linking a new node, new node point to old head
        if (size == 0){
            tail = head;                //new node becomes tail (moving it to tail)
        }
        size++;
    }
    //adding a node at the tail of the linked list and making a new tail
    public void addLast(T t){
        Node<T> newest = new Node<>(t, null);   //node will become the tail in future
        if(isEmpty())
            head = newest;              //if empty, new node becomes the head
        else
            tail.setNext(newest);       //if not empty, new node after existing tail
        tail = newest;                  // new node becomes the tail
        size++;
    }
    //method for removing head and returning the element
    public T removeFirst() {            //removes and return the first element
        if(isEmpty()) return null;      //nothing to remove
        T answer = head.getElement();
        head = head.getNext();          //assign next one to the new head and will become null if list had only one node
        size--;
        if(size==0) tail = null;        //list is empty
        return answer;
    }
    public T removeLast() {            //removes and return the last element
        if(isEmpty()) return null;      //nothing to remove

        Node<T> lastNode = head;
        Node<T> previousToLast = null;
        while(lastNode.getNext() != null){
            previousToLast = lastNode;
            lastNode = lastNode.getNext();
        }
        //assigning the new tail as new tail and setting the next to tail as null (last element)
        //toString called, since its null, it won't add and the last element is removed
        tail = previousToLast;
        tail.setNext(null);
        size--;
        return lastNode.getElement();
    }
    //Define method to realize the link-list as a stack with head as the top of the stack
    //method to push an element to the top of the stack
    public void pushAtHead(T element){
        addFirst(element);
    }
    public T popFromHead(){
        return removeFirst();
    }
    public void pushAtTail(T element){
        addLast(element);
    }
    public T popFromTail(){
        return removeLast();
    }
    //method to realize the link-list as a queue with the tail as the rear of the queue
    public void enqueueAtTail(T rear){
        addLast(rear);
    }
    //method to realize the link-list as a queue with the head as the front of the queue
    public T dequeueAtHead(){   //remove element from the tail(back) and increment to front(head)
        return removeFirst();
    }
    //method to search an element in the stack from the head-side of the link-list and return an integer value based on the position of the element
    public int searchStack (T element){
        Node<T> current = head;         //current node is the head
        for(int i=0;i<getSize();i++){   //looping through all the element in stack
            if(element== current.getElement()) {    //comparing the current head
                return i+1;   //return the index at where the value is found
            }
            current = current.getNext();            //allowing the node to compare the next value
        }
                return -1;  //return -1 if value is not found
    }

}
