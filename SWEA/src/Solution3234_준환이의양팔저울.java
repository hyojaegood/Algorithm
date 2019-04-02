import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution3234_준환이의양팔저울 {
	static int N;
	static char[] seq1 = new char[10];
	static char[] seq2 = new char[10];
	static int[] weight = new int[10];
	static int[] rightWeight = new int[10];
	static int[] leftWeight = new int[10];
	static int[] fact = {1,1,2,6,24,120,720,5040, 40320,362880,29030400};
	static int[] pow = {1,2,4,8,16,32,64,128,256,512,1024};
	static double totalWeight;
	static boolean[] visit = new boolean[10];//true면 right에 포함됨
	static int cnt;
	static int callCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			totalWeight = 0;
			cnt = 0;
			callCnt = 0;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				totalWeight+=weight[i];
			}
			for(int i=0;i<N;i++) {
				visit[i] =true;
				dfs(i,0,0,0,true);
				visit[i] = false;
			}
			bw.write("#"+tc+" "+cnt+"\n");
			bw.flush();
			//System.out.println(callCnt);
		}
		bw.close();
	}
	public static void dfs(int idx, int depth, int leftSum, int rightSum, boolean LR) {
		if(LR) {//왼쪽에 올림
			leftSum+=weight[idx];
		}else {//오른쪽에 올림
			rightSum+=weight[idx];
		}
		if(rightSum>totalWeight/2)return;
		if(leftSum<rightSum)return;
		if(depth<N-1 && leftSum>=totalWeight/2) {
			cnt += (fact[N-depth-1]*pow[N-depth-1]);
			return;
		}
		if(depth==N-1) {
			cnt++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i,depth+1,leftSum,rightSum,true);
				visit[i] = false;
				visit[i] = true;
				dfs(i,depth+1,leftSum,rightSum,false);
				visit[i] = false;
			}
		}
		
	}
}
