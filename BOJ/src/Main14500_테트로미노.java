import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14500_테트로미노 {
	static int N,M;
	static int[][] map = new int[501][501];
	static int[][] dr = {
			{0,0,0,0},
			{0,1,2,3},
			{0,1,2,2},
			{0,1,0,0},
			{0,0,1,2},
			{0,0,0,-1},
			{0,0,-1,-2},
			{0,0,0,1},
			{0,1,2,0},
			{0,1,1,1},
			{0,1,1,2},
			{0,1,0,-1},
			{0,0,1,1},
			{0,0,-1,-1},
			{0,0,1,0},
			{0,0,-1,1},
			{0,0,0,-1},
			{0,1,2,1},
			{0,0,1,1}
	};
	static int[][] dc = {
			{0,1,2,3},
			{0,0,0,0},
			{0,0,0,1},
			{0,0,1,2},
			{0,1,1,1},
			{0,1,2,2},
			{0,1,1,1},
			{0,1,2,2},
			{0,0,0,1},
			{0,0,1,2},
			{0,0,1,1},
			{0,0,1,1},
			{0,1,1,2},
			{0,1,1,2},
			{0,1,1,2},
			{0,1,1,1},
			{0,1,2,1},
			{0,0,0,1},
			{0,1,0,1}
	};
	static int maxValue;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maxValue = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int k=0;k<19;k++) {
					int tmp = check(i,j,k);
					if(tmp>maxValue) {
						maxValue=tmp;
					}
				}
			}
		}
		System.out.println(maxValue);
	}
	public static int check(int row ,int col, int block) {
		int result = 0;
		int nextR, nextC;
		for(int i=0;i<4;i++) {
			nextR = row+dr[block][i];
			nextC = col+dc[block][i];
			if(nextR>=N || nextR<0 || nextC>=M || nextC<0) {
				return -1;
			}
			result+=map[nextR][nextC];
		}
		return result;
	}
}
