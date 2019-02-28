package training.supportbank;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvReading {

    public static List<Transaction> getTransactionsFromFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            Transaction transactionFromLine = convertLineToTransaction(lines.get(i));
            transactions.add(transactionFromLine);
        }
        return transactions;
    }

    private static Transaction convertLineToTransaction(String line) {
        String[] lineParts = line.split(",");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Transaction(
                LocalDate.parse(lineParts[0], format),
                lineParts[1],
                lineParts[2],
                lineParts[3],
                new BigDecimal(lineParts[4])
        );
    }
}
