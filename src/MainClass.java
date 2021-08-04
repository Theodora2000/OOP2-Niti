class MojaNit extends Thread{
    private int suma;
    public void run(){
        int s=0;
        for(int i=0;i<100 && !interrupted();i+=2){
            s+=i;
        }
        suma=s;
    }

    public int getSuma() {
        return suma;
    }

}
class IncThread extends Thread{
private Brojac brojac;

    public IncThread(Brojac brojac) {
        this.brojac = brojac;
    }

    public void run(){
        for(int i=0;i<1000000;i++){
            brojac.inc();
        }
    }
}
class Brojac{

    private int br=0;

    public void inc(){
        synchronized (this){//synchronized nas stiti od kvaranje nase strukture
            br++;
        }//zakljucava objekat

    }
    public int getBr(){
        synchronized (this) {
            return br;
        }
    }

}


public class MainClass {
    public static void main(String args[]) throws InterruptedException  {
        Brojac br = new Brojac();
        Thread t1= new IncThread(br);
        t1.start();
        Thread t2= new IncThread(br);
        t2.start();
        Thread t3= new IncThread(br);
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(br.getBr());
    }

    public static void main1(String args[]) throws InterruptedException{
        MojaNit t = new MojaNit();
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
        t.interrupt();
        t.join();
        System.out.println(t.getSuma());
        //skedzule je kod 1 jezra, daje iluziju da se stvari izvravaju paralelno

    }
}
