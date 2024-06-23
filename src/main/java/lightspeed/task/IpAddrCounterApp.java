package lightspeed.task;

import lightspeed.task.counter.UniqueIpAddressCounter;
import lightspeed.task.counter.UniqueIpAddressCounter4dArrayImpl;
import lightspeed.task.counter.UniqueIpAddressCounterBitSetImpl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IpAddrCounterApp {

    private static void processFile(String fileName, String counterImpl) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            UniqueIpAddressCounter counter;

            switch (counterImpl) {
                case "BitSet":
                    counter = new UniqueIpAddressCounterBitSetImpl();
                    break;
                case "4dArray":
                    counter = new UniqueIpAddressCounter4dArrayImpl();
                    break;
                default:
                    counter = new UniqueIpAddressCounterBitSetImpl();
                    break;
            }


            long linesProcessed = 0;
            String line;

            while ((line = reader.readLine()) != null) {

                counter.registerIpAddress(line);
                linesProcessed++;

            }

            System.out.print("Total of " + linesProcessed + "  IP addresses processed, from which "
                    + counter.getUniqueAddrCount() + " where unique");

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public static void main(String[] args) {

        if (args.length == 0) {
            throw new IllegalArgumentException("File Path Not Specified");
        }


        if (Files.exists(Paths.get(args[0]))) {

            String counterStrategy = "BitSet";
            if (args.length == 2) {
                counterStrategy = args[1];
            }
            processFile(args[0], counterStrategy);

        } else {

            System.out.println("File " + args[0] + " doesn't exist");

        }

    }
}