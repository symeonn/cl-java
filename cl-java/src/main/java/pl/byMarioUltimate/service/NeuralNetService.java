package pl.byMarioUltimate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pl.byMario.dao.NeuronDao;
import pl.byMario.dao.WordDao;
import pl.byMario.jpa.NeuronEntity;
import pl.byMarioUltimate.dto.NeuralNetDto;
import pl.byMarioUltimate.dto.NeuronDto;
import pl.byMarioUltimate.dto.NeuronIDto;


/**
 * 
 * @author Mariusz Lewandowski; byMario
 */
@Service
@Scope("session")
public class NeuralNetService {

	NeuralNetDto netDto;

//	@Autowired
//	NeuronService neuronService;

//	@Autowired
//	UserCommunicationService userCommunicationService;

	@Autowired
	NeuronDao neuronDao;

	@Autowired
	WordDao wordDao;

	List<NeuronIDto> allInputNeurons = new ArrayList<NeuronIDto>();

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	public void initNet() {

		netDto = new NeuralNetDto();
		
		List<NeuronEntity> neuronsInLayer = null;
		NeuronDto neuronDto = null;

		// reading existing neurons from DB
		for(String layer : netDto.getNetStructure().keySet()) {

			neuronsInLayer = neuronDao.getNeuronByLayer(layer);

			for(NeuronEntity neuronEntity : neuronsInLayer) {

				if(NeuralNetDto.INPUT_LAYER.equals(layer)) {
					String word = wordDao.findWordByNeuronId(neuronEntity.getId());
					neuronDto = new NeuronIDto(neuronEntity.getId(), neuronEntity.getConnectionFrom(), neuronEntity.getLayer(), word);
				}
				else {
					neuronDto = new NeuronDto(neuronEntity.getId(), neuronEntity.getConnectionFrom(), neuronEntity.getLayer());
				}
				netDto.getNetStructure().get(layer).add(neuronDto);
				netDto.neuronsCount++;
			}
		}
		
		System.out.println("TOTAL NEURONS: " + netDto.neuronsCount);

	}

	public void processFinal(String sentence) {

		List<NeuronIDto> allInputNeurons = searchForAssociatedNeurons(getNeuronsFromSentence(sentence), netDto.getLinkLevel());
		
		

	}

	public List<NeuronIDto> getNeuronsFromSentence(String sentence) {

		List<NeuronIDto> inputNeurons = new ArrayList<NeuronIDto>();
		List<NeuronIDto> inputNeuronsToAdd = new ArrayList<NeuronIDto>();
		List<NeuronDto> hiddenNeuronsToAdd = new ArrayList<NeuronDto>();

		String[] words = sentence.split(" ");

		for(String word : words) {
			boolean neuronFound = false;

			for(NeuronDto neuron : netDto.getInputLayer()) {
				NeuronIDto neuronI = (NeuronIDto)neuron;
				if(word.equalsIgnoreCase(neuronI.getWord())) {
					inputNeurons.add(neuronI);
					neuronFound = true;
					break;
				}
			}

			if(!neuronFound) {
//				NeuronIDto createdNewNeuronI = neuronService.createNewNeuronI(netDto.neuronsCount + 1, NeuralNetDto.INPUT_LAYER, word);
//				inputNeuronsToAdd.add(createdNewNeuronI);
////				NeuronDto createdNewNeuron = ;
////				createdNewNeuron.s
//				hiddenNeuronsToAdd.add(neuronService.createNewNeuron(netDto.neuronsCount + 2, NeuralNetDto.HIDDEN_LAYER, createdNewNeuronI.getNeuronID().toString()));

			}
		}

		netDto.getInputLayer().addAll(inputNeuronsToAdd);
		netDto.getHiddeLayer().addAll(hiddenNeuronsToAdd);
		
		netDto.neuronsCount += inputNeuronsToAdd.size() + hiddenNeuronsToAdd.size();

		inputNeurons.addAll(inputNeuronsToAdd);

		return inputNeurons;
	}

