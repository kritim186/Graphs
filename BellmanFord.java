import java.util.*;
public class BellmanFord {
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

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));

    }

    private static void bellmanFord(ArrayList<Edge>[] graph, int src){

        int[] dist = new int[graph.length];
        //initialise each distance to infinity except the source
        for(int i = 0; i < graph.length; i++){
            if(i != src)
                   dist[i] = Integer.MAX_VALUE;
        }


        int vertices = graph.length;

        //algorithm
        for(int i = 0 ; i < vertices-1; i++){

            for(int j = 0; j < graph.length; j++){
                for(int k = 0; k < graph[j].size(); k++){
                    Edge e = graph[j].get(k);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    //relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }

                }
            }

        }
        
            for(int ele : dist){
                System.out.print(ele+" ");
            }
            System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];

        createGraph(graph);
        bellmanFord(graph, 0);
    }
}
