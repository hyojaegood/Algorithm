import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main13460_구슬탈출2 {
	static int N,M;
	static char[][] map = new char[10][10];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int redR, redC, blueR, blueC;
	static int holeR, holeC;
	static int minDepth;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String in;
		char[][] oriMap = new char[10][10];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minDepth = N*M;
		for(int i=0;i<N;i++) {
			in = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = in.charAt(j);
			}
		}
	}

}
