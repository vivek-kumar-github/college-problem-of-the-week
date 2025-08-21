public class deepCloneLinkedListWithRandom {

    // Node with next and random pointers
    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    // Simple singly linked list that supports random pointers
    static class LinkedList {
        Node head;

        // Add node at the end
        void addNode(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        // Set random pointer of a node
        void setRandom(Node node, Node randomNode) {
            if (node != null) {
                node.random = randomNode;
            }
        }

        // Print linked list with random pointers
        void printList() {
            Node temp = head;
            while (temp != null) {
                int randomVal = (temp.random != null) ? temp.random.val : -1;
                System.out.println(
                        "Node val: " + temp.val +
                                ", Next: " + ((temp.next != null) ? temp.next.val : "null") +
                                ", Random: " + randomVal
                );
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Add nodes
        list.addNode(7);
        list.addNode(13);
        list.addNode(11);
        list.addNode(10);
        list.addNode(1);

        // Get references to each node
        Node node1 = list.head;           // 7
        Node node2 = node1.next;          // 13
        Node node3 = node2.next;          // 11
        Node node4 = node3.next;          // 10
        Node node5 = node4.next;          // 1

        // Set random pointers as per example
        list.setRandom(node2, node1);  // Node2.random → Node1
        list.setRandom(node3, node5);  // Node3.random → Node5
        list.setRandom(node4, node3);  // Node4.random → Node3
        list.setRandom(node5, node1);  // Node5.random → Node1

        // Print list
        System.out.println("Original List");
        list.printList();

        deepCloneLinkedListWithRandom solve = new deepCloneLinkedListWithRandom();
        Node answerList = solve.copyRandomList(list.head);

        System.out.println("\nDeep copied new list");
        LinkedList clonedList = new LinkedList();
        clonedList.head = answerList;
        clonedList.printList();
    }

    // THE SOLUTION FUNCTION
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Create new list with same values
        Node curr = head;
        while (curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Copy the random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Seperate the two lists
        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;
        while (curr != null) {
            curr.next = newCurr.next;
            curr = curr.next;
            if (curr != null) {
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
        }
        return newHead;
    }
}
