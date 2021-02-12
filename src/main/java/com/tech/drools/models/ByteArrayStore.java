package com.tech.drools.models;

import java.io.Serializable;
import java.util.Objects;

public class ByteArrayStore implements Serializable {

    private Long byteString;

    public ByteArrayStore(Long byteString) {
        this.byteString = byteString;
    }

    public Long getByteString() {
        return byteString;
    }

    public void setByteString(Long byteString) {
        this.byteString = byteString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ByteArrayStore that = (ByteArrayStore) o;
        return Objects.equals(byteString, that.byteString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(byteString);
    }

    @Override
    public String toString() {
        return "ByteArrayStore{" +
                "byteString='" + byteString + '\'' +
                '}';
    }
}
