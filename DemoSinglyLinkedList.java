package LA1Q1;
import java.util.*;

public class DemoSinglyLinkedList {
    public static void main (String args[]){

        myHeader(1);

        //ArrayList type Integer
        ArrayList<Integer> intArray = new ArrayList<>(Arrays.asList(56,-22,34,57,98));
        //ArrayList type String
        ArrayList<String> stringArray = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));

        //Printing these two array lists on the screen
        System.out.println("The given Integer array: " + intArray);
        System.out.println("The given String array: " + stringArray);

        //Declaring linked list of Integers to populate the two arrays above
        SinglyLinkedList<Integer> singlyLinkedListInt = new SinglyLinkedList<>();
        SinglyLinkedList<String> singlyLinkedListString = new SinglyLinkedList<>();

        //Populating the Integer and String ArrayList in a given format
        for(int i=0;i< intArray.size();i++){
            if(i<3){
                //Setting 34, -22, 56
                singlyLinkedListInt.addFirst(intArray.get(i));
                singlyLinkedListString.addFirst(stringArray.get(i));
            } else {
                //Setting 98, 57
                singlyLinkedListInt.addLast(intArray.get(intArray.size()-(i-2)));
                singlyLinkedListString.addLast(stringArray.get(stringArray.size()-(i-2)));
            }
        }

        System.out.println("Your Integer List: " + singlyLinkedListInt);
        System.out.println("Your Integer String: " + singlyLinkedListString);

        System.out.println("\nStack demo with the Integer linked list ...");
        //calling the stackDemo() method with Integer Linked List parameter
        stackDemo(singlyLinkedListInt);

        System.out.println("\nQueue demo with the String linked list ...");
        //calling the queueDemo() method with String Linked List parameter
        queueDemo(singlyLinkedListString);

        System.out.println("\nLets search the Stack ...");
        System.out.println("\nThe current stack: " + singlyLinkedListInt.toString());

        //reference variable
        char terminate = 'y';
        int value;
        //terminate the code if the user input is not y, if y continue
        while(true){
            System.out.print("\nEnter the value you are searching for: ");
            value = scan.nextInt();
            if (singlyLinkedListInt.searchStack(value) == -1){
                System.out.println("The value is not found!");
            } else {
                System.out.printf("The value %d is found in location %d from the top of the stack", value, singlyLinkedListInt.searchStack(value));
            }
            System.out.println("\nDo you want to continue? (enter 'y' for yes or enter any other key to discontinue):");
            terminate = scan.next().charAt(0);
            if(terminate != 'y'){
                break;
            }
        }
        myFooter(1);
    }
    //This is myHeader method containing my name and student number
    public static void myHeader(int assignnmentNum){
        System.out.println("=====================================================");
        System.out.printf("Lab Assignment %d-Q1 \n", assignnmentNum);
        System.out.println("Prepared By: Dasol Lim");
        System.out.println("Student Number: 251224110");
        System.out.println("Goal of this Exercise: ....................");
        System.out.println("=====================================================");
    }
    //This is myFooter containing a good-bye message
    public static void myFooter(int assignnmentNum) {
        System.out.println("=====================================================");
        System.out.printf("Completion of Lab Assignment %d-Q1 is successful! \n", assignnmentNum);
        System.out.println("Signing off - Dasol Lim");
        System.out.println("=====================================================");
    }

    public static Scanner scan = new Scanner(System.in);

    //accept a SinglyLinkedList type parameter and demonstrate the queue operation
    //pass the object into the method
    public static void stackDemo(SinglyLinkedList<Integer> intList){

        int endType = 0;
        System.out.println("Which end of the Linked List you would like to use as the stack top?");
        System.out.print("Enter 1 for head or 2 for tail: ");
        while (true){
            try {
                //converting String value inputs as int
                endType = scan.nextInt();
                //checking integer value inputs
                    if (endType != 1 && endType != 2){
                        System.out.print("Try again, input 1 or 2: ");
                    }break;
        } catch (Exception ex){
                System.out.print("Try again, input 1 or 2: ");
                //setting year as 0 since input is invalid
                endType = 0;
                scan.nextLine();
            }
            //breaking the while loop if Scanner input is 2, 3, or 4
            if (endType == 1 || endType == 2) {
                break;
            }
            }

        //pop all the elements of the linked list one at a time and display stack
        if(endType==1){
            //output statement
            System.out.println("\nStack Top: Head of he linked list");
            System.out.println("\nLets pop all the elements from the stack in sequence");
            //displaying the current stack
            System.out.println("The current stack: " + intList.toString() + "\n");
            for(int i =0; i<5;i++){
                //popping al the element of the linked list one at a time using for loop and displaying the stack
                System.out.println(intList.popFromHead() + " has been popped! The Revised stack: " + intList.toString());
            }
            System.out.println("\nLets push 39 and -58 in the stack ...");
            System.out.println("The current stack: " + intList.toString());
            intList.pushAtHead(39);
            System.out.println("After 39 is pushed, the revised stack: " + intList.toString());
            intList.pushAtHead(-58);
            System.out.println("After -58 is pushed, the revised stack: " + intList.toString());
        } else if (endType == 2) {    //if endType == 2
            //output statement
            System.out.println("\nStack Top: Top of he linked list");
            System.out.println("\nLet's pop first three elements from the stack in sequence:");
            //displaying the current stack
            System.out.println("The current stack: " + intList.toString() + "\n");
            for(int i =0; i<3;i++){
                //popping three elements from the link list
                System.out.println(intList.popFromTail() + "has been popped! The Revised stack: " + intList.toString());
            }
            //pushing two more elements in the current stack, 39 and -58
            System.out.println("\nLets push 39 and -58 in the stack ...");
            System.out.println("The current stack: " + intList.toString());
            //pushing 39 into the current stack
            intList.pushAtTail(39);
            System.out.println("After 39 is pushed, the revised stack: " + intList.toString());
            //pushing -58 into the current stack
            intList.pushAtTail(-58);
            System.out.println("After -58 is pushed, the revised stack: " + intList.toString());
        }
    }
    //accept SinglyLinkList type parameter and demonstrate the queue operation
    public static void queueDemo(SinglyLinkedList<String> stringList){
        System.out.println("Note: Head is the Q-front , and Tail is the Q-rear");
        System.out.println("\nLet's enqueue Joelle and Lukas int he queue in sequence ....");
        System.out.println("\nThe current Queue: " + stringList.toString());
        //enqueuing Joelle
        stringList.enqueueAtTail("Joelle");
        System.out.println("\nAfter Joelle is enqueued, the revisedQueue: " + stringList.toString());
        //enqueuing Lukas
        stringList.enqueueAtTail("Lukas");
        System.out.println("After Lukas is enqueued, the revisedQueue: " + stringList.toString());

        //dequeue operation
//        for(int i=0; i<stringList.getSize(); i++){
//            System.out.println("Let's empty the queue: ");
//            stringList.dequeueAtHead();
//            System.out.println("The current Queue: " + stringList);
//        }

        System.out.println("\nLet's dequeue first three elements from the queue in sequence ...");
        System.out.println("The current Queue: " + stringList.toString());
        //dequeue the current head of SinglyLinkList
        stringList.dequeueAtHead();
        System.out.println("\nIsra has been dequeued!The revised queue: " + stringList);
        //dequeue the current head of SinglyLinkList
        stringList.dequeueAtHead();
        System.out.println("Will has been dequeued!The revised queue: " + stringList);
        //dequeue the current head of SinglyLinkList
        stringList.dequeueAtHead();
        System.out.println("Griffin has been dequeued!The revised queue: " + stringList);
    }
    //constructor, optional
    public DemoSinglyLinkedList(){
    }
}
