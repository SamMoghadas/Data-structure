class QueueFullException extends RuntimeException {

}

class QueueEmptyException extends RuntimeException {

}

public class Queue {
    private int f ;  // front
    private int r ;  // rear
    private int N ;  // capacity
    private int [ ] q ;  // array for elements
    private static final int CAPACITY = 100 ;

    public Queue (int capacity) {
        this.N = capacity ;
        this.f = this.r = -1 ;
        q = new int[N] ;
    }

    public Queue () {
        this(CAPACITY) ;
    }

    public boolean isEmpty () {
        return f == -1 ;
    }

    public void enqueue (int element) throws QueueFullException {
        if ((r + 1) % N == f) {
            throw new QueueFullException() ;
        }  else if (isEmpty()) {
            f = r = 0 ;
        } else {
            r  =( r +1 ) % N ;
        }
        q  [r] = element ;
    }


    public int dequeue () throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException() ;
        }  else {
            int element = q [f] ;
            if (f == r ) {
                f = r = -1 ;
            } else {
                f = (f + 1 ) % N ;
            }
            return element ;
        }
    }


    public int front () throws QueueEmptyException {          // working like getTop
        if (isEmpty()) {
            throw new QueueEmptyException() ;
        } else {
            return  q [f] ;   // returning the front element
        }
    }


    public void display () {
        if (isEmpty()) {
            System.out.println("Queue is empty ");
        } else {
            for (int elements : q) {
                System.out.println(elements);
            }
        }
    }


    public static void main (String [] args) {
        Queue queue = new Queue() ;
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println( queue.front());

    }
}