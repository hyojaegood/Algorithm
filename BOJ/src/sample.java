
public class sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		N=1000;
		int cost;
		System.out.println(N);
		for(int i=1;i<=1000;i++) {
			for(int j=0;j<3;j++) {
				cost = (int)(Math.random()*1000+1);
				System.out.printf("%d ",cost);
			}System.out.println();
		}
	}

}
