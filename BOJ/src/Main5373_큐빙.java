import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main5373_큐빙 {
	static char[][] up = new char[4][4];
	static char[][] down = new char[4][4];
	static char[][] left = new char[4][4];
	static char[][] right = new char[4][4];
	static char[][] front = new char[4][4];
	static char[][] back = new char[4][4];
	static String[] cmd = new String[1000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int k;
		for(int tc=1;tc<=T;tc++) {
			for(int i=1;i<=3;i++) {
				for(int j=1;j<=3;j++) {
					up[i][j] = 'w';
					down[i][j] = 'y';
					left[i][j] = 'g';
					right[i][j] = 'b';
					front[i][j] = 'r';
					back[i][j] = 'o';
				}
			}
			k=Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int r=0;r<k;r++) {
				cmd[r] = st.nextToken();
			}
			
			System.out.printf("#%d\n",tc);
			for(int r=0;r<k;r++) {
				rotate(cmd[r].charAt(0), cmd[r].charAt(1));
				System.out.println("up");
				for(int i=1;i<=3;i++) {
					for(int j=1;j<=3;j++) {
						System.out.printf("%c",up[i][j]);
					}System.out.println();
				}
				System.out.println("down");
				for(int i=1;i<=3;i++) {
					for(int j=1;j<=3;j++) {
						System.out.printf("%c",down[i][j]);
					}System.out.println();
				}
//				System.out.println("front");
//				for(int i=1;i<=3;i++) {
//					for(int j=1;j<=3;j++) {
//						System.out.printf("%c",front[i][j]);
//					}System.out.println();
//				}System.out.println("back");
//				for(int i=1;i<=3;i++) {
//					for(int j=1;j<=3;j++) {
//						System.out.printf("%c",back[i][j]);
//					}System.out.println();
//				}
			System.out.println("left");
				for(int i=1;i<=3;i++) {
					for(int j=1;j<=3;j++) {
						System.out.printf("%c",left[i][j]);
					}System.out.println();
				}System.out.println("right");
				for(int i=1;i<=3;i++) {
					for(int j=1;j<=3;j++) {
						System.out.printf("%c",right[i][j]);
					}System.out.println();
				}
				System.out.println("------------");
			}
		}
	}
	public static void rotate(char side, char dir) {
		char[] tmp1 = new char[4];
		char[] tmp2 = new char[4];
		char[] tmp3 = new char[4];
		char[] tmp4 = new char[4];
		char[] tmp5 = new char[4];
		char[] tmp6 = new char[4];
		char[] tmp7 = new char[4];
		switch (side) {
		case 'U':
			tmp1 = front[1].clone();
			tmp2 = left[1].clone();
			tmp3 = back[1].clone();
			tmp4 = right[1].clone();
			tmp5 = up[1].clone();
			tmp6 = up[2].clone();
			tmp7 = up[3].clone();
			if(dir=='+') {
				left[1] = tmp1.clone();
				back[1] = tmp2.clone();
				right[1] = tmp3.clone();
				front[1] = tmp4.clone();
				for(int i=1;i<=3;i++) {
					up[i][3] = tmp5[i];
				}
				for(int i=1;i<=3;i++) {
					up[i][2] = tmp6[i];
				}
				for(int i=1;i<=3;i++) {
					up[i][1] = tmp7[i];
				}
			}else {
				right[1] = tmp1.clone();
				back[1] = tmp4.clone();
				left[1] = tmp3.clone();
				front[1] = tmp2.clone();
				for(int i=1;i<=3;i++) {
					up[i][1] = tmp5[4-i];
				}
				for(int i=1;i<=3;i++) {
					up[i][2] = tmp6[4-i];
				}
				for(int i=1;i<=3;i++) {
					up[i][3] = tmp7[4-i];
				}
			}		
			break;
		case 'D':
			tmp1 = front[3].clone();
			tmp2 = left[3].clone();
			tmp3 = back[3].clone();
			tmp4 = right[3].clone();
			tmp5 = down[1].clone();
			tmp6 = down[2].clone();
			tmp7 = down[3].clone();
			if(dir=='+') {
				right[3] = tmp1.clone();
				back[3] = tmp4.clone();
				left[3] = tmp3.clone();
				front[3] = tmp2.clone();
				for(int i=1;i<=3;i++) {
					down[i][1] = tmp5[4-i];
				}
				for(int i=1;i<=3;i++) {
					down[i][2] = tmp6[4-i];
				}
				for(int i=1;i<=3;i++) {
					down[i][3] = tmp7[4-i];
				}
			}else {
				left[3]=tmp1.clone();
				back[3] = tmp2.clone();
				right[3] = tmp3.clone();
				front[3] = tmp4.clone();
				for(int i=1;i<=3;i++) {
					down[i][3] = tmp5[i];
				}
				for(int i=1;i<=3;i++) {
					down[i][2] = tmp6[i];
				}
				for(int i=1;i<=3;i++) {
					down[i][1] = tmp7[i];
				}
			}
			break;
		case 'F':
			tmp1 = up[3].clone();
			tmp2 = down[3].clone();
			for(int i=1;i<=3;i++)tmp3[i] = right[i][1];
			for(int i=1;i<=3;i++)tmp4[i] = left[i][1];
			tmp5 = front[1].clone();
			tmp6 = front[2].clone();
			tmp7 = front[3].clone();
			if(dir=='+') {
				for(int i=1;i<=3;i++)right[i][1]=tmp1[i];
				for(int i=1;i<=3;i++)left[i][1]=tmp2[i];
				up[3] = tmp4.clone();
				down[3] = tmp3.clone();
				for(int i=1;i<=3;i++) {
					front[i][3] = tmp5[i];
				}
				for(int i=1;i<=3;i++) {
					front[i][2] = tmp6[i];
				}
				for(int i=1;i<=3;i++) {
					front[i][1] = tmp7[i];
				}
			}else {
				for(int i=1;i<=3;i++)right[i][1]=tmp2[i];
				for(int i=1;i<=3;i++)left[i][1]=tmp1[i];
				up[3] = tmp3.clone();
				down[3] = tmp4.clone();
				for(int i=1;i<=3;i++) {
					front[i][1] = tmp5[4-i];
				}
				for(int i=1;i<=3;i++) {
					front[i][2] = tmp6[4-i];
				}
				for(int i=1;i<=3;i++) {
					front[i][3] = tmp7[4-i];
				}
			}
			break;
		case 'B':
			tmp1 = up[1].clone();
			tmp2 = down[1].clone();
			for(int i=1;i<=3;i++)tmp3[i] = right[i][3];
			for(int i=1;i<=3;i++)tmp4[i] = left[i][3];
			tmp5 = back[1].clone();
			tmp6 = back[2].clone();
			tmp7 = back[3].clone();
			if(dir=='+') {
				for(int i=1;i<=3;i++)right[i][3]=tmp2[i];
				for(int i=1;i<=3;i++)left[i][3]=tmp1[i];
				up[1] = tmp3.clone();
				down[1] = tmp4.clone();
				for(int i=1;i<=3;i++) {
					back[i][1] = tmp5[4-i];
				}
				for(int i=1;i<=3;i++) {
					back[i][2] = tmp6[4-i];
				}
				for(int i=1;i<=3;i++) {
					back[i][3] = tmp7[4-i];
				}
			}else {
				for(int i=1;i<=3;i++)right[i][3]=tmp1[i];
				for(int i=1;i<=3;i++)left[i][3]=tmp2[i];
				up[1] = tmp4.clone();
				down[1] = tmp3.clone();
				for(int i=1;i<=3;i++) {
					back[i][3] = tmp5[i];
				}
				for(int i=1;i<=3;i++) {
					back[i][2] = tmp6[i];
				}
				for(int i=1;i<=3;i++) {
					back[i][1] = tmp7[i];
				}
			}
			break;
		case 'L':
			for(int i=1;i<=3;i++)tmp1[i] = up[i][1];
			for(int i=1;i<=3;i++)tmp2[i] = down[i][1];
			for(int i=1;i<=3;i++)tmp3[i] = front[i][1];
			for(int i=1;i<=3;i++)tmp4[i] = back[i][1];
			tmp5 = left[1].clone();
			tmp6 = left[2].clone();
			tmp7 = left[3].clone();
			if(dir=='+') {
				for(int i=1;i<=3;i++)up[i][1]=tmp4[i];
				for(int i=1;i<=3;i++)down[i][1]=tmp3[i];
				for(int i=1;i<=3;i++)front[i][1]=tmp1[i];
				for(int i=1;i<=3;i++)back[i][1]=tmp2[i];
				for(int i=1;i<=3;i++) {
					left[i][3] = tmp5[4-i];
				}
				for(int i=1;i<=3;i++) {
					left[i][2] = tmp6[4-i];
				}
				for(int i=1;i<=3;i++) {
					left[i][1] = tmp7[4-i];
				}
			}else {
				for(int i=1;i<=3;i++)up[i][1]=tmp3[i];
				for(int i=1;i<=3;i++)down[i][1]=tmp4[i];
				for(int i=1;i<=3;i++)front[i][1]=tmp2[i];
				for(int i=1;i<=3;i++)back[i][1]=tmp1[i];
				for(int i=1;i<=3;i++) {
					left[i][1] = tmp7[i];
				}
				for(int i=1;i<=3;i++) {
					left[i][2] = tmp6[i];
				}
				for(int i=1;i<=3;i++) {
					left[i][3] = tmp5[i];
				}
			}
			break;
		case 'R':
			for(int i=1;i<=3;i++)tmp1[i] = up[i][3];
			for(int i=1;i<=3;i++)tmp2[i] = down[i][3];
			for(int i=1;i<=3;i++)tmp3[i] = front[i][3];
			for(int i=1;i<=3;i++)tmp4[i] = back[i][3];
			tmp5 = right[1].clone();
			tmp6 = right[2].clone();
			tmp7 = right[3].clone();
			if(dir=='+') {
				for(int i=1;i<=3;i++)up[i][3]=tmp3[i];
				for(int i=1;i<=3;i++)down[i][3]=tmp4[i];
				for(int i=1;i<=3;i++)front[i][3]=tmp2[i];
				for(int i=1;i<=3;i++)back[i][3]=tmp1[i];
				for(int i=1;i<=3;i++) {
					right[i][1] = tmp7[i];
				}
				for(int i=1;i<=3;i++) {
					right[i][2] = tmp6[i];
				}
				for(int i=1;i<=3;i++) {
					right[i][3] = tmp5[i];
				}
			}else {
				for(int i=1;i<=3;i++)up[i][3]=tmp4[i];
				for(int i=1;i<=3;i++)down[i][3]=tmp3[i];
				for(int i=1;i<=3;i++)front[i][3]=tmp1[i];
				for(int i=1;i<=3;i++)back[i][3]=tmp2[i];
				for(int i=1;i<=3;i++) {
					right[i][3] = tmp5[4-i];
				}
				for(int i=1;i<=3;i++) {
					right[i][2] = tmp6[4-i];
				}
				for(int i=1;i<=3;i++) {
					right[i][1] = tmp7[4-i];
				}
			}
			break;
		}
	}

}
