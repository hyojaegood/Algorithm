import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution4796_의석이의우뚝선산 {
	static int[] comp = new int[50000];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cnt;
		int up, down;
		boolean check;
		for(int tc=1;tc<=T;tc++) {
			cnt =0;
			N = sc.nextInt();
			int tmp1 = sc.nextInt();
			int tmp2;

			for(int i=0;i<N-1;i++) {
				tmp2 = sc.nextInt();
				if(tmp1<tmp2) {
					comp[i]=-1;
				}else {
					comp[i] = 1;
				}
				tmp1 = tmp2;
			}
			up = 0;
			down = 0;
			for(int i=0;i<N-1;i++) {
				if(comp[i]<0 && down>0) {
					cnt+=up*down;
					up = down = 0;
				}
				if(comp[i]<0) {
					up++;
				}else {
					down++;
				}
			}
			cnt+=up*down;
			System.out.printf("#%d %d\n",tc,cnt);
			
		}
	}

}
