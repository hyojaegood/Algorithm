import java.util.Scanner;

public class JO1053 {
	public static void main(String[] args) {
		int[][] result = new int[2][2];
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();
		while(N>=0) {
			result = fibo(N);
			System.out.println(result[1][0]);
			N = sc.nextInt();
		}
	}
	public static int[][] fibo(int n){
		if(n==1) {
			return new int[][] {{1,1},{1,0}};
		}
		if(n==0) {
			return new int[][] {{1,0},{0,1}};
		}
		if(n%2==0) {
			int[][] r = fibo(n/2);
			return multiMatrix(r,r);
		}else {
			int[][] r = fibo(n/2);
			return multiMatrix(multiMatrix(r,r),fibo(1));
		}
	}
	public static int[][] multiMatrix(int[][] a, int [][] b){
		int[][] r = new int[2][2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++) {
					r[i][j] += (a[i][k]*b[k][j])%10000;
				}
				r[i][j]%=10000;
			}
		}

		return r;
	}
	public static int[][] powMatrix(int[][] a, int b){
		if(b==1) {
			return a;
		}
		if(b%2 == 0) {
			int[][] tmp = powMatrix(a, b/2);
			return multiMatrix(tmp,tmp);
		}else {
			int[][] tmp = powMatrix(a,b/2);
			return multiMatrix(multiMatrix(tmp,tmp),a);
		}
	}
	public static int pow(int a, int b) {
		if(b==0) {
			return 1;
		}
		if(b==1) {
			return a;
		}
		if(b%2==0) {
			int r = pow(a,b/2);
			return r*r;
		}else {
			int r = pow(a,b/2);
			return r*r*a;
		}
	}
}
