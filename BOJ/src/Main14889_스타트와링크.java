import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14889_스타트와링크 {
	static int N;
	static int[][] S = new int[21][21];
	static boolean[] visit = new boolean[21];
	static int[] seq = new int[21];
	static int minDif;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		minDif = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N-N/2+1;i++) {
			visit[i] = true;
			dfs(i,1);
			visit[i] = false;
		}
		System.out.println(minDif);
	}
	public static void dfs(int idx, int depth) {
		if(depth == N/2) {
			int a,b;
			int tmp;
			a=b=0;
			for(int i=0;i<N;i++) {
				if(visit[i]) {
					for(int j=0;j<N;j++) {
						if(i==j)continue;
						if(visit[j]) {
							a+=S[i][j];
							//System.out.printf("a: [%d,%d]\n",i,j);
						}
					}
				}else {
					for(int j=0;j<N;j++) {
						if(i==j)continue;
						if(!visit[j]) {
							b+=S[i][j];
							//System.out.printf("b: [%d,%d]\n",i,j);
						}
					}
				}
			}
			tmp = dif(a,b);
			if(tmp<minDif) {
				minDif = tmp;
			}
		}
		for(int i=idx+1;i<N;i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i,depth+1);
				visit[i] = false;
			}
		}
	}
	public static int dif(int a, int b) {
		if(a-b>0)return a-b;
		return b-a;
	}
}
