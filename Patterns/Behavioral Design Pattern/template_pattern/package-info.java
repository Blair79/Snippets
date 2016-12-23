/**
In Template pattern, a parent abstract class expose several abstract methods for the subclass to implement.
In the parent abstract class there is another method or several methods which uses the abstract methods to achieve
business logics.
The abstract methods usually are for each step required by the parent class.
For example, in order to use a new software we need to download, install, configuration, and run. If we are going to use
template pattern to code the logic we would create a parent class as follows. 

For using different software we just need to inherit from the abstract class above and provide the detailed implementation.
Template pattern is a behavior pattern.
 */
/**
 * @author ColBl
 *
 */
package template_pattern;