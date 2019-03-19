import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution6913 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T, M,N;
		int[][] map = new int[20][20];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Queue<Integer> firstGrade = new LinkedList<>();
		int maxValue;
		int tmpValue;
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			maxValue = 0;
			firstGrade.clear();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				tmpValue =0;
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						tmpValue++;
					}
				}
				if(maxValue == tmpValue) {
					firstGrade.add(i);
				}else if(maxValue<tmpValue) {
					maxValue = tmpValue;
					firstGrade.clear();
					firstGrade.add(i);
				}
			}
			bw.write("#"+tc+" "+firstGrade.size()+" "+maxValue+"\n");
			bw.flush();
		}
		bw.close();
	}

}
