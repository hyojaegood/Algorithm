import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N=20;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==10 && j==10) {
					System.out.print("9 ");
					continue;
				}
				if(j%3==1) {
					System.out.print("3 ");
				}else if(j%3==2) {
					System.out.print("2 ");
				}else {
					System.out.print("1 ");
				}
			}System.out.println();
		}

	}

}
