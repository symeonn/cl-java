package pl.byMario;

/*
 * Main.java
 *
 * Copyright (C) 2008 Ville Voutilainen
 * $Id: Main.java 12307 2009-12-25 21:54:31Z ehuelsmann $
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

import java.io.EOFException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.armedbear.lisp.Java;
import org.jatha.Jatha;
import org.jatha.dynatype.LispValue;
import org.jatha.read.LispParser;
import org.springframework.beans.factory.annotation.Autowired;

import pl.byMario.service.NeuralNetService;
import pl.byMario.service.UserCommunicationService;
import pl.byMario.service.WordReaderService;
import pl.byMario.service.WordWriterService;

public class Main {

	@Autowired
	UserCommunicationService userCommunicationService;

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	/**
	 * This example creates an Interpreter instance, loads our lisp code from a
	 * file and then looks up a function defined in the loaded lisp file and
	 * executes the function.
	 * 
	 * The function takes a single parameter and invokes a java method on the
	 * object provided. We provide our Main object as the parameter.
	 * 
	 */
	public static void main(String[] argv) {

		// processNetTest();
//		checkLoopBreak();
//		ListContainsCheck();
		
		startNet();
		

		String operToUpdate = "";

		System.out.println(operToUpdate.isEmpty());
		// List<Long> removeTest = new ArrayList<Long>();
		// removeTest.add(1L);
		// removeTest.add(2L);
		// removeTest.add(3L);
		// removeTest.add(4L);
		//
		// Long removed = removeTest.remove(0);

		// String sentence = "";

		// UserCommunicationService userCommunicationService = new
		// UserCommunicationService();

		// List<Long> neuronIds =
		// userCommunicationService.processSentence(sentence);

		// List<Double> initialValues = new ArrayList<Double>();

		// for(int i = 0; i < 16; i++) {
		// initialValues.add(Math.random());
		// }

		// for(String str : yy) {
		// if(str.trim().equals("gray")) {
		// cellIds.add(1d);
		//
		// }
		// else {
		// cellIds.add(0d);
		// }
		// }

		// Double tanh = 0.845234624;
		// int decimal = 12;
		// System.out.println((int)doubleTemp);
		// String hex = Integer.toHexString((int)doubleTemp);
		// List<Object> sizeTest = new ArrayList<Object>(Integer.MAX_VALUE);

		// System.out.println(Long.MAX_VALUE);

		// String test = "kukunamuniu.xlsx";
		//
		// String[] test2 = test.split("\\.");

		// for(double i = 0d; i <1d; i += 0.01) {
		// Double tanh = (Math.pow(Math.E, i) - Math.pow(Math.E, -i)) /
		// (Math.pow(Math.E, i) + Math.pow(Math.E, -i));
		// Double artanh = 0.5*(Math.log((1+tanh)/(1-tanh)))*16;
		// // int integer1 = (int)Math.round(artanh);
		// System.out.println(i );
		// System.out.println(tanh.toString() + "\n" + artanh.toString());
		//
		// // System.out.println(integer1);
		// System.out.println("-------------------------");
		//
		// // System.out.println();
		//
		// }

		// List<Thing> basket = new ArrayList<Thing>();
		// Thing thing = new Thing(100);
		// basket.add(thing);
		// Thing another = new Thing(100);
		// System.out.println(basket.contains(thing));

		// List<Neuron> neuronsI = new ArrayList<Neuron>();
		// List<Neuron> neuronsH = new ArrayList<Neuron>();
		// List<Neuron> neuronsO = new ArrayList<Neuron>();
		//
		// NeuronI in1 = new NeuronI();
		// NeuronI in2 = new NeuronI();
		// // NeuronI in3 = new NeuronI();
		//
		// NeuronH h1 = new NeuronH();
		// NeuronH h2 = new NeuronH();
		// NeuronH h3 = new NeuronH();
		//
		// NeuronO out1 = new NeuronO();
		//
		// neuronsI.add(in1);
		// neuronsI.add(in2);
		// neuronsH.add(h1);
		// neuronsH.add(h2);
		// neuronsH.add(h3);
		// neuronsH.add(out1);

		// iterateNet();

		// java.lang.Math.atan(0);

		// Integer x = 18;

		// System.out.println(y);
		// System.out.println(y1);

		// testMap();
		try {

			// WordsImporter wi = new WordsImporter();
			// wi.importFromFile();

			// Properties props = System.getProperties();
			// String path = new File(".").getCanonicalPath();
			// String pat = System.getProperty("user.dir");
			//
			// mySqlTest();
			// clJava();
			// regCheck();
			// importWordsFromFile();
		}
		catch(Throwable t) {
			System.out.println("exception!");
			t.printStackTrace();
		}

	}

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	private static void startNet() {

		String sentence = "rozpoczynam start sieci";
		
		NeuralNetService net = new NeuralNetService();
		
		net.initNet();
		
		net.processFinal(sentence);
		
	}

	public static void processNetTest() {

		// NeuralNetService net = new NeuralNetService(16, 16, 2);

		// net.initNet2();
		// net.initInputNeurons();

		for(int i = 0; i < 160; i++) {
			// List<Double> processLayers = net.processLayers();
			System.out.print("NET OUTPUT: ");

			// for(Double double1 : processLayers) {
			// System.out.print(String.format("%.5G", double1) + "; ");
			// }

			System.out.println(" ITERATION " + i);

			// System.out.println();
		}

		// net.processFinal(neuronIds);

	}

	public void processSentence() {

	}

	public int addTwoNumbers(int a, int b) {
		return a + b;
	}

	public void jatha() throws EOFException {

		Jatha lisp = new Jatha(false, false);
		lisp.init();
		lisp.start();
		System.out.println(lisp.findPackage("CL-USER"));
		System.out.println(lisp.allPackages());
		LispValue symbol1 = lisp.parse("FOO", LispParser.PRESERVE);

		LispValue foo1 = lisp.makeInteger(7);

		// String input = "(* 5 10)";
		// LispValue result = myLisp.eval(input);
		// System.out.println(input + " = " + result);
		// System.out.println(myLisp.eval("(let ((x 7)) (* 5 x)))"));
		// System.out.println(myLisp.eval("(progn (setq x 7) (* 5 x))"));
		System.out.println(lisp.eval("(setq x 7)"));
		System.out.println(lisp.eval("(* 5 x)"));

		LispValue file = lisp.makeString("D:\\Dropbox\\LISP\\sentenceGenerator.lisp");
		LispValue rez1 = lisp.load(file);

		System.out.println(rez1.toString());

	}

	private static void mySqlTest() {

		String dbtime;
		String dbUrl = "jdbc:mysql://localhost:3306/words?user=root&password=xsed";
		String dbClass = "com.mysql.jdbc.Driver";
		String query = "Select count(*) FROM all_words";

		String findTablesQ = "SELECT DISTINCT * FROM INFORMATION_SCHEMA.COLUMNS";
		findTablesQ += " WHERE  TABLE_SCHEMA='words'";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()) {
				// rs.
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					LOGGER.info(dbtime = rs.getString(i));
				}
				// LOGGER.info(dbtime = rs.getString(1));

				// LOGGER.info(dbtime + rs.getString(2));
			}

			con.close();
		}

		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch(SQLException e) {
			e.printStackTrace();
		}

	}

	private static void importWordsFromFile() {

		WordWriterService wordWriterService = new WordWriterService();

		wordWriterService.importFromFile(null);
	}

	protected Logger getLogger() {
		return LOGGER;
	}

	public static void regCheck() {

		String zdanie = "Nr umowy 4986S";
		String zdanie1 = "Nr umowy 49866";
		String zdanie2 = "Nr umowy: 64879";

		String patternString = "Nr umowy[ \\t:]*([\\w\\-]+|[\\d]{5}|[\\d]{1,4}[A-Z]{1,3})";
		Pattern pat = Pattern.compile(patternString);

		Matcher m = pat.matcher(zdanie);
		System.out.println(zdanie);
		if(m.matches()) {
			System.out.println("pasuje");
		}
		else {
			System.out.println("NIE pasuje");

		}
		m = pat.matcher(zdanie1);
		System.out.println(zdanie1);

		if(m.matches()) {
			System.out.println("pasuje");
		}
		else {
			System.out.println("NIE pasuje");

		}
		m = pat.matcher(zdanie2);
		System.out.println(zdanie2);

		if(m.matches()) {
			System.out.println("pasuje");
		}
		else {
			System.out.println("NIE pasuje");

		}
	}

	public static void testMap() {

		List<Integer> intList = new ArrayList<Integer>();
		Set<Integer> intSet = new HashSet<Integer>();

		for(int i = 0; i < 10; i++) {
			intList.add(i);
			intSet.add(i);
		}

		System.out.println(intList.size());
		System.out.println(intSet.size());

		intList.add(2);
		intSet.add(3);

		System.out.println(intList.size());
		System.out.println(intSet.size());
	}

	static void checkLoopBreak() {

		for(int i = 0; i < 20; i++) {

			for(int j = 0; j < 20; j++) {
				System.out.print(j + " ");
				if(j == 10) break;
			}

			System.out.println(i + " ");
		}
	}

	static void ListContainsCheck() {

		List<Integer> intList = new ArrayList<Integer>();

		intList.add(new Integer(1));
		intList.add(new Integer(2));
		intList.add(new Integer(3));

		Integer integerToCheck = new Integer(6);
		int intToCheck = 4;
		

		System.out.println(intList.contains(integerToCheck));
		System.out.println(intList.contains(intToCheck));

	}

}
