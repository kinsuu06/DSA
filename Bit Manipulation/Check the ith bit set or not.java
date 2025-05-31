import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int ls = 1<<k;
		if((ls&n) != 0){
		  System.out.println(true);
		}else{
		    System.out.println(false);
		}
	}
}
