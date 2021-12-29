package pl.edu.agh.kis.pz1;

public class User extends Thread{
    public final String name;
    static Room room;
    public boolean userWriter;

    public User(Room room, String name) {
        this.room = room;
        this.name = name;
    }

    public synchronized void run(){
        while(true){
            try {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.join();
                room.enter(this);
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                room.leave(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
