import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class countFriendGroups {
    public static int countGroup(int n, Map<Integer, List<Integer>> friendship){
        boolean[] visited = new boolean[n];
        int groups = 0;
        for (int student = 0; student < n; student++){
            if (!visited[student]){
                dfs(student, friendship, visited);
                groups++;
            }
        }
        return groups;
    }

    public static void dfs(int student, Map<Integer, List<Integer>> friendship, boolean[] visited){
        visited[student] = true;
        for(int friend : friendship.get(student)){
            if (!visited[friend]){
                dfs(friend, friendship, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> friendship = new HashMap<>();
        friendship.put(0, Arrays.asList(1));
        friendship.put(1, Arrays.asList(0, 2));
        friendship.put(2, Arrays.asList(1));
        friendship.put(3, Arrays.asList(4));
        friendship.put(4, Arrays.asList(3));
        friendship.put(5, Arrays.asList(1));
        friendship.put(6, Arrays.asList(3));

        System.out.println(countGroup(7, friendship));
    }
}
