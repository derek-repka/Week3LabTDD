package cmput402.tdd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;

import cmput402.tdd.service.Search;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	Utility util = new Utility();
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void TestcountAverageScore()
    {
    	Search mockSearch = mock(Search.class);
    	HashMap<String, ArrayList<Integer>> fakeMap = new HashMap<String, ArrayList<Integer>>();
    	
    	ArrayList<Integer> messi = new ArrayList<Integer>();
    	messi.add(100);
    	messi.add(200);
    	
    	ArrayList<Integer> ronaldo = new ArrayList<Integer>();
    	ronaldo.add(80);
    	ronaldo.add(150);
    	
    	ArrayList<Integer> neymar = new ArrayList<Integer>();
    	neymar.add(50);
    	neymar.add(80);
    	
    	fakeMap.put("messi", messi);
    	fakeMap.put("ronaldo", ronaldo);
    	fakeMap.put("neymar", neymar);
    	
    	when(mockSearch.returnAll()).thenReturn(fakeMap);
    	HashMap<String, Float> results = util.countAverageScore(mockSearch);
    	
    	assert(results.get("messi").equals(2f));
    	assert(results.get("ronaldo").equals(1.875f));
    	assert(results.get("neymar").equals(1.6f));


    }
    
    public void TestfindTopScorer()
    {
    	Search mockSearch = mock(Search.class);
    	HashMap<String, ArrayList<Integer>> fakeMap = new HashMap<String, ArrayList<Integer>>();
    	
    	ArrayList<Integer> messi = new ArrayList<Integer>();
    	messi.add(100);
    	messi.add(200);
    	
    	ArrayList<Integer> ronaldo = new ArrayList<Integer>();
    	ronaldo.add(80);
    	ronaldo.add(150);
    	
    	ArrayList<Integer> neymar = new ArrayList<Integer>();
    	neymar.add(50);
    	neymar.add(80);
    	
    	fakeMap.put("messi", messi);
    	fakeMap.put("ronaldo", ronaldo);
    	fakeMap.put("neymar", neymar);
    	
    	when(mockSearch.returnAll()).thenReturn(fakeMap);
    	HashMap<String, Integer> results = util.findTopScorer(mockSearch);

    	assert(results.keySet().toArray()[0].toString().compareTo("messi") == 0);
    	assert(results.get("messi").equals(200));
    	assert(results.get("ronaldo") == null);
    	assert(results.get("neymar") == null);
    }
}
