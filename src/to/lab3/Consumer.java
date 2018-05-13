package lab3;

class Consumer extends Thread {
	   private Buffor cubbyhole;
	   private int number;
	   
	   public Consumer(Buffor c, int number) {
	      cubbyhole = c;
	      this.number = number;
	   }
	   public void run() {
	      int value = 0;
	      while(true) {
	         value = cubbyhole.get();
	         System.out.println("Consumer #" + this.number + " got: " + value + " buffor size: " + cubbyhole.size());
	         try {
	        	 sleep((int) (Math.random() * 800));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
	   }
	}
