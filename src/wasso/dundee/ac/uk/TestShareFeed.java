package wasso.dundee.ac.uk;

import junit.framework.TestCase;

public class TestShareFeed extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetPrice() {
		ShareFeed feed = new ShareFeed();
		assertTrue(feed.getPrice("BP") >= 0 && feed.getPrice("BP") < 10000) ;
	}

}
