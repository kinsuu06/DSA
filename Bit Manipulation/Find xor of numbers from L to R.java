import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int l = sc.nextInt();
	    int r = sc.nextInt();
		System.out.println(findxor(l-1)^findxor(r));
	}
	public static int findxor(int n){
	    if(n%4 == 1) return 1;
	    else if(n%4 == 2) return n+1;
	    else if(n%4 == 3) return 0;
	    else return n;
	}
}
