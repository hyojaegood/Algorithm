import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1865 {
	static int N;
	static double[][] p = new double[16][16];
	static boolean[] visit = new boolean[16];
	static boolean[] visitR = new boolean[16];
	static boolean[] visitC = new boolean[16];
	static double max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int maxR, maxC;
		double maxValue;
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			max = 0;
			N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					p[i][j] = (double)Integer.parseInt(st.nextToken())/100;
				}
			}
			for(int i=0;i<N;i++) {
				visit[i] = false;
			}
			for(int i=0;i<N;i++) {
				visit[i] = true;
				dfs(i,0,1);
				visit[i] = false;
			}
			System.out.printf("#%d %.6f\n",tc, max*100);
		}
	}
	public static void dfs(int idx, int depth, double prob) {
		prob = prob * p[depth][idx];
		if(prob<max || prob==0) {
			return;
		}
		if(depth==N-1) {
			if(prob>max) {
				max = prob;
			}
		}else {
			for(int i=0;i<N;i++) {
				if(!visit[i]) {
					visit[i] = true;
					dfs(i,depth+1,prob);
					visit[i] = false;
				}
			}
		}
	}
}
