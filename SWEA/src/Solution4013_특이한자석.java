import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4013_특이한자석 {
	static int k;
	static int[][] magnet = new int[5][8];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int num, operation;
		int result;
		for(int tc=1;tc<=T;tc++) {
			result = 0;
			k = Integer.parseInt(br.readLine());
			for(int i=1;i<=4;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				num = Integer.parseInt(st.nextToken());
				operation = Integer.parseInt(st.nextToken());
				rotate(num,operation);
			}
			for(int i=1;i<=4;i++) {
				if(magnet[i][0]==1) {
					result+=pow(2,i-1);
				}
			}
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static int pow(int a,int b) {
		int result =1;
		for(int i=0;i<b;i++) {
			result*=a;
		}
		return result;
	}
	public static void change(int num, int dir) {
		if(dir>0) {
			int tmp1 = magnet[num][0];
			int tmp2;
			for(int i=1;i<8;i++) {
				tmp2 = magnet[num][i];
				magnet[num][i] = tmp1;
				tmp1 = tmp2;
			}
			magnet[num][0] = tmp1;
		}else {
			int tmp1 = magnet[num][7];
			int tmp2;
			for(int i=6;i>=0;i--) {
				tmp2 = magnet[num][i];
				magnet[num][i] = tmp1;
				tmp1 = tmp2;
			}
			magnet[num][7] = tmp1;
		}
	}
	public static void rotate(int num, int dir) {
		int[] rotation = new int[5];
		rotation[num] = dir;
		if(num==1) {
			if(magnet[1][2]!=magnet[2][6]) {
				rotation[2] = -dir;
				if(magnet[2][2]!=magnet[3][6]) {
					rotation[3]=dir;
					if(magnet[3][2]!=magnet[4][6]) {
						rotation[4] = -dir;
					}
				}
			}
		}else if(num==2) {
			if(magnet[2][6]!=magnet[1][2]) {
				rotation[1] = -dir;
			}
			if(magnet[2][2]!=magnet[3][6]) {
				rotation[3] = -dir;
				if(magnet[3][2]!=magnet[4][6]) {
					rotation[4] = dir;
				}
			}
		}else if(num==3) {
			if(magnet[3][6]!=magnet[2][2]) {
				rotation[2] = -dir;
				if(magnet[2][6]!=magnet[1][2]) {
					rotation[1] = dir;
				}
			}
			if(magnet[3][2]!=magnet[4][6]) {
				rotation[4] = -dir;
			}
		}else {
			if(magnet[4][6]!=magnet[3][2]) {
				rotation[3] = -dir;
				if(magnet[2][2]!=magnet[3][6]) {
					rotation[2]=dir;
					if(magnet[2][6]!=magnet[1][2]) {
						rotation[1] = -dir;
					}
				}
			}
		}
		for(int i=1;i<=4;i++) {
			if(rotation[i]!=0)change(i,rotation[i]);
		}
//		for(int i=1;i<=4;i++) {
//			System.out.printf("%d: ",i);
//			for(int j=0;j<8;j++) {
//				System.out.printf("%d",magnet[i][j]);
//			}System.out.println();
//		}
	}

}
