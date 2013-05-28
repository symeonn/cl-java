package pl.byMario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import pl.byMario.dto.NeuronDto;

/**
 *  Output neutron
 *  
 * @author Mariusz Lewandowski; Archidoc S.A.
 */
public class NeuronO extends NeuronDto{
	
	

	
	public NeuronO(List<Double> input, long neuronId) {
		super(input, neuronId);
		
//		System.out.println("CREATE nO, input " + inputList.toString()+ "; waga " + weightList.toString());
		
//		this.inputList = input;
//		process();
	}

	public NeuronO(long neuronId) {
		super(neuronId);
	}


	/**
	 * @see pl.byMario.Neuron#process()
	 */
//	@Override
//	protected void process() {
//		Map<Double, Double> output = new HashMap<Double, Double>();
//
//		Double weight = 0d;
//		Double value = 0d;
//		
//		for(Object input : inputList) {
//			Map<Double, Double> inputMap = (Map<Double, Double>)input;
//
//			for(Entry<Double, Double> element : inputMap.entrySet()) {
//				weight += element.getKey();
//				value += element.getKey() * element.getValue();
//			}
//
//		}
//		weight = (weight/inputList.size());// + getWeight();
//		// TEMPORARY as initInput equals input layer output
//
//		output.put(weight, tanh(value));
//		
//		outputList.add(output);
//
////		System.out.println("PROCESS no, output: " + output.toString());
//	}
	
	
	

}
