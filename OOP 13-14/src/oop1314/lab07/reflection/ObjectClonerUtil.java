package oop1314.lab07.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


/**
 * Utility class for cloning objects via reflection
 * @author Andrea Santi
 *
 */
public class ObjectClonerUtil{
  
  private static final String GETTER_PREFIX = "get";
  private static final String SETTER_PREFIX = "set";

  /**
   * Clone the object provided in input
   * @param obj
   * @param theClass
   * @return the cloned object
   * @throws CloningException in case of any problem during the cloning
   */
  public static <T> T cloneObj(T obj, Class<T> theClass) throws CloningException {
	  T returnValue = null;
	  try{
		  Constructor<T> costruttore = theClass.getConstructor();
		  returnValue = (T)costruttore.newInstance();
		  Method[] metodi = theClass.getMethods();
		  for (Method metodoGetter : metodi){
			  if (metodoGetter.getName().startsWith(GETTER_PREFIX) && metodoGetter.getDeclaringClass().equals(theClass)){
				  Class<?> ret = metodoGetter.getReturnType();
				  String setterName = metodoGetter.getName().replace(GETTER_PREFIX, SETTER_PREFIX);
				  Method metodoSetter = theClass.getMethod(setterName, ret);
				  metodoSetter.invoke(returnValue,metodoGetter.invoke(obj));
				  }
		  }
		  
	  }catch(Exception ecc){
		  throw new CloningException(ecc.getMessage());
	  }
	  
	  return returnValue;  
	  
    /**
     * 1) Retrieve the constructor from theClass
     * 2) Cycle all the methods found in theClass
     * 3) If the method is a getter (starts with GETTER_PREFIX) of the current class
     *    (i.e. is not a getter defined in a super class, use the getDeclaringClass method 
     *    for this check) find the corresponding setter keeping in mind that: 
     *    - The setter name can be constructed by a combination of: 1)SETTER_PREFIX
     *    and 2) a substring of the getter method name.
     *    - The getReturnType method of the class Method returns the return type of a method
     * 4) Invoke the getter on obj and store the value in a temp var (tmp)
     * 5) Invoke the corresponding setter on returnValue providing as parameter tmp
     * 6) Return the cloned object
     * */
  }
}