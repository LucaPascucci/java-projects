package it.unibo.apice.oop.p13reflection.annotations;

import javax.annotation.processing.*;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.Element;
import javax.lang.model.SourceVersion;
import javax.tools.Diagnostic.Kind;
import com.sun.tools.javac.code.TypeTags;

import java.util.*;

import com.sun.tools.javac.code.Symbol.MethodSymbol;

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("it.unibo.apice.oop.p13annotations.ToString")
public class ToStringChecker extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (Element e : roundEnv.getElementsAnnotatedWith(ToString.class)) {
			if (!(e instanceof MethodSymbol) || 
				!((MethodSymbol)e).params.isEmpty() ||
				((MethodSymbol)e).getReturnType().tag==TypeTags.VOID){
				processingEnv.getMessager().printMessage(Kind.ERROR,
						"@ToString cannot be applied to "+e+": it must be a getter method");
			}
		}
		return true;
	}

}
// mirko@mirko-Latitude-E6520 ~/workspace/oop/src $ javac -classpath .:/usr/lib/jvm/java-7-openjdk-amd64/lib/tools.jar  -processorpath ../bin -processor it.unibo.apice.oop.p13annotations.ToStringChecker it/unibo/apice/oop/p13annotations/*.java

