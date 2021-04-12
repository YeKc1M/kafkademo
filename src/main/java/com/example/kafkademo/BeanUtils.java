package com.example.kafkademo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BeanUtils {

    public static byte[] bean2Byte(Object obj){
        byte[] bb = null;
        try(ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArray)){
            outputStream.writeObject(obj);
            outputStream.flush();
            bb = byteArray.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bb;
    }

    public static Object byte2Obj(byte[] bytes){
        Object readObject = null;
        try(ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            ObjectInputStream inputStream = new ObjectInputStream(in)){
            readObject = inputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return readObject;
    }

}
