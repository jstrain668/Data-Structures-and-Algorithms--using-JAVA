package homework.queues;


public class QueueUsingLinkedList {
    Node front;
    Node rear;
    int size;

    class Node{
        String value;
        Node next;

        Node(String value){
            this.value = value;
            this.next = null;
        }
    }

    public QueueUsingLinkedList(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    // Inserts are at the rear of the queue
    public void enqueue(String value){

        Node newNode = new Node(value);

        if (isEmpty()){
            this.front = newNode;
            this.rear = newNode;
        } else {
            //Old rear points to new node
            this.rear.next = newNode;
            //Rear becomes new node
            this.rear = newNode;
        }

        this.size++;
    }

    // Removals are at the front of the queue
    public void dequeue(){

        if (isEmpty()){
            System.out.println("Cannot remove from an empty queue");
        } else{
            //Front points to the next node to remove front node from queue
            this.front = this.front.next;

            //If queue size is 1 then removal results in empty queue
            if (this.size == 1){
                rear = null;
            }
            this.size--;
        }
    }

    public String peek(){

        if (isEmpty()){
            System.out.println("Can't peek against an empty list");
            return null;
        } else {
            // Return value of first node in the queue
            return this.front.value;
        }
    }

    public static void main(String[] args) {
        QueueUsingLinkedList myQueue = new QueueUsingLinkedList();
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.peek());
        myQueue.enqueue("Apple");
        myQueue.enqueue("Ball");
        myQueue.enqueue("Cat");
        myQueue.dequeue();
        System.out.println(myQueue.peek());
    }
}
