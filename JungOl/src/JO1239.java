import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JO1239 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N;
		int[] num = new int[10];
		String tmp;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		int[] ch = {0, 15, 19, 28,
					38, 41,53, 58};
		boolean flag;
		String output = "";
		N = Integer.parseInt(br.readLine());
		input = br.readLine();
		for(int i=0;i<N;i++) {
			tmp = input.substring(i*6, i*6+6);
			for(int j=0;j<6;j++) {
				num[i]+=(tmp.charAt(j) - '0')*pow(2,5-j);
			}
		}
		for(int i=0;i<N;i++) {
			flag = false;
			for(int j=0;j<8;j++) {
				if((num[i]^ch[j])==0) {
					char c = (char) (j+'A');
					output+= c;
					flag =true;
					break;
				}else if(check((num[i]^ch[j]))) {
					char c = (char) (j+'A');
					output+= c;
					flag =true;
					break;
				}
			}
			if(!flag) {
				output = ""+(i+1);
				break;
			}
		}
		System.out.println(output);
	}
	public static boolean check(int a) {
		for(int i=0;i<6;i++) {
			if(a==pow(2,i)) {
				return true;
			}
		}
		return false;
	}
	public static int pow(int a, int b) {
		if(b==0)return 1;
		if(b%2==0) {
			int tmp = pow(a,b/2);
			return tmp*tmp;
		}else {
			int tmp = pow(a,b/2);
			return tmp*tmp*a;
		}
	}
}
