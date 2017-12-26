package de.dielicht.budget.persistence;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class BudgetFileReader
{
    public static final Path BUDGET_FILE_PATH=Paths.get("Budgetwerte.txt");

    public BudgetFileReader() throws IOException
    {
        List<String> initialContent=Arrays.asList("Mindestguthaben=1000.00",
                "Kontostand=2300.00",
                "Berechnungsdatum=02.08.2017",
                "Planung=mit",
                "Gehalt-Vater=h;99.01;01;2;2000.00",
                "Miete=s;15.01;01;0;555.00",
                "Energie=s;13.01;01;3;64.00",
                "Rundfunk-Fernsehen=s;15.03;03;3;52.50",
                "Provider=s;11.03;06;0;50.00",
                "Versicherung=s;20.07;12;0;240.00",
                "Urlaub=p;30.12;12;0;1600.00");

        try
        {
            Files.write(BUDGET_FILE_PATH, initialContent,
                    Charset.forName("UTF-8"),
                    StandardOpenOption.CREATE_NEW);
        }
        catch (FileAlreadyExistsException faee)
        {
            // ignore exception because we want to work with the existing values
            // from the user
        }
    }

    public Map<String, String> readFile() throws IOException
    {
        return Files.readAllLines(BUDGET_FILE_PATH)
                .stream()
                .collect(Collectors.toMap(
                        line -> StringUtils.substringBefore(line, "="),
                        line -> StringUtils.substringAfter(line, "=")));
    }

    public void writeFile(Map<String, String> newContent) throws IOException
    {
        List<String> lines=new ArrayList<>();

        newContent.forEach(
                (key, value) -> lines.add(String.join("=", key, value)));

        Files.write(BUDGET_FILE_PATH, lines, Charset.forName("UTF-8"),
                StandardOpenOption.WRITE);
    }
}
