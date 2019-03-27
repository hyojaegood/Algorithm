import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ15953_상금헌터 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T;
		int a,b;
		int[] rank1 = {1,2,4,7,11,16,22};
		int[] price1 = {5000000,3000000,2000000,500000,300000,100000};
		int[] rank2 = {1,2,4,8,16,32};
		int[] price2 = {5120000,2560000,1280000,640000,320000};
		int rankA;
		int rankB;
		int sum;
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			sum = 0;
			rankA = -1;
			rankB = -1;
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(a!=0) {
				for(int i=0;i<6;i++) {
					if(a>=rank1[i] && a<rank1[i+1]) {
						rankA = i;
						break;
					}
				}
			}
			if(rankA>=0) {
				sum+=price1[rankA];
			}
			if(b!=0) {
				for(int i=0;i<5;i++) {
					if(b>=rank2[i] && b<rank2[i+1]) {
						rankB = i;
						break;
					}
				}
			}
			if(rankB>=0) {
				sum+=price2[rankB];
			}
			bw.write(""+sum+"\n");
			bw.flush();
		}
		bw.close();
	}

}
