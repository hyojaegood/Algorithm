import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution7208 {
	static int[][] adj = new int[8][8];
	static int[] color = {1,2,3,4};
	static int[] firstColor = new int[8];
	static int[] changedColor = new int[8];
	static int N;
	static int minValue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			minValue = 8;
			for(int i=0;i<N;i++) {
				firstColor[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					adj[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=1;i<=4;i++) {
				paint(0,i);
			}
			bw.write("#"+tc+" "+minValue+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static void paint(int idx, int color) {
		changedColor[idx] = color;
		int tmp;
		if(idx == N-1) {
			if(isValid()) {
				tmp = changedColorCount();
//				for(int i=0;i<N;i++) {
//					System.out.printf("%d ",changedColor[i]);
//				}System.out.println();
				if(tmp<minValue) {
					minValue = tmp;
				}
			}
		}else {
			for(int i=1;i<=4;i++) {
				paint(idx+1,i);	
			}
		}
	}
	public static boolean isValid() {
		boolean result = true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(adj[i][j]==1) {
					if(changedColor[i] == changedColor[j]) {
						result = false;
						break;
					}
				}
			}
			if(!result)break;
		}
		return result;
	}
	public static int changedColorCount() {
		int result = 0;
		for(int i=0;i<N;i++) {
			if(firstColor[i]!=changedColor[i]) {
				result++;
			}
		}
		return result;
	}
}