	/**
	 * Search for associated neurons to include it into InputLayer (recurrent method)
	 * 
	 * @param predecessorNeurons
	 * @param linkLevel
	 * @return
	 * @author Mariusz Lewandowski; byMario
	 */
	private List<NeuronIDto> searchForAssociatedNeurons(List<NeuronIDto> predecessorNeurons, int linkLevel) {

		List<NeuronIDto> allAssociatedNeurons = new ArrayList<NeuronIDto>();

		if(predecessorNeurons.isEmpty() || linkLevel < 0) return allAssociatedNeurons;
		// if(predecessorNeuronId.isEmpty()) return associatedNeurons;

		// pop out from list
		NeuronIDto currentNeuron = predecessorNeurons.remove(0);
		allAssociatedNeurons.add(currentNeuron);
		// associated for current neuron
//		List<NeuronIDto> associatedNeurons = neuronService.getAssociatedNeurons(currentNeuron.getNeuronID());
//
//		allAssociatedNeurons.addAll(associatedNeurons);

		// for(Long neuronId : predecessorNeuronId) {

		// for(int i = 0; i < linkLevel; i++) {

		// find associated for rest of neurons
//		allAssociatedNeurons.addAll(searchForAssociatedNeurons(predecessorNeurons, linkLevel));
//
//		allAssociatedNeurons.addAll(searchForAssociatedNeurons(associatedNeurons, linkLevel--));

		// associatedNeurons.addAll(neuronService.getAssociatedNeurons(predecessorNeuronId));
		// allInputNeurons.addAll(associatedNeurons);
		// }

		// }

		return allAssociatedNeurons;

	}

	// List<Double> outputInputList = new ArrayList<Double>();
	// List<Double> outputHiddenList = new ArrayList<Double>();
	// List<Object> outputList = new ArrayList<Object>();

	// List<NeuronDto> neuronsI = new ArrayList<NeuronDto>();
	// List<NeuronDto> neuronsH = new ArrayList<NeuronDto>();
	// List<NeuronDto> neuronsO = new ArrayList<NeuronDto>();
	// NeuronIDto neuronI;
	// NeuronH neuronH;
	// NeuronO neuronO;

	// for(Double initInputValue : initialValues) {
	//
	// neuronI = new NeuronIDto(Arrays.asList(initInputValue), neuronsCount++);
	// neuronsI.add(neuronI);
	//
	// outputInputList.add(neuronI.getOutput());
	//
	// netStructure.put("inputL", neuronsI);
	//
	// }

	// for(Neuron neuronI : inList) {
	// neuronI.process();
	// outputInputList.add(neuronI.getOutput());
	//
	// }

	// System.out.println("WARSTWA WEJSCIOWA: " + neuronsI.size() + " neuronow "
	// + "; output " + outputInputList.toString());
	// System.out.println("--------------------------------");

	// for hidden N
	// for(int i = 0; i < neuronHamount; i++) {
	//
	// neuronH = new NeuronH(outputInputList, neuronsCount++);
	// // neuronH.setWeight((int)Math.random()*10);
	// neuronsH.add(neuronH);
	//
	// outputHiddenList.add(neuronH.getOutput());
	// netStructure.put("hiddenL", neuronsH);
	//
	// // Double inputSum = 0d;
	// // for(Object input : neuronH.getInput()) {
	// //
	// // }
	//
	// // tanh(inputSum);
	//
	// }
	// System.out.println("WARSTWA UKRYTA: " + neuronsH.size() + " neuronow " +
	// "; output " + outputHiddenList.toString());
	// System.out.println("--------------------------------");

