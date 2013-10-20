package pl.byMario.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pl.byMario.cl.DbUtil;
import pl.byMario.dao.WordDao;
import pl.byMario.dto.NeuronDto;
import pl.byMario.jpa.WordEntity;
import pl.byMario.service.MailSendService;
import pl.byMario.service.NeuralNetService;
import pl.byMario.service.UserCommunicationService;
import pl.byMario.service.WordReaderService;
import pl.byMario.service.WordWriterService;

@Controller
@Scope("session")
public class StartController {

	private static final Logger LOGGER = Logger.getLogger(StartController.class);

	private String nazwaAplikacji;
	private String userSentence;
	public String tekst;
	public Integer state = 909090;
	@Autowired
	private NeuralNetService net;

	Map<Integer, Boolean> daysEnabled;
	Map<Integer, List<Integer>> daysWithHours;
	
	private Map<Integer, String> fieldColorMap;

	public String texxxt = "";

	List<Boolean> komorki = new ArrayList<Boolean>();

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	List<SelectItem> dictionaryItems = new ArrayList<SelectItem>();

	@Autowired
	private WordWriterService wordWriterService;

	@Autowired
	private UserCommunicationService userCommunicatorService;

	// @Autowired
	private MailSendService mailSendService;

	private boolean ttt;

	@Resource
	public void setMailSend(MailSendService mailSend) {
		this.mailSendService = mailSend;
	}

	public String getUserSentence() {
		return userSentence;
	}

