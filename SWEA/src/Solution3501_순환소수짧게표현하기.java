import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution3501_순환소수짧게표현하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		int q, r;
		int a, b;
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		Queue<qr> queue = new LinkedList<>();
		String result;
		ArrayList<Integer> check[] = null;
		qr tmp;
		boolean isCycle;
		for(int tc=1;tc<=T;tc++) {
			result = "";
			isCycle =false;
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			check = new ArrayList[100001];
			for(int i=0;i<=100000;i++) {
				check[i] = new ArrayList<Integer>();
			}
			if(a/b>0) {
				result+=a/b;
				r = a%b;
				a = r*10;
			}else {
				result+="0";
				r = a%b;
				a = r*10;
			}
			if(r==0) {
				bw.write("#"+tc+" "+result+"\n");
				bw.flush();
				continue;
			}else {
				result+=".";	
			}
			while(true) {
				if(a/b==0) {
					q = 0;
					r = a % b;
					a *=10;
				}else {
					q= a/b;
					r=a%b;
					a = r*10;
				}
				if(check[q].contains(r)) {
					//q,r이 나올때 까지는 그냥 추가
					while(!(queue.peek().q==q && queue.peek().r==r)) {
						result+=queue.poll().q;
					}
					if(!queue.isEmpty()) {
						isCycle = true;
						result+="(";
					}
					while(!queue.isEmpty()) {
						result+=queue.poll().q;
					}
					if(isCycle)result+=")";
					break;
				}else {
					check[q].add(r);
					tmp = new qr(q,r);
					queue.add(tmp);		
				}
				if(r==0) {
					while(!queue.isEmpty()) {
						result+=queue.poll().q;
					}
					break;
				}
			}
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		bw.close();
	}
}
class qr{
	int q, r;
	qr(int a,int b){
		q =a;
		r = b;
	}
}
