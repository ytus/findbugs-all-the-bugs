package cz.rozumim.findbugsallbugs.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cz.rozumim.findbugsallbugs.FindbugsTestCase;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.Detector;
import edu.umd.cs.findbugs.detect.DumbMethods;

public class DMI_RANDOM_USED_ONLY_ONCE_TestCase implements FindbugsTestCase {

	class DMI_RANDOM_USED_ONLY_ONCE {

		// PROBLEM: This code creates a java.util.Random object, uses it to
		// generate one random number, and then discards the Random object.

		public int getRandom() {
			return (new Random()).nextInt();
		}
	}
	
	class DMI_RANDOM_USED_ONLY_ONCE_OK {
	
		// this is OK though
		
		public int getRandomOK() {
			Random r = new Random();
			return r.nextInt();
		}
	}

	public String getBugType() {
		return "DMI_RANDOM_USED_ONLY_ONCE";
	}

	public Detector getDetector(BugReporter bugReporter) {
		return new DumbMethods(bugReporter);
	}

	@Override
	public List<Class> getClassesWithBug() {

		List<Class> classes = new ArrayList<Class>();

		classes.add(DMI_RANDOM_USED_ONLY_ONCE.class);

		return classes;
	}

	@Override
	public List<Class> getClassesWithoutBug() {
		
		List<Class> classes = new ArrayList<Class>();

		classes.add(DMI_RANDOM_USED_ONLY_ONCE_OK.class);

		return classes;
	}
}
