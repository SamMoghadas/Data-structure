class FullStackException extends RuntimeException {

}

class EmptyStackException extends RuntimeException {

}

public class Stack {

    private int capacity ;
    private int top = 0 ;
    private int [] s ;
    private static final int CAPACITY = 100 ;

    public Stack (int capacity ) {
        this.capacity = capacity ;
        top = -1 ;
        s = new int [capacity] ;
    }

    public Stack () {
        this(CAPACITY) ;
    }

    public boolean isEmpty () {
        return top < 0 ;
    }

    public void push (int element) throws FullStackException {
        if (capacity -1 == top) {
            throw new FullStackException() ;
        } else {
            s [++top] = element ;
        }
    }


    public int pop () throws EmptyStackException {
        if (isEmpty() ) {
            throw new EmptyStackException() ;
        } else {
            int element = s [top --] ;
            return element;
        }
    }

    public int getTop () throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException() ;
        } else {
            return s [top] ;
        }
    }

    @Override
    public String toString () throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            StringBuilder sb = new StringBuilder() ;
            for (int i = 0 ; i <= top ; i ++) {
                sb.append(s[i]).append("") ;
            }
            return sb.toString() ;
        }
    }

    public static void main (String [] args) {
        Stack stack = new Stack (6) ;

        stack.push(1);
        stack.push(2) ;
        stack.push (3);
        stack.push(4);
        System.out.println(stack.getTop());

        stack.pop() ;
        stack.pop() ;

        System.out.println(stack);
    }
}