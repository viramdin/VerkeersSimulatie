package sr.unasat.verkeer.simulatie.datastructures;

import sr.unasat.verkeer.simulatie.entities.Voertuig;

public class Queue {
    private Node front, rear;
    private int currentSize; // number of items

    //class to define linked node
    private class Node {
        Voertuig voertuig;
        Node next;
    }

    //Zero argument constructor
    public Queue() {
        front = null;
        rear = null;
        currentSize = 0;
    }

    //Remove item from the beginning of the list.
    public Voertuig dequeue() {
        Voertuig voertuig = front.voertuig;
        front = front.next;
        if (isEmpty()) {
            rear = null;
        }
        currentSize--;
        return voertuig;
    }

    //Add data to the end of the list.
    public void enqueue(Voertuig voertuig) {
        Node oldRear = rear;
        rear = new Node();
        rear.voertuig = voertuig;
        rear.next = null;
        if (isEmpty()) {
            front = rear;
        } else {
            oldRear.next = rear;
        }
        currentSize++;
    }

    public int getnItems() {
        return currentSize;
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }
//    private Voertuig[] queArray;
//    private int nItems;
//    private int front;
//    private int rear;
//    private int size;
//
//    public Queue(int nItems) {
//        this.nItems = nItems;
//        front = this.size = 0;
//        rear = nItems - 1;
//        queArray = new Voertuig[this.nItems];
//    }
//
//    // Queue is full when size becomes
//    // equal to the nItems
//    public boolean isFull(Queue queue) {
//        return (queue.size == queue.nItems);
//    }
//
//    // Queue is empty when size is 0
//    public boolean isEmpty(Queue queue) {
//        return (queue.size == 0);
//    }
//
//    // Method to add an item to the queue.
//    // It changes rear and size
//    public void enqueue(Voertuig voertuig) {
//        if (isFull(this))
//            return;
//        this.rear = (this.rear + 1)
//                % this.nItems;
//        this.queArray[this.rear] = voertuig;
//        this.size = this.size + 1;
////        System.out.println(voertuig
////                + " enqueued to queue");
//    }
//
//    // Method to remove an item from queue.
//    // It changes front and size
//    public Voertuig dequeue() {
//        if (isEmpty(this))
//            return null;
//
//        Voertuig voertuig = this.queArray[this.front];
//        this.front = (this.front + 1)
//                % this.nItems;
//        this.size = this.size - 1;
//        return voertuig;
//    }
//
//    // Method to get front of queue
//    public Voertuig front() {
//        if (isEmpty(this))
//            return null;
//
//        return this.queArray[this.front];
//    }
//
//    // Method to get rear of queue
//    public Voertuig rear() {
//        if (isEmpty(this))
//            return null;
//
//        return this.queArray[this.rear];
//    }
//
//    public int getnItems() {
//        return nItems;
//    }
}
