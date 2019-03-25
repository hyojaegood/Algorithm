import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class J1077 {
	static int[] d = new int[10001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N, W;
		int[] p = new int[1000];
		int[] w = new int[1000];
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=W;i++) {
			for(int j=0;j<N;j++) {
				if(i-w[j]>=0) {
					d[i] = max(d[i],d[i-w[j]]+p[j]);	
				}
			}
		}
		bw.write(""+d[W]);
		bw.flush();
		bw.close();
	}
	public static int max(int a,int b) {
		if(a>b)return a;
		return b;
	}
}
