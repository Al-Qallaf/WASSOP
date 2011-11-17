package wasso.dundee.ac.uk;

import junit.framework.TestCase;


import wasso.dundee.ac.uk.sqldb;
import android.content.Context;

public class sqldb_test extends TestCase{
	private static final Context Context = null;
	
	public void testCreateEntry() {
		//fail("Not yet implemented");
		//sqldb ce = new sqldb(Context);
		//ce.open();
		//assertEquals(-1,ce.createEntry("share name", "60", "10", "8"));
		//ce.close();
	}

	
	public void testCheckValidety() {
		//fail("Not yet implemented");
		sqldb ndb = new sqldb(Context);
		assertEquals("00",ndb.checkValidety("-1"));
		assertEquals("10",ndb.checkValidety("10"));
		assertEquals("0000",ndb.checkValidety(""));
		assertEquals("000",ndb.checkValidety("1000000"));
		assertEquals("0",ndb.checkValidety("0"));
		assertEquals("0000",ndb.checkValidety("testt"));
		assertEquals("0000",ndb.checkValidety("12t66"));
	}

}
