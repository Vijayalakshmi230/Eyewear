package com.examly;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testEyewearClassExists() {
        assertDoesNotThrow(() -> Class.forName("com.examly.entity.Eyewear"),
                "Eyewear class should exist in com.examly.entity");
    }    

    @Test
    public void testEyewearServiceExists() {
        assertDoesNotThrow(() -> Class.forName("com.examly.service.EyewearService"),
                "EyewearService should exist in com.examly.dao");
    }

    @Test
    public void testEyewearServiceImplExists() {
        assertDoesNotThrow(() -> Class.forName("com.examly.service.EyewearServiceImpl"),
                "EyewearServiceImpl should exist in com.examly.dao");
    }

    @Test
    public void testDBConnectionUtilExists(){
        assertDoesNotThrow(() -> Class.forName("com.examly.util.DBConnectionUtil"),
                "DBConnectionUtil should exixt in com.examly.util");      
    }

    @Test
    public void testBookRepositoryImplIsConcrete() throws Exception {
        Class<?> impl = Class.forName("com.examly.service.EyewearServiceImpl");
        assertFalse(Modifier.isAbstract(impl.getModifiers()), "EyewearServiceImpl must be a concrete class");
    }

    @Test
    public void testMainModuleExists(){
        assertDoesNotThrow(() -> Class.forName("com.examly.MainModule"),
                "MainModule should exist in com.examly.MainModule");  
    }


}
