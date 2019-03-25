import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main16000 {
	static int N, M;
	static int[][] map = new int[2000][2000];
	static int[][] changedMap = new int[2000][2000];
	static char[][] oriMap = new char[2000][2000];
	static boolean[][] visit = new boolean[2000][2000];
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static boolean[] isSafe = new boolean[2000];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String input;
		int islandNum = 1;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			input = br.readLine();
			oriMap[i] = input.toCharArray();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(oriMap[i][j]=='#' && !visit[i][j]) {
					makeMap(islandNum,i,j);
					islandNum++;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.printf("%d ",map[i][j]);
			}System.out.println();
		}
	}
	
	public static void move(int num, int row, int col) {
		if(row==N-1 || row ==0 || col == M-1 || col==0) {//외곽에 도달한 경우
			isSafe[num] = true;
		}else {
			int nextR, nextC;
			for(int i=0;i<4;i++) {
				nextR = row+dr[i];
				nextC = col+dc[i];
				if(nextR<N && nextR>=0 && nextC<M && nextC>=0 && changedMap[nextR][nextC]==0) {
					move(num, nextR, nextC);
				}
			}
		}
	}
	public static void makeMap(int num, int row, int col) {
		visit[row][col] = true;
		map[row][col] = num;
		int nextR, nextC;
		for(int i=0;i<4;i++) {
			nextR = row +dr[i];
			nextC = col +dc[i];
			if(nextR<N && nextR>=0 && nextC<M && nextC>=0 && 
				!visit[nextR][nextC] && oriMap[nextR][nextC]=='#') {
				makeMap(num,nextR,nextC);
			}
		}
	}

}
