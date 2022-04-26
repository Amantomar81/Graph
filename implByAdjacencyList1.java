import java.util.*;

/*
1-------2
|       |
|       |
3--------4
|
|
5---------6
 */
public class implByAdjacencyList1 {
    Map<Integer, LinkedList<Integer>>obj;
    public implByAdjacencyList1(){
        obj = new HashMap<>();
    }

    public void addedge(int v1,int v2, boolean bidirectional){
        LinkedList<Integer> v1neighbour = obj.getOrDefault(v1, new LinkedList());
        v1neighbour.add(v2);
        obj.put(v1,v1neighbour);
        if(bidirectional == true)
        {
            List<Integer>destineighbour = obj.getOrDefault(v2,new LinkedList<>());
            destineighbour.add(v1);
            obj.put(v1, v1neighbour);
        }
    }

    public void diplay(){
        for(Map.Entry<Integer, LinkedList<Integer>>obj :obj.entrySet()) {
            System.out.println(obj.getKey());
            System.out.println(obj.getValue());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        implByAdjacencyList1 obj= new implByAdjacencyList1();
        obj.addedge(1,2,true);
        obj.addedge(2,3,true);
        obj.addedge(3,4,true);
        obj.addedge(3,5,true);
        obj.addedge(5,6,true);
        obj.diplay();
    }

}
