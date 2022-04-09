import java.util.Scanner;
import com.fazecast.jSerialComm.*;


/**
 * Barre
 */
public class Main{
    public static void main(String[] args) 
    {
        Barre barre = new Barre(true);

        SerialPort comPort = SerialPort.getCommPorts()[0];
        comPort.openPort();
        try 
        {
            while (true)
            {
                while (comPort.bytesAvailable() == 0)
                    Thread.sleep(20);

                Scanner data = new Scanner(comPort.getInputStream());

                while(data.hasNextLine())
                {
                    int number = 0;
                    try{number = Integer.parseInt(data.nextLine());}catch(Exception e){}
                    barre.setLevel(number);
                }
            }
        } 
        catch (Exception e) { e.printStackTrace(); }
        comPort.closePort();

    }
}   