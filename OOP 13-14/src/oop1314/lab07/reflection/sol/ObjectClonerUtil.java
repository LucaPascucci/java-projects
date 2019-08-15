package oop1314.lab07.reflection.sol;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Utility class for cloning objects via reflection
 * @author Andrea Santi
 *
 */
public class ObjectClonerUtil {
  
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
    try {
      Constructor<T> c = theClass.getConstructor();
      returnValue = c.newInstance();
      Method[] methods = theClass.getMethods();
      Method correspondingSetter;
      for (Method m : methods){
        if (m.getName().startsWith(GETTER_PREFIX) && m.getDeclaringClass().equals(theClass)){
          Object res = m.invoke(obj);
          correspondingSetter = theClass.getMethod(SETTER_PREFIX.concat(m.getName().substring(GETTER_PREFIX.length())), m.getReturnType());
          correspondingSetter.invoke(returnValue, res);
        }
      }
    } catch (Exception e) {
      throw new CloningException(e.toString());
    }
    return returnValue;
  }
}