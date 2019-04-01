import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4012_요리사 {
	static int N;
	static int[][] S = new int[16][16];
	static int[][] map = new int[16][16];//1=>A,-1=>B
	static boolean[] visit = new boolean[16];
	static int[] A = new int[8];
	static int[] B = new int[8];
	static int minDif;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			minDif = 0;
			N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
					minDif+=S[i][j];
				}
			}
			visit[0] = true;
			dfs(0,0);
			visit[0] = false;
			bw.write("#"+tc+" "+minDif+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static void dfs(int idx, int depth) {
		A[depth] = idx;
		if(depth==N/2-1) {
			int cnt = 0;
			int aSum = 0;
			int bSum = 0;
			int dif;
			for(int i=0;i<N;i++) {
				if(!visit[i]) {
					B[cnt] = i;
					cnt++;
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<N/2;j++) {
					if(i!=j) {
						map[A[i]][A[j]] = 1;
						map[A[j]][A[i]] = 1;
						map[B[i]][B[j]] = -1;
						map[B[j]][B[i]] = -1;
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if(map[i][j]==1) {
						aSum+=(S[i][j]+S[j][i]);
					}else if(map[i][j]==-1) {
						bSum+=(S[i][j]+S[j][i]);
					}
				}
			}
			dif = difference(aSum, bSum);
			if(dif<minDif)minDif = dif;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = 0;
				}
			}
		}else {
			for(int i=idx+1;i<N;i++) {
				if(!visit[i]) {
					visit[i] =true;
					dfs(i,depth+1);
					visit[i] =false;
				}
			}
		}
	}
	public static int difference(int a, int b) {
		if(a>b)return a-b;
		else return b-a;
	}
}
