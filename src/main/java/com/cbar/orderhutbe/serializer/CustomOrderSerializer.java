package com.cbar.orderhutbe.serializer;

import com.cbar.orderhutbe.model.FinalOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomOrderSerializer extends StdSerializer<List<FinalOrder>> {

    public CustomOrderSerializer() {
        this(null);
    }

    public CustomOrderSerializer(Class<List<FinalOrder>> t) {
        super(t);
    }

    @Override
    public void serialize(List<FinalOrder> finalOrders, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<FinalOrder> orders = new ArrayList<>();
        for (FinalOrder o : finalOrders) {
            o.setDishList(null);
            orders.add(o);
        }
        jsonGenerator.writeObject(orders);
    }
}
