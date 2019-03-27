import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ15954_인형들 {
	static int N,K;
	static long[] num = new long[500];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		double minValue = Double.MAX_VALUE;
		int startIdx;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for(int j=K;j<=N;j++) {
			for(int i=0;i<=N-j;i++) {
				int start = i;
				int end = i+j-1;
				double m, dis, dev;
				m = average(start,end,j);
				dis = dispersion(start,end,m,j);
				dev = deviation(dis);
				if(dev<minValue) {
					minValue =dev;
				}
			}	
		}
		bw.write(""+minValue);
		bw.flush();
		bw.close();
	}
	public static double average(int start, int end, int k) {
		double result = 0;
		long tmp = 0;
		for(int i=start;i<=end;i++) {
			tmp+=num[i];
		}
		result = (double)tmp/k;
		return result;
	}
	public static double dispersion(int start, int end, double m, int k) {
		double result = 0;
		for(int i=start;i<=end;i++) {
			result +=(num[i]-m)*(num[i]-m);
		}
		result = result/k;
		return result;
	}
	public static double deviation(double d) {
		double result = Math.sqrt(d);
		return result;
	}

}
