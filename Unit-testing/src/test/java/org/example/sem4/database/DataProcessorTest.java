package org.example.sem4.database;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DataProcessorTest {

    @Test
    void processData() {
        Database database = mock(Database.class);
        String sql = "wbfviru";
        List<String> fakeData = List.of("Data1", "Data2", "Data3");
        when(database.query(sql)).thenReturn(fakeData);
        DataProcessor dp = new DataProcessor(database);

        List<String> ls = dp.processData(sql);

        assertEquals(fakeData, ls);
    }
}