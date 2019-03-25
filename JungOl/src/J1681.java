import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class J1681 {
	static int[][] adj = new int[12][12];
	static int N;
	static int minCost;
	static boolean[] visit = new boolean[12];
	static int[] ary = new int[12];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		minCost = N*100;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<N;i++) {
			if(adj[0][i]>0) {
				visit[i] = true;
				dfs(0, i , adj[0][i]);
				visit[i] = false;	
			}
		}
		System.out.println(minCost);
	}
	public static void dfs(int depth, int idx, int curCost) {
		ary[depth] = idx;
		if(depth==N-2) {
			if(adj[idx][0]==0) {
				return;
			}
			curCost+=adj[idx][0];
//			for(int i=0;i<N;i++) {
//				System.out.printf("%d ",ary[i]+1);
//			}System.out.println(": "+curCost);
			if(curCost<minCost) {
				minCost = curCost;
			}
			return;
		}
		if(curCost>=minCost) {
			return;
		}
		for(int i=1;i<N;i++) {
			if(!visit[i]&&adj[idx][i]>0) {
				visit[i] = true;
				dfs(depth+1, i, curCost+adj[idx][i]);
				visit[i] = false;
			}
		}
	}
}
