package pl.byMario.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pl.byMario.dao.WordDao;
import pl.byMario.dto.NeuronIDto;
import pl.byMario.jpa.WordEntity;

/**
 * 
 * @author Mariusz Lewandowski; Archidoc S.A.
 */

@Service
@Scope("prototype")
public class UserCommunicationService {

	private static final Logger LOGGER = Logger.getLogger(UserCommunicationService.class);

	
	@Autowired
	private WordReaderService wordReaderService;
	
	@Autowired
	private WordDao wordDao;
	
	public List<WordEntity> userInputDecompose(String userSentence){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<WordEntity> wordsList = new ArrayList<WordEntity>();
		
		String[] userWords = userSentence.split(" ");
		
		for(String word : userWords) {
			
			wordsList.add(wordReaderService.findByText(word));
			
		}
		
		for(String string : userWords) {
			map.put(string, wordReaderService.findInTableByWord(string));
		}

		LOGGER.info("Words in sentence: " + wordsList.size());
		return wordsList;
	}
	
//	stworzenie listy lub zmiennej CL wprowadzenie tego do CL i juz dalej niech sie CL tym zajmuje
//	dzieki temu zminimalizujemy udzial javy
	public void createListCL(String userSentence){
		
		
		
	}
	/**
	 * creates sentence from CL list to display to the user
	 * 
	 * @return
	 * @author Mariusz Lewandowski; Archidoc S.A.
	 */
	public String userOutputCompose(){
		
		String outputSentence ="";
		
		return outputSentence;
	}
	
	public void getDependencies(String word){
		
		
		
		
	}
	
	public List<Long> processSentence(String sentence){
		
		String[] words = sentence.split(" ");
		List<Long> inputNeurons = new ArrayList<Long>();
		
		for(String string : words) {
			WordEntity wordEntity = wordDao.findByWord(string);
			
			inputNeurons.add(wordEntity.getNeuronId());
			
		}
		
		return inputNeurons;
		
	}
	
}
