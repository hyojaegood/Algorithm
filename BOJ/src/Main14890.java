import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14890 {
	static int[][] map = new int[100][100];
	static boolean[] row = new boolean[100];
	static boolean[] col = new boolean[100];
	static boolean[][] visit = new boolean[100][100];
	static int N, L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
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
				if((map[i][j]-map[i][j+1])==-1) {
					row[i] = checkUp(i,j);
				}else if((map[i][j]-map[i][j+1])==1) {
					row[i] = checkDown(i,j);
				}else if((map[i][j]-map[i][j+1])==0) {
					row[i] = true;
				}else {
					row[i] = false;
				}
				if(!row[i])break;
			}
		}
		
		System.out.println("------------------");
		for(int i=0;i<N;i++) {
			col[i] = true;
			for(int j=0;j<N-1;j++) {
				if((map[j][i]-map[j+1][i])==-1) {
					col[i] = checkUpC(j,i);
				}else if((map[j][i]-map[j+1][i])==1) {
					col[i] = checkDownC(j,i);
				}else if((map[j][i]-map[j+1][i])==0) {
					col[i] = true;
				}else {
					col[i] = false;
				}
				if(!col[i])break;
			}
		}
		for(int i=0;i<N;i++) {
			System.out.println(row[i]);
		}
		System.out.println("----------------");
		for(int i=0;i<N;i++) {
			System.out.println(col[i]);
		}
	}
	public static boolean checkUpC(int row, int col) {
		System.out.printf("up: %d, %d\n",row,col);
		int start = row-L+1;
		int end = row;
		if(start>=0) {
			for(int i=start;i<end;i++) {
				if(map[i][col]!=map[i+1][col]) {
					return false;
				}
			}
		}else {
			return false;
		}
		for(int i=start;i<=end;i++) {
			visit[i][col] = true;
		}
		return true;
	}
	public static boolean checkDownC(int row, int col) {
		System.out.printf("down: %d, %d\n",row,col);
		int start = row+1;
		int end = row+L;
		if(end<N) {
			for(int i=start;i<end;i++) {
				if(map[i][col]!=map[i+1][col]) {
					return false;
				}
			}
		}else {
			return false;
		}
		for(int i=start;i<=end;i++) {
			visit[i][col] = true;
		}
		return true;
	}
	
	public static boolean checkUp(int row, int col) {
		System.out.printf("up: %d, %d\n",row,col);
		int start = col-L+1;
		int end = col;
		if(start>=0) {
			for(int i=start;i<end;i++) {
				if(map[row][i]!=map[row][i+1]) {
					return false;
				}
			}
		}else {
			return false;
		}
		for(int i=start;i<=end;i++) {
			visit[row][i] = true;
		}
		return true;
	}
	public static boolean checkDown(int row, int col) {
		System.out.printf("down: %d, %d\n",row,col);
		int start = col+1;
		int end = col+L;
		if(end<N) {
			for(int i=start;i<end;i++) {
				if(map[row][i]!=map[row][i+1]) {
					return false;
				}
			}
		}else {
			return false;
		}
		for(int i=start;i<=end;i++) {
			visit[row][i] = true;
		}
		return true;
	}
}
