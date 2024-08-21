package check;

import library.LibraryService;

/**
 * PerformanceTest
 */
public class PerformanceTest {

    public static long checkPerformanceTime() {

        long beforeTime = System.currentTimeMillis();

        long afterTime = System.currentTimeMillis();

        long secDiffTime = (afterTime - beforeTime)/1000;
        
        return secDiffTime;

    }    
}