import org.junit.Test;

import com.example.Model.Parkinglot;
import com.example.Model.User;
import com.example.Model.Vehical;
import com.example.Model.VehicalType;
import com.example.Service.ParkinglotSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class ParkinglotSystemTest {

    @Test
    public void bookSlotTest() {
        // Create a Person object

        ArrayList<Parkinglot> parkinglots = new ArrayList<>();
        Parkinglot parkinglot1 = new Parkinglot(1, VehicalType.TRICICLE);
        Parkinglot parkinglot2 = new Parkinglot(3, VehicalType.BYCYCLE);
        Parkinglot parkinglot3 = new Parkinglot(5, VehicalType.BYCYCLE);
        Parkinglot parkinglot4 = new Parkinglot(2, VehicalType.BYCYCLE);
        Parkinglot parkinglot5 = new Parkinglot(7, VehicalType.BIKE);
        Parkinglot parkinglot6 = new Parkinglot(8, VehicalType.CAR);
        parkinglots.add(parkinglot1);
        parkinglots.add(parkinglot2);
        parkinglots.add(parkinglot3);
        parkinglots.add(parkinglot4);
        parkinglots.add(parkinglot5);
        parkinglots.add(parkinglot6);
        ParkinglotSystem parkinglotSystem = new ParkinglotSystem(parkinglots);
        Vehical vehical1 = new Vehical(1, VehicalType.BIKE);
        Vehical vehical2 = new Vehical(2, VehicalType.BYCYCLE);
        Vehical vehical3 = new Vehical(6, VehicalType.BYCYCLE);
        Vehical vehical4 = new Vehical(8, VehicalType.TRICICLE);
        User user1 = new User(5);
        User user2 = new User(6);
        parkinglotSystem.bookSlot(vehical1, user1);
        parkinglotSystem.bookSlot(vehical3, user1);
        parkinglotSystem.bookSlot(vehical4, user1);

        parkinglotSystem.bookSlot(vehical1, user2);
        parkinglotSystem.bookSlot(vehical3, user2);
        parkinglotSystem.bookSlot(vehical4, user2);
        parkinglotSystem.bookSlot(vehical2, user1);

         ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        
        parkinglotSystem.printAllSlots(user1);
        // Check if the message was printed
        assertEquals("slot bbb id = 7 vehical id = 1 \n" + //
                        "slot bbb id = 3 vehical id = 6 \n" + //
                        "slot bbb id = 1 vehical id = 8 \n" + //
                        "slot bbb id = 2 vehical id = 2 \n", outContent.toString());

        // Restore original System.out
        System.setOut(System.out);
    }

    @Test
    public void releaseSlotTest(){

        ArrayList<Parkinglot> parkinglots = new ArrayList<>();
        Parkinglot parkinglot1 = new Parkinglot(1, VehicalType.TRICICLE);
        Parkinglot parkinglot2 = new Parkinglot(3, VehicalType.BYCYCLE);
        Parkinglot parkinglot3 = new Parkinglot(5, VehicalType.BYCYCLE);
        Parkinglot parkinglot4 = new Parkinglot(2, VehicalType.BYCYCLE);
        Parkinglot parkinglot5 = new Parkinglot(7, VehicalType.BIKE);
        Parkinglot parkinglot6 = new Parkinglot(8, VehicalType.CAR);
        parkinglots.add(parkinglot1);
        parkinglots.add(parkinglot2);
        parkinglots.add(parkinglot3);
        parkinglots.add(parkinglot4);
        parkinglots.add(parkinglot5);
        parkinglots.add(parkinglot6);
        ParkinglotSystem parkinglotSystem = new ParkinglotSystem(parkinglots);
        Vehical vehical1 = new Vehical(1, VehicalType.BIKE);
        Vehical vehical2 = new Vehical(2, VehicalType.BYCYCLE);
        Vehical vehical3 = new Vehical(6, VehicalType.BYCYCLE);
        Vehical vehical4 = new Vehical(8, VehicalType.TRICICLE);
        User user1 = new User(5);
        User user2 = new User(6);
        parkinglotSystem.bookSlot(vehical1, user1);
        parkinglotSystem.bookSlot(vehical3, user1);
        parkinglotSystem.bookSlot(vehical4, user1);

        parkinglotSystem.bookSlot(vehical1, user2);
        parkinglotSystem.bookSlot(vehical3, user2);
        parkinglotSystem.bookSlot(vehical4, user2);
        parkinglotSystem.bookSlot(vehical2, user1);
        parkinglotSystem.releaseSlot(3, user1);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        
        parkinglotSystem.printAllSlots(user1);
        // Check if the message was printed
        assertEquals("slot bbb id = 7 vehical id = 1 \n" + //
                        "slot bbb id = 1 vehical id = 8 \n" + //
                        "slot bbb id = 2 vehical id = 2 \n", outContent.toString());

        // Restore original System.out
        System.setOut(System.out);
    }
}
