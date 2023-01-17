package LA1Q1;

//generic class
//node is an entity that stores elements
//entity is typically represented as a table in a relational to database
public class Node <T>{
    //two private fields with Node<T> type
    private T element;  //reference variable of elements stored in the Node (each item)
    private Node<T> next;   //reference to the subsequent node in the list (the Node we will be using to store elements)

    //constructor without parameter
    public Node(){}
    //constructor with parameter
    public Node(T element, Node<T> next){
        this.element = element;
        this.next =  next;
        }
    //setter method for generic type T element
//    public void setElement(T element){
//        this.element = element;
//    }
    //setter method for generic type T next
    public void setNext(Node<T> next){
        this.next = next;
    }

    //since node has two attributes: data(getElement) and next(getNext)
    //getter method for generic type T element
    public T getElement(){
        return element;
    }
    //getter method for generic type T next and pointer to the next node
    public Node<T> getNext(){
        return next;
    }
}
