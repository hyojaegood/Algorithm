import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6730 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		int N;
		int[] h = new int[100];
		int desc;
		int asc;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			desc = 0;
			asc = 0;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<N-1;i++) {
				int dif = h[i]-h[i+1];
				if(dif>0) {//내려가기
					if(desc<dif)desc=dif;
				}else {//올라가기
					if(asc>dif)asc=dif;
				}
			}
			bw.write("#"+tc+" "+abs(asc)+" "+desc+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static int abs(int a) {
		if(a<0)return -a;
		return a;
	}
}
