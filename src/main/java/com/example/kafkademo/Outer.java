package com.example.kafkademo;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Outer implements Serializable {

    public int id;

    public Inner inner;

}
