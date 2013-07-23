package pl.byMarioUltimate.controller;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pl.byMario.cl.DbUtil;
import pl.byMario.dao.WordDao;
import pl.byMario.jpa.WordEntity;
import pl.byMario.service.WordWriterService;
import pl.byMarioUltimate.dto.NeuralNetDto;
import pl.byMarioUltimate.service.NeuralNetService;

@Controller
@Scope("session")
public class StartController {

	private static final Logger LOGGER = Logger.getLogger(StartController.class);

	private String userSentence;
//	NeuralNetDto neuralNet;
	
	
	@Autowired
	private NeuralNetService netService;

	@Autowired
	private WordWriterService wordWriterService;

	public String getUserSentence() {
		return userSentence;
	}

	public void setUserSentence(String userSentence) {
		this.userSentence = userSentence;
	}

	public StartController() {

//		neuralNet = new NeuralNetDto();
//		netService.initNet();
		
		System.out.println("StartController constructor");
		this.userSentence = "napisz zdanie";

	}

	public String clTestNoEvent() {
		testOrmWithService();
		System.out.println("jest wartosc NOevent");
		return null;
	}

	public String initNet() {
		
		netService.initNet();

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

//			tekst = "to nie numer";
		}
//		tekst = "Zapisano s��w: " + wordWriterService.importFromFile(i);

		System.out.println("KONIEC IMPORTU!!");
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

//			this.tekst = tt;
		}
		catch(Exception e) {
			e.printStackTrace();
			getLogger().error(e.getMessage());
		}

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

	public void valueChanged(ValueChangeEvent event) {
		try {
			Integer newValue = Integer.parseInt(event.getNewValue().toString());

		}
		catch(Exception e) {
			// e.printStackTrace();
		}

	}

	public Object processUserSentence(String userSentence) {

		return null;
	}

	public void initNetwork(ActionEvent event) {

	}

	public void learning(ActionEvent event) {

		if(netService != null) {
			netService.process();

		}
	}
	
	public void process(ActionEvent event) {
		
		if(netService != null) {
			netService.processFinal(userSentence);
			
		}
	}

}
