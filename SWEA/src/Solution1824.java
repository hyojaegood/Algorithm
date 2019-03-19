import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.concurrent.BrokenBarrierException;

public class Solution1824 {
	static int R,C;
	static char[][] map = new char[20][20];
	static boolean[][][][] visit = new boolean[16][4][20][20];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			for(int i=0;i<R;i++) {
				map[i] = br.readLine().toCharArray();
			}
			for(int i=0;i<16;i++) {
				for(int r=0;r<R;r++) {
					for(int c=0;c<C;c++) {
						for(int k=0;k<4;k++) {
							visit[i][k][r][c] = false;	
						}
						
					}
				}
			}
			if(isExist()) {
				if(check(0,0,3,0)) {
					bw.write("#"+tc+" YES\n");
					bw.flush();
				}else {
					bw.write("#"+tc+" NO\n");
					bw.flush();
				}	
			}else {
				bw.write("#"+tc+" NO\n");
				bw.flush();
			}
		}
		bw.close();
	}
	public static boolean isExist() {
		boolean result = false;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] =='@') {
					result = true;
					break;
				}
			}
		}
		return result;
	}
	public static boolean check(int r, int c, int dir, int mem) {
		boolean result;
		int curR,curC, nextR,nextC;
		int curM = mem;
		curR = r;
		curC = c;
		while(true) {
			if(map[curR][curC]=='@') {
				return true;
			}
			if(visit[curM][dir][curR][curC]) {
				return false;
			}
			visit[curM][dir][curR][curC] = true;
			if(map[curR][curC]=='?') {
				for(int i=0;i<4;i++) {
					nextR = curR+dr[i];
					nextC = curC+dc[i];
					if(nextR==R) {
						nextR = 0;
					}else if(nextR==-1) {
						nextR = R-1;
					}
					if(nextC==C) {
						nextC = 0;
					}else if(nextC==-1) {
						nextC = C-1;
					}
					if(check(nextR,nextC,i,curM))return true;
				}
			}
			/*******************************************************/
			if(map[curR][curC]=='^') {
				dir = 0;
			}else if(map[curR][curC]=='v') {
				dir = 1;
			}else if(map[curR][curC]=='<') {
				dir = 2;
			}else if(map[curR][curC]=='>') {
				dir = 3;
			}else if(map[curR][curC]=='_') {
				if(curM==0) {
					dir = 3;
				}else {
					dir = 2;
				}
			}else if(map[curR][curC]=='|') {
				if(curM==0) {
					dir = 1;
				}else {
					dir = 0;
				}
			}else if(map[curR][curC]=='.') {

			}else if(map[curR][curC]=='+') {
				if(curM==15) {
					curM = 0;
				}else {
					curM++;
				}
			}else if(map[curR][curC]=='-') {
				if(curM==0) {
					curM = 15;
				}else {
					curM--;
				}
			}else {//숫자인 경우
				curM = map[curR][curC] - '0';
			}
			/*******************************************************/
			nextR = curR+dr[dir];
			nextC = curC+dc[dir];
			if(nextR==R) {
				nextR = 0;
			}else if(nextR==-1) {
				nextR = R-1;
			}
			if(nextC==C) {
				nextC = 0;
			}else if(nextC==-1) {
				nextC = C-1;
			}
			curR = nextR;
			curC = nextC;
		}
	}

}
