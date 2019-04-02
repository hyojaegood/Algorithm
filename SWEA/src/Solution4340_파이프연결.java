import java.util.Scanner;

public class Solution4340_파이프연결 {
	static int N;
	static int[][] map = new int[50][50];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int minDis;
	static boolean[][] visit = new boolean[50][50];
	static int[][] result = new int[1000][2];
	public static void main(String[] args){
		// TODO Auto-generated method stub
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			minDis = N*N;
			visit[0][0] = true;
			move(0,0,3,1);
			visit[0][0] = false;
			System.out.printf("#%d %d\n",tc, minDis);
		}
	}
	public static boolean check(int row, int col, int dir) {
		if(visit[row][col])return false;
		if(map[row][col]==0)return false;
		if(map[row][col]==1) {
			if(dir!=2 && dir!=3)return false;
		}else if(map[row][col]==2) {
			if(dir!=0 && dir!=1)return false;
		}else if(map[row][col]==3) {
			if(dir!=2 && dir!=0)return false;
		}else if(map[row][col]==4) {
			if((dir!=3 && dir!=0))return false;
		}else if(map[row][col]==5) {
			if(dir!=3 && dir!=1)return false;
		}else if(map[row][col]==6) {
			if(dir!=1 && dir!=2)return false;
		} 
		return true;
	}
	public static int changeDir(int row, int col, int dir) {
		if(map[row][col]==1) {
			dir = dir;
		}else if(map[row][col]==2) {
			dir = dir;
		}else if(map[row][col]==3) {
			if(dir==0)dir = 3;
			else dir =1;
		}else if(map[row][col]==4) {
			if(dir==3)dir = 1;
			else dir =2;
		}else if(map[row][col]==5) {
			if(dir==3)dir = 0;
			else dir =2;
		}else if(map[row][col]==6) {
			if(dir==1)dir = 3;
			else dir =0;
		}
		return dir;
	}
	public static void move(int row, int col, int dir, int depth) {
		int nextR, nextC;
		if(depth>minDis)return;
//		result[depth][0] = row;
//		result[depth][1] = col;
		if(row==N-1 && col==N-1) {
			if(minDis>depth) {
				minDis=depth;
			}
			return;
		}
		dir = changeDir(row, col, dir);
		//다음 방문할 파이프의 좌표
		nextR = row+dr[dir];
		nextC = col+dc[dir];
		if(nextR>=0 && nextR<N && nextC<N && nextC>=0) {
			int pipe = map[nextR][nextC];
			if(nextR == N-1 && nextC == N-1) {
				if(check(nextR,nextC,dir)) {
					visit[nextR][nextC] = true;
					move(nextR,nextC,dir,depth+1);
					visit[nextR][nextC] = false;
				}
			}else if(map[nextR][nextC]==1 || map[nextR][nextC] == 2) {
				map[nextR][nextC] = 1;
				if(check(nextR,nextC,dir)) {
					visit[nextR][nextC] = true;
					move(nextR,nextC,dir,depth+1);
					visit[nextR][nextC] = false;
				}
				map[nextR][nextC] = 2;
				if(check(nextR,nextC,dir)) {
					visit[nextR][nextC] = true;
					move(nextR,nextC,dir,depth+1);
					visit[nextR][nextC] = false;
				}
			}else if(map[nextR][nextC]==3 || map[nextR][nextC]==4 || map[nextR][nextC]==5 ||map[nextR][nextC]==6) {
				map[nextR][nextC] = 3;
				if(check(nextR,nextC,dir)) {
					visit[nextR][nextC] = true;
					move(nextR,nextC,dir,depth+1);
					visit[nextR][nextC] = false;
				}
				map[nextR][nextC] = 4;
				if(check(nextR,nextC,dir)) {
					visit[nextR][nextC] = true;
					move(nextR,nextC,dir,depth+1);
					visit[nextR][nextC] = false;
				}
				map[nextR][nextC] = 5;
				if(check(nextR,nextC,dir)) {
					visit[nextR][nextC] = true;
					move(nextR,nextC,dir,depth+1);
					visit[nextR][nextC] = false;
				}
				map[nextR][nextC] = 6;
				if(check(nextR,nextC,dir)) {
					visit[nextR][nextC] = true;
					move(nextR,nextC,dir,depth+1);
					visit[nextR][nextC] = false;
				}
			}
			map[nextR][nextC] = pipe;
		}
	}
	
}
