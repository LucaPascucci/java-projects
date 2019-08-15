package it.unibo.apice.oop.p13reflection.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented						// genera documentazione javadoc
@Target(ElementType.METHOD)		// potrà essere usato solo nei metodi
@Retention(RetentionPolicy.RUNTIME)		// sarà visibile a run-time
public @interface ToString {
	boolean showMethodName() default true;	  // proprietà specificabili
	String customName() default "";
	String associationSymbol() default "->";
	String separator() default "|";
}
