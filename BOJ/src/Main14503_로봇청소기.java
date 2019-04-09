import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14503_로봇청소기 {
	static int N,M;
	static int[][] map = new int[50][50];
	static int minCnt;
	static int r,c,d;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static boolean[][] isCleaned = new boolean[50][50];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean isExit = false;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			//1
			isCleaned[r][c] = true;
			System.out.printf("[%d,%d]\n",r,c);
			//2
			for(int i=1;i<=4;i++) {
				d--;
				if(d==-1)d=3;
				if(check(r,c,d)) {
					move(r,c,d);
					break;
				}
				if(i==4) {//네방향 모두 청소가 되어있거나 벽인 경우
					//뒤 확인
					if(!checkBack(r,c,d)) {
						isExit = true;//네방향 모두 청소되어 있거나 벽이고 뒤쪽이 벽인 경우
					}
				}
				if(isExit)break;
			}
		}
	}
	public static boolean checkBack(int row, int col, int dir) {
		int nextR = row + dr[(dir+2)%4];
		int nextC = col + dr[(dir+2)%4];
		if(nextR<N && nextR>=0 && nextC<M && nextC>=0) {
			if(map[nextR][nextC]==0) {
				r = nextR;
				c = nextC;
				return true;
			}
		}
		return false;
	}
	public static boolean check(int row, int col, int dir) {
		int nextR = row+dr[dir];
		int nextC = col+dc[dir];
		if(nextR>=0 && nextR<N && nextC>=0 && nextC<M) {
			if(!isCleaned[nextR][nextC] && map[nextR][nextC]==0) {
				return true;
			}
		}
		return false;
	}
	public static void move(int row, int col, int dir) {
		int nextR = row+dr[dir];
		int nextC = col+dc[dir];
		r = nextR;
		c = nextC;
	}
}
