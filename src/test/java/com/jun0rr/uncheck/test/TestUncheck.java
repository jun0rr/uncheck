/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jun0rr.uncheck.test;

import com.jun0rr.uncheck.Uncheck;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Juno
 */
public class TestUncheck {
  
  @Test public void testUncheck() {
    Assertions.assertThrows(IOException.class, ()->{
      throw Uncheck.uncheck(new IOException());
    });
  }
  
  @Test public void testRunnable() {
    Assertions.assertThrows(IOException.class, ()->Uncheck.call(()->{
      throw new IOException();
    }));
  }
  
}
