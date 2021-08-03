class MojaNit extends Thread{
    public void run(){
        for(int i=0;i<100;i+=2){
            System.out.println(i);
        }
    }
}
public class MainClass {

    public static void main(String args[]){
        Thread t = new MojaNit();
        //t.run();
        //niti su predstavljenje objektima klase thread
        //KORISNICKE niti obavljaju nsto za korisnika
        //pozadinke sluze da omoguce korisnickim nitima da odrade svoj posao-garbage collector

        //kod niti prvo definisiemo tip

        t.start();
        //ako imamo dva jezgra onda se izvrsava sve paralelno
        for(int i=1;i<100;i+=2){
            System.out.println(i);
        }
        throw new NullPointerException();
    }
}
