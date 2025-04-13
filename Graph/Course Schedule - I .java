class Solution {
    HashMap<Integer,List<Integer>> map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       for(int i=0; i<numCourses; i++){
        map.put(i,new ArrayList<>());
       }
       for(int i=0; i<prerequisites.length; i++){
        int v2 = prerequisites[i][0];
        int v1 = prerequisites[i][1];
        map.get(v1).add(v2);
       }
       return finish();
    }
    public boolean finish(){
        Queue<Integer> q = new LinkedList<>();
        int[] arr = inorder();
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int rv = q.poll();
            count++;
            for(int nbrs : map.get(rv)){
                arr[nbrs]--;
                if(arr[nbrs] == 0){
                    q.add(nbrs);
                }
            }
        }
        return count == map.size();
    }
    public int[] inorder(){
        int[] arr = new int[map.size()];
        for(int i=0; i<arr.length; i++){
            for(int nbrs : map.get(i)){
                arr[nbrs]++;
            }
        }
        return arr;
    }
}
