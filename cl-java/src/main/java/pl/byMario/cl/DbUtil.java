package pl.byMario.cl;
import org.armedbear.lisp.*;
import org.armedbear.lisp.Closure.Parameter;
import org.armedbear.lisp.Package;

import pl.byMario.Main;
/**
 * 
 * @author Mariusz Lewandowski; Archidoc S.A.
 */
public class DbUtil {
	
	private String responce = "";

	
	public String clJava(String userSentence) throws InterruptedException {

		Runnable r = new Runnable() {
			public void run() {

				Interpreter interpreter = Interpreter.createInstance();
				if( interpreter == null){
					interpreter = Interpreter.getInstance();
				}
//				InterpreterInstance interpreterInstance = new InterpreterInstance();
				
//				Interpreter interpreter = interpreterInstance.getInterpreter();
				
				System.out.println(interpreter.eval("(load \"D:/Dropbox/LISP/sentenceGenerator.lisp\")").getStringValue());
				// the function is not in a separate package, thus the
				// correct package is CL-USER. Symbol names are
				// upper case. Package needs the prefix, because java
				// also has a class named Package.

				Package defaultPackage = Packages.findPackage("CL-USER");
				System.out.println(defaultPackage.getName());
				Symbol voidsym = defaultPackage.findAccessibleSymbol("GENERATES");
				System.out.println(voidsym.getDescription().getStringValue());
				Function myFunction = (Function)voidsym.getSymbolFunction();
				System.out.println(myFunction.printObject());
//				JavaObject parameter = new JavaObject ("*simple-grammar*");
				Symbol ttsym = defaultPackage.findAccessibleSymbol("*SIMPLE-GRAMMAR*");
				LispObject sg = ttsym.getSymbolValue();
//				System.out.println(ttsym.getDescription().getStringValue());
				System.out.println(ttsym.name.toString());
//				Parameter parameter = ttsym.getp
//				SimpleString ss = ttsym.name;
//				LispObject ob = JavaObject.getInstance(new SimpleString("*simple-grammar*"), false);
//				System.out.println(interpreter.eval("(GENERATES *SIMPLE-GRAMMAR*)"));
//				System.out.println(myFunction.execute(ttsym.name));
				Cons list =  (Cons) myFunction.execute(sg);
				LispObject result = myFunction.execute(sg);
//				String tt = list.getStringValue();
				System.out.println(result.length());
				System.out.println(result.toString());
				System.out.println(result.printObject());
//				System.out.println(list.chars());
//				Load.loadSystemFile("D:\\lispfunctions.lisp", false);
				responce =  result.printObject();
			}
		};
		Thread t = new Thread(null, r, "interpreter", 4194304L);
		t.start();
		
		t.join();
		
		return responce;

	}
	
}
