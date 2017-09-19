package builder_pattern;
/**
Builder pattern is used to create a complex object using simple objects.
It creates the bigger object step by step from small and simple object.
Builder pattern is another creational pattern.
For example, when creating a window as our application's main window, we need to create a menu, a toolbar and then
add the menu and toolbar.
For each window we are going to create, we need to create an empty window, create a menu, create a toolbar,
install the menu and toolbar to the window.
We can use the builder pattern to hide the implementation of how to create a window. 
 */
/**
 * @author colblair
 *
 */
