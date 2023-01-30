package com.cbar.orderhutbe.serializer;

import com.cbar.orderhutbe.model.Dish;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomDishSerializer extends StdSerializer<List<Dish>> {

    public CustomDishSerializer() {
        this(null);
    }

    public CustomDishSerializer(Class<List<Dish>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Dish> dishes, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<Dish> dishList = new ArrayList<>();
        for (Dish d : dishes) {
            d.setOrderList(null);
            dishList.add(d);
        }
        jsonGenerator.writeObject(dishList);
    }
}
