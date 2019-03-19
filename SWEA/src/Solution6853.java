import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6853 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int x1,x2,y1,y2;
		int x, y;
		int state1,state2,state3;
		int N;
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			state1 = state2 = state3 = 0;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				if((x>x1&&x<x2)&&(y>y1&&y<y2)) {
					state1++;
				}else if(((x==x1)&&(y>=y1&&y<=y2))||((x==x2)&&(y>=y1&&y<=y2))||((y==y1)&&(x>=x1&&x<=x2))||((y==y2)&&(x>=x1&&x<=x2))) {
					state2++;
				}else {
					state3++;
				}
			}
			bw.write("#"+tc+" "+state1+" "+state2+" "+state3+"\n");
			bw.flush();
		}
		bw.close();
	}

}
