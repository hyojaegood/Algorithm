import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14499_주사위굴리기 {
	static int N,M,x,y,K;
	static int[][] map = new int[21][21];
	static int[] dice = new int[7];
	static int[] move = new int[1001];
	static int[] dr = {0,0,0,-1,1};
	static int[] dc = {0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=6;i++) {
			dice[i] = 0;
		}
		for(int i=0;i<K;i++) {
			if(operation(move[i])) {
				bw.write(""+dice[6]+"\n");
				bw.flush();
			}
		}
		bw.close();
	}
	public static boolean operation(int dir) {
		int[] tmp = new int[7];
		int nextX, nextY;
		//이동
		for(int i=1;i<=6;i++) {
			tmp[i] = dice[i];
		}
		nextX = x+dr[dir];
		nextY = y+dc[dir];
		if(nextX<N && nextX>=0 && nextY<M && nextY>=0) {
			if(dir==1) {
				dice[1] = tmp[3];
				dice[2] = tmp[2];
				dice[3] = tmp[6];
				dice[4] = tmp[1];
				dice[5] = tmp[5];
				dice[6] = tmp[4];
			}else if(dir==2) {
				dice[1] = tmp[4];
				dice[2] = tmp[2];
				dice[3] = tmp[1];
				dice[4] = tmp[6];
				dice[5] = tmp[5];
				dice[6] = tmp[3];
			}else if(dir==3) {
				dice[1] = tmp[2];
				dice[2] = tmp[6];
				dice[3] = tmp[3];
				dice[4] = tmp[4];
				dice[5] = tmp[1];
				dice[6] = tmp[5];
			}else {
				dice[1] = tmp[5];
				dice[2] = tmp[1];
				dice[3] = tmp[3];
				dice[4] = tmp[4];
				dice[5] = tmp[6];
				dice[6] = tmp[2];
			}
			if(map[nextX][nextY]==0) {
				map[nextX][nextY] = dice[1];
			}else {
				dice[1] = map[nextX][nextY];
				map[nextX][nextY] = 0;
			}
			x = nextX;
			y = nextY;
			return true;
		}
		return false;
	}
}
