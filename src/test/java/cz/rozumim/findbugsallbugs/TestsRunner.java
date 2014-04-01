package cz.rozumim.findbugsallbugs;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.youdevise.fbplugins.tdd4fb.DetectorAssert;

import cz.rozumim.findbugsallbugs.testcases.BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS_TestCase;
import cz.rozumim.findbugsallbugs.testcases.CN_IDIOM_NO_SUPER_CALL_TestCase;
import cz.rozumim.findbugsallbugs.testcases.CN_IDIOM_TestCase;
import cz.rozumim.findbugsallbugs.testcases.HE_EQUALS_USE_HASHCODE_TestCase;
import edu.umd.cs.findbugs.BugReporter;


public class TestsRunner {

	private static final transient Logger log = Logger
			.getLogger(TestsRunner.class);

	private FindbugsTestCase[] testCases = new FindbugsTestCase[] {
			new HE_EQUALS_USE_HASHCODE_TestCase(),
			new BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS_TestCase(),
			new CN_IDIOM_TestCase(),
			new CN_IDIOM_NO_SUPER_CALL_TestCase()};  
	
	@Test
	public void test() throws Exception {
	
		for(FindbugsTestCase testCase : testCases) {
			
			log.info("testCase=" + testCase);

			for (Class c : testCase.getClassesWithBug()) {

				log.info("+- classWithBug=" + c.getName());

				BugReporter bugReporter = DetectorAssert
						.bugReporterForTesting();

				DetectorAssert.assertBugReported(c,
						testCase.getDetector(bugReporter), bugReporter,
						DetectorAssert.ofType(testCase.getBugType()));
			}

			for (Class c : testCase.getClassesWithoutBug()) {
				
				log.info("+- classWithoutBug=" + c.getName());

				BugReporter bugReporter = DetectorAssert
						.bugReporterForTesting();
				
				DetectorAssert.assertNoBugsReported(c,
						testCase.getDetector(bugReporter), bugReporter);
			}
		}
	}
}
