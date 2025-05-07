import java.util.*;
public class DfSinGraph {
    
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

    public static void createGraph(ArrayList<Edge>[] graph){
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

    //Tc = O(V+E)
    private static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited){
       
       //perform the operation for the curr
        System.out.print(curr+" ");
        visited[curr] = true;

        //call for the neighbour of curr;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!visited[e.dest]){ // if the neighbour is visited or not
                dfs(graph, e.dest, visited);
            }

        }
        

    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[7];
        boolean[] visited = new boolean[graph.length];
        createGraph(graph);
        dfs(graph, 0,visited);
    }
}
