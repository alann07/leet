package com.mycompany.lrucache146;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCacheTest {
    @Test
    public void testLRUCache() {
        LRUCache cache = new LRUCache(2);
        assertEquals(-1, cache.get(1));
        cache.put(1,1);
        assertEquals(1, cache.get(1));
        cache.put(1,2);
        assertEquals(2, cache.get(1));
        cache.put(2,2);
        assertEquals(2, cache.get(2));
        assertEquals(2, cache.get(1));
        cache.put(3,3);
        assertEquals(3, cache.get(3));
        assertEquals(-1, cache.get(2));
        cache.put(4,4);
        assertEquals(-1, cache.get(2));

//        [[2],[1,0],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        cache = new LRUCache(2);
        cache.put(1,0);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        assertEquals(-1, cache.get(2));
        cache.put(4,4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
        cache.put(4,4);
        assertEquals(3, cache.get(3));
    }
}
