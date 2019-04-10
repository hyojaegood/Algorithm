import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sample {
	static int[][] circle = new int[5][9];
	static int K;
	static int[][] move = new int[102][2];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String in;
		T= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			K=Integer.parseInt(br.readLine());
			for(int i=1;i<=4;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					circle[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				move[i][0] = Integer.parseInt(st.nextToken());
				move[i][1] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<K;i++) {
				rotation(move[i][0],move[i][1]);
			}
			int result = 0;
			for(int i=1;i<=4;i++) {
				if(circle[i][0]==1) {
					result+=pow(i-1);
				}
			}
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static int pow(int n) {
		int result =1;
		for(int i=0;i<n;i++) {
			result*=2;
		}
		return result;
	}
	public static void rotation(int num, int dir) {
		int[] canRotate = new int[5];
		for(int i=1;i<=4;i++) {
			canRotate[i] = 0;
		}
		if(num==1) {
			canRotate[1] = dir;
			if(circle[1][2]!=circle[2][6]) {
				canRotate[2] = -dir;
				if(circle[2][2]!=circle[3][6]) {
					canRotate[3] = dir;
					if(circle[3][2]!=circle[4][6]) {
						canRotate[4] = -dir;
					}
				}
			}
		}else if(num==2) {
			canRotate[2] = dir;
			if(circle[2][6]!=circle[1][2]) {
				canRotate[1] = -dir;
			}
			if(circle[2][2]!=circle[3][6]) {
				canRotate[3] = -dir;
				if(circle[3][2]!=circle[4][6]) {
					canRotate[4] = dir;
				}
			}
		}else if(num==3) {
			canRotate[3] = dir;
			if(circle[3][6]!=circle[2][2]) {
				canRotate[2] = -dir;
				if(circle[2][6]!=circle[1][2]) {
					canRotate[1] = dir;
				}
			}
			if(circle[3][2]!=circle[4][6]) {
				canRotate[4] = -dir;
			}
		}else {
			canRotate[4] = dir;
			if(circle[4][6]!=circle[3][2]) {
				canRotate[3] = -dir;
				if(circle[3][6]!=circle[2][2]) {
					canRotate[2] = dir;
					if(circle[2][6]!=circle[1][6]) {
						canRotate[1] = -dir;
					}
				}
			}
		}
		int[] tmp = new int[9]; 
		for(int i=1;i<=4;i++) {
			tmp  = circle[i].clone();
			if(canRotate[i]>0) {
				int tmp1 = circle[i][0];
				int tmp2;
				for(int j=1;j<8;j++) {
					tmp2 = circle[i][j];
					circle[i][j] = tmp1;
					tmp1 = tmp2;
				}
				circle[num][0] = tmp1;
			}else if(canRotate[i]<0) {
				int tmp1 = circle[i][7];
				int tmp2;
				for(int j=6;j>=0;j--) {
					tmp2 = circle[i][j];
					circle[i][j] = tmp1;
					tmp1 = tmp2;
				}
				circle[i][7] = tmp1;
			}
		}

	}

}
