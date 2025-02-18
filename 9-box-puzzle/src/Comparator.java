public class Comparator implements java.util.Comparator<Node> {
    public int compare(Node a, Node b) {
        if (a.score1 > b.score1) {
            return 1;
        } else {
            return a.score1 == b.score1 ? a.name.compareTo(b.name) : -1;
        }
    }
}