	// for(int i = 0; i < neuronOamount; i++) {
	// neuronO = new NeuronO(outputHiddenList, neuronsCount++);
	// // neuronO.setWeight((int)Math.random()*10);
	//
	// neuronsO.add(neuronO);
	// outputList.add(neuronO.getOutput());
	// netStructure.put("outputL", neuronsO);
	//
	// }
	// System.out.println("WARSTWA WYJSCIOWA: " + neuronsO.size() + " neuronow "
	// + "; output " + outputList.toString());
	// System.out.println("--------------------------------");

	// Double resultD = (Double)outputList.get(0);
	// Double result = Math.tan(resultD);

	// System.out.println("Wynik: " + result);

	// public void initNet2() {
	//
	// NeuronIDto neuronI;
	// NeuronDto neuronH;
	// NeuronDto neuronO;
	//
	// List<NeuronDto> neuronsI = new ArrayList<NeuronDto>();
	// List<NeuronDto> neuronsH = new ArrayList<NeuronDto>();
	// List<NeuronDto> neuronsO = new ArrayList<NeuronDto>();
	//
	// for(int i = 0; i < neuronIamount; i++) {
	// neuronI = new NeuronIDto(neuronsCount++);
	// neuronsI.add(neuronI);
	// }
	//
	// for(int i = 0; i < neuronHamount; i++) {
	// neuronH = new NeuronDto(neuronsCount++);
	// // neuronH.initWeights(neuronIamount);
	// neuronsH.add(neuronH);
	// }
	//
	// for(int i = 0; i < neuronOamount; i++) {
	// neuronO = new NeuronDto(neuronsCount++);
	// // neuronO.initWeights(neuronHamount);
	// neuronsO.add(neuronO);
	// }
	//
	// netStructure.put(INPUT_LAYER, neuronsI);
	// netStructure.put(HIDDEN_LAYER, neuronsH);
	// netStructure.put(OUTPUT_LAYER, neuronsO);
	//
	// }

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	public void process() {

		Integer runCount = 0;
		List<Object> outputInput = new ArrayList<Object>();
		List<Object> input;

		for(Entry<String, List<NeuronDto>> layer : netDto.getNetStructure().entrySet()) {
			input = outputInput;
			outputInput.clear();

			System.out.println("PROCESS " + layer.getKey() + "layer; run: " + runCount);

			for(NeuronDto neuron : layer.getValue()) {
				// neuron.process();
//				outputInput.add(neuron.getOutput());
			}
		}
		// for each layer, go through each neuron and process

	}

	// public List<Double> process(List<Double> inputValues) {
	//
	// Integer runCount = 0;
	//
	// List<Double> outputInput = new ArrayList<Double>(); // lista wartosci
	// // pomiedzy wartwami
	//
	// // na poczatki ruchu ustawiam wejscia dla inputLayer
	// List<Double> input = new ArrayList<Double>();
	//
	// input.addAll(inputValues);
	//
	// // List<Object> outputInputList = new ArrayList<Object>();
	// // List<Object> outputHiddenList = new ArrayList<Object>();
	// // List<Object> outputList = new ArrayList<Object>();
	//
	// // po kazdej warstwie
	// for(Entry<String, List<NeuronDto>> layer : netStructure.entrySet()) {
	//
	// outputInput.clear();
	//
	// if(layer.getKey().equalsIgnoreCase(INPUT_LAYER)) {
	//
	// int i = 0;
	// for(NeuronDto neuron : layer.getValue()) {
	// neuron.process(Arrays.asList(input.get(i)));
	// outputInput.add(neuron.getOutput());
	// i++;
	// }
	//
	// }
	// else {
	//
	// // po kazdym neuronie w warstwie
	// for(NeuronDto neuron : layer.getValue()) {
	// neuron.process(input);
	// outputInput.add(neuron.getOutput());
	// }
	// }
	// input.clear();
	// input.addAll(outputInput);
	// }
	// return outputInput;
	// }

