package job;

public class LinkReverse {
    public static Node reverse(Node nodehead) {
        Node prenode = null;
        Node nodenow = nodehead;
        Node nodeout = null;
        while (nodenow!=null) {
            Node nodenext = nodenow.next;
            if (nodenext == null) {
                nodeout = nodenow;
            }
            nodenow.next = prenode;
            prenode = nodenow;
            nodenow = nodenext;
        }
        return nodeout;
    }

    public static Node reverse1(Node nodehead) {
        Node prenode = null;
        Node nodenow = nodehead;
        Node nodeout = null;
        while (nodenow != null) {
            Node nodenext = nodenow.next;
            if (nodenext == null) {
                nodeout = nodenow;
            }
            nodenow.next = prenode;
            prenode = nodenow;
            nodenow = nodenext;
        }
        return nodeout;
    }

    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node = node0;
        System.out.print(node0+" ");
        for (int i = 1; i < 10; i++) {
            node.next = new Node(i);
            node = node.next;
            System.out.print(node+" ");
        }

        Node node1 = reverse1(node0);
        System.out.println();
        System.out.print(node1 + " ");
        while (node1.next!=null) {
            node1 = node1.next;
            System.out.print(node1 + " ");
        }

    }
}
