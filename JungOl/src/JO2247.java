import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JO2247 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N;
		int[][] info;
		int[] time = new int[2147483647];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		info = new int[N][2];
		int firstTime = 2147483647;
		int lastTime = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				info[i][j] = Integer.parseInt(st.nextToken())-1;
			}
			for(int j=info[i][0];j<=info[i][1];j++) {
				time[j]++;
			}
			if(firstTime>info[i][0])firstTime = info[i][0];
			if(lastTime<info[i][1])lastTime = info[i][1];
		}
		int maxStayTime = 0;
		int maxEmptyTime = 0;
		int tmp1 = 0;
		int tmp2 = 0;
		for(int i=firstTime;i<=lastTime;i++) {
			if(time[i]>0) {
				tmp1++;
				if(tmp2>maxEmptyTime) {
					maxEmptyTime = tmp2;
				}
				tmp2 = 0;
			}
			if(time[i]==0) {
				tmp2++;
				if(tmp1>maxStayTime) {
					maxStayTime = tmp1;
				}
				tmp1 = 0;
			}
		}
	}
}
