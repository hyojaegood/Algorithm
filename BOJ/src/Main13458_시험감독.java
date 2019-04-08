import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main13458_시험감독 {
	static int[] A = new int[1000001];
	static int N,B,C;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		long result;
		int X;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		result=N;
		for(int i=0;i<N;i++) {
			X=A[i]-B;
			if(X<=0) {
				continue;
			}
			if(X%C==0) {
				result+=X/C;
			}else {
				result+=(X/C)+1;
			}
		}
		bw.write(""+result+"\n");
		bw.flush();
		bw.close();
	}

}
