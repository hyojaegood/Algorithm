import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6900 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T, N, M;
		String[][] nStr = new String[100][2];
		String[] mStr = new String[1000];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int sum;
		boolean done;
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				nStr[i][0] = st.nextToken();
				nStr[i][1] = st.nextToken();
			}
			for(int i=0;i<M;i++) {
				mStr[i] = br.readLine();
			}
			for(int i=0;i<M;i++) {
				done = false;
				for(int j=0;j<N;j++) {
					if(done)break;
					for(int k=0;k<8;k++) {
						if(nStr[j][0].charAt(k)!='*') {
							if(mStr[i].charAt(k)!=nStr[j][0].charAt(k)) {
								break;
							}
						}
						if(k==7) {
							sum+=Integer.parseInt(nStr[j][1]);
							done =true;
						}
					}	
				}
			}
			bw.write("#"+tc+" "+sum+"\n");
			bw.flush();
		}
		bw.close();
	}
}
