package pl.byMario.service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pl.byMario.dao.WordDao;
import pl.byMario.jpa.WordDetailsEntity;
import pl.byMario.jpa.WordEntity;

/**
 * 
 * @author Mariusz Lewandowski; Archidoc S.A.
 */
@Service
@Scope("prototype")
public class WordReaderService {
	
	private static final Logger LOGGER = Logger.getLogger(WordReaderService.class);
	
	@Autowired
	private WordDao wordDao;

	
	public List<WordEntity> findEntity(){
		
		List<WordEntity> we = wordDao.findById(null);
		
		return we;
	}
	
	public WordEntity findByText(String word) {
		
//		WordEntity wordEntity = null;
		return wordDao.findByWord(word);
//		return wordEntity;
		
	}
	
	public List<WordDetailsEntity> findInTableByWord(String word) {
		
//		WordEntity wordEntity = null;
		return wordDao.findTable(word);
//		return wordEntity;
		
	}

}
