import koans.*;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure

public class ThePathToEnlightenment {

	private static TestSuite koans() {
		TestSuite suite = new TestSuite(this.class.name);
        [       
//		[  	    AboutAsserts.class
//            ,   AboutTruth.class
                AboutClasses.class
		].each { koan -> suite.addTestSuite(koan) }
		return suite;
	}

	public static void main(String[] args) {
		new Guru().seekAdviceOn(koans())
	}

}
