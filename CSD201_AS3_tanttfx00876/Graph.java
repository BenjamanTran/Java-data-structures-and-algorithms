import java.util.LinkedList;

public class Graph {
    int[][] a;
 int n;
 int temp;
 Graph(){
   
 }
 void clear(){
     a=null;
     n=0;
     temp=0;
 }
 void setData(int[][] b){
     n=b.length;
     a=new int[n][n];
     int i,j;
     for(i=0;i<n;i++){
         for(j=0;j<n;j++){
             a[i][j]=b[i][j];
         }
     }
 }
 void dispAdj()
   {int i,j;
    System.out.println("\nThe adjacency matrix:"); 
    for(i=0;i<n;i++)
     {System.out.println();
      for(j=0;j<n;j++)
      { System.out.printf("%5d",a[i][j]);}
     }
   }
   void visit(int i) {System.out.print(i+" ");}
   void DFSUtil(int v, boolean visited[])
   {
       
       visited[v] = true;
       switch(v){
        case 0:
        System.out.print("A"+" ");
        break;
        case 1:
        System.out.print("B"+" ");
        break;
        case 2:
        System.out.print("C"+" ");
        break;
        case 3:
        System.out.print("D"+" ");
        break;
        case 4:
        System.out.print("E"+" ");
        break;
        case 5:
        System.out.print("F"+" ");
        break;
        case 6:
        System.out.print("G"+" ");
        break;
    }
       for(int i=0;i<a.length;i++){
        int n=a[v][i];
        if(!visited[i] && n!=0 && n!=9999){
            DFSUtil(i, visited);
        }
    }
   }

  
   void DFS(int v)
   {
    System.out.println("DFS_Graph: ");

       boolean visited[] = new boolean[n];

      
       DFSUtil(v, visited);
   }
   void breadth(int k){
       LinkedList<Integer> q=new LinkedList<>();
       boolean[] visited= new boolean[n];

       visited[k]=true;
       q.add(k);

       while (q.isEmpty()==false) {
           k=q.poll();
           
           switch(k){
               case 0:
               System.out.print("A"+" ");
               break;
               case 1:
               System.out.print("B"+" ");
               break;
               case 2:
               System.out.print("C"+" ");
               break;
               case 3:
               System.out.print("D"+" ");
               break;
               case 4:
               System.out.print("E"+" ");
               break;
               case 5:
               System.out.print("F"+" ");
               break;
               case 6:
               System.out.print("G"+" ");
               break;
           }
        //   System.out.print(k+" ");
           for(int i=0;i<a.length;i++){
               int n=a[i][k];
               if(!visited[i] && n!=0){
                   visited[i]=true;
                   q.add(i);
               }
           }
       }
       for(int i=0;i<visited.length;i++){
           if(visited[i]==true){
                temp++;
           }
       }
   }
   void isConnected()
   {
       
    if(temp==a.length){
        System.out.println("G is connected");
    }
    else{
        System.out.println("G is not connected");
    }
   }
   int degree(int k)
   {
       int dem=0;
       for(int i=0;i<a.length;i++){
           if(a[i][k]==1){
            dem++;
           }
       }
       return dem;
   }
    
}
