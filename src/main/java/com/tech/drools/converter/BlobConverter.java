package com.tech.drools.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BlobConverter implements AttributeConverter<byte[], String> {
    @Override
    public String convertToDatabaseColumn(byte[] bytes) {
        if (bytes != null) return new String(bytes);
        else return null;
    }

    @Override
    public byte[] convertToEntityAttribute(String s) {
        if (s != null) return s.getBytes();
        else return null;
    }
}
