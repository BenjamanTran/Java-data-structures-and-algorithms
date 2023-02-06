import java.util.LinkedList;

public class MyQueue {
    LinkedList<Node> t;
    MyQueue(){
        t=new LinkedList<>();
    }
    Boolean isEmpty(){
        return t.isEmpty();
    }
    void enQueue(Node x){
        t.add(x);
    }
    Node deQueue(){
        return t.poll();
    }
    int size(){
        return t.size();
    }
    void search(String id){
        for (int i = 0; i < size(); i++) {
            if(id.equalsIgnoreCase(t.get(i).info.id)){
                System.out.println(t.get(i).info.toString());
                break;
            }
        }
    }
}
