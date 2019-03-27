import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ11508_2플러스1세일 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		int[] cost;
		int cnt = 0;
		int sum = 0;
		N = Integer.parseInt(br.readLine());
		cost = new int[N];
		for(int i=0;i<N;i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(cost);
		for(int i=N-1;i>=0;i--) {
			cnt++;
			if(cnt%3!=0) {
				sum+=cost[i];
			}
		}
		bw.write(""+sum+"\n");
		bw.flush();
		bw.close();
	}

}
