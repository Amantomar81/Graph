import java.util.*;

public class BFSGraph {
    HashMap<Integer, List<Integer>>obj;
    public BFSGraph()
    {
        obj = new HashMap<Integer,List<Integer>>();
    }
    // Graph Creation Method

    public void addedge(int source, int desti, boolean isbidirection) {
        List<Integer> sourceneighbour = obj.getOrDefault(source, new ArrayList<>());
        sourceneighbour.add(desti);
        obj.put(source, sourceneighbour);
        if (isbidirection) {
            List<Integer> destineighbour = obj.getOrDefault(desti, new ArrayList<>());
            destineighbour.add(source);
            obj.put(desti, destineighbour);
        }
    }
        // BFS Traversal uses Queue DS
        // Level Order Traversal
        public void bfsl ( int src)
        {
            Queue<Integer> bfs = new LinkedList<>();
            bfs.add(src);
            Set<Integer> vis = new HashSet<>();
            vis.add(src);
            while (!bfs.isEmpty()) {
                int front = bfs.poll();
                System.out.print(front + " ");
                List<Integer> neighbourlist = obj.get(front);
                for (int neighbour : neighbourlist) {
                    if (!vis.contains(neighbour)) {
                        bfs.add(neighbour);
                        vis.add(neighbour);
                    }
                }
            }
        }
        public void display ()
        {
            for (Map.Entry<Integer, List<Integer>> entry : obj.entrySet()) {
                System.out.println(entry.getKey() + "   " + entry.getValue());

            }
        }

        public static void main (String[]args){
            Graph1 obj = new Graph1();
            obj.addedge(1, 2, true);
            obj.addedge(1, 4, true);
            obj.addedge(2, 3, true);
            obj.addedge(3, 4, true);
            obj.addedge(3, 5, true);
            obj.addedge(5, 6, true);
            System.out.println("Graph Details");
            obj.display();
            System.out.println("BFS Traversal");
            obj.bfs(1);


        }

    }
