package com.tech.drools.converter;

import javax.persistence.AttributeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteToBinaryStreamConverter implements AttributeConverter<byte[], ByteArrayOutputStream> {
    @Override
    public ByteArrayOutputStream convertToDatabaseColumn(byte[] bytes) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        if (bytes != null) {
            try {
                outputStream.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputStream;
    }

    @Override
    public byte[] convertToEntityAttribute(ByteArrayOutputStream byteArrayOutputStream) {
        byte[] byteArray = null;
        if (byteArrayOutputStream != null) {
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }
}
