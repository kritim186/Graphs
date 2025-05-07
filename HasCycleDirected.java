
import java.util.*;


public class HasCycleDirected {
    static class Edge {
     int src;
     int dest;
     public Edge(int s, int d){
        this.src = s;
        this.dest = d;
     }
        
    }

    public static void createGraph(ArrayList<Edge>[] graph){

        for(int i = 0 ; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));

    }

    private static boolean hasCycle(ArrayList<Edge>[] graph){

        boolean[] visi = new boolean[graph.length];
        boolean[] callStack = new boolean[graph.length];
        //this stack is mainly used for - 

        for(int i = 0; i < graph.length; i++){
            if(!visi[i]){
                if(hasCycleUtil(graph, i, callStack, visi)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] callStack, boolean[] visi){

        visi[curr] = true;
        callStack[curr] = true; // modification

        //call for neighbours
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(callStack[e.dest] == true){ // cycle exist
                return true;
            }
            if(!visi[e.dest]){
                if(hasCycleUtil(graph, e.dest, callStack, visi)){
                    return true;
                }
            }
        }
        callStack[curr] = false;

        return false;
    }

    public static void main(String[] args) {
        @SuppressWarnings("Unchecked")
        ArrayList<Edge>[] graph= new ArrayList[4];

        createGraph(graph);

        System.out.println(hasCycle(graph));




    }
}
