import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main16234_인구이동 {
	static int N,L,R;
	static int[][] A = new int[51][51];
	static int[][] unionMap = new int[51][51];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] unionInfo = new int[2501][2];//unionCnt, unionSum
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int unionCnt;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			unionCnt = 0;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(unionMap[i][j]==0) {
						unionCnt++;
						dfs(i,j,unionCnt);
					}
				}
			}
			if(unionCnt==N*N)break;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					A[i][j] = unionInfo[unionMap[i][j]][1]/unionInfo[unionMap[i][j]][0];
				}
			}
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					System.out.printf("%d ",A[i][j]);
				}System.out.println();
			}System.out.println("---------------");
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					unionMap[i][j] = 0;
				}
			}
		}
	}
	public static int abs(int a) {
		if(a<0)return -a;
		return a;
	}
	public static void dfs(int row, int col, int unionNum) {
		int nextR, nextC;
		unionInfo[unionNum][0]++;
		unionInfo[unionNum][1]+=A[row][col];
		unionMap[row][col] = unionNum;
		for(int i=0;i<4;i++) {
			nextR = row+dr[i];
			nextC = col+dc[i];
			if(nextR>=1 && nextR<=N && nextC>=1 && nextC<=N) {
				if(unionMap[nextR][nextC] == 0 && abs(A[row][col]-A[nextR][nextC])>=L && abs(A[row][col]-A[nextR][nextC])<=R) {
					dfs(nextR, nextC, unionNum);
				}
			}
		}
	}

}
