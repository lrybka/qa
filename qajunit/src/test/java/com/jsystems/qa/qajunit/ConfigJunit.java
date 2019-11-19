package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.AfterAll;

public class ConfigJunit {
    @AfterAll
    public static void setupAll(){
        System.out.println("==========setupAll===========");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("==========AfetrAll===========");
    }
}
