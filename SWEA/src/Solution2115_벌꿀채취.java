import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2115_벌꿀채취 {
	static int N,M,C;
	static int maxP;
	static int[][] map = new int[10][10];
	static int[][] price = new int[10][10];
	static boolean[][] visit = new boolean[10][10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int maxPrice;
		for(int tc=1;tc<=T;tc++) {
			maxPrice = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N-M+1;j++) {
					price[i][j] = calMax(i,j);
				}
			}
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.printf("%d ",price[i][j]);
//				}System.out.println();
//			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N-M+1;j++) {
					maxPrice = max(maxPrice,pick(i,j, tc));
				}
			}
			bw.write("#"+tc+" "+maxPrice+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static int max(int a, int b) {
		if(a>b)return a;
		else return b;
	}
	public static int pick(int r, int c, int tc) {//A가 (r,c)를 선택했을 경우, A+B의 최댓값을 계산
		int maxPrice = price[r][c];
		int tmp;
		for(int i=c;i<=c+M-1;i++) {
			visit[r][i] = true;
		}
		for(int i=c;i>=0 && i>=c-M+1;i--) {
			visit[r][i] = true;
		}
		for(int i=r;i<N;i++) {
			for(int j=0;j<N-M+1;j++) {
				if(visit[i][j])continue;
				tmp = price[r][c] + price[i][j];
				if(tmp>maxPrice) {
					maxPrice=tmp;
				}
			}
		}
		for(int i=c;i<=c+M-1;i++) {
			visit[r][i] = false;
		}
		for(int i=c;i>=0 && i>=c-M+1;i--) {
			visit[r][i] = false;
		}
		return maxPrice;
	}
	public static int calMax(int r, int c) {//(r,c)에서부터 M개를 선택했을 때 최대 수익 
		maxP = 0;
		dfs(r,c,1,0,0,true);
		dfs(r,c,1,0,0,false);
		return maxP;
	}
	public static void dfs(int r, int c, int depth, int P, int W, boolean isSelected) {
		if(isSelected) {
			W+=map[r][c];
			if(W>C)return;
			P+=map[r][c]*map[r][c];
		}
		if(depth==M) {
			if(P>maxP) {
				maxP = P;
			}
			return;
		}else {
			dfs(r,c+1,depth+1,P,W,false);
			dfs(r,c+1,depth+1,P,W,true);
		}
	}

}
