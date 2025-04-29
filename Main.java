public class Main {
  public static void main(String[] args) {
   
    String[] vertices = {
        "Liberal Arts",
        "Student Services",
        "Health Careers & Sciences",
        "Health Technologies Center",
        "Recreation Center",
        "Technology Learning Center",
        "Business & Technology",
        "Theatre"
    };

    int[][] edges = {
        {0, 1}, // Liberal Arts ↔ Student Services
        {1, 2}, // Student Services ↔ Health Careers & Sciences
        {2, 3}, // Health Careers & Sciences ↔ Health Technologies Center
        {3, 4}, // Health Technologies Center ↔ Recreation Center
        {4, 5}, // Recreation Center ↔ Technology Learning Center
        {5, 6}, // Technology Learning Center ↔ Business & Technology
        {6, 0}, // Business & Technology ↔ Liberal Arts
        {6, 7}  // Business & Technology ↔ Theatre
    };

    Graph<String> graph = new UnweightedGraph<>(vertices, edges);
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology")); // Get a DFS starting at the Business & Technology building.Change this is you called it different in your vertices 
    
    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++) {
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    }
    System.out.println();

    // Display parents of each vertex
    for (int i = 0; i < searchOrders.size(); i++) {
      if (dfs.getParent(i) != -1) {
        System.out.println("parent of " + graph.getVertex(i) +
            " is " + graph.getVertex(dfs.getParent(i)));
      }
    }
    // Display paths from Business & Technology to specified buildings
    graph.printPath(graph.getIndex("Business & Technology"), graph.getIndex("Health Technologies Center"));
    graph.printPath(graph.getIndex("Business & Technology"), graph.getIndex("Student Services"));
    graph.printPath(graph.getIndex("Business & Technology"), graph.getIndex("Recreation Center"));

    // Print the entire tree
    dfs.printTree();
  }
}
