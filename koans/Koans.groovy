package koans;

import junit.framework.TestResult 

class Koans extends GroovyTestCase {
	def __ = "FILL ME IN"
	def ___
	
	@Override void run(final TestResult result) {
		super.run(result)
		if (hasFailuresOrErrors(result)) result.stop()
	}
	
	private hasFailuresOrErrors(final TestResult result) {
		result.errorCount() || result.failureCount()
	}
	
	public static void assertTruth(Object expected, Object actual) {
		if(actual == null) {
			assertEquals(expected, false);
		} else {
			assertEquals(expected, actual.asBoolean());
		}
	}

}
