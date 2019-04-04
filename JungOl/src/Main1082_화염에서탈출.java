import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1082_화염에서탈출 {
	static int R, C;
	static int homeR,homeC,fireR,fireC,startR,startC;
	static char[][] map = new char[50][50];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int t;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String input;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		t = 0;
		for(int i=0;i<R;i++) {
			input = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j]=='S') {
					startR = i;
					startC = j;
				}else if(map[i][j]=='D') {
					homeR = i;
					homeC = j;
				}
			}
			
		}
		bfs();
		if(!flag) {
			bw.write(""+t);
		}else {
			bw.write("impossible\n");
		}
		bw.flush();
		bw.close();
	}
	public static void bfs() {
		Queue<location> qFire = new LinkedList<location>();
		Queue<location> qHuman = new LinkedList<location>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='*') {
					qFire.add(new location(i,j));			
				}
			}
		}
		qHuman.add(new location(startR,startC));
		int tmpR, tmpC;
		flag = true;
		while(flag && !qHuman.isEmpty()) {
			t++;
			int qSize1 = qFire.size();
			for(int i=0;i<qSize1;i++) {
				for(int j=0;j<4;j++) {
					tmpR = qFire.peek().r + dr[j];
					tmpC = qFire.peek().c + dc[j];
					if(tmpR<R && tmpR>=0 && tmpC<C && tmpC>=0) {
						if(map[tmpR][tmpC]=='.') {
							map[tmpR][tmpC] = '*';
							qFire.add(new location(tmpR, tmpC));
						}
					}
				}
				qFire.poll();
			}
			int qSize2 = qHuman.size();
			for(int i=0;i<qSize2;i++) {
				for(int j=0;j<4;j++) {
					tmpR = qHuman.peek().r + dr[j];
					tmpC = qHuman.peek().c + dc[j];
					if(tmpR<R && tmpR>=0 && tmpC<C && tmpC>=0) {
						if(map[tmpR][tmpC]=='.') {
							map[tmpR][tmpC] = 'S';
							qHuman.add(new location(tmpR, tmpC));
						}
						if(map[tmpR][tmpC]=='D') {
							flag = false;
						}
					}
				}
				qHuman.poll();
			}
//			System.out.printf("%d분후\n",t);
//			for(int i=0;i<R;i++) {
//				for(int j=0;j<C;j++) {
//					System.out.printf("%c",map[i][j]);
//				}System.out.println();
//			}
		}
		//불이동
		//용자이동
	}
}
class location{
	int r;
	int c;
	location(int row, int col){
		r = row;
		c = col;
	}
}
