package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.base.Stopwatch;
import generated.Catalog;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class XmlToJsonService {

    public String convertXmlToJson() {

        Stopwatch xmlStopWatch =  Stopwatch.createUnstarted();
        Stopwatch jsonStopWatch =  Stopwatch.createUnstarted();

        File initialFile = new File("src/main/resources/input.xml");


        ObjectMapper objectMapper = new ObjectMapper();

        ObjectMapper xmlMapper = new XmlMapper();
        ((XmlMapper) xmlMapper).setDefaultUseWrapper(false);

        try {
            xmlStopWatch.start();
            Catalog catalog =  xmlMapper.readValue(initialFile, Catalog.class);
            xmlStopWatch.stop();

            jsonStopWatch.start();
            String json = objectMapper.writeValueAsString(catalog);
            jsonStopWatch.stop();

            System.out.println("XML to Object: " + xmlStopWatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
            System.out.println("Object to Json: " + jsonStopWatch.elapsed(TimeUnit.MILLISECONDS) + "ms");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Done";
    }
}
