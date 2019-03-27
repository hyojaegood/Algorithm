import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ13460_구슬탈출2 {
	static int N,M;
	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static int minCost;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String in;
		int redR, redC, blueR, blueC;
		redR = 0;
		redC = 0;
		blueR = 0;
		blueC = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			in = br.readLine();
			map[i] = in.toCharArray();
			for(int j=0;j<M;j++) {
				if(map[i][j]=='R') {
					redR = i;
					redC = j;
				}
				if(map[i][j]=='B') {
					blueR = i;
					blueC = j;
				}
			}
		}
		minCost =Integer.MAX_VALUE;
		for(int i=0;i<4;i++) {
			move(redR, redC, blueR, blueC, i, 0);
		}
		System.out.println(minCost);
	}
	public static void move(int redR,int redC,int blueR,int blueC, int dir, int depth) {
		int nextR, nextC;
		if(dir==0) {
			if(redR<blueR) {//red먼저 이동
				while(map[redR][redC]=='.') {
					map[redR][redC] = 'R';
					nextR = redR+dr[dir];
					nextC = redC+dc[dir];
				}
			}else {//blue 먼저 이동

			}
		}else if(dir==1) {
			if(redR>blueR) {//red먼저 이동

			}else {//blue 먼저 이동

			}
		}else if(dir==2) {

		}else {

		}
	}

}
