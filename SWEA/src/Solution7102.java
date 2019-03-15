import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7102 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T, N, M;
		int[] count = new int[41];
		int maxValue;
		int qSize;
		Queue<Integer> idxs = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			maxValue = 0;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					count[i+j]++;
				}
			}
			for(int i=2;i<=N+M;i++) {
				if(count[i]>maxValue) {
					idxs.clear();
					idxs.add(i);
					maxValue = count[i];
				}else if(count[i] == maxValue) {
					idxs.add(i);
					maxValue = count[i];
				}
				count[i] = 0;
			}
			bw.write("#"+tc+" ");
			bw.flush();
			qSize = idxs.size();
			for(int i=0;i<qSize;i++) {
				bw.write(idxs.poll()+" ");
				bw.flush();
			}bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
}
