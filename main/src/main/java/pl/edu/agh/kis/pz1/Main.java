package pl.edu.agh.kis.pz1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main( String[] args ){
        List<User> users = new ArrayList<>();

        Room room = new Room(users);

        User re1 = new User(room, "Maciej Krajewski");
        User re2 = new User(room, "Pawel Patus");
        User wr1 = new User(room, "Konrad Kojec");
        wr1.userWriter = true;
        User re3 = new User(room, "Pandors Crewcheck");
        User re4 = new User(room, "Pan Jezus");
        User wr2 = new User(room, "Adam");
        wr2.userWriter = true;
        User re5 = new User(room, "Jan Paweł II");
        User re6= new User(room, "Paweł Skrzynia");


        Thread reader1 = new Thread(re1);
        Thread reader2 = new Thread(re2);
        Thread writer1 = new Thread(wr1);
        Thread reader3 = new Thread(re3);
        Thread reader4 = new Thread(re4);
        Thread reader5 = new Thread(re5);
        Thread reader6 = new Thread(re6);
        Thread writer2 = new Thread(wr2);

        reader2.start();
        reader1.start();
        writer1.start();
        reader3.start();
        reader4.start();
        writer2.start();
        reader5.start();
        reader6.start();
    }
}
