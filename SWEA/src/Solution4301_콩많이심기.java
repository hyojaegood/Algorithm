import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4301_콩많이심기 {
	static int N,M;
	static int totalEA;
	static int[][] map = new int[1000][1000];
	static int[] dr = {2,-2,0,0};
	static int[] dc = {0,0,2,-2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int cnt;
		int result;
		int tmp1, tmp2;
		for(int tc=1;tc<=T;tc++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					for(int k=0;k<4;k++) {
						tmp1 = i+dr[k];
						tmp2 = j+dc[k];
						if(map[i][j]==0 && tmp1<M && tmp1>=0 && tmp2<N && tmp2>=0) {
							map[tmp1][tmp2] = 1;
						}
					}
				}
			}
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==1) {
						map[i][j] = 0;
						cnt++;
					}
				}
			}
			result = N*M-cnt;
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		bw.close();
	}
}
