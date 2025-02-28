package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvHelper {
    public static Object[][] readCsvFile(String fileName) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(fileName));
        List<String[]> csvDate = csvReader.readAll();
        Object[][] result = new Object[csvDate.size()][2];
        for (int i = 0; i<csvDate.size(); i++){
            result[i]=csvDate.get(i);
        }
        return result;
    }
}
