package pl.edu.agh.kis.pz1;

import java.util.List;

public class Room {

    public int usersNumber = 0;
    public static boolean readerAvailable = true;
    public static boolean writerAvailable = true;
    public static List<User> users;

    public Room(List<User> users) {
        this.users = users;
    }


    public synchronized void enter(User user) throws InterruptedException {
        while(true){
        if (usersNumber == 0) writerAvailable = true;
        if (user.userWriter == false) {
            if (readerAvailable) {
                writerAvailable = false;
                usersNumber++;
                users.add(user);
                System.out.println("Reader " + user.name + " has entered the room to read some books.");
                if(usersNumber == 5) readerAvailable = false;
                break;
            } else {
                System.out.println("Reader " + user.name + " is waiting.");
                wait();
            }
        }
        else {
            if (writerAvailable) {
                readerAvailable = false;
                writerAvailable = false;
                usersNumber++;
                users.add(user);
                System.out.println("Writer " + user.name + " has entered the room and started writing.");
                break;
            } else {
                System.out.println("Writer " + user.name + " is waiting.");
                wait();
            }
            }
        }
    }

    public synchronized void leave(User user){
        if (user.userWriter == false){
            usersNumber--;
            readerAvailable = true;
            System.out.println("Reader " + user.name + " has finished reading and left the room.");
        }
        if(user.userWriter == true){
            readerAvailable = true;
            writerAvailable = true;
            usersNumber--;
            System.out.println("Writer " + user.name + " has finished writing and left the room.");
        }
        users.remove(user);
        notifyAll();
    }

}
