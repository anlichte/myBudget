package de.dielicht.budget.persistence;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonPersister
{
    public static final Path BUDGET_FILE_PATH = Paths.get("Budgetwerte.txt");
    private ObjectMapper jsonMapper;

    public JsonPersister()
    {
        this.jsonMapper = new ObjectMapper()
        		.registerModule(new JavaTimeModule())
                .enable(SerializationFeature.INDENT_OUTPUT);
    }

    public BudgetData read() throws IOException
    {
        return this.jsonMapper.readValue(BUDGET_FILE_PATH.toFile(),
                BudgetData.class);
    }

    public void write(BudgetData data) throws IOException
    {
        this.jsonMapper.writeValue(BUDGET_FILE_PATH.toFile(), data);
    }
}
