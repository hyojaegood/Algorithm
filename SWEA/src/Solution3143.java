import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.StringTokenizer;

public class Solution3143 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		String a, b;
		int aLen, bLen;
		int cnt;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		int sameLen;
		for(int tc=1;tc<=T;tc++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			a = st.nextToken();
			b = st.nextToken();
			aLen = a.length();
			bLen = b.length();
			for(int i=0;i<aLen;i++) {
				sameLen = 0;
				for(int j=0;j<bLen && i+j<aLen;j++) {
					if(a.charAt(i+j) == b.charAt(j)) {
						sameLen++;
					}else {
						break;
					}
				}
				if(sameLen == bLen) {
					i = i+bLen-1;
				}
				cnt++;
			}
			bw.write("#"+tc+" "+cnt+"\n");
			bw.flush();
		}
		bw.close();
	}

}
