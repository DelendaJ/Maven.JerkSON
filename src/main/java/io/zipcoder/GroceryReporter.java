package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;

public class GroceryReporter {
    private final String originalFileText;
    ItemParser parse = new ItemParser();

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {
        try {
            parse.parseItemList(originalFileText);
            List<Item> ok = parse.parseItemList(originalFileText);
            for (Item i : ok) {
                System.out.println(i);

            }


        } catch (ItemParseException e) {
            e.printStackTrace();
        }
        return null;


    }
}
