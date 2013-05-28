package pl.byMario.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import pl.byMario.jpa.NeuronEntity;

/**
 * Klasa symbolizujaca pojedynczy neuron
 * 
 * @author Mariusz Lewandowski; Archidoc S.A.
 */
public class NeuronDto {

	private static Double alfa = 0.5;

	protected Long neuronID;

	List<Double> inputList;
	List<Double> outputList;
	List<Object> weightList;
	Double[][] weightInputMap;
	
	Map<Long, Double[]> inputMap;
	String layer;
	Double weight;
	Double output;
	Object bias;

	Integer constant = 1;

	/**
	 * @param input
	 */
	public NeuronDto(Long neuronID, String connectionsFrom, String layer) {

		this.neuronID = neuronID;
		this.inputMap = decodeConnections(connectionsFrom);
		this.layer = layer;
		
		
//		this.inputList = input;
		this.outputList = new ArrayList<Double>();
		this.weightList = new ArrayList<Object>();
		this.output = null;
		initWeights2();

//		process(inputList);
	}
	

	public NeuronDto(List<Double> input, long neuronId) {
		neuronID = neuronId;
		// System.out.println("CREATE n, input size " + input.size());
		// this.weight = ((Math.random()*10));
		this.inputList = input;
		this.outputList = new ArrayList<Double>();
		this.weightList = new ArrayList<Object>();
		this.output = null;
		initWeights();

		process(inputList);
	}

	public NeuronDto(long neuronId) {
		neuronID = neuronId;

		this.inputList = new ArrayList<Double>();
		this.outputList = new ArrayList<Double>();
		this.weightList = new ArrayList<Object>();
		this.output = null;
		// initWeights();
		// process();
	}

	public NeuronDto() {

	}

	public void initWeights() {

		for(int i = 0; i < inputList.size(); i++) {
			weightInputMap[i][0] = Math.random() / 10;
			// weightInputMap[i][1] = inputList.get(i);
		}
	}
	
	public void initWeights2() {
		
		for(int i = 0; i < inputMap.size(); i++) {
			weightInputMap[i][0] = Math.random() / 10;
			// weightInputMap[i][1] = inputList.get(i);
		}
	}

	public void initWeights(int inputCount) {

		for(int i = 0; i < inputCount; i++) {
			weightList.add(Math.random());

		}
	}

	protected void process2() {

		Map<Double, Double> output = new HashMap<Double, Double>();

		Double weight = 0d;
		Double value = 0d;

		Double sumOfInputs = 0d;

		for(int i = 0; i < inputList.size(); i++) {

			if(weightInputMap[i][0] == null) {
				weightInputMap[i][0] = Math.random() / 10;
			}

			sumOfInputs += weightInputMap[i][0] * weightInputMap[i][1];
			// weightInputMap[i][0] = Math.random();
			// weightInputMap[i][1] = inputList.get(i);
		}

		// for(Object input : inputList) {
		// Map<Double, Double> inputMap = (Map<Double, Double>)input;
		//
		// for(Entry<Double, Double> element : inputMap.entrySet()) {
		// weight += element.getKey();
		// value += element.getKey() * element.getValue();
		// }
		//
		// }
		// weight = (weight / inputList.size());// + getWeight();
		// // TEMPORARY as initInput equals input layer output

		// output.put(weight, tanh(value));

		// outputList.add(output);

		// System.out.println("PROCESS no, output: " + output.toString());
		// this.output = sigmoidal(sumOfInputs);
		this.output = tanh(sumOfInputs);
		// wieghtCorrectionOja();
		wieghtCorrectionHebb();

	}

	public void process(List<Double> input) {

		List<Object> newWeightList = new ArrayList<Object>();

		List<Double> output = new ArrayList<Double>();

		Double weight = 0d;
		Double value = 0d;

		for(int i = 0; i < input.size(); i++) {
			// wi(t+1) = wi (t) + cy(t)(xi(t) - y(t)wi)
			// newWeightList.add((Double)weightList.get(i) +
			// (constant*(Double)outputList.get(0)*((Double)inputList.get(i)-(Double)outputList.get(0)*(Double)weightList.get(i))));

			value += (Double)input.get(i) * (Double)weightList.get(i);

		}
		this.output = tanh(value);
		outputList.add(tanh(value));

		wieghtCorrectionOja();

		// System.out.println("PROCESS no, output: " + output.toString());

	}

	List<Double> getInput() {
		return inputList;
	}

	void setInput(List<Double> input) {
		this.inputList = input;

		weightInputMap = new Double[inputList.size()][2];

		for(int i = 0; i < inputList.size(); i++) {
			// weightInputMap[i][0] = Math.random();
			weightInputMap[i][1] = inputList.get(i);
		}

	}

