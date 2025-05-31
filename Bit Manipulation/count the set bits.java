import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		while(n > 0){
		    cnt += n&1; // cnt += n%2
		    n = n>>1;    // n /= 2
		}
		System.out.println(cnt);
	}
}
