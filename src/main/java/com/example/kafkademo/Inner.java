package com.example.kafkademo;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Inner implements Serializable {

    public int id;

    public String msg;

}
