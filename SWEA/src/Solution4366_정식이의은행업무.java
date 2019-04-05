import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution4366_정식이의은행업무 {
	static char[] bi = new char[40];
	static int biLen;
	static char[] tri = new char[40];
	static int triLen;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		String in;
		char tmp1, tmp2;
		int biValue, triValue;
		int result;
		for(int tc=1;tc<=T;tc++) {
			result = -1;
			in = br.readLine();
			biLen = in.length();
			bi = in.toCharArray();
			in = br.readLine();
			triLen = in.length();
			tri = in.toCharArray();
			for(int i=0;i<biLen;i++) {
				if(result>=0)break;
				tmp1 = bi[i];
				biChange(i);
				biValue = toDecimal(2);
				for(int j=0;j<triLen;j++) {
					if(result>=0)break;
					tmp2 = tri[j];
					for(int k=0;k<3;k++) {
						if(tmp2!=k+'0') {
							triChange(j,(char)(k+'0'));
							triValue = toDecimal(3);
							if(biValue==triValue) {
								result = biValue;
								break;
							}
						}
					}
					tri[j]=tmp2;
				}
				bi[i]=tmp1;
			}
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static int pow(int a, int n) {
		if(n==0)return 1;
		if(n==1)return a;
		if(n%2==0) {
			int tmp = pow(a,n/2);
			return tmp*tmp;
		}else {
			int tmp = pow(a,n/2);
			return a*tmp*tmp;
		}
	}
	public static int toDecimal(int num) {
		int result = 0;
		if(num==2) {
			for(int i=0;i<biLen;i++) {
				result+=(bi[i]-'0')*pow(2,biLen-i-1);
			}
		}else {
			for(int i=0;i<triLen;i++) {
				result+=(tri[i]-'0')*pow(3,triLen-i-1);
			}
		}
		return result;
	}
	public static void biChange(int idx) {
		int tmp = bi[idx]-'0';
		if(tmp==0) {
			bi[idx] = '1';
		}else {
			bi[idx] = '0';
		}
	}
	public static void triChange(int idx, char i) {
		tri[idx] = i;
	}

}
