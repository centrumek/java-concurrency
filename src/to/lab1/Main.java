package lab1;

public class Main {
	public static int REPS=100000000;
	public static void main(String[] args) throws InterruptedException{
		Count c1=new Count(0);
		Thread t1=new Thread(){
			public void run(){
				for(int i=0;i<REPS;i++){
					c1.inc();
					//System.out.println("t1: "+Count.a);
				}
			}
		};
		Thread t2=new Thread(){
			public void run(){
				for(int i=0;i<REPS;i++){
					c1.dec();
					//System.out.println("t2: "+Count.a);
				}
			}
		};
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		//System.out.println(Count.a);
		System.out.println(c1.a);
		
	}
	
}
