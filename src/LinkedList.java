public class LinkedList {
    private int size;
    private Node head;

    public LinkedList() {
        this.size = 0;
        this.head = null;
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // حذف اولین نود لیست
    public void removeFirst() {
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        }
        head = head.next;
        size--;
    }

    // حذف آخرین نود لیست
    public void removeLast() {
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        }
        if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void reverse () {
        Node p , r ,q ;
        p = head ;
        q = null ;
        while (p != null) {
            r = q ;
            q = p ;
            p= p.next ;
            q.next = r ;
        }
        head = q ;
    }

    public int findMax () {
        if (head == null) {
            throw new IllegalArgumentException () ;
        }
        Node current = head.next ;
        int max = head.data ;
        while (current != null) {
            if (current.data > max) {
                max = current.data ;
            }
            current = current.next ;
        }
        return max ;
    }

    public int findMin () {
        if (head == null) {
            throw new IllegalArgumentException () ;
        }
        int min = head.data ;
        Node current = head.next ;
        while (current != null) {
            if (current.data < min) {
                min = current.data ;
            }
            current = current.next ;
        }
        return min ;
    }

    public void print () {
        Node current = head ;
        while (current != null) {
            System.out.println(current.data);
            current = current.next ;
        }
    }

    @Override
    public String toString () {
        String result = "{" ;
        Node current = head ;
        while (current != null) {
            result += current.data ;
            current = current.next ;
            if (current != null) {
                result += "," ;

            } else {
                result += "}" ;
            }
        }
        return result ;
    }

    public int countElements () {
        int count = 0 ;
        Node current = head ;
        while (current != null) {
            count ++ ;
            current= current.next ;
        }
        return count ;
    }


    public boolean contains (int  element) {
        Node current = head ;
        while (current != null) {
            if (current.data  == element) {
                return true ;
            }
            current = current.next ;
        }
        return false ;
    }



    public int getElement (int index ) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException() ;
        }
        Node current = head ;
        for (int i  = 0 ; i < index  ; i ++) {
            current = current.next  ;
        }
        return current.data ;
    }

    public void removeSP (int element) {
        if (head == null) {
            System.out.println("list is empty");
        }
        if (head.data == element ) {
            head = head.next ;
            size -- ;
        }
        Node current = head ;
        while (current.next != null && current.data != element) {
            current = current.next ;
        }

        if (current.next == null) {
            throw new IllegalArgumentException( ) ;
        }
        current.next = current.next.next ;
        size -- ;
    }

    public static void main (String [] args) {
        LinkedList list = new LinkedList() ;
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.print();
        System.out.println(list.toString());

        list.reverse();
        System.out.println(list.toString());

        System.out.println(list.countElements());
        System.out.println(list.contains(1));
    }

}
