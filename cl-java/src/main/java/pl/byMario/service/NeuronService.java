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

import pl.byMario.dao.NeuronDao;
import pl.byMario.dao.WordDao;
import pl.byMario.dto.NeuronDto;
import pl.byMario.dto.NeuronIDto;
import pl.byMario.jpa.WordDetailsEntity;
import pl.byMario.jpa.WordEntity;

/**
 * 
 * @author Mariusz Lewandowski; Archidoc S.A.
 */
@Service
@Scope("session")
public class NeuronService {

	private static final Logger LOGGER = Logger.getLogger(NeuronService.class);

	@Autowired
	NeuronDao neuronDao;

	@Autowired
	WordDao wordDao;

	public NeuronDto createNewNeuron(Long neuronId, String layer) {

		NeuronDto newNeuron = new NeuronDto(neuronId, null, layer);

		try {
			neuronDao.save(newNeuron);
//			wordDao.updateWordByNeuron(newNeuronI);
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newNeuron;
	}
	
	public NeuronDto createNewNeuron(Long neuronId, String layer, String connectionFrom) {

		NeuronDto newNeuron = new NeuronDto(neuronId, connectionFrom, layer);

		try {
			neuronDao.save(newNeuron);
//			wordDao.updateWordByNeuron(newNeuronI);
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newNeuron;
	}

	/**
	 * @return
	 * @author Mariusz Lewandowski; Archidoc S.A.
	 * @param neuronId
	 */
	public List<NeuronIDto> getAssociatedNeurons(long predecessorNeuronId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param word
	 * @author Mariusz Lewandowski; Archidoc S.A.
	 * @return
	 */
	public NeuronIDto createNewNeuronI(Long neuronId, String layer, String word) {

		NeuronIDto newNeuronI = new NeuronIDto(neuronId, null, layer, word);

		try {
			neuronDao.save(newNeuronI);
			wordDao.updateWordByNeuron(newNeuronI);
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newNeuronI;
	}

}
