
class List {
    Node head; // first Node of the list
    int size;  // size of the list

    public List() {
        this.head = null;  // first is null before add elements
        this.size = 0;     // size is 0 initially
    }

    public void add(int data) {
        Node newNode = new Node(data);
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

    public boolean remove(int data) {
        if (head == null) {
            return false;
        }

        if (head.data == data) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        Node previous = null;
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        previous.next = current.next;
        size--;
        return true;
    }

    public int deleteAll(int value, List resultList) {
        int count = 0;
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.data == value) {
                count++;
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    head = current.next;
                }
                size--;
            } else {
                resultList.add(current.data);
                previous = current;
            }
            current = current.next;
        }

        return count;
    }

    /*public int removeMin() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        Node minNode = head;
        Node current = head;
        Node previous = null;
        Node minPrev = null;

        while (current != null) {
            if (current.data < minNode.data) {
                minNode = current;
                minPrev = previous;
            }
            previous = current;
            current = current.next;
        }

        if (minPrev != null) {
            minPrev.next = minNode.next;
        } else {
            head = minNode.next;
        }

        size--;
        return minNode.data;
    }*/



    public int removeMin() {
        if (head == null) {
            return -1;
        }

        Node minNode = head;
        Node current = head;
        Node previous = null;
        Node minPrev = null;


        while (current != null) {
            if (current.data < minNode.data) {
                minNode = current;
                minPrev = previous;
            }
            previous = current;
            current = current.next;
        }

        // حذف گره با کمترین مقدار
        if (minPrev != null) {
            minPrev.next = minNode.next;
        } else {
            head = minNode.next;
        }

        size--;
        return minNode.data;
    }


    public boolean equals(List other) {
        Node current1 = this.head;
        Node current2 = other.head;

        while (current1 != null && current2 != null ) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return current2 == current1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.data).append(" -> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();
    }
}

class Main {
    public static void main(String[] args) {
        List testList1 = new List();
        testList1.add(1);
        testList1.add(2);
        testList1.add(3);
        testList1.add(2);
        testList1.add(4);
        testList1.add(2);

        List testList2 = new List();
        testList2.add(1);
        testList2.add(2);
        testList2.add(3);
        testList2.add(2);
        testList2.add(4);


        System.out.println("Lists Equal: " + testList1.equals(testList2));

        List resultList = new List();
        int deletedCount = testList1.deleteAll(2, resultList);

        System.out.println("Deleted Count: " + deletedCount);  // 3
        System.out.println("Resulting List: " + resultList);

        System.out.println("Min Element Removed: " + testList1.removeMin());
        System.out.println("Resulting List: " + resultList);
    }
}