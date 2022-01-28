package za.co.sfy.lucid.sams.domain.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class XSDBuilder {

//    private static final Logger LOGGER = LoggerFactory.getLogger(XSDBuilder.class);
//
//    private static final String OPENING_TAG = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
//            "\n<xsd:schema xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:od=\"urn:schemas-microsoft-com:officedata\">";
//    private static final String CLOSING_TAG = "\n</xsd:schema>";
//
////    @Value("hosted.xsd.location.base.url")
//    private String hostedLocation= "http://omnisam.co.za/sasams21.3.0/";
//
////    @Value("generated.xsd.schema.location")
//    private String outputLocation = "D:\\dev\\sfy\\Lucid-SAMS\\domain\\src\\main\\java\\za\\co\\sfy\\lucid\\sams\\domain\\schema\\xsd\\SASAMS_Schemas.xsd";
//
//    public void build() throws LucidSamsExecutionException {
//
//        long start = new Date().getTime();
//
//        File outputFile = new File(outputLocation);
//        createNewFile();
//
//        ArrayList<URL> fileLocations = readDirectory();
//        for (URL fileLocation : fileLocations) {
//            populateFileContents(outputFile, fileLocation);
//        }
//
//        addClosingTag();
//        long end = new Date().getTime();
//
//        double diff = (end - start) * 0.001;
//        LOGGER.error(diff + " Seconds");
//    }
//
//    private void populateFileContents(File outputFile, URL fileLocation) throws LucidSamsExecutionException {
//        BufferedReader bufferedReader = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//
//            bufferedReader = new BufferedReader(new InputStreamReader(fileLocation.openStream()));
//            String inputLine;
//            FileWriter fileWritter = new FileWriter(outputFile.getName(),true);
//            bufferedWriter = new BufferedWriter(fileWritter);
//
//            while ((inputLine = bufferedReader.readLine()) != null) {
//
//                if (inputLine.contains("version=\"1.0\" encoding=\"UTF-8\"") || inputLine.contains("xsd:schema xmlns:xsd")) {
//                    continue;
//                }
//
//                if (inputLine.equalsIgnoreCase("<xsd:element name=\"dataroot\">")) {
//                    while ((inputLine = bufferedReader.readLine()) != null) {
//                        if (inputLine.equals("</xsd:element>")) {
//                            inputLine = bufferedReader.readLine();
//                            break;
//                        }
//                    }
//                }
//
//                if (inputLine.contains("</xsd:schema>")) {
//                    continue;
//                }
//                bufferedWriter.write("\n" + inputLine);
//            }
//        } catch (IOException e) {
//            throw new LucidSamsExecutionException("Unable to open the SASAMS_Schemas.xsd to populate all " +
//                    "child XSD's.", e);
//        } finally {
//            try {
//                if (null != bufferedReader) {
//                    bufferedReader.close();
//                }
//                if (null != bufferedWriter) {
//                    bufferedWriter.close();
//                }
//            } catch (IOException e) {
//                throw new LucidSamsExecutionException("Unable to close streams after writing to SASAMS_Schemas.xsd.", e);
//            }
//        }
//    }
//
//    private void createNewFile() throws LucidSamsExecutionException {
//
//        Path path = Paths.get(outputLocation);
//        try {
//            Files.write(path, OPENING_TAG.getBytes(), TRUNCATE_EXISTING);
//        } catch (IOException e) {
//            throw new LucidSamsExecutionException("Unable to open the SASAMS_Schemas.xsd to write the opening tag" +
//                    " and create the file.", e);
//        }
//    }
//
//    private void addClosingTag() throws LucidSamsExecutionException {
//
//        Path path = Paths.get(outputLocation);
//        try {
//            Files.write(path, CLOSING_TAG.getBytes(), APPEND);
//        } catch (IOException e) {
//            throw new LucidSamsExecutionException("Unable to open the SASAMS_Schemas.xsd to write the closing tag.", e);
//        }
//    }
//
//    private ArrayList<URL> readDirectory() throws LucidSamsExecutionException {
//
//        ArrayList<URL> hostedFiles = new ArrayList<>();
//        Document document;
//        try {
//            document = Jsoup.connect(hostedLocation).get();
//        } catch (IOException e) {
//            throw new LucidSamsExecutionException("Unable to establish connection to the hosted XSD directory", e);
//        }
//
//        // This foreach loop reads all files from the directory listing so that we can create the full file names to
//        // read from.
//        for (Element file : document.select("td a")) {
//            String fileName = file.attr("href");
//            if (fileName.contains("/")) {
//                continue;
//            }
//
//            URL hostedFileLocationURL = null;
//            try {
//                hostedFileLocationURL = new URL(hostedLocation + fileName);
//                LOGGER.error(hostedFileLocationURL.toString());
//            } catch (MalformedURLException e) {
//                throw new LucidSamsExecutionException("Unable to create hosted XSD location URL.", e);
//            }
//            hostedFiles.add(hostedFileLocationURL);
//        }
//
//        return hostedFiles;
//    }

    public ArrayList<Node> read() throws IOException {

        long start = new Date().getTime();

        File outputFile = new File("D:\\dev\\pps\\untitled\\SASAMS_Schemas.xsd");
        createNewFile(outputFile);

        ArrayList<URL> fileLocations = readDirectory();

        for (URL fileLocation : fileLocations) {
            populateFileContents(outputFile, fileLocation);
        }

        addClosingTag(outputFile);
        long end = new Date().getTime();

        double diff = (end - start) * 0.001;
        System.out.println(diff + " Seconds");
        return null;
    }

    private void populateFileContents(File outputFile, URL fileLocation) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(fileLocation.openStream()));

        String inputLine;
        BufferedWriter bw = null;
        FileWriter fileWritter = new FileWriter(outputFile.getName(),true);
        bw = new BufferedWriter(fileWritter);
        while ((inputLine = in.readLine()) != null) {

            if (inputLine.contains("version=\"1.0\" encoding=\"UTF-8\"") || inputLine.contains("xsd:schema xmlns:xsd")) {
                continue;
            }

            if (inputLine.equalsIgnoreCase("<xsd:element name=\"dataroot\">")) {
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.equals("</xsd:element>")) {
                        inputLine = in.readLine();
                        break;
                    }
                }
            }

            if (inputLine.contains("</xsd:schema>")) {
                continue;
            }
            bw.write("\n" + inputLine);
        }
        bw.close();
        in.close();
    }

    private void createNewFile(File file) throws IOException {
        String openingTags = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<xsd:schema xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:od=\"urn:schemas-microsoft-com:officedata\">";
        Path path = Paths.get("D:\\dev\\pps\\untitled\\SASAMS_Schemas.xsd");
        Files.write(path, openingTags.getBytes(), TRUNCATE_EXISTING);
    }

    private void addClosingTag(File file) throws IOException {

        String closingTag = "\n</xsd:schema>";
        Path path = Paths.get("D:\\dev\\pps\\untitled\\SASAMS_Schemas.xsd");
        Files.write(path, closingTag.getBytes(), APPEND);

    }

    private ArrayList<URL> readDirectory() throws IOException {
        String hostedLocation = "http://omnisam.co.za/sasams21.3.0/";
        ArrayList<URL> hostedFiles = new ArrayList<>();

        Document doc = Jsoup.connect(hostedLocation).get();
        for (Element file : doc.select("td a")) {
            String fileName = file.attr("href");
            if (fileName.contains("/")) {
                continue;
            }

            hostedFiles.add(new URL(hostedLocation + fileName));
        }
        return hostedFiles;
    }
}
