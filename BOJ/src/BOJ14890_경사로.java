import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ14890_경사로 {
	static int[][] map = new int[100][100];
	static boolean[] row = new boolean[100];
	static boolean[] col = new boolean[100];
	static boolean[][] visit = new boolean[100][100];
	static int N, L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			row[i] = true;
			for(int j=0;j<N-1;j++) {
				 if(map[i][j]-map[i][j+1]==1) {
					 row[i] = makeRow(i,j,1);
				 }else if(map[i][j]-map[i][j+1]==-1) {
					 row[i] = makeRow(i,j,0);
				 }else if(map[i][j]-map[i][j+1]==0) {
					 
				 }else {
					 row[i] = false;
				 }
				 if(!row[i]) {
					 break;
				 }
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				visit[i][j] = false;
			}
		}
		for(int i=0;i<N;i++) {
			col[i] = true;
			for(int j=0;j<N-1;j++) {
				 if(map[j][i]-map[j+1][i]==1) {
					 col[i] = makeCol(j,i,1);
				 }else if(map[j][i]-map[j+1][i]==-1) {
					 col[i] = makeCol(j,i,0);
				 }else if(map[j][i]-map[j+1][i]==0) {
					 
				 }else {
					 col[i] = false;
				 }
				 if(!col[i]) {
					 break; 
				 }
			}
		}
		for(int i=0;i<N;i++) {
			if(row[i])cnt++;
		}
		for(int i=0;i<N;i++) {
			if(col[i])cnt++;
		}
		bw.write(""+cnt);
		bw.flush();
		bw.close();
	}
	public static boolean makeRow(int row, int col, int dir) {
		int start, end;
		if(dir==0) {
			start = col-L+1;
			end = col;
			if(start<0)return false;
			if(start==end) {
				if(visit[row][start])return false;
			}
			for(int i=start;i<end;i++) {
				if(map[row][i]!=map[row][i+1] || visit[row][i]||visit[row][i+1]) {
					return false;
				}
			}
		}else {
			start = col+1;
			end = col+L;
			if(end>=N)return false;
			if(start==end) {
				if(visit[row][start])return false;
			}
			for(int i=start;i<end;i++) {
				if(map[row][i]!=map[row][i+1] || visit[row][i]||visit[row][i+1]) {
					return false;
				}
			}
		}
		for(int i=start;i<=end;i++) {
			visit[row][i] = true;
		}
		return true;//만들 수 있음
	}
	public static boolean makeCol(int row, int col, int dir) {
		int start, end;
		if(dir==0) {
			start = row-L+1;
			end = row;
			if(start<0)return false;
			if(start==end) {
				if(visit[start][col])return false;
			}
			for(int i=start;i<end;i++) {
				if(map[i][col]!=map[i+1][col] || visit[i][col]||visit[i+1][col]) {
					return false;
				}
			}
		}else {
			start = row+1;
			end = row+L;
			if(end>=N)return false;
			if(start==end) {
				if(visit[start][col])return false;
			}
			for(int i=start;i<end;i++) {
				if(map[i][col]!=map[i+1][col] || visit[i][col]||visit[i+1][col]) {
					return false;
				}
			}
		}
		for(int i=start;i<=end;i++) {
			visit[i][col] = true;
		}
		return true;//만들 수 있음
	}
}
