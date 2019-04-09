import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502_연구소 {
	static int N,M;
	static int[][] map = new int[10][10];
	static int minCnt;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static int callCnt;
	static boolean[][] visit = new boolean[10][10];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		callCnt = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minCnt = N*M;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					dfs(i,j,1);
					map[i][j] = 0;
				}
			}
		}
		int tmp =N*M;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1)tmp--;
			}
		}
		tmp = tmp - 3 - minCnt;
		System.out.println(tmp);
	}
	public static void dfs(int row, int col, int depth) {
		Queue<location> q = new LinkedList<>();
		if(depth==3) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					visit[i][j] = false;
				}
			}
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==2) {
						q.add(new location(i,j));
						if(cnt>=minCnt)return;
						cnt++;
					}
				}
			}
			int nextR, nextC;
			int qSize;
			while(!q.isEmpty()) {
				qSize = q.size();
				for(int i=0;i<qSize;i++) {
					for(int j=0;j<4;j++) {
						nextR = q.peek().r + dr[j];
						nextC = q.peek().c + dc[j];
						if(nextR>=0 && nextR<N && nextC>=0 && nextC<M) {
							if(map[nextR][nextC]==0 && !visit[nextR][nextC]) {
								q.add(new location(nextR, nextC));
								cnt++;
								if(cnt>=minCnt)return;
								visit[nextR][nextC] = true;
							}
						}
					}
					q.poll();
				}
			}
			if(cnt<minCnt)minCnt = cnt;
			return;
		}
		for(int i=row;i<N;i++) {
			if(i==row) {
				for(int j=col+1;j<M;j++) {
					if(map[i][j]==0) {
						map[i][j] =1;
						dfs(i,j,depth+1);
						map[i][j] =0;
					}
				}	
			}else {
				for(int j=0;j<M;j++) {
					if(map[i][j]==0) {
						map[i][j] =1;
						dfs(i,j,depth+1);
						map[i][j] =0;
					}
				}
			}
		}
	}
}
class location{
	int r,c;
	location(int r, int c){
		this.r = r;
		this.c = c;
	}
}
