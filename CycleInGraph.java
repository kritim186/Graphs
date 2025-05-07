import java.util.ArrayList;

public class CycleInGraph {

    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    private static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

}

    private static boolean hasCycle(ArrayList<Edge>[] graph){
        boolean[] visi = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!visi[i]){
                if(hasCycleUtil(graph, i, -1, visi)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasCycleUtil(ArrayList<Edge>[] graph, int curr, int parent, boolean[] visi){
        visi[curr] = true;

        //call for neighbours
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            //when neightbour is not visited
            if(!visi[e.dest]){
                if(hasCycleUtil(graph, e.dest, curr, visi)){
                    return true;
                }
            }

            // if neightbour is visited and not the parent
            else if(visi[e.dest] && e.dest != parent){
                return true;
            }

        }
        return false;
    }
   public static void main(String[] args) {
        
    ArrayList<Edge>[] graph = new ArrayList[5];
    createGraph(graph);
    boolean ans = hasCycle(graph);
    System.out.println(ans);

    }

    
}
