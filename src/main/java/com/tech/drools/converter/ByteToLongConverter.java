package com.tech.drools.converter;

import javax.persistence.AttributeConverter;
import java.nio.ByteBuffer;

public class ByteToLongConverter implements AttributeConverter<byte[], Long> {
    @Override
    public Long convertToDatabaseColumn(byte[] bytes) {
        System.out.println(" <---------------------------------------------- value in bytes :" + bytes);
        if (bytes != null) {
            ByteBuffer bb = ByteBuffer.wrap(bytes);
            System.out.println("<---------------------------------------------- value in Long : " + bb.getLong());
            return bb.getLong();
        } else return null;
    }

    @Override
    public byte[] convertToEntityAttribute(Long aLong) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(aLong);
        return buffer.array();
    }
}
