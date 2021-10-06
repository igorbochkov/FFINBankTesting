package org.example.testing.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.testing.model.Goods;

import java.io.IOException;
import java.io.InputStream;

public class UtilParser {

    public static Goods parseFromGoods(InputStream resourceAsStream) {
        ObjectMapper objectMapper = new ObjectMapper();

        Goods goods = null;
        try {
            goods = objectMapper.readValue(resourceAsStream, Goods.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return goods;
    }

}
