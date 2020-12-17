package com.mkyong.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStockService {

    @DisplayName("Test deduct stock")
    @Test
    public void testDeduct() {
        StockService obj = new StockService(100);
        assertEquals(90, obj.deduct(10));
        assertEquals(0, obj.deduct(90));
        assertEquals(0, obj.deduct(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            obj.deduct(-1);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            obj.deduct(100);
        });

    }

    @DisplayName("Test add stock")
    @Test
    public void testAdd() {
        StockService obj = new StockService(100);
        assertEquals(110, obj.add(10));
        assertEquals(110, obj.add(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            obj.add(-1);
        });
    }

      @DisplayName("Test add stock")
    @Test
    public void testAdd7() {
        StockService obj = new StockService(100);
        assertEquals(110, obj.add(10));
        assertEquals(110, obj.add(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            obj.add(-1);
        });
    }

      @DisplayName("Test add stock")
    @Test
    public void testAdd6() {
        StockService obj = new StockService(100);
        assertEquals(110, obj.add(10));
        assertEquals(110, obj.add(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            obj.add(-1);
        });
    }

      @DisplayName("Test add stock")
    @Test
    public void testAdd5() {
        StockService obj = new StockService(100);
        assertEquals(110, obj.add(10));
        assertEquals(110, obj.add(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            obj.add(-1);
        });
    }

      @DisplayName("Test add stock")
    @Test
    public void testAdd4() {
        StockService obj = new StockService(100);
        assertEquals(110, obj.add(10));
        assertEquals(110, obj.add(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            obj.add(-1);
        });
    }

      @DisplayName("Test add stock")
    @Test
    public void testAdd3() {
        StockService obj = new StockService(100);
        assertEquals(110, obj.add(10));
        assertEquals(110, obj.add(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            obj.add(-1);
        });
    }

      @DisplayName("Test add stock")
    @Test
    public void testAdd2() {
        StockService obj = new StockService(100);
        assertEquals(110, obj.add(10));
        assertEquals(110, obj.add(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            obj.add(-1);
        });
    }

      @DisplayName("Test add stock")
    @Test
    public void testAdd1() {
        StockService obj = new StockService(100);
        assertEquals(110, obj.add(10));
        assertEquals(110, obj.add(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            obj.add(-1);
        });
    }



}