	public void setUserSentence(String userSentence) {
		this.userSentence = userSentence;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public StartController() {

		System.out.println("StartController constructor");
		this.nazwaAplikacji = "kuku";
		this.tekst = "nie ma jeszcze tekstu";
		this.userSentence = "napisz zdanie";

		for(int i = 0; i < 9; i++) {
			komorki.add(true);
		}

		initNetwork2(null);

		fieldColorMap = new HashMap<Integer, String>();
		
		daysEnabled = new HashMap<Integer, Boolean>();
		daysWithHours = new HashMap<Integer, List<Integer>>();
		
		for(int i = 1; i <= 7 ; i++) {
			List<Integer> rrr = new ArrayList<Integer>();
			 rrr.add(i+1);
			 rrr.add(i+2);
			 rrr.add(i+3);
			daysEnabled.put(i, true);
			daysWithHours.put(i, rrr);

		}
		
	}

	public void clTest(ActionEvent event) {

//		userCommunicatorService.userInputDecompose(userSentence);

		// userCommunicatorService

		robocza(userSentence);

		System.out.println("jest wartosc event");

	}

	public String clTestNoEvent() {
		// robocza(userSentence);
		// testOrm();
		testOrmWithService();
		System.out.println("jest wartosc NOevent");
		return null;
	}

	public String button1() {

		Integer i = null;
		try {
			i = Integer.parseInt(userSentence);

		}
		catch(Exception e) {
			LOGGER.warn("to nie numer");

			// LOGGER.warn(LOGGER.getEffectiveLevel());
			// LOGGER.info("logger INFO");
			// LOGGER.warn("logger WARN");
			// LOGGER.debug("logger DEBUG");

			tekst = "to nie numer";
		}
		tekst = "Zapisano s��w: " + wordWriterService.importFromFile(i);

		System.out.println("KONIEC IMPORTU!!");
		return null;
	}

	public String sendMail() {

		LOGGER.info("wysylanie maila");
		// MailSend mailSend = new MailSend();

		mailSendService.executeSendMail();

		return null;
	}

	public synchronized void robocza(String userSentence) {
		try {
			LOGGER.info("xcv INFO");
			LOGGER.warn("xcv WARN");

			Properties props = System.getProperties();
			String path = new File(".").getCanonicalPath();
			String pat = System.getProperty("user.dir");

			DbUtil abcl = new DbUtil();

			String tt = abcl.clJava(userSentence);

			this.tekst = tt;
		}
		catch(Exception e) {
			e.printStackTrace();
			getLogger().error(e.getMessage());
		}

	}

	public String getNazwaAplikacji() {
		return nazwaAplikacji;
	}

	protected Logger getLogger() {
		return LOGGER;
	}

	public void testOrm() {

		try {

			WordDao dao = new WordDao();
			List<WordEntity> we = dao.findById(1);
			LOGGER.info(we.toString());

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void testOrmWithService() {

		try {
			List<WordEntity> we = wordWriterService.findEntity();

			LOGGER.info(we.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void fillDictList(int beginning) {
		this.state = beginning;
		// System.out.println(""+beginning);

		// List<Integer> list = new ArrayList<Integer>();
		dictionaryItems.clear();
		LOGGER.info(beginning + " fill start");
		for(Integer i = 1; i < 800; i++) {
			if(i.toString().startsWith("" + beginning)) {
				dictionaryItems.add(new SelectItem(i, "l " + i, "d " + i));
			}
		}
		LOGGER.info(beginning + " fill end");

	}

	public List<SelectItem> getDictionaryItems() {
		// fillDictList(2);
		return dictionaryItems;

	}

	public String getComboSize() {
		return "size" + dictionaryItems.size();

	}

	public void valueChanged(ValueChangeEvent event) {
		try {
			Integer newValue = Integer.parseInt(event.getNewValue().toString());
			ttt = event.getNewValue().toString().length() == 1 && event.getOldValue().toString().length() <= 1;
			if(ttt && !(newValue.equals(state))) {
				fillDictList(newValue);
				// System.out.println("generate starting with: " +
				// event.getNewValue().toString());
				// System.out.println("generated size: " +
				// dictionaryItems.size());
				// event.getComponent().getChildren().set(0, dictionaryItems);
			}

		}
		catch(Exception e) {
			// e.printStackTrace();
		}

	}

	public String getToRender() {

		if(ttt) {
			System.out.println("dictValue");
			return "dictValue";

		}
		else {
			System.out.println("NULL");

			return null;
		}
	}

	private List<Double> inputValues = new ArrayList<Double>();
	private List<Object> paternValues = new ArrayList<Object>();

	// private ArrayList&lt;String&gt; capitalsNames = new
	// ArrayList&lt;String&gt;();
	// private List&lt;SelectItem&gt; capitalsOptions = new
	// ArrayList&lt;SelectItem&gt;();

	private String capital = "raz";

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	List<Integer> result = new ArrayList<Integer>();

	public List<Integer> autocomplete(Object suggest) {

		System.out.println("autocomplete");

		String pref = (String)suggest;

		if(pref.equals("null")) {
			return result;
		}
		result.clear();

		// Iterator&lt;Capital&gt; iterator = getCapitals().iterator();

		for(SelectItem selectItem : dictionaryItems) {

			Integer elem = (Integer)selectItem.getValue();

			if((elem != null && elem.toString().toLowerCase().indexOf(pref.toLowerCase()) == 0) || "".equals(pref)) {
				result.add(elem);
			}

		}

		return result;

	}

	public Object processSentence(Map<String, Object> sentence) {

		if(sentence.isEmpty()) return null;

		for(String string : sentence.keySet()) {

			getDependencies(string);
		}
		// processSentence();

		return new ArrayList<String>();

	}

	/**
	 * @param string
	 * @author Mariusz Lewandowski; Archidoc S.A.
	 */
	private Map<String, Object> getDependencies(String word) {

		Map<String, Object> subSentenceDep = new HashMap<String, Object>();

		// subSentenceDep.put(word, value)

		return null;

	}

	public void initNetwork(ActionEvent event) {

		// event.getComponent().getAttributes().get("texxxt")

//		inputValues.addAll(decodeInputString());

//		Integer neuronIamount = 9;
//		Integer neuronHamount = 3;
//		Integer neuronOamount = 2;

//		net = new NeuralNetService(neuronIamount, neuronHamount, neuronOamount);
		// net.setPaternValues(paternValues);

//		List<Object> initialValues = new ArrayList<Object>();
//
//		for(int i = 0; i < neuronIamount; i++) {
//			// input = new HashMap<Double, Double>();
//			// input.put((Math.random()), Math.random());
//			Double init = Math.random();
//			initialValues.add(init);
//			// System.out.println("INIT input: " + init.toString());
//		}
//		System.out.println("--------------------------------");

		net.initNet();

	}

	public void initNetwork2(ActionEvent event) {

		Integer neuronIamount = 16;
		Integer neuronHamount = 8;
		Integer neuronOamount = 1;

//		net = new NeuralNetService(neuronIamount, neuronHamount, neuronOamount);

//		net.initNet2();

	}

	public void makePatern(ActionEvent event) {
		paternValues.addAll(decodeInputString());

	}

	public void learning(ActionEvent event) {

		if(net != null) {
			net.process();

		}
	}
	
	public void process(ActionEvent event) {
		
		if(net != null) {
			net.processFinal(userSentence);
			
		}
	}

	public List<Boolean> getKomorki() {
		return komorki;
	}

	public void setKomorki(List<Boolean> komorki) {
		this.komorki = komorki;
	}

	public String getTexxxt() {
		return texxxt;
	}

	public void setTexxxt(String texxxt) {
		this.texxxt = texxxt;
	}

	private List<Double> decodeInputString() {
		texxxt = texxxt.substring(0, texxxt.length() - 1);
		String[] yy = texxxt.split(",", 17);

		List<Double> cellIds = new ArrayList<Double>();

		for(String str : yy) {
			if(str.trim().equals("gray")) {
				cellIds.add(1d);

			}
			else {
				cellIds.add(0d);
			}
		}

		// inputValues.addAll(cellIds);

		System.out.println("FROM MATRIX: " + cellIds + "   size: " + cellIds.size());

		return cellIds;
	}

	private boolean networkWin = false;

	public void makeMove(ActionEvent event) {
		String CIRCLE = "O";
		String CROSS = "X";

		inputValues = decodeInputString();

		for(int i = 0; i < inputValues.size(); i++) {

			if(inputValues.get(i).equals(1.0)) {
				// if(!fieldColorMap.containsKey(i)){
				fieldColorMap.put(i, CIRCLE);
				// }
			}

		}

		Double tempFinalOutput = null;

//		while(!networkWin) {
			while(true) {

//				tempFinalOutput = net.process(inputValues).get(0);
				double artanh = NeuronDto.artanh(tempFinalOutput);
				Integer hexInt = (int)Math.round(artanh);
				System.out.println("OUTPUT int: " + hexInt);
				
				if(!fieldColorMap.containsKey(hexInt)) {
					fieldColorMap.put(hexInt, CROSS);
					break;
				}
			}
			
			
//		}
		
		for(int i = 0; i < 16; i++) {
			
			System.out.print(fieldColorMap.get(i)==null?"_":fieldColorMap.get(i));
			if(i==3 || i==7 ||i==11) System.out.println();
		}
		
		
//		this.tekst = tempFinalOutput.toString();
//		double artanh = Neuron.artanh(tempFinalOutput);
//		Integer hexInt = (int)Math.round(artanh);
//		String hexStr = Integer.toHexString(hexInt * 16);
//
//		System.out.println("OUTPUT: " + tekst);
//		System.out.println("ARTANH: " + artanh);
//		System.out.println("HEXINT: " + hexInt);
//		System.out.println("HEX: " + hexStr);

	}
	
	
	public List<SelectItem> getDays() {

		List<SelectItem> daysList = new ArrayList<SelectItem>();

		for(Integer day : daysWithHours.keySet()) {
			Object bol = daysWithHours.get(day).isEmpty();
			daysList.add(new SelectItem(bol, day.toString()));
		}
		return daysList;

	}
	
	public List<SelectItem> getHours() {
		
		
//		for(iterable_type iterable_element : Calendar.HOUR_OF_DAYSATURDAY) {
//			
//		}
		List<SelectItem> daysList = new ArrayList<SelectItem>();
		
		daysList.add(new SelectItem(-1, ""));
		for(int i =0 ; i<24;i++) {
//			Object bol = daysWithHours.get(day).isEmpty();
			daysList.add(new SelectItem(i, String.valueOf(i)));
		}
		return daysList;
		
	}

	public Map<Integer, Boolean> getDaysEnabled() {
		return daysEnabled;
	}
	public List<Integer> getDaysEnabledList() {
		
		List<Integer> result = new ArrayList<Integer>(daysEnabled.keySet());
		return result;
	}

	public Map<Integer, List<Integer>> getDaysWithHours() {
		return daysWithHours;
	}
}
