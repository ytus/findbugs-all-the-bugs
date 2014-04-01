package cz.rozumim.findbugsallbugs;

import java.util.List;

import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.Detector;


public interface FindbugsTestCase {

	public String getBugType();
	
	public List<Class> getClassesWithBug();

	public List<Class> getClassesWithoutBug();
	
	public Detector getDetector(BugReporter bugReporter);
}
