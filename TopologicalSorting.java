
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){

        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));

    }

    public static void topoSort(ArrayList<Edge>[] graph){

        boolean[] visi = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < graph.length; i++){
            if(!visi[i]){
                    topoSortUtil(graph, i, visi, st);
            }
        }

        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }

    public static void topoSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visi, Stack<Integer> st){

        visi[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visi[e.dest]){
                topoSortUtil(graph, e.dest, visi, st);
            }
        }
        st.push(curr);
        
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        
        createGraph(graph);

       topoSort(graph);
    }
}
