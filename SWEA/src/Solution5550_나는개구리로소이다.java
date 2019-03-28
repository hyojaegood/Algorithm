import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution5550_나는개구리로소이다 {
	static char[] ary = new char[2500];
	static boolean[] visit = new boolean[2500];
	static int length;
	static char[] ch= {'c','r','o','a','k'};
	static boolean isPossible;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		String input;
		int firstK;
		int cCnt;
		int kCnt;
		int result;
		int firstC;
		for(int tc=1;tc<=T;tc++) {
			input = br.readLine();
			ary = input.toCharArray();
			length = ary.length;
			kCnt = 0;
			cCnt = 0;
			firstK = length;
			firstC = length;
			isPossible = true;
			for(int i=0;i<length;i++) {
				if(ary[i]=='c'&&!visit[i]) {
					traverse(i);
				}
				if(!isPossible) {
					break;
				}
			}
			for(int i=0;i<length;i++) {
				if(!visit[i]) {
					isPossible = false;
				}
				if(!isPossible)break;
			}
			
			
			
			if(isPossible) {
	
			}
			for(int i=0;i<length;i++) {
				visit[i] = false;
			}
			if(isPossible) {
				result = kCnt - cCnt;
			}else {
				result = -1;
			}
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static void traverse(int idx) {
		int cnt=1;
		visit[idx] = true;
		for(int i=idx+1;i<length;i++) {
			if(ary[i]==ch[cnt] && !visit[i]) {
				visit[i] = true;
				cnt++;
			}
			if(cnt==5)break;
		}
		if(cnt!=5) {
			isPossible = false;
		}
	}

}
