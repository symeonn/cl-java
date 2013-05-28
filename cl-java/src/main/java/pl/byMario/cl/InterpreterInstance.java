package pl.byMario.cl;

import org.armedbear.lisp.Interpreter;

/**
 * 
 * @author Mariusz Lewandowski; byMario
 */
public class InterpreterInstance {

	Interpreter interpreter;
	
	public Interpreter getInterpreter() {
		return interpreter;
	}

	public void setInterpreter(Interpreter interpreter) {
		this.interpreter = interpreter;
	}

	public InterpreterInstance() {
		interpreter = Interpreter.createInstance();
		if(interpreter == null) {
			interpreter = Interpreter.getInstance();
		}
	}
}
