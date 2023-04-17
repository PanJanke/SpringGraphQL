package com.jano.springApartments.Utils;

import com.jano.springApartments.model.Apartment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static List<Apartment> readListFromCsv(String filePath) {
        List<Apartment> apartmentList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Skip the header row
            reader.readLine();

            // Read each apartment object from the file
            String line;
            int iterator=0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                String webAddress = values[0];
                String address = values[1];
                String price = values[2];
                String pricePerSqaureMeter = values[3];
                String numOfRooms = values[4];
                String squareMeters = values[5];
                Apartment apartment = new Apartment(++iterator,webAddress, address, price, pricePerSqaureMeter, numOfRooms, squareMeters);
                apartmentList.add(apartment);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return apartmentList;
    }
}
