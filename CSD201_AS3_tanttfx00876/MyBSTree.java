
import java.util.Vector;



public class MyBSTree {
    public Node root;

    
    public MyBSTree() {
    }
    public void searchByQueue(String id,Node node){
     
    }
    public Node searchInBSTrê(Node root,String info){
        if(root==null){

            return null;
        }
        if(info.compareTo(root.info.id)<0){
            return searchInBSTrê(root.left, info);
        }
        else if(info.compareTo(root.info.id)>0){
            return searchInBSTrê(root.right, info);
        }
        else{
            return root;
        }
    }
    void insert(Person1 key) { root = insertIntoBSTree(root, key); }
    public Node insertIntoBSTree(Node rootNode,Person1 info){

        if(rootNode==null){
            return new Node(info);
        }
        if(searchInBSTrê(rootNode, info.id)!=null){
            return rootNode;
        }
        if(info.id.compareTo(rootNode.info.id)<0){
           
           
            rootNode.left = insertIntoBSTree(rootNode.left, info);
        }
        else if(info.id.compareTo(rootNode.info.id)>0){
    
        rootNode.right = insertIntoBSTree(rootNode.right, info);
         }

        return rootNode;
    }
    //tim node trai cung
    public Node findLeftNode(Node root){
        if(root==null){
            return null;
        }
        Node leftNode=root.left;
        while(leftNode.left!=null){
            leftNode=leftNode.left;
        }

        return leftNode;
    }
    public Node deleteNode(Node root,String key){
        if(root==null){
            return null;
        }
        if(key.compareTo(root.info.id)<0){
            root.left= deleteNode(root.left, key);
        }
        else if(key.compareTo(root.info.id)>0){
            
            root.right =deleteNode(root.right, key);
        }
        //root== key xac dinh duoc not can xoa
        //xoa not root
        else{
            //TH1:root la la:
            if(root.left==null && root.right==null){
                return null;
            }
            //th2 chi co 1 con ben trai
            else if(root.left!=null && root.right==null){
                return root.left;
            }
            else if(root.left==null && root.right!=null){
                return root.right;
            }
            //th3 ton tai 2 con trai va phai
            //tim node con trai cung cua cay con ben Phai
            Node leftNode=findLeftNode(root.right);
            root.info=leftNode.info;
           root.right= deleteNode(root.right, leftNode.info.id);

        }
        return root;
    }
    public void InOrder(Node currentNode){
        if(currentNode==null){
         //   System.out.println("danh sach rong");
            return;
        }

        InOrder(currentNode.left);
        System.out.println(currentNode.info.toString());
        InOrder(currentNode.right);
    }
    public int count(Node node) {
        int temp=0;
        if(node ==null){
            return 0;
        }
        count(node.left);
        count(node);
        count(node.right);
        return temp;
    }
    public void BFSTree(){
        MyQueue q=new MyQueue();
       // int countNode=count(node);
       // boolean[] visited=new boolean[countNode];
        // if (root==null) {
        //     return ;
        // }
        q.enQueue(root);
        while (!q.isEmpty()) {
            Node current=q.deQueue();
            System.out.println(current.info.toString());
            if (current.left!=null) {
                q.enQueue(current.left);
            }
            if(current.right!=null) {
                q.enQueue(current.right);
            }
        }
    }
    void storeBSTNodes(Node rootNode, Vector<Node> nodes)
    {
        
        if (rootNode == null)
            return;
 
       //thêm node vào trong vector theo thứ tự inorder
        storeBSTNodes(rootNode.left, nodes);
        nodes.add(rootNode);
        storeBSTNodes(rootNode.right, nodes);
    }
  
     Node buildTreeUtil(Vector<Node> nodes, int start,
            int end)
    {
       
        if (start > end)
            return null;
 
        //bởi vì inorder nên phần tử giữa mảng sẽ 
        //là node root
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);
 
        //dùng đệ quy để build lại toàn bộ node con của mid từ 
        //start đến trước mid
        //tương tự với node bên phải
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);
 
        return node;
    }
    Node buildTree(Node rootNode)
    {
        
        Vector<Node> nodes = new Vector<Node>();
        storeBSTNodes(rootNode, nodes);
 
        //cân bằng cây theo mảng vector
        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
    }
   public int LuyThua(int a,int n){
    if(n==0){
        return 1;

    }
    else {
        return LuyThua(a, n-1)*a;
    }
   }
    
}


