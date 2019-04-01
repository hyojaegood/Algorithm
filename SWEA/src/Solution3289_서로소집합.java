import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution3289_서로소집합 {
	static int n, m;
	static int[] parent = new int[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int operation, a, b;
		String result;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			result = "";
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			for(int i=1;i<=n;i++) {
				parent[i] = i;
			}
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				operation = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(operation==0) {
					a = find(a);
					b = find(b);
					parent[b] = a;
				}else {
					if(find(a) == find(b)) {
						result+="1";
					}else {
						result+="0";
					}
				}
			}
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static int find(int a) {
		if(parent[a]==a) {
			return parent[a];
		}else {
			parent[a] = find(parent[a]);
			return parent[a];
		}
	}

}
