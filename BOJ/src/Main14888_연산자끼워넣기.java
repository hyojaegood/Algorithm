import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14888_연산자끼워넣기 {
	static int N;
	static int[] A = new int[100];
	static int[] opSeq = new int[99];
	static boolean[] visit = new boolean[99];
	static int[] operator = new int[99];
	static int maxValue;
	static int minValue;
	static int callCnt;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		maxValue = -1000000001;
		minValue = 1000000001;
		callCnt =1;
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			operator[i]= tmp;
		}
		int op = 0;
		for(int i=0;i<4;i++) {
			if(operator[i]!=0) {
				op = i;
				break;
			}
		}
		for(int i=0;i<N-1;i++) {
			visit[i] = true;
			operator[op]--;
			dfs(0,i,op);
			visit[i] = false;
			operator[op]++;
		}
		System.out.println(maxValue);
		System.out.println(minValue);
	}
	public static void dfs(int depth, int idx, int op) {

	}

}
