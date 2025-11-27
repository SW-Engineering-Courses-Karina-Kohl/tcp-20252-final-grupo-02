package com.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.model.Creator;
//importar o repositorio de criadores
public class CreatorService {

    private ArrayList<Creator> creators;


    public CreatorService() {
        this.creators = new ArrayList<>(
            Arrays.asList(
                new Creator("Alice", "Silva", "111.111.111-11", "alice@example.com", "123"),
                new Creator("Bruno", "Costa", "222.222.222-22", "bruno@example.com", "123"),
                new Creator("Carla", "Souza", "333.333.333-33", "carla@example.com", "123")
            )
        );
    }



    
}