	List<Double> getOutputList() {
		return outputList;
	}

	void setOutputList(List<Double> output) {
		this.outputList = output;
	}

	/**
	 * Hyperbolic tangent function [-1 , 1]
	 * 
	 * @param x
	 * @return
	 * @author Mariusz Lewandowski; Archidoc S.A.
	 */
	public static Double tanh(Double x) {
		// Hyperbolic tangent function
		return (Math.pow(Math.E, x) - Math.pow(Math.E, -x)) / (Math.pow(Math.E, x) + Math.pow(Math.E, -x));

	}

	public static Double artanh(Double x) {
		// Hyperbolic tangent function
		return 0.5 * (Math.log((1 + x) / (1 - x)));

	}

	/**
	 * Sigmoidal function [0 , 1]
	 * 
	 * @param x
	 * @return
	 * @author Mariusz Lewandowski; Archidoc S.A.
	 */
	public static Double sigmoidal(Double x) {

		// sigmoidal function
		return 1 / (1 + Math.pow(Math.E, -(alfa * x)));
	}

	Double getWeight() {
		return weight;
	}

	void setWeight(Double weight) {
		this.weight = weight;
	}

	List<Object> getWeightList() {
		return weightList;
	}

	void setWeightList(List<Object> weightList) {
		this.weightList = weightList;
	}

	public Double getOutput() {
		return output;
	}

	public void setOutput(Double output) {
		this.output = output;
	}

	public Long getNeuronID() {
		return neuronID;
	}

	public void fillFromEntity(NeuronEntity neuronEntity) {

//		this.neuronID = neuronEntity.getNeuronId();

	}

	/**
	 * weight correction Hebb rule wi(m)(t+1) = wi(m)(t) + cxi(t)y(m)(t)
	 * 
	 * @author Mariusz Lewandowski; Archidoc S.A.
	 */
	private void wieghtCorrectionHebb() {

		Double[][] newWeightInputMap = new Double[inputList.size()][2];

		for(int i = 0; i < inputList.size(); i++) {

			newWeightInputMap[i][0] = weightInputMap[i][0] + (constant * weightInputMap[i][1] * output);
			newWeightInputMap[i][1] = weightInputMap[i][1];
		}

		Arrays.fill(weightInputMap, null);
		weightInputMap = Arrays.copyOf(newWeightInputMap, newWeightInputMap.length);

	}

	/**
	 * weight correction Oja rule wi(t+1) = wi (t) + cy(t)(xi(t) - y(t)wi)
	 * 
	 * @author Mariusz Lewandowski; Archidoc S.A.
	 */
	private void wieghtCorrectionOja() {

		Double[][] newWeightInputMap = new Double[inputList.size()][2];

		for(int i = 0; i < inputList.size(); i++) {

			newWeightInputMap[i][0] = weightInputMap[i][0] + ((constant * output) * (weightInputMap[i][1] - (output * weightInputMap[i][0])));
			newWeightInputMap[i][1] = weightInputMap[i][1];
		}

		Arrays.fill(weightInputMap, null);
		weightInputMap = Arrays.copyOf(newWeightInputMap, newWeightInputMap.length);

	}

	public Double[][] getWeightInputMap() {
		return weightInputMap;
	}

	public void setWeightInputMap(Double[][] weightInputMap) {
		this.weightInputMap = weightInputMap;
	}

	private Map<Long, Double[]> decodeConnections(String connectionsFrom) {

		Map<Long, Double[]> tempMap = new HashMap<Long, Double[]>();
		Double[] weightInputArray = null;
		// strong format:
		// neuronId1,weight1;neuronId2,weight2;neuronId3,weight3;...
		if(connectionsFrom!=null && !connectionsFrom.isEmpty()) {
			String[] neuronId_weight_array = connectionsFrom.split(";");
			
			for(String neuronId_weight : neuronId_weight_array) {
				
				String[] split = neuronId_weight.split(",");
				
				Long neuronId = Long.parseLong(split[0]);
				Double weight = Double.parseDouble(split[1]);
//				new ArrayList<Double>(2)
				
				weightInputArray = new Double[2];
				weightInputArray[0]=weight;
				
				tempMap.put(neuronId, weightInputArray);
				
			}
			
		}

		return tempMap;
	}

	private String encodeConnections(Map<Long, Double[]> inputMap2) {

		return null;
	}

	public Map<Long, Double[]> getInputMap() {
		return inputMap;
	}

	public void setInputMap(Map<Long, Double[]> inputMap) {
		this.inputMap = inputMap;
	}
	
	public String getInputMapAsString() {
		return encodeConnections(inputMap);
	}

	public void setInputMapFromString(String inputString) {
		this.inputMap = decodeConnections(inputString);
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}
}
