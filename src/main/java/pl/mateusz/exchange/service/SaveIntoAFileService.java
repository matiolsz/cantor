package pl.mateusz.exchange.service;

import org.springframework.stereotype.Service;
import pl.mateusz.exchange.dao.CurrencyExchangeRepository;
import pl.mateusz.exchange.model.dto.CurrencyExchangeDTO;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@Service
public class SaveIntoAFileService {

    private static final String USER_DIR = System.getProperty("user.dir");

    private static File folder;
    private static File historyOfConversionsFile;
    private final CurrencyExchangeRepository currencyExchangeRepository;
    private PrintWriter writer;

    public SaveIntoAFileService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    public void saveAConversionToTheFile(CurrencyExchangeDTO currencyExchangeDTO) {
        writer.print(currencyExchangeDTO.toString());
    }

    public void createAFile(){
        folder = new File(USER_DIR + File.separator + "history-of-conversions");
        folder.mkdir();
        System.out.println(folder.getAbsolutePath());
        try {
            historyOfConversionsFile = new File(folder.getParentFile()+"\\history-of-conversions" + File.separator + LocalDateTime.now().withNano(0).format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")));
            if(historyOfConversionsFile.createNewFile()) {
                System.out.println("File created: " + historyOfConversionsFile.getName());
            }else{
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }

        try {
            writer = new PrintWriter(historyOfConversionsFile.getAbsolutePath(),"UTF-8");
            writer.println("History of conversions: ");
        }catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public void closeWriter(){
        writer.close();
    }
}
