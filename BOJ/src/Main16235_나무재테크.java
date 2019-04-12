import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Time;
import java.time.Clock;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Timer;

public class Main16235_나무재테크 {
	static PriorityQueue[][] trees = new PriorityQueue[11][11];
	static Queue[][] dead = new LinkedList[11][11];
	static int N,M,K;
	static int[][] map = new int[11][11];
	static int[][] A = new int[11][11];
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int x,y,age;
		long start = System.currentTimeMillis();

		st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
				trees[i][j] = new PriorityQueue<Integer>();
				dead[i][j] = new LinkedList<Integer>();
			}
		}
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			age=Integer.parseInt(st.nextToken());
			trees[x][y].add(age);
		}
		for(int i=0;i<K;i++) {
			spring();
			summer();
			fall();
			winter();
//			System.out.printf("%d년 후\n",i+1);
//			for(int r=1;r<=N;r++) {
//				for(int c=1;c<=N;c++) {
//					if(!trees[r][c].isEmpty()) {
//						System.out.printf("[%d,%d]: ",r,c);
//						System.out.println(trees[r][c]);
//					}
//				}
//			}
		}
		int result = 0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(!trees[i][j].isEmpty()) {
					result+=trees[i][j].size();
				}
			}
		}
		System.out.println(result);
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
	}
	public static void spring() {
		PriorityQueue<Integer> tmp = new PriorityQueue<>();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(!trees[i][j].isEmpty()) {
					while(true) {
						if(trees[i][j].isEmpty())break;
						if((int)trees[i][j].peek()<=map[i][j]) {
							tmp.add((int)trees[i][j].peek());
							map[i][j]-=(int)trees[i][j].poll();
						}else {
							while(!trees[i][j].isEmpty()) {
								dead[i][j].add(trees[i][j].poll());
							}
						}
					}
					while(!tmp.isEmpty()) {
						trees[i][j].add((tmp.poll()+1));
					}
				}
			}
		}
	}
	public static void summer() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				while(!dead[i][j].isEmpty()) {
					map[i][j]+=((int)dead[i][j].poll())/2;
				}
			}
		}
	}
	public static void fall() {
		PriorityQueue<Integer> tmp = new PriorityQueue<>();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(!trees[i][j].isEmpty()) {
					//size만큼 1짜리 나무 추가
					int cnt = 0;
					while(!trees[i][j].isEmpty()) {
						if(((int)trees[i][j].peek())%5==0) {
							cnt++;
						}
						tmp.add((int)trees[i][j].poll());
					}
					for(int k=0;k<8;k++) {
						int nextR = i+dr[k];
						int nextC = j+dc[k];
						if(nextR>=1 && nextR<=N && nextC>=1 && nextC<=N) {
							for(int t=0;t<cnt;t++) {
								trees[nextR][nextC].add(1);
							}
						}
					}
					while(!tmp.isEmpty()) {
						trees[i][j].add(tmp.poll());
					}
				}
			}
		}
	}
	public static void winter() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				map[i][j]+=A[i][j];
			}
		}
	}
}
