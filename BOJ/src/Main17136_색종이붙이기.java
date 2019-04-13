import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main17136_색종이붙이기 {
	static int[][] map = new int[11][11];
	static boolean[][] covered = new boolean[11][11];
	static int[] cnt = {0,5,5,5,5,5};
	static int min;
	static int[][] seq = new int[1000][3];
	static int time;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		time =0;
		boolean isZero = true;
		for(int i=1;i<=10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)isZero=false;
			}
		}
		if(isZero) {
			System.out.println("0");
			return;
		}
		min = 12345678;
		int startR = 0, startC = 0;
		boolean find = false;
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				if(map[i][j]==1 && !covered[i][j]) {
					startR = i;
					startC = j;
					find = true;
					break;
				}
			}
			if(find)break;
		}
		for(int k=5;k>=1;k--) {
			if(check(startR,startC,k)) {
				cnt[k]--;
				cover(startR,startC,k, 1);
				deCover(startC,startC,k);
				cnt[k]++;	
			}
		}
		if(min==12345678) {
			System.out.println("-1");
		}else {
			System.out.println(min);	
		}
	}
	public static boolean isDone() {
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				if(map[i][j]==1 && !covered[i][j])return false;
			}
		}
		return true;
	}
	public static void deCover(int row, int col, int size) {
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				covered[i][j] = false;
			}
		}
	}

	public static void cover(int row, int col, int size, int depth) {
		if(depth>=min)return;
		for(int i=row;i<=row+size-1;i++) {
			for(int j=col;j<=col+size-1;j++) {
				covered[i][j] = true;
			}
		}
		int r=0,c=0;
		boolean find = false;
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				if(map[i][j]==1 && !covered[i][j]) {
					r = i;
					c = j;
					find = true;
					break;
				}
			}
			if(find)break;
		}
		if(!find) {
			if(isDone()) {
				int result =0;
				for(int i=1;i<=5;i++) {
					result+=(5-cnt[i]);
				}
				if(result<min)min=result;
			}
			return;
		}
		for(int k=5;k>=1;k--) {
			if(check(r,c,k)) {
				if(cnt[k]>0) {
					cnt[k]--;
					cover(r,c,k, depth+1);
					deCover(r,c,k);
					cnt[k]++;		
				}
			}
		}
	}
	public static boolean check(int row, int col, int size) {
		for(int i=row;i<=row+size-1;i++) {
			for(int j=col;j<=col+size-1;j++) {
				if(i>10 || j>10)return false;
				if(map[i][j]==0 || covered[i][j])return false;
			}
		}
		return true;
	}
}
