import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16236_아기상어 {
	static int N;
	static int r,c,size,eatCnt;
	static int[][] map = new int[21][21];
	static boolean[][] visit = new boolean[21][21];
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,-1,1,0};
	static int time;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					r = i;
					c = j;
					size = 2;
					eatCnt = 0;
					map[i][j] = 0;
				}
			}
		}
		time = 0;
		while(true) {
			if(!check()) {
				break;
			}
		}
		System.out.println(time);
	}
	public static boolean check() {
		Queue<loc> q = new LinkedList<>();
		q.add(new loc(r,c));
		int t=0;
		boolean isExist = false;
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				visit[r][c] = false;
			}
		}
		while(!q.isEmpty()) {
			int qSize = q.size();
			int nextR, nextC;
			t++;
			int candR=0;
			int candC=0;

			for(int i=0;i<qSize;i++) {
				for(int k=0;k<4;k++) {
					nextR = q.peek().r+dr[k];
					nextC = q.peek().c+dc[k];
					if(nextR>=1&&nextR<=N && nextC>=1 && nextC<=N) {
						if(map[nextR][nextC]<size && map[nextR][nextC]!=0) {
							isExist = true;
							if(candR== 0 && candC ==0) {
								candR = nextR;
								candC = nextC;	
							}else {
								if(nextR<candR) {
									candR = nextR;
									candC = nextC;
								}else if(nextR == candR) {
									if(nextC<candC) {
										candR = nextR;
										candC = nextC;
									}
								}
							}
						}else if((map[nextR][nextC]==size || map[nextR][nextC]==0)&&!visit[nextR][nextC]) {
							visit[nextR][nextC] = true;
							q.add(new loc(nextR,nextC));
						}
					}
				}
				q.poll();
			}
			if(isExist) {
				eatCnt++;
				if(eatCnt==size) {
					size++;
					eatCnt=0;
				}
				map[candR][candC] = 0;
				r = candR;
				c = candC;
				time+=t;
				return true;
			}
		}
		return false;
	}

}
