import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution5656_벽돌깨기 {
	static int W,H,N;
	static int[][] map = new int[15][12];
	static int[][] changedMap = new int[15][12];
	static int[] dropSeq = new int[4];
	static int minCnt;
	static int bricksCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			bricksCnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			minCnt = W*H;
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<W;i++) {
				for(int j=0;j<H;j++) {
					changedMap[j] = map[j].clone();
				}	
				dfs(i,0);
			}
			bw.write("#"+tc+" "+minCnt+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static int countOfBricks() {
		int result = 0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(changedMap[i][j]!=0)result++;
			}
		}
		return result;
	}
	public static void drop(int col) {
		for(int i=0;i<H;i++) {
			if(changedMap[i][col]!=0) {
				breaks(i,col,changedMap[i][col]);
				arrange();
				break;
			}
		}
	}
	public static void dfs(int idx, int depth) {
		dropSeq[depth] = idx;
		int[][] savedMap = new int[15][12];
		drop(idx);//changedMap의 상태가 바뀜
		if(depth == N-1) {
			int tmp = countOfBricks();
			if(tmp<minCnt) {
				minCnt = tmp;
			}
			return;
		}else {
			for(int i=0;i<W;i++) {
				for(int k=0;k<H;k++) {
					for(int j=0;j<W;j++) {
						savedMap[k][j] = changedMap[k][j];
					}
				}
				dfs(i,depth+1);
				for(int k=0;k<H;k++) {
					for(int j=0;j<W;j++) {
						changedMap[k][j] = savedMap[k][j];
					}
				}
			}
		}
	}
	public static void arrange() {
		int target;
		for(int i=0;i<W;i++) {
			for(int j=H-1;j>=0;j--) {
				if(changedMap[j][i]!=0) {
					for(int k=H-1;k>j;k--) {
						if(changedMap[k][i]==0) {
							target = k;							
							changedMap[target][i] = changedMap[j][i];
							changedMap[j][i] = 0;
							break;
						}
					}
				}
			}
		}
	}
	public static void breaks(int row, int col, int k) {
		int tmp;
		changedMap[row][col] = 0;
		if(k==1)return;
		for(int i=row-k+1;i<=row+k-1;i++) {
			if(i>=0 && i<H) {
				if(changedMap[i][col]==1) {
					changedMap[i][col] = 0;
				}else if(changedMap[i][col]>1){
					tmp = changedMap[i][col];
					changedMap[i][col] = 0;
					breaks(i,col,tmp);
				}
			}
		}
		for(int i=col-k+1;i<=col+k-1;i++) {
			if(i>=0 && i<W) {
				if(changedMap[row][i]==1) {
					changedMap[row][i] = 0;
				}else if(changedMap[row][i]>1){
					tmp = changedMap[row][i];
					changedMap[row][i] = 0;
					breaks(row,i,tmp);
				}
			}
		}
	}
}
