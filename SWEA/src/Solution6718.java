import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6718 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		double d;
		int ans;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			d = Double.parseDouble(br.readLine());
			d = d/1000;
			ans = 10;
			for(int i=-1;i<=3;i++) {
				if(d<pow(10,i)) {
					ans = i+1;
					break;
				}
			}
			if(ans==10)ans=5;
			bw.write("#"+tc+" "+ans+"\n");
			bw.flush();
		}bw.close();
	}
	public static double pow(int a, int b) {
		if(b==0)return 1;
		if(b==-1)return (double)1/a;
		if(b%2==0) {
			double tmp = pow(a,b/2);
			return tmp*tmp;
		}else {
			double tmp = pow(a,b/2);
			return tmp*tmp*a;
		}
	}

}
