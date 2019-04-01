import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4014_활주로건설 {
	static int N, X;
	static int[][] map = new int[20][20];
	static boolean[] isPossibleRow = new boolean[20];
	static boolean[] isPossibleCol = new boolean[20];
	static boolean[][] visit = new boolean[20][20];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int cnt;
		for(int tc=1;tc<=T;tc++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N;i++) {//row체크
				isPossibleRow[i] = true;
				for(int j=0;j<N-1;j++) {
					if(map[i][j] - map[i][j+1] == 1) {
						//j+1 ~ j+X까지 체크
						isPossibleRow[i] = check(i,j,0);
						if(isPossibleRow[i]) {
							for(int k=j+1;k<=j+X;k++) {
								visit[i][k] = true;
							}
						}
					}else if(map[i][j]-map[i][j+1]==-1) {
						//j-X+1 ~ j까지 체크
						isPossibleRow[i] = check(i,j,2);
						if(isPossibleRow[i]) {
							for(int k=j-X+1;k<=j;k++) {
								visit[i][k] = true;
							}
						}
					}else if(map[i][j] == map[i][j+1]) {
						
					}else {
						isPossibleRow[i] = false;
					}
					if(!isPossibleRow[i])break;
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					visit[i][j] = false;
				}
			}
			for(int i=0;i<N;i++) {//col체크
				isPossibleCol[i] = true;
				for(int j=0;j<N-1;j++) {
					if(map[j][i] - map[j+1][i] == 1) {
						//j+1 ~ j+X까지 체크
						isPossibleCol[i] = check(j,i,1);
						if(isPossibleCol[i]) {
							for(int k=j+1;k<=j+X;k++) {
								visit[k][i] = true;
							}
						}
					}else if(map[j][i]-map[j+1][i]==-1) {
						//j-X+1 ~ j까지 체크
						isPossibleCol[i] = check(j,i,3);
						if(isPossibleCol[i]) {
							for(int k=j-X+1;k<=j;k++) {
								visit[k][i] = true;
							}
						}
					}else if(map[j][i] == map[j+1][i]) {
						
					}else {
						isPossibleCol[i] = false;
					}
					if(!isPossibleCol[i])break;
				}
			}
//			for(int i=0;i<N;i++) {
//				if(isPossibleRow[i])cnt++;
//				System.out.println(isPossibleRow[i]);
//			}
//			System.out.println("-----------------");
//			for(int i=0;i<N;i++) {
//				if(isPossibleCol[i])cnt++;
//				System.out.println(isPossibleCol[i]);
//			}
			for(int i=0;i<N;i++) {
				if(isPossibleRow[i])cnt++;
				if(isPossibleCol[i])cnt++;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					visit[i][j] = false;
				}
			}
			bw.write("#"+tc+" "+cnt+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static boolean check(int row, int col, int dir) {
		if(dir==0) {
			int tmp = map[row][col+1];
			if(col+X>=N)return false;
			for(int i=col+1;i<=col+X;i++) {
				if(tmp!=map[row][i] || visit[row][i]) {
					return false;
				}
			}
		}else if(dir==1){
			int tmp = map[row+1][col];
			if(row+X>=N)return false;
			for(int i=row+1;i<=row+X;i++) {
				if(tmp!=map[i][col] || visit[i][col]) {
					return false;
				}
			}
		}else if(dir==2) {
			//j-X+1 ~ j까지 체크
			int tmp = map[row][col];
			if(col-X+1<0)return false;
			for(int i=col-X+1;i<=col;i++) {
				if(tmp!=map[row][i] || visit[row][i])return false;
			}
		}else {
			int tmp = map[row][col];
			if(row-X+1<0)return false;
			for(int i=row-X+1;i<=row;i++) {
				if(tmp!=map[i][col] || visit[i][col])return false;
			}
		}
		return true;
	}
}
