package practice.ch3.source;

public class Greeter implements Runnable {
    private int n;
    private String target;

    public Greeter(int n, String target) {
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        for(int i=0; i<this.n; i++) {
            System.out.println("Hello, " + this.target);
        }
    }
}
