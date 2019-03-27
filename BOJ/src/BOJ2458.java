import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2458 {
	static int N,M;
	static int[][] up;
	static int[][] down;
	static boolean[] visit;
	static int downCnt;
	static int upCnt;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int a, b;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		up = new int[N+1][N+1];
		down = new int[N+1][N+1];
		visit = new boolean[N+1];
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			down[a][b] = 1;
			up[b][a] = 1;
		}
//		for(int i=1;i<=N;i++) {
//			for(int j=1;j<=N;j++) {
//				System.out.printf("%d ",down[i][j]);
//			}System.out.println();
//		}
//		System.out.println("---------------------");
//		for(int i=1;i<=N;i++) {
//			for(int j=1;j<=N;j++) {
//				System.out.printf("%d ",up[i][j]);
//			}System.out.println();
//		}
		for(int i=1;i<=N;i++) {
			downCnt = -1;
			dfs1(i);
			for(int j=1;j<=N;j++) {
				visit[j] = false;
			}
			upCnt = -1;
			dfs2(i);
			for(int j=1;j<=N;j++) {
				visit[j] = false;
			}
			if(upCnt+downCnt==N-1) {
				cnt++;
			}
			//System.out.printf("[%d] %d %d\n",i,downCnt,upCnt);
		}
		bw.write(""+cnt);
		bw.flush();
		bw.close();
	}
	public static void dfs1(int idx) {
		downCnt++;
		visit[idx] = true;
		for(int i=1;i<=N;i++) {
			if(down[idx][i]==1 && !visit[i]) {
				dfs1(i);
			}
		}
	}
	public static void dfs2(int idx) {
		upCnt++;
		visit[idx] = true;
		for(int i=1;i<=N;i++) {
			if(up[idx][i]==1 && !visit[i]) {
				dfs2(i);
			}
		}
	}

}
