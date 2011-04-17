package koans

class AboutAsserts extends Koans {
	
	void testAssertTruth() {
		assert true		// this should be true
	}
	
	void testAssertWithMessage() {
		assert false, "This should be true -- Please fix this"
	}

}
