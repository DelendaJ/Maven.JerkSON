package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;

// set regex to handle bullshit

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) throws ItemParseException {

        String separator = "##";
        String[] thisIsAnArrayOfStrings = valueToParse.split(separator);
        ArrayList<Item> thisIsAnArrayList = new ArrayList<Item>();

        for (String str : thisIsAnArrayOfStrings)
            try {
                thisIsAnArrayList.add(parseSingleItem(str + ("##")));
            } catch (ItemParseException ok) {

            }
        return thisIsAnArrayList;

    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {

        try {
            String[] pairs = singleItem.toLowerCase().split(";");
            String regex = "[:@^]";
            String name = pairs[0].substring(5);
            Double price = Double.parseDouble(pairs[1].substring(6));
            String type = pairs[2].substring(5);
            String expiration = pairs[3].substring(11, pairs[3].length() - 2);
            Item item = new Item(name, price, type, expiration);

            return item;

        } catch (Exception e) {
            throw new ItemParseException();
        }


    }
}

