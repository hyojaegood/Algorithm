import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1953_탈주범검거 {
	static int[][] map = new int[51][51];
	static boolean[][] visit = new boolean[51][51];
	static int N,M,R,C,L;
	static int[][] dr = {
			{},
			{-1,1,0,0},
			{-1,1},
			{0,0},
			{-1,0},
			{1,0},
			{0,1},
			{0,-1}
	};
	static int[][] dc = {
			{},
			{0,0,-1,1},
			{0,0},
			{-1,1},
			{0,1},
			{0,1},
			{-1,0},
			{-1,0}
	};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int cnt;
		for(int tc=1;tc<=T;tc++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			/*******************************************************/
			bfs(R,C);
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visit[i][j]) {
						cnt++;
						visit[i][j]=false;
					}
				}
			}
			bw.write("#"+tc+" "+cnt+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static void bfs(int r, int c) {
		int t=1;
		int qSize;
		int tmpSize;
		int tmpR, tmpC;
		int nextR, nextC;
		Queue<location> q = new LinkedList<location>();
		visit[r][c] = true;
		q.add(new location(r,c));
		while(t<L) {
			qSize = q.size();
			for(int i=0;i<qSize;i++) {
				
				tmpR = q.peek().r;
				tmpC = q.peek().c;
				tmpSize = dc[map[tmpR][tmpC]].length;
				for(int j=0;j<tmpSize;j++) {
					nextR = tmpR+dr[map[tmpR][tmpC]][j];
					nextC = tmpC+dc[map[tmpR][tmpC]][j];
					if(nextR>=0 && nextR<N && nextC>=0 && nextC<M && !visit[nextR][nextC]) {
						if(tmpR-nextR == 0) {
							if(tmpC-nextC==-1) {
								//오른쪽으로 이동
								//가능한 블록 1,3,6,7
								if(map[nextR][nextC]==1||map[nextR][nextC]==3||map[nextR][nextC]==6||map[nextR][nextC]==7) {
									visit[nextR][nextC] = true;
									q.add(new location(nextR, nextC));
								}
							}else {
								//왼쪽으로 이동
								//가능한 블록 1,3,4,5
								if(map[nextR][nextC]==1||map[nextR][nextC]==3||map[nextR][nextC]==4||map[nextR][nextC]==5) {
									visit[nextR][nextC] = true;
									q.add(new location(nextR, nextC));
								}
							}
						}else if(tmpR-nextR == -1) {
							//아래도 이동
							//가능한 블록 1,2,4,7
							if(map[nextR][nextC]==1||map[nextR][nextC]==2||map[nextR][nextC]==4||map[nextR][nextC]==7) {
								visit[nextR][nextC] = true;
								q.add(new location(nextR, nextC));
							}
						}else {
							//위로 이동
							//가능한 블록 1,2,5,6
							if(map[nextR][nextC]==1||map[nextR][nextC]==2||map[nextR][nextC]==5||map[nextR][nextC]==6) {
								visit[nextR][nextC] = true;
								q.add(new location(nextR, nextC));
							}
						}
					}
				}
				q.poll();
			}
			t++;
		}
	}

}
class location{
	int r,c;
	location(int a, int b){
		this.r = a;
		this.c = b;
	}
}