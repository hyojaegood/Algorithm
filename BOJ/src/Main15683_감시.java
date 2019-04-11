import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main15683_감시 {
	static String[][] cctvInfo = {
			{""},
			{"0", "1","2","3"},
			{"12", "03"},
			{"01", "13","23","02"},
			{"012", "013","123","023"},
			{"0123"}
	};
	static int[][] cctv = new int[9][3];//row,col, cctvNum
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,1,-1,0};
	static int N,M;
	static int[][] map = new int[9][9];
	static int cnt;
	static int minValue;
	static int[] dir = new int[9];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		cnt = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minValue = N*M;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>=1 && map[i][j]<6) {
					cctv[cnt][0] = i;
					cctv[cnt][1] = j;
					cctv[cnt][2] = map[i][j];
					cnt++;
				}
			}
		}
		if(cnt==0) {
			minValue = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==0) {
						minValue++;
					}
				}
			}
		}else {
			for(int i=0;i<cctvInfo[cctv[0][2]].length;i++) {
				setTv(i, 0);
			}
		}
		System.out.println(minValue);
	}
	public static void setTv(int d, int depth) {
		dir[depth] = d;
		if(depth==cnt-1) {
//			for(int i=0;i<cnt;i++) {
//				System.out.printf("%d ",dir[i]);
//			}System.out.println();
			int value = 0;
			for(int i=0;i<cnt;i++) {
				int row = cctv[i][0];
				int col = cctv[i][1];
				for(int j=0;j<cctvInfo[cctv[i][2]][dir[i]].length();j++) {
					int tmp = cctvInfo[cctv[i][2]][dir[i]].charAt(j)-'0';
					int nextR = row+dr[tmp];
					int nextC = col+dc[tmp];
					while(true) {
						if(nextR>=0 && nextR<N && nextC>=0 && nextC<M) {
							if(map[nextR][nextC]==6)break;
							if(map[nextR][nextC]==0)map[nextR][nextC]=7;
						}else {
							break;
						}
						nextR = nextR+dr[tmp];
						nextC = nextC+dc[tmp];
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==0)value++;
					if(value>=minValue)break;
				}
				if(value>=minValue)break;
			}
			if(value<minValue)minValue = value;
			for(int i=0;i<cnt;i++) {
				int row = cctv[i][0];
				int col = cctv[i][1];
				for(int j=0;j<cctvInfo[cctv[i][2]][dir[i]].length();j++) {
					int tmp = cctvInfo[cctv[i][2]][dir[i]].charAt(j)-'0';
					int nextR = row+dr[tmp];
					int nextC = col+dc[tmp];
					while(true) {
						if(nextR>=0 && nextR<N && nextC>=0 && nextC<M) {
							if(map[nextR][nextC]==6)break;
							if(map[nextR][nextC]==7)map[nextR][nextC]=0;
						}else {
							break;
						}
						nextR = nextR+dr[tmp];
						nextC = nextC+dc[tmp];
					}
				}
			}
			return;
		}
		for(int i=0;i<cctvInfo[cctv[depth+1][2]].length;i++) {
			setTv(i, depth+1);
		}
	}

}
