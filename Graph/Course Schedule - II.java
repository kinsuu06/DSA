class Solution {
    HashMap<Integer,List<Integer>> map = new HashMap<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
        int v2 = prerequisites[i][0];
        int v1 = prerequisites[i][1];
        map.get(v1).add(v2);
       }
        int[] arr = indegree(map);
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                q.add(i);
            }
        }
        
        int i=0;
        int count = 0;
        while(!q.isEmpty()){
            int rv = q.poll();
            count++;
            ans[i++] = rv;
            for(int nbrs : map.get(rv)){
                arr[nbrs]--;
                if(arr[nbrs] == 0){
                    q.add(nbrs);
                }
            }
        }
        if(count != map.size())  return new int[0];
        return ans;
    }
    public int[] indegree(HashMap<Integer,List<Integer>> map){
        int[] arr = new int[map.size()];
        for(int i=0; i<map.size(); i++){
            for(int nbrs : map.get(i)){
                arr[nbrs]++;
            }
        }
        return arr;
    }
}
