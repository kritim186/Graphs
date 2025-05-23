import java.lang.reflect.Array;
import java.util.*;
public class ConnectedComponents {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    private static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));


        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    private static void bfs(ArrayList<Edge>[] graph){
        boolean[] visi = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
                if(!visi[i])
                     bfsUtil(graph, visi);
            
        }
    }

    private static void bfsUtil(ArrayList<Edge>[] graph, boolean[] visi){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visi[curr]){
                System.out.print(curr+" ");
                visi[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    private static void dfs(ArrayList<Edge>[] graph){
        boolean[] visi = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!visi[i])        
                dfsUtil(graph, i, visi);         
        }

    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visi){
        System.out.print(curr+" ");
        visi[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visi[e.dest]){
                dfsUtil(graph, e.dest, visi);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        bfs(graph);
        System.out.println();
        dfs(graph);
    }
}
