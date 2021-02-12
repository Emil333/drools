package com.tech.drools.converter;

import javax.persistence.AttributeConverter;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;

public class ByteToBlobConverter implements AttributeConverter<byte[], Blob> {
    @Override
    public Blob convertToDatabaseColumn(byte[] bytes) {
        Blob blob = null;
        if (bytes != null){
            try {
                blob = new SerialBlob(bytes);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return blob;
    }

    @Override
    public byte[] convertToEntityAttribute(Blob blob) {
        byte[] bytes = null;
        if (blob != null){
            try {
                bytes = blob.getBytes(1l, (int)blob.length());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return bytes;
    }
}
