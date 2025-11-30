package support;
import java.util.Random;
public class Node<E> {
    public static Random r = new Random(100);
    public E data;
    int priority = r.nextInt();
    Node<E> parent;
    Node<E> left;
    Node<E> right;

    public Node(E data){
        this.data = data;
    }
    public Node(E data, Node<E> parent){
        this.data = data;
        this.parent = parent;
    }
    public String toString(){
        return "data = "+ data + " priority = "+priority;
    }
}
