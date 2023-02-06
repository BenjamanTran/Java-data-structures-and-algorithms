import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static Scanner sc=new Scanner(System.in);
    public static void showMenu() {
       

        System.out.println("Choose one of this options:");
   
        System.out.println("Person Tree:");
   
        System.out.println("1. Insert a new Person.");
   
        System.out.println("2. Inorder traversal");
   
        System.out.println("3. Breadth-First Traversal");
   
        System.out.println("4. Search by Person ID");
   
        System.out.println("5. Delete by Person ID");
   
        System.out.println("6. Balancing Binary Search Tree ");
   
        System.out.println("7. DFS_Graph");
   
        System.out.println("8. Dijkstra");
   
        System.out.println("Exit:");
   
        System.out.println("0. Exit");
   
      }
      public static void main(String[] args) throws IOException {
        List<Student> st=new ArrayList();
        st.add(new Student(1,"a"));
        st.add(new Student(2,"b"));
        st.add(new Student(3,"c"));
        
        //             1          Ha 12/09/90             Ha noi

// 4          Lan 04/04/87           Ha noi

// 2          An                 Nam Dinh

// 5          Tuan 02/02/89             TB         

// 3          Binh 01/05/92             TH         
          MyBSTree myBSTree=new MyBSTree();
          Person1 a1=new Person1("1", "ha","12/09/90", 
          "ha noi");
          Person1 a2=new Person1("4", "lan","04/04/87", 
          "ha noi");
          Person1 a3=new Person1("2", "an","12/09/90", 
          " Nam Dinh");
          Person1 a4=new Person1("5", "tuan","02/02/89", 
          "TB  ");
          Person1 a5=new Person1("3", "binh","01/05/92", 
          "TH ");
          myBSTree.insert(a1);
          myBSTree.insert(a2);
          myBSTree.insert(a3);
          myBSTree.insert(a4);
          myBSTree.insert(a5);

          
          while(true){
              showMenu();
            int choice=sc.nextInt();
            if(choice==0){
                System.out.println("Good bye");
                break;
            }

            switch(choice){
                case 1:
               
                Person1 p1=Input();
                myBSTree.insert(p1);
              //  myBSTree.insertIntoBSTree(myBSTree.root, p1);
                break;
                
                case 2:
                myBSTree.InOrder(myBSTree.root);
                break;
                case 3:
                myBSTree.BFSTree();
                break;
                case 4:
                System.out.println(" Search for ID :");
                String id=sc.next();
                Node node=myBSTree.searchInBSTrê(myBSTree.root, id);
                System.out.println(node.info.toString());
                break;
                case 5:
                System.out.println(" Delete for ID: ");
                String ID=sc.next();
                myBSTree.root=myBSTree.deleteNode(myBSTree.root, ID);
                break;
                case 6:
                myBSTree.root=myBSTree.buildTree(myBSTree.root);
                myBSTree.InOrder(myBSTree.root);
                break;
                case 7:
                int[][] b=InputMatrix("Matran.txt", 7);
                Graph g=new Graph();
                g.setData(b);
                g.DFS(0);

                System.out.println();
                break;
                case 8:
                int[][] c=InputMatrix("Matran.txt", 7);
                displayMatrix(c);
                Dijkstra(c);
                break;
               
               
            }
          }
      }
    private static Person1 Input() {
        System.out.println("Input new ID: ");
        String id=sc.next();
        System.out.println("Input Name:");
        String name=sc.next();
        System.out.println("Input birthplace:");
        String birthPlace=sc.next();
        System.out.println(" input Birth of Date:");
        String birth=sc.next();

       return new Person1(id, name, birthPlace, birth);
    }
    private static int[][] InputMatrix(String fileName,int n) throws IOException{
      int[][] a=new int[n][n];
      try {
        int temp=0;
        
        FileReader fr=new FileReader(fileName);
        BufferedReader br=new BufferedReader(fr);
        String line="";
        while (true) {
          line=br.readLine();
          if (line==null) {
            break;
          }
          String[] kq=line.split("\\s+");

          for(int i=0;i<n;i++){
            
            int numb=Integer.parseInt(kq[i].trim());
            a[temp][i]=numb;
            
          }
          temp++;

        }
        br.close();
      } catch (Exception e) {
       
      }
      return a;
    }
   
    public static void displayMatrix(int [][] a){
      int n=a.length;
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          String kq=""+a[i][j];
          if(kq.equals("9999")){
            kq="INF";
          }
          System.out.print(kq+"    ");
        }
        System.out.println();
      }
    }
    public static void Dijkstra(int [][] a){
      String kytu="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      //thêm dữ liệu của các đỉnh có trong matran.txt
      Vert[] allVerts=new Vert[a.length];
      for(int i=0;i<a.length;i++){
        allVerts[i]=new Vert(kytu.charAt(i)+"");
      }
      
      for (int i = 0; i < a.length; i++) {  
        Vert vert=allVerts[i];
        for(int j=0;j<a.length;j++){
          Vert vert1=allVerts[j];
           if(a[j][i]!=0 && a[j][i]!=9999){//nếu 2 đỉnh liền kề thì thêm cung
          vert1.addNeighbour(new Edge(a[j][i], vert1, vert));
          }
        }
        

      }
      PathFinder shortestPath = new PathFinder();
      shortestPath.ShortestP(allVerts[0]);//tìm đường đi ngắn nhất từ A đến tất
      //cả các đỉnh còn lại
      System.out.println("A --> E: " + shortestPath.getShortestP(allVerts[4]));
      System.out.println("A --> E: " + allVerts[4].getDist());//lấy trọng số
    }
}