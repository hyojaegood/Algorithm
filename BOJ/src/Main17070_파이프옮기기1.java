import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main17070_파이프옮기기1 {
	static int N;
	static int[][] map = new int[17][17];
	static int cnt;
	static int[][] seq = new int[10000][2];
	static int dr[][] = {
			{0},
			{1},
			{0,1,1}
	};
	static int dc[][] = {
			{1},
			{0},
			{1,0,1}
	};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		long start = System.currentTimeMillis();
		N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move(1,2,0);
		bw.write(""+cnt+"\n");
		bw.flush();
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
		bw.close();
	}
	public static void move(int row2, int col2, int dir) {
		if(row2==N && col2 == N) {
			cnt++;
			return;
		}
		int nextR = 0, nextC = 0;
		for(int i=0;i<3;i++) {
			int isPossible=0;
			if(dir==0 && i==1)continue;
			if(dir==1 && i==0)continue;
			for(int j=0;j<dr[i].length;j++) {
				nextR = row2+dr[i][j];
				nextC = col2+dc[i][j];
				if(nextR<=N && nextR>=1 && nextC<=N && nextC>=1) {
					if(map[nextR][nextC]==0) {
						isPossible++;
					}
				}else {
					isPossible = 0;
					break;
				}
			}
			if(isPossible==dr[i].length) {
				move(nextR,nextC,i);
			}
		}
	}

}
