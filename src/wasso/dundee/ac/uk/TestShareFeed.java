package wasso.dundee.ac.uk;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestShareFeed {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPrice() {
	ShareFeed feed = new ShareFeed();
	assertTrue(feed.getPrice("BP") >= 0 && feed.getPrice("BP") < 10000) ;
	}

}
