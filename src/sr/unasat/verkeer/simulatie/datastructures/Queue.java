package sr.unasat.verkeer.simulatie.datastructures;

import sr.unasat.verkeer.simulatie.entities.Voertuig;

public class Queue {
    private Voertuig[] queArray;
    private int nItems;
    private int front;
    private int rear;
    private int size;

    public Queue(int nItems) {
        this.nItems = nItems;
        front = this.size = 0;
        rear = nItems - 1;
        queArray = new Voertuig[this.nItems];
    }

    // Queue is full when size becomes
    // equal to the nItems
    public boolean isFull(Queue queue) {
        return (queue.size == queue.nItems);
    }

    // Queue is empty when size is 0
    public boolean isEmpty(Queue queue) {
        return (queue.size == 0);
    }

    // Method to add an item to the queue.
    // It changes rear and size
    public void enqueue(Voertuig voertuig) {
        if (isFull(this))
            return;
        this.rear = (this.rear + 1)
                % this.nItems;
        this.queArray[this.rear] = voertuig;
        this.size = this.size + 1;
//        System.out.println(voertuig
//                + " enqueued to queue");
    }

    // Method to remove an item from queue.
    // It changes front and size
    public Voertuig dequeue() {
        if (isEmpty(this))
            return null;

        Voertuig voertuig = this.queArray[this.front];
        this.front = (this.front + 1)
                % this.nItems;
        this.size = this.size - 1;
        return voertuig;
    }

    // Method to get front of queue
    public Voertuig front() {
        if (isEmpty(this))
            return null;

        return this.queArray[this.front];
    }

    // Method to get rear of queue
    public Voertuig rear() {
        if (isEmpty(this))
            return null;

        return this.queArray[this.rear];
    }

    public int getnItems() {
        return nItems;
    }
}
