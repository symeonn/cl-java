package pl.byMario;

import java.io.EOFException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.jatha.Jatha;
import org.jatha.dynatype.LispValue;
import org.jatha.read.LispParser;
import org.springframework.beans.factory.annotation.Autowired;

import pl.byMario.service.NeuralNetService;
import pl.byMario.service.UserCommunicationService;
import pl.byMario.service.WordWriterService;

public class Main {

	@Autowired
	UserCommunicationService userCommunicationService;

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] argv) {
		
		compoundCheck();
//		forLoopCheck();
//		switchTest();
//		checkMassiveFunc();
		// jatha();
		// checkSysProps();
		// regExpCheck();
		// checkArrays();
		// parseDate();
		// getWordsFromString("so322word95");
		// stringTest();
		// processNetTest();
		// checkLoopBreak();
		// ListContainsCheck();
		// checkMapInsertion();
		// startNet();
		// processNet();
		// Double d = 45.00;
		// Double d1 = sigmoidal(d);
		// Double d2 = sigmoidalDerivative(d);
		// System.out.println(d1);
		// System.out.println(d2);

		// checkListImpl();

		// String operToUpdate = "";

		// System.out.println(operToUpdate.isEmpty());
		// List<Integer> removeTest = new ArrayList<Integer>();
		// removeTest.add(new Integer(10));

		// Integer i1 = new Integer(5);
		// Integer i2 = new Integer(10);
		//
		// if (removeTest.contains(i1)){
		// System.out.println("i1");
		// }
		//
		// if (removeTest.contains(i2)){
		// System.out.println("i2");
		// }

		// removeTest.add(2L);
		// removeTest.add(3L);
		// removeTest.add(4L);

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

		System.out.println("koniec MAIN");
	}

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	private static void compoundCheck() {


		int a=10;
		System.out.print(a + ": ");
		System.out.println(a%=3);
		
		a=4;
		System.out.print(a + ": ");
		System.out.println(a&=2);
		
		a=4;
		System.out.print(a + ": ");
		System.out.println(a^=2);
		
		a=4;
		System.out.print(a + ": ");
		System.out.println(a|=2);
		
		a=4;
		System.out.print(a + ": ");
		System.out.println(a<<=2);
		
		a=3;
		System.out.print(a + ": ");
		System.out.println(a>>=2);
		
		a=3;
		System.out.print(a + ": ");
		System.out.println(a>>>=2);
		
	}

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	private static void forLoopCheck() {
		int i = 0;
		for(i = 0; i < 5; i++) {
			System.out.println(i);
		}
		System.out.println(i);
		i=0;
		for(i = 0; i < 5; ++i) {
			System.out.println(i);
		}
		System.out.println(i);
		
	}

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	private static void switchTest() {
		
		int i = 3;
		
		switch(i) {
		case 1:
			System.out.println("case 1");	
			System.out.println(i);	
//			break;
		case 2:
			System.out.println("case 2");	
			System.out.println(i);	
		case 3:
			System.out.println("case 3");	
			System.out.println(i);	
		case 4:
			System.out.println("case 4");	
			System.out.println(i);	
			break;
		case 5:
			System.out.println("case 5");	
			System.out.println(i);	
		default:
			System.out.println("default");	
			System.out.println(i);	
//			break;
		}
		
		
	}

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	private static void checkMassiveFunc() {
//		int it = 100;
		BigDecimal it = new BigDecimal(1000);
		BigDecimal sum = new BigDecimal(1);
		for(BigDecimal x = new BigDecimal(0); x.compareTo(it) < 0; x = x.add(new BigDecimal(1))) {
			sum = sum.multiply(new BigDecimal(1).add(x));
		}
System.out.println(sum);
	}

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	private static void checkSysProps() {

		OperatingSystemMXBean odXb = ManagementFactory.getOperatingSystemMXBean();

		System.out.println(odXb.getAvailableProcessors());
		System.out.println(odXb.getArch());
		System.out.println(odXb.getName());
		System.out.println(odXb.getSystemLoadAverage());
		System.out.println(odXb.getVersion());
		System.out.println();

		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(Runtime.getRuntime().freeMemory());
		System.out.println(Runtime.getRuntime().maxMemory());
		System.out.println(Runtime.getRuntime().totalMemory());

		// RuntimeMXBean mml = ManagementFactory.getRuntimeMXBean();
		// System.out.println(mml.getName());
		//
		// for(MemoryPoolMXBean memoryManagerMXBean : mml) {
		// System.out.println(memoryManagerMXBean.getName());
		// }
	}

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	private static void checkArrays() {

		int[][] testArray;

		testArray = new int[2][];

		for(int i = 0; i < testArray.length; i++) {

			if(i == 0) {

				testArray[i] = new int[4];
			}
			else {
				testArray[i] = new int[9];

			}

		}

		System.out.println(testArray.length);
		for(int[] is : testArray) {
			System.out.println(is.length);

		}

	}

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	private static void parseDate() {
		// TODO Auto-generated method stub
		Long dateLong = new Date().getTime();
		Integer dateInt = (int)new Date().getTime();

		System.out.println();
	}

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 * @param string
	 */
	private static void getWordsFromString(String sSentence) {

		List<String> stringsToCheck = new ArrayList<String>();
		List<String> wordsToCheckInDB = new ArrayList<String>();

		Pattern characterPattern = Pattern.compile("[a-zA-Z]+");

		String password = "12KuDupaKk";

		StringBuilder pwCharsOnly = new StringBuilder();

		// Strip out all characters except A-Z and remove capitalization.
		Matcher matcher = characterPattern.matcher(password.toLowerCase());
		while(matcher.find()) {
			String group = matcher.group();
			if(group.length() >= 4) {
				stringsToCheck.add(group);
			}

			pwCharsOnly.append(matcher.group());
		}
		System.out.println(pwCharsOnly);

		Integer liczbaPodslow = 0;

		for(String string : stringsToCheck) {

			int pwLength = string.length();
			int strWidth = 4;
			int position = 0;
			String compareStr = null;
			while(strWidth < pwLength) {

				position = 0;
				while((position + strWidth) <= pwLength) {

					compareStr = string.substring(position, (position + strWidth));
					wordsToCheckInDB.add(compareStr);
					liczbaPodslow++;

					position++;
				}

				// Increase the width of the word now
				strWidth++;
			}
		}

		System.err.println("Liczba stringow do sprawdzenia: " + liczbaPodslow + " przy dlugosci hasla=" + password.length());

		// String sSentence = "The quick brown fox jumped over the lazy dog.";
		// Pattern p = Pattern.compile("\\d+");
		// String[] result = p.split(sSentence);
		// System.out.println(sSentence);

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("(");
		for(String string : wordsToCheckInDB) {
			queryBuilder.append("'" + string + "', ");
		}

		queryBuilder.replace(queryBuilder.length() - 2, queryBuilder.length(), "");

		queryBuilder.append(")");

		queryBuilder.toString();
		// TODO Auto-generated method stub

	}

	/**
	 * checking null value into string
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	private static void stringTest() {

		Object ob = null;

		ob = "kuku";

		System.out.println(ob);
		System.out.println(String.valueOf(ob));
		System.out.println(ob.toString());

	}

	/**
	 * sprawdza roznice pomiedzy ArrayList a LinkedList
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	private static void checkListImpl() {

		List<Integer> aL = new ArrayList<Integer>();
		List<Integer> lL = new LinkedList<Integer>();

		for(int i = 0; i < 5; i++) {
			aL.add(i);
			lL.add(i);
		}
		aL.add(9);
		lL.add(9);

		aL.add(9);
		lL.add(9);

		aL.add(10);
		lL.add(10);

		aL.remove(5);
		lL.remove(5);

		aL.add(11);
		lL.add(11);

		for(Iterator iterator = aL.iterator(); iterator.hasNext();) {
			Integer integer = (Integer)iterator.next();
			// if(integer.equals(4)){
			// iterator.remove();
			// }
			// iterator.

		}

		for(Iterator iterator = lL.iterator(); iterator.hasNext();) {
			Integer integer = (Integer)iterator.next();
			if(integer.equals(4)) {
				integer = new Integer(999);
				iterator.remove();

			}
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

	public static void jatha() {
		try {

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
		catch(EOFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public static void regExpCheck() {

		String zdanie = "Qwert!@#$";
		String zdanie1 = "Nr umowy 49866";
		String zdanie2 = "Nr umowy: 64879";

		String patternString = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#$%&]).*)";
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

	public static void testList() {

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

	public static void checkMapInsertion() {

		// check if when put same key with different value replaces record
		Map<Integer, String> testMap = new HashMap<Integer, String>();

		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, null);

		testMap.put(1, null);
		testMap.put(3, "three");

		System.out.println(testMap.get(1));
		System.out.println(testMap.get(2));
		System.out.println(testMap.get(3));
		System.out.println(testMap.get(4));

	}

	// for XOR

	// I I | O
	// ----+--
	// 0 0 | 0
	// 0 1 | 1
	// 1 0 | 1
	// 1 1 | 0

	static int inputNeuronsCount = 2;
	static int hiddenNeuronsCount = 3;
	static int outputNeuronsCount = 1;

	static Double momentum = 0.5;
	static Double E = 0.9; // learning rate

	static Double posStep = 1.2;
	static Double negStep = 0.5;
	static Double updateValueMax = 50d;
	static Double updateValueMin = 0.000001;

	// array: [node number][inputValues*weights sum, outputValue, nodeDelta]
	public static Double[][] inputNodes = new Double[inputNeuronsCount + 1][3]; // properties
																				// of
																				// input
																				// layer
																				// nodes
	public static Double[][] hiddenNodes = new Double[hiddenNeuronsCount + 1][3]; // properties
																					// of
																					// hidden
																					// layer
																					// nodes
	public static Double[][] outputNodes = new Double[outputNeuronsCount][3]; // properties
																				// of
																				// output
																				// layer
																				// nodes

	public static Double[] idealOutput = new Double[outputNodes.length];

	// array: [2nd layer node number][1st layer node number - input
	// from][weight, gradient, weightDelta, updateValue]
	static Double[][][] hiddenWeights = new Double[hiddenNodes.length][inputNodes.length][4]; // connections
																								// properties
																								// from
																								// input
																								// to
																								// hidden
																								// layer
	static Double[][][] outputWeights = new Double[outputNodes.length][hiddenNodes.length][4]; // connections
																								// properties
																								// from
																								// hidden
																								// to
																								// output
																								// layer

	static void setInputValues() {
		// +1 - bias
		System.out.println("INPUT");
		for(int i = 0; i < inputNodes.length - 1; i++) {
			// inputNodes[i][0] = null;
			inputNodes[i][1] = getRandomBit().doubleValue();
			// inputNodes[i][1] = 1d;
			System.out.println("neuron " + (i + 1) + " out value: " + inputNodes[i][1]);
		}
		// bias always has value = 1
		// inputNodes[inputNeuronsCount][0] = 1d;
		inputNodes[inputNeuronsCount][1] = 1d;
		System.out.println("BIAS " + inputNodes[inputNeuronsCount][1]);

		idealOutput[0] = Double.parseDouble(String.valueOf(inputNodes[0][1].intValue() ^ inputNodes[1][1].intValue()));
		System.out.println("IDEAL: " + idealOutput[0]);
	}

	public static void processNet() {

		// THIS IS OLD VERSION OF MY NETWORK
		// IT HAS BUGS, BUT TOTALLY DIFFERENT APPROACH

		// DO NOT DELETE THIS WHOLE PROCESS

		// init();
		setInputValues();

		Integer iteration = 0;

		Double output;
		System.out.println("************************");
		System.out.println("backProp");
		System.out.println("************************");

		do {
			iteration++;
			System.out.println("Iteration " + iteration);
			output = iterate();

			// if(iteration > 10) break;
		}
		while(checkErrorGradientMomentum());

		// System.out.println("Iterations " + iteration);
		// System.out.println(outputNodes[0][1].toString());

		System.out.println("Iterations TOTAL " + iteration);
		System.out.println("RESULT: " + outputNodes[0][1].toString());

		// for(int i = 0; i < inputNodes.length - 1; i++) {
		// System.out.println("neuron " + (i + 1) + " out value: " +
		// inputNodes[i][1]);
		// }

	}

	public static Double iterate() {

		// setInputValues();

		// System.out.println("iterate");
		processLayer(inputNodes, hiddenWeights, hiddenNodes);
		hiddenNodes[hiddenNeuronsCount][1] = 1d;

		// System.out.println("OUTPUT");
		processLayer(hiddenNodes, outputWeights, outputNodes);
		System.out.println("OUT: " + outputNodes[0][1]);

		// for(Double outputValue : outputNodes[0][1]) {
		// System.out.println(outputNodes[0][1].toString());
		// }

		return outputNodes[0][1];
	}

	public static void processLayer(Double[][] layerFrom, Double[][][] connectionProp, Double[][] layerTo) {
		// public static Double[] processLayer(Double[][] weights, Double[]
		// values) {

		// Double[][] tempOutputValues = new Double[weights.length];

		for(int i = 0; i < layerTo.length; i++) {

			Double sum = 0d;

			for(int j = 0; j < layerFrom.length; j++) {

				if(connectionProp[i][j][0] == null) {
					// initial weight setup
					connectionProp[i][j][0] = getRandomDouble();
				}
				//
				// if(connectionProp[i][j][0].isNaN()){
				// System.out.println();
				// }
				sum += connectionProp[i][j][0] * layerFrom[j][1];
			}

			layerTo[i][0] = sum;
			layerTo[i][1] = sigmoidal(sum);
			if(layerTo[i][1].isNaN()) {
				// System.out.println("neuron " + (i + 1) + " out value: " +
				// sum);
			}
		}

		return;

	}

	public static boolean checkErrorGradientCalculation() {

		int idealOutputInt = inputNodes[0][1].intValue() ^ inputNodes[1][1].intValue();

		Double idealOutput = Double.parseDouble(String.valueOf(idealOutputInt));

		Double error = outputNodes[0][1] - idealOutput;
		System.out.println("ERR: " + error);
		if(Math.abs(error) > 0.002) {

			gradientCalculation(error);
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean checkErrorGradientMomentum() {

		// Double idealOutput =
		// Double.parseDouble(String.valueOf(idealOutputInt));
		Double temp = 0d;

		// for(int i = 0; i < outputNodes.length; i++) {
		// temp += Math.pow(outputNodes[i][1] - idealOutput[i], 2);
		// }
		System.out.println("checking gradient");

		// Double error = temp/outputNodes.length;
		Double error = outputNodes[0][1] - idealOutput[0];
		System.out.println("ERR: " + error);

		if(Math.abs(error) > 0.002) {
			// System.out.println("ERR: "+error);
			gradientCalculation(error);

			// gradientMomentum(error);
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	private static void gradientCalculation(Double error) {

		// nodeDelta for output
		for(Double[] outputNode : outputNodes) {
			if(outputNode[0] != null) {
				outputNode[2] = (error) * (sigmoidalDerivative(outputNode[0]));
				// if(outputNode[2]==null){
				// System.out.println(outputNode[2]);
				// }
			}
		}

		// nodeDelta for hidden
		// for(Double[] hiddenNode : hiddenNodes) {
		for(int i = 0; i < hiddenNodes.length; i++) {

			if(hiddenNodes[i][0] != null) {

				// sum of weights between this H and O's
				Double weightsTimesNodeDeltaSum = 0d;
				for(int j = 0; j < outputNodes.length; j++) {

					if(outputNodes[j][2] != null) {
						weightsTimesNodeDeltaSum += outputWeights[j][i][0] * outputNodes[j][2];
					}
				}

				hiddenNodes[i][2] = sigmoidalDerivative(hiddenNodes[i][0]) * weightsTimesNodeDeltaSum;
			}
		}

		// gradient and weight
		for(int i = 0; i < outputWeights.length; i++) {

			for(int j = 0; j < hiddenNodes.length; j++) {

				Double prevGradient = outputWeights[i][j][1];

				if(prevGradient == null) {
					prevGradient = 0d;
				}

				outputWeights[i][j][1] = hiddenNodes[j][1] * outputNodes[i][2];
				// System.out.println(outputWeights[i][j][1]);

				if(outputWeights[i][j][2] == null) {
					outputWeights[i][j][2] = 0d;
				}
				if(outputWeights[i][j][3] == null) {
					outputWeights[i][j][3] = 0.05;
				}

				Double tempOldWeightDelta = outputWeights[i][j][2];

				// new weightDelta
				// System.out.println("GR "+outputWeights[i][j][1]);

				// gradient descent
				// outputWeights[i][j][2] = (-E * outputWeights[i][j][1]);

				// momentum
				// outputWeights[i][j][2] = (-E * outputWeights[i][j][1]) +
				// momentum * tempOldWeightDelta;

				// outputWeights[i][j][0] += outputWeights[i][j][2];

				// RPROP
				rProp(prevGradient, outputWeights[i][j]);

			}
		}

		// for(int i = 0; i < hiddenWeights.length - 1; i++) {
		//
		// for(int j = 0; j < inputNodes.length; j++) {
		//
		// Double prevGradient = hiddenWeights[i][j][1];
		//
		// if(prevGradient == null) {
		// prevGradient = 0d;
		// }
		//
		// // if(inputNodes[i][2] != null) {
		// hiddenWeights[i][j][1] = inputNodes[j][1] * hiddenNodes[i][2];
		// // System.out.println(hiddenWeights[i][j][1]);
		// // }
		// // if(hiddenWeights[i][j][1].isNaN()){
		// // System.err.println();
		// // }
		//
		// if(hiddenWeights[i][j][2] == null) {
		// hiddenWeights[i][j][2] = 0d;
		// }
		// if(hiddenWeights[i][j][3] == null) {
		// hiddenWeights[i][j][3] = 0.05;
		// }
		//
		// Double tempOldWeightDelta = hiddenWeights[i][j][2];
		//
		// // new weightDelta
		// // hiddenWeights[i][j][2] = (E * hiddenWeights[i][j][1]);
		//
		// // gradient descent
		// // outputWeights[i][j][2] = (-E * outputWeights[i][j][1]);
		//
		// // momentum
		// hiddenWeights[i][j][2] = (E * hiddenWeights[i][j][1]) +
		// momentum * tempOldWeightDelta;
		//
		// // new weight
		// hiddenWeights[i][j][0] += hiddenWeights[i][j][2];
		//
		// // RPROP
		// // rProp(prevGradient, hiddenWeights[i][j]);
		//
		// }
		// }

	}

	private static void rProp(Double prevGradient, Double[] nauronWeights) {

		if((prevGradient * nauronWeights[1]) > 0) {

			nauronWeights[3] = posStep * nauronWeights[3];

			if(nauronWeights[3] > updateValueMax) {
				nauronWeights[3] = updateValueMax;
			}

			nauronWeights[2] = -sign(nauronWeights[1]) * nauronWeights[3];
			nauronWeights[0] += nauronWeights[2];

		}
		else if((prevGradient * nauronWeights[1]) < 0) {

			nauronWeights[3] = negStep * nauronWeights[3];

			if(nauronWeights[3] < updateValueMin) {
				nauronWeights[3] = updateValueMin;
			}

			nauronWeights[1] = 0d;

		}
		else {
			nauronWeights[2] = -sign(nauronWeights[1]) * nauronWeights[3];
			nauronWeights[0] += nauronWeights[2];
		}
	}

	private static Double sign(Double x) {

		if(x > 0) {
			return 1d;
		}
		else if(x < 0) {
			return -1d;
		}
		else {
			return 0d;
		}

	}

	private static void rProp(Double error) {

		// nodeDelta for output
		for(Double[] outputNode : outputNodes) {
			if(outputNode[0] != null) {
				outputNode[2] = (error) * (sigmoidalDerivative(outputNode[0]));
				// if(outputNode[2]==null){
				// System.out.println(outputNode[2]);
				// }
			}
		}

		// nodeDelta for hidden
		// for(Double[] hiddenNode : hiddenNodes) {
		for(int i = 0; i < hiddenNodes.length; i++) {

			if(hiddenNodes[i][0] != null) {

				// sum of weights between this H and O's
				Double weightsTimesNodeDeltaSum = 0d;
				for(int j = 0; j < outputNodes.length; j++) {

					if(outputNodes[j][2] != null) {
						weightsTimesNodeDeltaSum += outputWeights[j][i][0] * outputNodes[j][2];
					}
				}

				hiddenNodes[i][2] = sigmoidalDerivative(hiddenNodes[i][0]) * weightsTimesNodeDeltaSum;
			}
		}

		// gradient and weight
		for(int i = 0; i < outputWeights.length; i++) {

			for(int j = 0; j < hiddenNodes.length; j++) {

				// if(outputNodes[i][2] != null) {
				outputWeights[i][j][1] = hiddenNodes[j][1] * outputNodes[i][2];
				// }

				if(outputWeights[i][j][2] == null) {
					outputWeights[i][j][2] = 0d;
				}

				Double tempOldWeightDelta = outputWeights[i][j][2];
				// new weightDelta
				outputWeights[i][j][2] = (E * outputWeights[i][j][1]) + momentum * tempOldWeightDelta;
				// new weight
				outputWeights[i][j][0] += outputWeights[i][j][2];

			}
		}

		for(int i = 0; i < hiddenWeights.length - 1; i++) {

			for(int j = 0; j < inputNodes.length; j++) {
				// if(inputNodes[i][2] != null) {
				hiddenWeights[i][j][1] = inputNodes[j][1] * hiddenNodes[i][2];
				// }
				// if(hiddenWeights[i][j][1].isNaN()){
				// System.err.println();
				// }

				if(hiddenWeights[i][j][2] == null) {
					hiddenWeights[i][j][2] = 0d;
				}

				Double tempOldWeightDelta = hiddenWeights[i][j][2];
				// new weightDelta
				hiddenWeights[i][j][2] = (E * hiddenWeights[i][j][1]) + momentum * tempOldWeightDelta;
				// new weight
				hiddenWeights[i][j][0] += hiddenWeights[i][j][2];

			}
		}

	}

	public static Double sigmoidal(Double x) {

		// sigmoidal function
		return 1 / (1 + Math.pow(Math.E, -(x)));
	}

	public static Double sigmoidalDerivative(Double x) {
		Double temp = (sigmoidal(x) * (1 - sigmoidal(x)));

		if(temp.isInfinite() || temp.isNaN()) {
			System.err.println("kuku");
			temp = Double.MAX_VALUE;
		}

		// System.out.println("SD: "+temp);
		return temp;
	}

	private static Double getRandomDouble() {

		// devided by 10 because we need as small weight as possible
		return (Math.random() - 0.5) / 10;

	}

	private static Integer getRandomBit() {

		if(Math.random() < 0.5) {
			return 0;
		}
		else {
			return 1;
		}

	}

	public static void init() {

		// inputNodes = new Double[inputNeuronsCount + 1];
		// hiddenValues = new Double[hiddenNeuronsCount + 1];
		// outputValues = new Double[outputNeuronsCount];

	}

}
