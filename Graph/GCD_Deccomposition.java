import java.util.*;
public class GCD_Decomposition {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            set.add(arr[i]);
        }
        if(set.size()<2){
            System.out.println("no");
        }
        List<List<Integer>> adj =new ArrayList<>();
        List<Integer>num=new ArrayList<>(set);
        for(int i=0;i<num.size();i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<num.size();i++){
            for(int j=i+1;j<num.size();j++){
                int a=num.get(i);
                int b=num.get(j);
                if(GCD(a, b)==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        if(isBipartite(adj)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
  
    public static boolean  isBipartite(List<List<Integer>>adj){
        int color[]=new int[adj.size()];//0 means not coloured
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<adj.size();i++){
            if(color[i] == 0){
                q.add(i);
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int nbrs:adj.get(node)){
                        if(color[nbrs] == 0){
                            color[nbrs] = 3 - color[node];
                            q.add(nbrs);
                        }
                        else if(color[nbrs] == color[node]){
                            return false;
                        }
                    }
                }
            }          
        }
        return true;   
    }
  
    public static int GCD(int a,int b){
        while(a%b!=0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        return b;
    }
}
