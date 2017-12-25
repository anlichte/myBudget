package de.dielicht;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BudgetFileReaderTest
{
    private BudgetFileReader bfr;

    @Before
    public void setup() throws IOException
    {
        this.bfr=new BudgetFileReader();
    }

    @After
    public void tearDown() throws IOException
    {
        Files.delete(BudgetFileReader.BUDGET_FILE_PATH);
    }

    @Test
    public void testInitialFileCreation() throws IOException
    {
        assertThat(Files.exists(BudgetFileReader.BUDGET_FILE_PATH))
                .isEqualTo(true);
        assertThat(Files.readAllLines(BudgetFileReader.BUDGET_FILE_PATH).size())
                .isEqualTo(11);
    }

    @Test
    public void testReadFileIfNotExists() throws IOException
    {
        Map<String, String> content=this.bfr.readFile();

        assertThat(content.get("Gehalt-Vater"))
                .isEqualTo("h;99.01;01;2;2000.00");
    }

    @Test
    public void testThatAnExistingFileIsNotOverwritten() throws IOException
    {
    }
}
