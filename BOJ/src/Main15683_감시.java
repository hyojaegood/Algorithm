import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main15683_감시 {
	static String[][] cctv = {
			{""},
			{"0", "1","2","3"},
			{"12", "03"},
			{"01", "13","23","12"},
			{"231", "013","123","023"},
			{"0123"}
	};
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,1,-1,0};
	static int N,M;
	static int[][] map = new int[9][9];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>=1 && map[i][j]<6) {
					for(int k=0;k<cctv[map[i][j]].length;k++) {
						setTv(i,j,k);
					}
				}
			}
		}
	}
	public static void setTv(int row,int col, int dir) {
		int cctvNum = map[row][col];
		int dirCnt = cctv[cctvNum][dir].length();
		int d;
		for(int i=0;i<dirCnt;i++) {
			d = cctv[cctvNum][dir].charAt(i)-'0';
			int nextR = row+dr[d];
			int nextC = col+dc[d];
			while(true) {
				if(nextR>=0 && nextR<N && nextC>=0 && nextC<M) {
					if(map[nextR][nextC]==0) {
						map[nextR][nextC] = 7;
					}else if(map[nextR][nextC]==6) {
						break;
					}
				}else {
					break;
				}
			}
			for(int r=row;r<N;r++) {
				if(r==row) {
					for(int c=col+1;c<M;c++) {
						if(map[r][c]>=1 && map[r][c]<6) {
							for(int k=0;k<cctv[map[r][c]].length;k++) {
								setTv(r,c,k);
							}
						}
					}
				}else {
					for(int c=0;c<M;c++) {
						if(map[r][c]>=1 && map[r][c]<6) {
							for(int k=0;k<cctv[map[r][c]].length;k++) {
								setTv(r,c,k);
							}
						}
					}
				}
			}
		}
	}

}
