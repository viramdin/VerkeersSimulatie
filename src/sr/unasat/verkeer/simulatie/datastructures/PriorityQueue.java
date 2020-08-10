package sr.unasat.verkeer.simulatie.datastructures;

import sr.unasat.verkeer.simulatie.entities.Voertuig;

public class PriorityQueue {
    private int maxSize;
    private Voertuig[] queArray;
    private int nItems;
    private int front;
    private int rear;

    public PriorityQueue(int maxSize) // constructor
    {
        this.maxSize = maxSize;
        queArray = new Voertuig[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(Voertuig voertuig) // put item at rear of queue
    {
        int currentItemIndex;
        if (nItems == 0) // if no items,
            queArray[nItems++] = voertuig; // insert at 0
        else // if items,
        {
            for (currentItemIndex = nItems - 1; currentItemIndex >= 0; currentItemIndex--) // start at end,
            {
                if (voertuig.getPriority() < queArray[currentItemIndex].getPriority()) // if new item larger,
                    queArray[currentItemIndex + 1] = queArray[currentItemIndex]; // shift upward
                else // if smaller,
                    break; // done shifting
            } // end for
            queArray[currentItemIndex + 1] = voertuig; // insert it
            nItems++;
        } // end else (nItems > 0)
    } // end insert()

    public Voertuig remove() // take item from front of queue
    {
        Voertuig temp = queArray[front];//3 // get value and incr front
        queArray[front] = null;//3 removed
        if (front + 1 == maxSize) { // deal with wraparound
            front = 0;
        } else {
            front++;
        }
        nItems--;// one less item
        return temp;
    }

    public Voertuig peekFront() // peek at front of queue
    {
        return queArray[front];
    }

    public boolean isEmpty() // true if queue is empty
    {
        return (nItems == 0);
    }

    public boolean isFull() // true if queue is full
    {
        return (nItems == maxSize);
    }

    public int size() // number of items in queue
    {
        return nItems;
    }
}
