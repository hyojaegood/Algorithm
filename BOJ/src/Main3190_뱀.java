import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main3190_뱀 {
	static int map[][] = new int[101][101];
	static int move[][] = new int[100][2];//time, dir
	static int snake[][] = new int[10000][2];//row, col => 0번째가 머리
	static int showMap[][] = new int[101][101];
	static int sLen;
	static int N;
	static int L;
	static int K;
	static int dir;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String in;
		int time;
		int lCnt = 0;
		boolean isCrush = false;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		L = Integer.parseInt(br.readLine());
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			move[i][0] = Integer.parseInt(st.nextToken());
			move[i][1] = st.nextToken().charAt(0);
		}
		sLen = 1;
		snake[0][0] = 1;
		snake[0][1] = 1;
		time = 0;
		dir=1;
		while(!isCrush) {
			time++;
			//머리를 늘려 다음칸에 위치시킴
			int tmpR, tmpC;
			int tR1, tC1, tR2, tC2;
			tmpR = snake[0][0]+dr[dir];
			tmpC = snake[0][1]+dc[dir];
			if(tmpR<=N && tmpR>=1 && tmpC<=N && tmpC>=1) {
				//자신의 몸과 충돌하는지 체크
				for(int i=1;i<sLen;i++) {
					if(tmpR==snake[i][0] && tmpC==snake[i][1]) {
						isCrush = true;
						break;
					}
				}
				if(isCrush)break;
				if(map[tmpR][tmpC]==1) {//사과가 있다면 꼬리는 움직이지 않음
					tR2 = tmpR;
					tC2 = tmpC;
					for(int i=0;i<sLen;i++) {
						tR1 = snake[i][0];
						tC1 = snake[i][1];
						snake[i][0] = tR2;
						snake[i][1] = tC2;
						tR2 = tR1;
						tC2 = tC1;
					}
					sLen++;
					snake[sLen-1][0] = tR2;
					snake[sLen-1][1] = tC2;
					map[tmpR][tmpC] = 0;
				}else{//사과가 없다면 꼬리가 위치한 칸을 비워줌
					tR2 = tmpR;
					tC2 = tmpC;
					for(int i=0;i<sLen;i++) {
						tR1 = snake[i][0];
						tC1 = snake[i][1];
						snake[i][0] = tR2;
						snake[i][1] = tC2;
						tR2 = tR1;
						tC2 = tC1;
					}
				}
			}else {//벽에 충돌하는 경우
				break;
			}
			
//			
//			for(int i=1;i<=N;i++) {
//				for(int j=1;j<=N;j++) {
//					showMap[i][j] = map[i][j];
//				}
//			}
//			for(int i=0;i<sLen;i++) {
//				showMap[snake[i][0]][snake[i][1]] = 3;
//			}
//			System.out.println(time);
//			for(int i=1;i<=N;i++) {
//				for(int j=1;j<=N;j++) {
//					System.out.printf("%d",showMap[i][j]);
//				}System.out.println();
//			}
//			System.out.println("------------------");
//			for(int i=1;i<=N;i++) {
//				for(int j=1;j<=N;j++) {
//					showMap[i][j] = 0;
//				}
//			}
			if(move[lCnt][0]==time) {
				if(move[lCnt][1]=='D') {
					dir =dir+1;
					if(dir==4)dir=0;
				}else {
					dir = dir-1;
					if(dir<0)dir=3;
				}
				lCnt++;
			}
		}
		System.out.println(time);
	}

}
