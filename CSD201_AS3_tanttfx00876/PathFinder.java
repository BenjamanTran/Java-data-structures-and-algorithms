import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PathFinder {
    
    public void ShortestP(Vert sourceV) {
        sourceV.setDist(0);//xét trọng số ban đầu =0
        PriorityQueue<Vert> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceV);//trong mỗi đỉnh đều có thuộc tính visited
        sourceV.setVisited(true);
        //lấy tất cả các đỉnh liền kề thêm vào queue
        while (!priorityQueue.isEmpty()) {
            Vert actualVertex = priorityQueue.poll();
            for (Edge edge : actualVertex.getList()) {
                Vert v = edge.getTargetVert();
                if (!v.Visited()) {
                    //xem đã đến đỉnh đó và xét trọng số xem phải trọng số
                    //nhỏ nhất không nếu không thì remove và xem xét những đỉnh khác

                    double newDistance = actualVertex.getDist()
+ edge.getWeight();
                    
                    if (newDistance < v.getDist()) {
                        //nếu trọng số mới nhỏ hơn trọng số mặc định của đỉnh thì
                        //remove và thiết lập lại trọng số của vị trí đó là new
                        priorityQueue.remove(v);
                        v.setDist(newDistance);
                        v.setPr(actualVertex);
                        priorityQueue.add(v);
                       

                    }
                       
                  
                }
             
            }
            
            actualVertex.setVisited(true);
            
        }
        
    }

    public List<Vert> getShortestP(Vert targetVertex) {
        List<Vert> path = new ArrayList<>();
        for (Vert vertex = targetVertex; vertex != null; vertex = vertex.getPr()) {
            path.add(vertex);
        }
        //đảo ngược list của path
        Collections.reverse(path);
        return path;
    }

}