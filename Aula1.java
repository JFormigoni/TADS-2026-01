public class Aula1 extends Thread{
    private int id;

    public Aula1 (int id){
        this.id = id;
    }

    public void run(){
        for (int i = 1; i<=10; i++){
            System.out.println(id + ":" + i);
            //try{
            //    Thread.sleep(1000);
            //} catch (InterruptedException ie){   
            //}
        }
    }

    public static void main(String[] args) {
        for (int x = 1; x <= 10; x++){
            Aula1 a1 = new Aula1(x);
            //a1.setDaemon(true);
            a1.setPriority(x);
            a1.start();
        }
        //try{
        //Thread.sleep(100);
        //} catch(InterruptedException ie){
        //}
        System.out.println("Ok");
    }
}