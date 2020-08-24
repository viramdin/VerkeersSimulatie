package sr.unasat.verkeer.simulatie.datastructures;

import sr.unasat.verkeer.simulatie.entities.Voertuig;

public class Stack {
    private class Node {
        Voertuig voertuig;
        Node next;

        public Node(Voertuig voertuig) {
            this.voertuig = voertuig;
        }
    }

    private int size;
    private Node head;

    public Stack() {
        size = 0;
        head = null;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Voertuig voertuig) {
        Node newNode = new Node(voertuig);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public Voertuig pop() {
        if (head == null) return null;

        Node n = head;
        head = head.next;
        size--;

        return n.voertuig;
    }

    public Voertuig peek() {
        if (head == null) return null;

        return head.voertuig;
    }
//    private int maxSize; // size of stack array
//    private Voertuig[] stackArray;
//    private int top; // top of stack
//
//    public Stack(int size) // constructor
//    {
//        maxSize = size; // set array size
//        stackArray = new Voertuig[maxSize]; // create array
//        top = -1; // no items yet
//    }
//
//    public void push(Voertuig voertuig) // put item on top of stack
//    {
//        stackArray[++top] = voertuig; // increment top, insert item
//    }
//
//    public Voertuig pop() // take item from top of stack
//    {
//        return stackArray[top--]; // access item, decrement top
//    }
//
//    public Voertuig peek() // peek at top of stack
//    {
//        return stackArray[top];
//    }
//
//    public boolean isEmpty() // true if stack is empty
//    {
//        return (top == -1);
//    }
//
//    public boolean isFull() // true if stack is full
//    {
//        return (top == maxSize - 1);
//    }
}
