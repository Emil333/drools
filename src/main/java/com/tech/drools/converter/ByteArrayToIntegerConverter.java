package com.tech.drools.converter;

import javax.persistence.AttributeConverter;

public class ByteArrayToIntegerConverter implements AttributeConverter<byte[], Integer> {
    @Override
    public Integer convertToDatabaseColumn(byte[] bytes) {
        return 1;
    }

    @Override
    public byte[] convertToEntityAttribute(Integer integer) {
        return new byte[0];
    }
}
