package Graph;

public class GraphDemo {
    public static void main(String[] args) {
        int n = 5;
        String [] vertex = {"A", "B","C","D","E"};
        Graph graph = new Graph(5);

        for(String value : vertex){
            graph.insertVertex(value);
        }

        //添加边 A-B, A-C, B-C, B-D, B-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.show();
    }
}
