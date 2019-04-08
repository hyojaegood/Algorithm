import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14501_퇴사 {
	static int N;
	static int[] P = new int[16];
	static int[] T = new int[16];
	static int maxValue;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		maxValue = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			if(i+T[i]-1<N) {
				dfs(i,0);	
			}
		}
		System.out.println(maxValue);
	}
	public static void dfs(int idx, int current) {
		int minNext;
		current +=P[idx];
		minNext = idx+T[idx];
		for(int i=minNext;i<N;i++) {
			if(i+T[i]-1<N) {
				dfs(i,current);	
			}
		}
		if(current>maxValue)maxValue = current;
	}
}
