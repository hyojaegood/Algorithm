import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution7193 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N, T;
		String X;
		int len;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		int sum;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = st.nextToken();
			len = X.length();
			sum = 0;
			for(int i=len;i>0;i--) {
				sum+=Integer.parseInt(X.substring(i-1, i))%(N-1);
				sum = sum%(N-1);
			}
			bw.write("#"+tc+" "+sum+"\n");
			bw.flush();
		}
		bw.close();
	}
}
