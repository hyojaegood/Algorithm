import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main15684_사다리조작 {
	static int N,M,H;
	static int[][] map = new int[31][11];
	static int horiCnt;
	static int minValue;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		horiCnt=0;
		int a, b;
		minValue = 4;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H  = Integer.parseInt(st.nextToken());
		int[][] saveMap = new int[31][11];
		for(int i=0;i<M;i++) {
			horiCnt++;
			st = new StringTokenizer(br.readLine());
			a =Integer.parseInt(st.nextToken());
			b =Integer.parseInt(st.nextToken());
			map[a][b] = map[a][b+1] = horiCnt;
		}
		if(check()) {
			bw.write("0\n");
		}else {
			for(int i=1;i<=H;i++) {
				for(int j=1;j<=N-1;j++) {
					if(map[i][j]==0 && map[i][j+1]==0) {
						for(int k=1;k<=H;k++) {
							saveMap[k] = map[k].clone();
						}
						addHori(i,j,horiCnt+1,0);
						for(int k=1;k<=H;k++) {
							map[k] = saveMap[k].clone();
						}
					}
				}
			}
			if(minValue==4) {
				bw.write("-1\n");
			}else {
				bw.write(""+minValue+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	public static boolean check() {
		int row;
		int col;
		for(int i=1;i<=N;i++) {
			row =1;
			col = i;
			while(true) {
				if(row==H+1)break;
				if(map[row][col]==0) {
					row++;	
				}else {
					if(col-1>=1 && col-1<=N) {
						if(map[row][col-1]==map[row][col]) {
							col--;
							row++;
							continue;
						}
					}
					if(col+1>=1 &&col+1<=N) {
						if(map[row][col+1]==map[row][col]) {
							col++;
							row++;
							continue;
						}
					}
				}
			}
			if(col!=i) {
				return false;
			}
		}
		return true;
	}
	public static void addHori(int row,int col, int hrCnt, int depth) {
		if(depth+1>=minValue)return;
		int[][] saveMap = new int[31][11];
		map[row][col] = map[row][col+1] = hrCnt;
		if(depth==2) {
			//체크
			if(check()) {
				if(minValue>3) {
					minValue=3;
				}
			}
			return;
		}
		//체크
		if(check()) {
			if(minValue>depth+1) {
				minValue=depth+1;
			}
			return;
		}
		//가로선 추가
		for(int i=row;i<=H;i++) {
			if(i==row) {
				for(int j=col+2;j<=N-1;j++) {
					if(map[i][j]==0 && map[i][j+1]==0) {
						for(int k=1;k<=H;k++) {
							saveMap[k] = map[k].clone();
						}
						addHori(i,j,hrCnt+1,depth+1);
						for(int k=1;k<=H;k++) {
							map[k] = saveMap[k].clone();
						}
					}
				}
			}else {
				for(int j=1;j<=N-1;j++) {
					if(map[i][j]==0 && map[i][j+1]==0) {
						for(int k=1;k<=H;k++) {
							saveMap[k] = map[k].clone();
						}
						addHori(i,j,hrCnt+1,depth+1);
						for(int k=1;k<=H;k++) {
							map[k] = saveMap[k].clone();
						}
					}
				}
			}
		}
	}
}
