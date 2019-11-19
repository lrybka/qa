package com.jsystems.qa.qajunit;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class ConfigJunit {
    @BeforeAll
    public static void setupAll(){
        System.out.println("==========setupAll===========");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("==========AfetrAll===========");
    }
}
