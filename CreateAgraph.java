import java.util.*;
class CreateAgraph{
    // each edge will have src, dest and wt
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

    public static void main(String[] args){

        int V = 5;
        // Array of ArrayList
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V]; // everything would be null = [null, null, null, null, null]

        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>(); // here - [[], [], [], [], []]
        }
        // you'll get a NullPointerException 
// Why? Because graph[0] is null → you can't call .add() on a null object.
        //vertex 0;
        graph[0].add(new Edge(0, 1, 5));

        //vertex 1;
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //vertex 2
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 4, 2));

        //vertex 3
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));

        //vertex 4
        graph[4].add(new Edge(4, 2, 2));

        // Q-Access the neighbour of 2 
        // first get the lists at index 2 then print the destination of the edge to get the neighbour
        for(int i = 0; i < graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.print(e.dest+" ");
        }
        



    }
}