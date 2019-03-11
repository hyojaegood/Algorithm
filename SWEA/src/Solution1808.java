import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1808 {
	static int[] D;
	static boolean[] digit = new boolean[10];
	static int X;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int tmp;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<=9;i++) {
				tmp = Integer.parseInt(st.nextToken());
				if(tmp == 0) {
					digit[i] = false;
				}else {
					digit[i] = true;
				}
			}
			X = Integer.parseInt(br.readLine());
			D = new int[X+1];
			for(int i=0;i<10;i++) {
				if(digit[i] && i<=X) {
					D[i] = 2;
					init(i);
				}
			}
			D[X] = dp(X);
			if(D[X]>0) {
				bw.write("#"+tc+" "+D[X]+"\n");	
			}else {
				bw.write("#"+tc+" -1\n");
			}
			bw.flush();
		}
		bw.close();
	}
	public static int dp(int n) {
		int minValue = X+4;
		int tmp1, tmp2;
		if(D[n]>0)return D[n];
		else {
			for(int i=2;n/i>=i;i++) {
				if(n%i==0) {
					if(D[i]>0) {
						tmp1 = D[i];
					}else {
						tmp1 = dp(i);
						D[i] = tmp1;
					}
					if(D[n/i]>0) {
						tmp2 = D[n/i];
					}else {
						tmp2 = dp(n/i);
						D[n/i] = tmp2;
					}
					if(tmp1>0 && tmp2>0) {
						if(tmp1+tmp2<minValue) {
							minValue = tmp1+tmp2;
						}		
					}
				}
			}
			if(minValue==X+4) {
				return 0;
			}
			return minValue;
		}
		
	}
	public static void init(int value) {
		if(value>X||value==0)return;
		for(int i=0;i<10;i++) {
			if(digit[i] && value*10 +i<=X) {
				D[value*10+i] = D[value]+1;
				init(value*10+i);
			}
		}
	}
}	