	// public void processFinal(List<Long> rawSentenceNeuronIds) {
	//
	// List<NeuronEntity> inputNeuronsEntities =
	// neuronDao.findInputByNeuronIds(rawSentenceNeuronIds);
	//
	// List<NeuronIDto> inputNeurons = new ArrayList<NeuronIDto>();
	//
	// for(NeuronEntity neuronEntity : inputNeuronsEntities) {
	// NeuronIDto neuronI = new NeuronIDto();
	// neuronI.fillFromEntity(neuronEntity);
	// inputNeurons.add(neuronI);
	// }
	//
	// // allInputNeurons.addAll(inputNeurons);
	//
	// // List<Long> predecessorNeuronIds = new ArrayList<Long>();
	//
	// // for(NeuronI inputNeuron : inputNeurons) {
	// // predecessorNeuronIds.add(inputNeuron.getNeuronID());
	// // }
	//
	// allInputNeurons.addAll(searchForAssociatedNeurons(inputNeurons,
	// linkLevel));
	//
	// netStructure.get(INPUT_LAYER).clear();
	// netStructure.get(INPUT_LAYER).addAll(allInputNeurons);
	// // teraz po ustawieniu I pora na przeslanie wszystkich outputow do H
	// // musi nastapic sprawdzenie czy w I są jakies nowe neurony
	// // (nieznajdujace sie w H)
	// // czy to sprawdzenie ma nastapic przed przejsciem po NN czy po
	//
	// // check if H have I included
	// for(NeuronDto neuronI : netStructure.get(INPUT_LAYER)) {
	//
	// boolean addNeuronToH = true;
	//
	// for(NeuronDto neuronH : netStructure.get(HIDDEN_LAYER)) {
	// if(neuronH.getNeuronID().equals(neuronI.getNeuronID())) {
	// addNeuronToH = false;
	// break;
	// }
	// }
	//
	// if(addNeuronToH) {
	// netStructure.get(HIDDEN_LAYER).add(neuronI);
	// }
	//
	// }
	// // WHILE what?
	// while(true) {
	// processLayers();
	// }
	//
	// // what to do with final output?
	//
	// }

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

	/**
	 * 
	 * @author Mariusz Lewandowski; byMario
	 */
	// public List<Double> processLayers() {
	//
	// List<Double> ItoHflow = new ArrayList<Double>();
	// List<Double> HtoOflow = new ArrayList<Double>();
	// List<Double> Oflow = new ArrayList<Double>();
	//
	// // System.out.print("INPUT LAYER: ");
	// for(NeuronDto neuronI : netStructure.get(INPUT_LAYER)) {
	// ItoHflow.add(neuronI.getOutput());
	// // System.out.print(String.format("%.5G", neuronI.getOutput()) +
	// // "; ");
	// }
	// // System.out.println();
	//
	// for(NeuronDto neuronH : netStructure.get(HIDDEN_LAYER)) {
	// neuronH.setInput(ItoHflow);
	// // neuronH.initWeights();
	// neuronH.process2();
	//
	// HtoOflow.add(neuronH.getOutput());
	// }
	//
	// for(NeuronDto neuronO : netStructure.get(OUTPUT_LAYER)) {
	// neuronO.setInput(HtoOflow);
	// // neuronO.initWeights();
	// neuronO.process2();
	// Oflow.add(neuronO.getOutput());
	// }
	//
	// return Oflow;
	// }
	//
	// public void initInputNeurons() {
	//
	// Double inputValue = null;
	//
	// for(NeuronDto neuronI : netStructure.get(INPUT_LAYER)) {
	// inputValue = Math.random() - 0.5;
	// neuronI.setInput(Arrays.asList(inputValue));
	// neuronI.initWeights();
	// for(int i = 0; i < neuronI.getWeightInputMap().length; i++) {
	// System.err.print("INPUT: " + neuronI.getWeightInputMap()[i][0] + "; " +
	// neuronI.getWeightInputMap()[i][1]);
	// }
	//
	// neuronI.process2();
	//
	// System.err.println(" --> OUTPUT: " + neuronI.getOutput());
	//
	// }
	//
	// }

}
