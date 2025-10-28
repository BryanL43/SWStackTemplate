import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import org.application.template.AppTests;

/**
 * MainTestSuite
 *
 * Test suite that sequentially execute the listed tests.
 */
@Suite
@SelectClasses({
    // Example: ExampleTest.class, ...
    AppTests.class
})
public class MainTestSuite {}
