package cz.rozumim.findbugsallbugs.testcases;

import java.util.ArrayList;
import java.util.List;

import cz.rozumim.findbugsallbugs.FindbugsTestCase;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.Detector;
import edu.umd.cs.findbugs.detect.CloneIdiom;
import edu.umd.cs.findbugs.detect.DumbMethods;
import edu.umd.cs.findbugs.detect.FindHEmismatch;


public class CN_IDIOM_TestCase implements FindbugsTestCase {
	
	class CN_IDIOM implements Cloneable{

		//  PROBLEM: missing clone() method
		//	@Override
		//	protected Object clone() throws CloneNotSupportedException {
		//		return super.clone();
		//	}
		
	}
		
	public String getBugType() {
		 return "CN_IDIOM";
	}

	public Detector getDetector(BugReporter bugReporter) {
		return new CloneIdiom(bugReporter);
	}

	@Override
	public List<Class> getClassesWithBug() {
		
		List<Class> classes = new ArrayList<Class>();

		classes.add(CN_IDIOM.class);

		return classes;
	}

	@Override
	public List<Class> getClassesWithoutBug() {
		List<Class> classes = new ArrayList<Class>();

		// classes.add();

		return classes;
	}
}
