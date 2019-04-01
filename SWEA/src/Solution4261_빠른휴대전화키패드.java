import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4261_빠른휴대전화키패드 {
	static int N;
	static String S;
	static String[] word = new String[1001];
	static int wordCnt;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		char[] result;
		int sLen;
		for(int tc=1;tc<=T;tc++) {
			cnt = 0;
			wordCnt = 0;
			result = new char[1000];
			st = new StringTokenizer(br.readLine().trim());
			S = st.nextToken();
			N = Integer.parseInt(st.nextToken());
			sLen = S.length();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				String tmp = st.nextToken();
				if(tmp.length()==sLen) {
					word[wordCnt] = tmp;
					wordCnt++;
				}
			}
			for(int i=0;i<wordCnt;i++) {
				for(int j=sLen-1;j>=0;j--) {
					result[j] = charToNum(word[i].charAt(j));
				}
				String tmp = new String(result);
				tmp = tmp.trim();
				if(tmp.equals(S)) {
					cnt++;
				}
			}
			bw.write("#"+tc+" "+cnt+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static char charToNum(char a) {
		if(a=='a' || a=='b' || a=='c') {
			return '2';
		}else if(a=='d' || a=='e' || a=='f') {
			return '3';
		}else if(a=='g' || a=='h' || a=='i') {
			return '4';
		}else if(a=='j' || a=='k' || a=='l') {
			return '5';
		}else if(a=='m' || a=='n' || a=='o') {
			return '6';
		}else if(a=='p' || a=='q' || a=='r'||a=='s') {
			return '7';
		}else if(a=='t' || a=='u' || a=='v') {
			return '8';
		}else {
			return '9';
		}
	}
}
