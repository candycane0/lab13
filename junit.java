import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class junit 
{
    lab13 lab;
    Integer[] expectedResult1;
    Integer[] expectedResult2;
    Integer[] expectedResult3;
    String inputFilename = "lab13_input_data.txt";
    String expectedResultsFilename = "lab13_expected_results.txt";

    @BeforeEach
    public void setUp() throws Exception 
    {
        // instantiate an instance of lab13
        lab = new lab13();
        
        // read the input value and populate the ArrayList<Integer> in the lab13 class
        lab.readData(inputFilename);
        
        // testData.get(0) has the expected results for getResult1()
        // testData.get(1) has the expected results for getResult2()
        // testData.get(2) has the expected results for getResult3()
        ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
        for( int i = 0; i < 3; i++ )
        {
            testData.add(new ArrayList<Integer>());
        }
        
        try
        {
            System.out.println("reading " + expectedResultsFilename);
            java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedResultsFilename)));
            for( int i = 0; i < testData.size(); i++ )
            {
                ArrayList<Integer> currentTestData = testData.get(i); 
                String inn;
                input.readLine();
                while( (inn = input.readLine()) != null )
                {
                    if( inn.length() > 0 )
                    {
                        currentTestData.add(Integer.valueOf(inn));
                    }
                    else
                    {
                        break;
                    }
                }
                testData.set(i, currentTestData);
                System.out.println("testData.get(" + i + ").size() = " + testData.get(i).size());
            }
            input.close();
            
            expectedResult1 = new Integer[testData.get(0).size()];
            for(int i = 0; i < testData.get(0).size(); i++)
            {
                expectedResult1[i] = testData.get(0).get(i);
            }
            
            expectedResult2 = new Integer[testData.get(1).size()];
            for(int i = 0; i < testData.get(1).size(); i++)
            {
                expectedResult2[i] = testData.get(1).get(i);
            }
            
            expectedResult3 = new Integer[testData.get(2).size()];
            for(int i = 0; i < testData.get(2).size(); i++)
            {
                expectedResult3[i] = testData.get(2).get(i);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            System.exit(0);
        }		
    }
    @Test
    void testMethod()
    {
        assertEquals(lab.getTotalCount(), 1000);
    }
    
    @Test
    void testMethod2()
    {
        assertEquals(lab.getOddCount(), 507);
    }
    
    @Test
    void testMethod3()
    {
        assertEquals(lab.getEvenCount(), 493);
    }
    
    @Test
    void testMethod4()
    {
        assertEquals(lab.getDistinctGreaterThanFiveCount(), 94);
    }
    
    @Test
    void testMethod5()
    {
        assertArrayEquals(lab.getResult1(), expectedResult1);
    }
    
    @Test
    void testMethod6()
    {
        assertArrayEquals(lab.getResult2(), expectedResult2);
    }
    
    @Test
    void testMethod7()
    {
        assertArrayEquals(lab.getResult3(), expectedResult3);
    }
}