import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6808 {
	static int[] kyu = new int[9];
	static int[] in= new int[9];
	static int[] initValue = new int[9];
	static boolean[] visit = new boolean[9];
	static boolean[] check = new boolean[19];
	static int winCnt, loseCnt;
	static int cCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			winCnt = loseCnt = 0;
			cCnt = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
				check[kyu[i]] = true;
			}
			int initIdx = 0;
			for(int i=1;i<=18;i++) {
				if(!check[i]) {
					initValue[initIdx] =i;
					check[i] = true;
					initIdx++;
				}
			}
			for(int i=0;i<9;i++) {
				makeComb(i, 1);
			}
			for(int i=1;i<=18;i++) {
				check[i] = false;
			}
			bw.write("#"+tc+" "+winCnt+" "+loseCnt+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static void makeComb(int idx, int cnt){
		visit[idx] = true;
		in[cnt-1] = initValue[idx];
		int kyuSum, inSum;
		if(cnt == 9) {
			kyuSum = 0;
			inSum = 0;
			for(int i=0;i<9;i++) {
				if(kyu[i]>in[i]) {
					kyuSum+=kyu[i]+in[i];
				}else {
					inSum+=kyu[i]+in[i];
				}
			}
			if(kyuSum>inSum) {
				winCnt++;
			}else if(kyuSum<inSum) {
				loseCnt++;
			}
		}else {
			for(int i=0;i<9;i++) {
				if(!visit[i]) {
					makeComb(i, cnt+1);
				}
			}
		}
		visit[idx] = false;
	}

}
