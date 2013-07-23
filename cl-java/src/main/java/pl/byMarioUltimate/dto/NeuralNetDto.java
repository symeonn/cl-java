package pl.byMarioUltimate.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.byMario.NeuronH;
import pl.byMario.NeuronO;
import pl.byMario.dao.NeuronDao;
import pl.byMario.jpa.NeuronEntity;

/**
 * 
 * @author Mariusz Lewandowski; Archidoc S.A.
 */
@Service
public class NeuralNetDto {

	public long neuronsCount = 0L;

	int linkLevel = 3;

	public final static String INPUT_LAYER = "inputL";
	public final static String HIDDEN_LAYER = "hiddenL";
	public final static String OUTPUT_LAYER = "outputL";

	Integer neuronIamount;
	Integer neuronHamount;
	Integer neuronOamount;
	
	private List<Object> paternValues = new ArrayList<Object>();
	Map<String, List<NeuronDto>> netStructure = new LinkedHashMap<String, List<NeuronDto>>();


//	@Autowired
	NeuronDao neuronDao;

//	List<NeuronIDto> allInputNeurons = new ArrayList<NeuronIDto>();

	/**
	 * @param neuronIamount
	 * @param neuronHamount
	 * @param neuronOamount
	 */
	public NeuralNetDto(Integer neuronIamount, Integer neuronHamount, Integer neuronOamount) {
		super();
		this.neuronIamount = neuronIamount;
		this.neuronHamount = neuronHamount;
		this.neuronOamount = neuronOamount;
	}



	

	/**
	 * 
	 */
	public NeuralNetDto() {
		this.neuronIamount = 0;
		this.neuronHamount = 0;
		this.neuronOamount = 0;
		
		netStructure.put(INPUT_LAYER, new ArrayList<NeuronDto>());
		netStructure.put(HIDDEN_LAYER, new ArrayList<NeuronDto>());
		netStructure.put(OUTPUT_LAYER, new ArrayList<NeuronDto>());
		
		
	}





	public List<Object> getPaternValues() {
		return paternValues;
	}

	public void setPaternValues(List<Object> paternValues) {
		this.paternValues = paternValues;
	}



	

	// dla kazdego neuronu ze slowa ze zdania, poszukac powiazan z innymi
	// neuronami do zadanego n poziomu (wspolczynnik kojarzenia)
	// i wyjscia wszystkich neuronow z I zapodac do H (skladajacej sie z tylu
	// neuronow ile slow siec poznala) i potem
	// albo wrocic do I (jednak w niej nie ma wszystkich slow)
	// albo isc dalej i (skoro w H jest tyle co poznanych slow czyli wektory
	// H=O) te ktore sa pobudzone w H wyplowaja slowa w O
	// (jeszcze trzeba poradzic sobie z kolejnoscia, ale to chyba mozna zalatwic
	// jakims procesem - tak jak w I)

	// public void setInputNeurons(List<NeuronI> rawSentenceNeurons) {
	// // dla kazdego slowa
	// for(NeuronI rawSentenceNeuron : rawSentenceNeurons) {
	//
	// // znajdujemy kojarzone slowa/neurony
	//
	// }
	//
	// }

	
	
	

	

	public Map<String, List<NeuronDto>> getNetStructure() {
		return netStructure;
	}

	public void setNetStructure(Map<String, List<NeuronDto>> netStructure) {
		this.netStructure = netStructure;
	}

	public List<NeuronDto> getInputLayer() {
		return netStructure.get(INPUT_LAYER);
	}
	
	public List<NeuronDto> getHiddeLayer() {
		return netStructure.get(HIDDEN_LAYER);
	}

	public int getLinkLevel() {
		return linkLevel;
	}

	public void setLinkLevel(int linkLevel) {
		this.linkLevel = linkLevel;
	}
	
}
