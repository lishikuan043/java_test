package job;

public class Node {
    public int num;
    public Node next;

    public Node(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return Integer.toString(num);
    }
}
