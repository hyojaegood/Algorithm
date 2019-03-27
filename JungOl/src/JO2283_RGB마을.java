import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JO2283_RGB마을 {
	static int N;
	static int[][] cost;
	static int minValue;
	static int[][] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		d = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minValue = Integer.MAX_VALUE;
		d[0][0] = cost[0][0];
		d[0][1] = cost[0][1];
		d[0][2] = cost[0][2];
		d[N-1][2] = dp(N-1, 2);
		d[N-1][1] = dp(N-1, 1);
		d[N-1][0] = dp(N-1, 0);
//		for(int i=1;i<N;i++) {
//			int tmp = Integer.MAX_VALUE;
//			tmp = min(tmp, d[i-1][1] + cost[i][0]);
//			tmp = min(tmp, d[i-1][2] + cost[i][0]);
//			d[i][0] = tmp;
//			tmp = Integer.MAX_VALUE;
//			tmp = min(tmp, d[i-1][0] + cost[i][1]);
//			tmp = min(tmp, d[i-1][2] + cost[i][1]);
//			d[i][1] = tmp;
//			tmp = Integer.MAX_VALUE;
//			tmp = min(tmp, d[i-1][1] + cost[i][2]);
//			tmp = min(tmp, d[i-1][0] + cost[i][2]);
//			d[i][2] = tmp;
//		}
		minValue = min(d[N-1][2],min(d[N-1][0],d[N-1][1]));
		System.out.println(minValue);
	}
	public static int dp(int n, int color) {
		if(d[n][color]>0) {
			return d[n][color];
		}else {
			int tmp1, tmp2;
			tmp1 = Integer.MAX_VALUE;
			for(int i=0;i<3;i++) {
				if(i!=color) {
					tmp1 = min(tmp1,dp(n-1,i)+cost[n][color]);
				}
			}
			d[n][color] = tmp1;
			return d[n][color];
		}
	}
	public static int min(int a, int b) {
		if(a<b)return a;
		else return b;
	}
	public static void dfs(int idx, int color, int c) {
		c += cost[idx][color];
		if(idx==N-1) {
			if(c<minValue) {
				minValue =c;
			}
			return;
		}
		if(c>=minValue) {
			return;
		}
		for(int i=0;i<3;i++) {
			if(i!=color) {
				dfs(idx+1,i,c);
			}
		}
	}

}
