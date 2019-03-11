import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution5648 {
	static int[][] map = new int[4001][4001];
	static int[][] atom = new int[1001][4];//x,y,dir,energy
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int N;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			sum = 0;
			N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<4;j++) {
					if(j<2) {
						atom[i][j] = Integer.parseInt(st.nextToken())*2+2000;	
					}else {
						atom[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				map[atom[i][1]][atom[i][0]] = atom[i][3];
			}
//			for(int i=0;i<N;i++) {
//				System.out.printf("[%d] %d,%d\n",i,atom[i][0],atom[i][1]);
//			}
			while(isExist()) {
				move();
			}
			bw.write("#"+tc+" "+sum+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static void move() {
		int tmp1,tmp2;
		for(int i=0;i<N;i++) {
			if(atom[i][3]!=0) {
				map[atom[i][1]][atom[i][0]] -=atom[i][3];
				tmp1= atom[i][0]+dx[atom[i][2]];
				tmp2= atom[i][1]+dy[atom[i][2]];
				if(tmp1>=0 && tmp1<=4000 && tmp2>=0 && tmp2<=4000) {
					atom[i][0] = tmp1;
					atom[i][1] = tmp2;
					map[atom[i][1]][atom[i][0]] +=atom[i][3];
				}else {
					//map[atom[i][1]][atom[i][0]] -= atom[i][3];
					atom[i][3] = 0;
				}
			}
		}
		for(int i=0;i<N;i++) {
			if(atom[i][3]!=0 && atom[i][3]!=map[atom[i][1]][atom[i][0]]) {
				sum +=atom[i][3];
				atom[i][3] = 0;
				map[atom[i][1]][atom[i][0]] = 0;
				//System.out.printf("[%d] %d,%d\n",i,atom[i][0],atom[i][1]);
			}
		}
	}
	public static boolean isExist() {
		boolean result = false;
		for(int i=0;i<N;i++) {
			if(atom[i][3]!=0) {
				result = true;
				break;
			}
		}
		return result;
	}
}
