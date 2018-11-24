/*
 * nkc160130
 * Due: 11/24/18
 */
package djsetmaze;

import java.util.Random;

/**
 * Generates a random integer within a range.
 * @author Kevin Chen
 */
public class RandIntGen 
{
    public static int genRandomNumber(int min, int max)
    {
        Random gen = new Random();
        return gen.nextInt(max - min + 1) + min;
    }
}
