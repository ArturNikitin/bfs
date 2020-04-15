import java.util.*;

public class BFS {
    /**
     * Bread-First Search
     * */
    public boolean bfs(HashMap<String, List<String>> graph, String key, String search) {
        Deque<String> deque = new ArrayDeque<>(graph.get(key));
        HashSet<String> checkedSet = new HashSet<>();
        while (!deque.isEmpty()){
            String check = deque.pollFirst();
            if (!checkedSet.contains(check)) {
                if (searchingCriteria(search, check)) {
                    System.out.println("Closest element is: " + check);
                    return true;
                } else if (graph.containsKey(check) && graph.get(check) != null) {
                    List<String> neighbours = graph.get(check);
                    for (String str :
                            neighbours) {
                        deque.addLast(str);
                    }
                }
            }
            checkedSet.add(check);
        }
        return false;
    }

    public boolean searchingCriteria(String search, String check) {
        return check.startsWith(search);
    }
}
