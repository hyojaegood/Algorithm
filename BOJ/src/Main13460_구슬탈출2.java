import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main13460_구슬탈출2 {
	static int N,M;
	static char[][] map = new char[11][11];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int minDepth;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String in;
		char[][] oriMap = new char[11][11];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minDepth = N*M;
		for(int i=0;i<N;i++) {
			in = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = in.charAt(j);
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<N;j++) {
				oriMap[j] = map[j].clone();
			}
			move(i,1);
			
			for(int j=0;j<N;j++) {
				map[j] = oriMap[j].clone();
			}
		}
		
		if(minDepth==N*M) {
			bw.write("-1\n");
		}else {
			bw.write(""+minDepth+"\n");
		}
		bw.flush();
		bw.close();
	}
	public static boolean push(int dir, int depth) {//파란색 공이 구멍에 빠질 경우, false
		int tmp = -1;
		if(dir==0) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]=='R'||map[i][j]=='B') {
						int target =-1;
						for(int k=i-1;k>=0;k--) {
							if(map[k][j]=='.') {
								target = k;
							}else if(map[k][j]=='O') {
								if(map[i][j]=='B') {
									return false;
								}else {
									if(depth<minDepth) {
										map[i][j] = '.';
										tmp = depth;
									}
								}
							}else {//벽이나 구슬을 만난 경우
								break;
							}
						}
						if(target>=0&& tmp<0) {
							map[target][j] =map[i][j];
							map[i][j] = '.';
						}
					}
				}
			}
		}else if(dir==1) {
			for(int i=N-1;i>=0;i--) {
				for(int j=0;j<M;j++) {
					if(map[i][j]=='R'||map[i][j]=='B') {
						int target =-1;
						for(int k=i+1;k<N;k++) {
							if(map[k][j]=='.') {
								target = k;
							}else if(map[k][j]=='O') {
								if(map[i][j]=='B') {
									return false;
								}else {
									if(depth<minDepth) {
										map[i][j] = '.';
										tmp = depth;
									}
								}
							}else {//벽이나 구슬을 만난 경우
								break;
							}
						}
						if(target>=0&& tmp<0) {
							map[target][j] = map[i][j];
							map[i][j] = '.';
						}
					}
				}
			}
		}else if(dir==2) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]=='R'||map[i][j]=='B') {
						int target =-1;
						for(int k=j-1;k>=0;k--) {
							if(map[i][k]=='.') {
								target = k;
							}else if(map[i][k]=='O') {
								if(map[i][j]=='B') {
									//System.out.printf("%d[%d,%d]:%c\n",dir,i,j,map[i][j]);
									return false;
								}else {
									if(depth<minDepth) {
										map[i][j] = '.';
										tmp = depth;
									}
								}
							}else {//벽이나 구슬을 만난 경우
								break;
							}
						}
						if(target>=0&& tmp<0) {
							map[i][target] = map[i][j];
							map[i][j] = '.';
						}
					}
				}
			}
		}else {
			for(int i=0;i<N;i++) {
				for(int j=M-1;j>=0;j--) {
					if(map[i][j]=='R'||map[i][j]=='B') {
						int target =-1;
						for(int k=j+1;k<M;k++) {
							if(map[i][k]=='.') {
								target = k;
							}else if(map[i][k]=='O') {
								if(map[i][j]=='B') {
									return false;
								}else {
									if(depth<minDepth) {
										map[i][j] = '.';
										tmp = depth;
									}
								}
							}else {//벽이나 구슬을 만난 경우
								break;
							}
						}
						if(target>=0 && tmp<0) {
							map[i][target] = map[i][j];
							map[i][j] = '.';
						}
					}
				}
			}
		}
		if(tmp>0) {
			minDepth = tmp;
		}
		return true;
	}
	public static void move(int dir, int depth) {
		//System.out.println(minDepth);
		char[][] saveMap = new char[11][11];
		if(depth>10) {//이동 횟수가 10번을 넘은 경우
			return;
		}
		if(depth>minDepth)return;
		//이동
		if(!push(dir,depth)) {//파란 구슬이 구멍에 빠지는 경우
			return;
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<N;j++) {
				saveMap[j] = map[j].clone();
			}
			move(i,depth+1);
			for(int j=0;j<N;j++) {
				map[j] = saveMap[j].clone();
			}
		}
	}
}
