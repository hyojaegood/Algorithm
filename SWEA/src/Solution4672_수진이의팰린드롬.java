import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4672_수진이의팰린드롬 {
	static char[] input = new char[10];
	static int[] count = new int[26];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int result;
		for(int tc=1;tc<=T;tc++) {
			result = 0;
			input = br.readLine().toCharArray();
			N = input.length;
			result = N;
			for(int i=0;i<='z'-'a';i++) {
				count[i] = 0;
			}
			for(int i=0;i<N;i++) {
				count[input[i]-'a']++;
			}
			for(int i=0;i<='z'-'a';i++) {
				if(count[i]>1) {
					result+=plus(count[i]);
				}
			}
			for(int i=0;i<N;i++) {
				System.out.printf("%c",input[i]);
			}System.out.println();
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static int plus(int n) {
		int result =0;
		for(int i=n-1;i>=1;i--) {
			result+=i;
		}
		return result;
	}

}
