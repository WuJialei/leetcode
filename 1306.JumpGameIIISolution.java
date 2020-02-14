class Solution {

    int[] array;
    boolean[] visited;

    public boolean canReach(int[] arr, int start) {
        array = arr;
        visited = new boolean[array.length];
        return dfs(start);
    }

    public boolean dfs (int index) {
        if (index < 0 || index >= array.length || visited[index]) {
            return false;
        }
        if (array[index] == 0) {
            return true;
        }
        visited[index] = true;
        return dfs(index + array[index]) || dfs(index - array[index]);
    }

}