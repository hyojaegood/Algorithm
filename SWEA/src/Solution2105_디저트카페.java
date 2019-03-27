import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2105_디저트카페 {
	static int N;
	static int[][] map = new int[100][100];
	static int[] dr = {1,1,-1,-1};
	static int[] dc = {-1,1,1,-1};
	static boolean[] visit = new boolean[101];
	static int maxValue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			maxValue = -1;
			N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if((i==0 && j==0)||(i==0&&j==N-1)||(i==N-1&&j==0)||(i==N-1&&j==N-1))continue;
					visit[map[i][j]] = true;
					if(i+dr[0]<N && i+dr[0]>=0 && j+dc[0]<N && j+dc[0]>=0 && !visit[map[i+dr[0]][j+dc[0]]]) {
						visit[map[i+dr[0]][j+dc[0]]]=true;
						dfs(i,j,i+dr[0],j+dc[0],0,1);
						visit[map[i+dr[0]][j+dc[0]]]=false;
					}
					visit[map[i][j]] = false;
				}
			}
			bw.write("#"+tc+" "+maxValue+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static void dfs(int startRow, int startCol, int row, int col, int dir, int val) {
		int curR,curC,nextR,nextC;
		curR=row;
		curC=col;
		for(int i=0;i<2;i++) {
			if(dir+i<=3) {
				nextR = curR+dr[dir+i];
				nextC = curC+dc[dir+i];
				if(startRow == nextR && startCol==nextC) {
					if(maxValue<val+1)maxValue=val+1;
					return;
				}
				if(nextR<N&&nextR>=0&&nextC<N&&nextC>=0&&nextR>=startRow&&!visit[map[nextR][nextC]]) {
					visit[map[nextR][nextC]] = true;
					dfs(startRow,startCol, nextR,nextC,dir+i,val+1);
					visit[map[nextR][nextC]] = false;
				}
			}
		}
	}

}
