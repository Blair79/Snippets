/**
In Null Object pattern, a business-meaningless object is created incase of null object.
We use the business-meaningless object to replace the null pointer check.
We call the a business-meaningless object Null Object.
Null object provides default behaviour when data is not available.
In Null Object pattern, we usually create an abstract class to specify the various operations.
Both Null Object and concreate classes will extends this abstract class.
The Null Object class just provide empty logic. 
 */
/**
 * @author ColBl
 *
 */
package null_object_pattern;