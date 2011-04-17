package koans

/**
 * Groovy objects. 
 * 
 * Instructions: Replace __ with the appropriate value.
 * - http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html
 * - http://groovy.codehaus.org/GDK+Extensions+to+Object
 */
class AboutObjects extends Koans {
	
    void testJustAboutEverythingisAnObject() {
        assert __ == 1 instanceof Object
        assert __ == 1.5 instanceof Object
        assert __ == "string" instanceof Object
        assert __ == {} instanceof Object            // The {} syntax is a closure
    }

    void testNullMeansNoObject() {
        assert __ == null instanceof Object 
    }

    void testEverythingIncludingNullCanBeConvertedToAString() {
        assert __ == 123.toString()
        assert __ == 1.5.toString()
        assert __ == null.toString()
    }

}

