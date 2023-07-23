package exercise;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    private void dfs(int startNodeNum, List<List<Integer>> node, boolean[] visited, List<Integer> result) {
        if (visited[startNodeNum]) {
            return;
        }

        visited[startNodeNum] = true;
        result.add(startNodeNum);

        List<Integer> nodes = node.get(startNodeNum);
        for (Integer nodeNum : nodes) {
            dfs(nodeNum, node, visited, result);
        }
    }

    public List<Integer> execute(List<List<Integer>> node) {
        List<Integer> result = new ArrayList<>();
        dfs(0, node, new boolean[node.size()], result);
        System.out.println(result);
        return result;
    }
}
