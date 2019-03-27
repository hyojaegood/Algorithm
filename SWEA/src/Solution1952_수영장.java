import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1952_수영장 {
	static int[] month = new int[12];
	static int[] price = new int[4];
	static int[] d = new int[12];
	static int[] k = {1,1,3,12};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int tmp;
		for(int tc=1;tc<=T;tc++) {
			for(int i=0;i<12;i++) {
				d[i] = 0;
			}
			st = new StringTokenizer(br.readLine().trim());
			for(int i=0;i<4;i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine().trim());
			for(int i=0;i<12;i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			if(month[0]==0) {
			}else {
				d[0] = min(min(price[0]*month[0],price[1]), min(price[2], price[3]));
			}
			for(int i=1;i<12;i++) {
				tmp = Integer.MAX_VALUE;
				if(month[i]!=0) {
					tmp = min(tmp, d[i-1] + price[0]*month[i]);
					tmp = min(tmp, d[i-1] + price[1]);
					if(i-3>=0) {
						tmp = min(tmp, d[i-3] + price[2]);	
					}else {
						tmp = min(tmp, price[2]);	
					}
					tmp = min(tmp, price[3]);
					d[i] = tmp;
				}else {
					d[i] = d[i-1];
				}
			}
			bw.write("#"+tc+" "+d[11]+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static int min(int a,int b) {
		if(a<b)return a;
		else return b;
	}

}
