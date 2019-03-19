import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution3074 {
	static long[] time = new long[100000];
	static long latestTime;
	static long worstCnt;
	static int N,M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		long left, mid, right;
		long ans;
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) { 
			latestTime = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for(int i=0;i<N;i++) {
				time[i] = Integer.parseInt(br.readLine());
				if(time[i]>latestTime)latestTime = time[i];
			}
			worstCnt = latestTime*M;
			ans = worstCnt;
			right = worstCnt;
			left = 0;
			while(left<=right) {
				mid = (left+right)/2;
				long sum = 0;
				for(int i=0;i<N;i++) {
					sum+=mid/time[i];
				}
				if(M<=sum) {
					if(mid<ans) {
						ans = mid;
					}
					right = mid-1;
				}else {
					left = mid+1;
				}
			}
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
}
