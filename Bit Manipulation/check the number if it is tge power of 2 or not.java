import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if((n&(n-1)) != 0){
		  System.out.println(false);
		}else{
		    System.out.println(true);
		}
	}
}
