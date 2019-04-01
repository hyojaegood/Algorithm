import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4340_파이프연결 {
	static int N;
	static int[][] map = new int[50][50];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int minDis;
	static boolean[][] visit = new boolean[50][50];
	static int[][] result = new int[1000][2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
		}
	}
	public static void move(int row, int col, int dir, int depth) {

	}
	
}
