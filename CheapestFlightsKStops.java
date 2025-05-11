/* Question =  There are n cities connected by some number of flights.
You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that 
there is a flight from city from i to city toi with cost price i.

You are also given three integers src, dst, and k, return the cheapest 
price from src to dst with at most k stops. If there is no such route, return -1.
 */
import java.util.*;
public class CheapestFlightsKStops {
    
    public static void main(String[] args) {
        int[][] flights = {{0,1,100}, {2,0,100}, {1,3,600},{2,3,200},{1,2,100}};
        int k=1, src=0,dest=3;
        int n = 4;

        System.out.println(cheapestFlights(n, flights, src, dest, k));
    }

    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Info{
        int v;
        int cost;
        int k;

        Info(int v, int c, int k){
            this.v = v;
            this.cost = c;
            this.k = k;
        }
    } 

    private static void createGraph(int flights[][], ArrayList<Edge>[] graph){
         for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();          
        }

        for (int i = 0; i < flights.length; i++) {
            int s = flights[i][0];
            int d = flights[i][1];
            int c = flights[i][2];
            Edge e = new Edge(s, d, c);
            graph[s].add(e);
        }
    }
    private static int cheapestFlights(int n ,int[][] flights, int src, int dest, int k){
        //create a graph;
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        int[] dist = new int[n];
        for (int i = 0; i < dist.length; i++) {
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
       
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));// The cost till source is 0, stops are also 0

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.k > k){
                break;
            }
            //call for neighbours
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                if(curr.cost + e.wt < dist[e.dest] && curr.k <=k){
                    dist[e.dest] = curr.cost + e.wt;
                    q.add(new Info(e.dest, dist[e.dest], curr.k+1));
                }
            }
        }

            if(dist[dest] == Integer.MAX_VALUE){
                return -1;
            } else{
                return dist[dest];
            }

    }
}
