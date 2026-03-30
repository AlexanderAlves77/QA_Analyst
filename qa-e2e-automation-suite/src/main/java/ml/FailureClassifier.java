package ml;

import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.ArrayList;

public class FailureClassifier 
{
	private Instances trainingData;
	private J48 tree;
	
	public FailureClassifier() 
	{
		try 
		{
			// Carrega o CSV gerado na Etapa A (convertendo para formato ARFF interno da Weka)
			DataSource source = new DataSource("targe/ml_failure_data.csv");
			trainingData = source.getDataSet();
			
			// Define qual coluna queremos prever (FailureType - a última)
			if (trainingData.classIndex() == -1) {
				trainingData.setClassIndex(trainingData.numAttributes() - 1);
			}
			
			// Treina o modelo
			tree = new J48();
			tree.buildClassifier(trainingData);
			System.out.println("### ML Model trained successfully!");
		}
		catch (Exception e) {
            System.out.println("### ML Engine: Not enough data to train yet. Using default classification.");
        }
	}
	
	public String classify(String exception, String message, long duration) 
	{
		try 
		{
			if (tree == null) return "INSUFFICIENT_DATA";
			
			// Cria uma instância temporária para classificação baseada nos dados do teste atual
			DenseInstance instance = new DenseInstance(trainingData.numAttributes());
			instance.setDataset(trainingData);
			instance.setValue(0, exception);
			instance.setValue(1, message);
			instance.setValue(2, duration);
			
			double result = tree.classifyInstance(instance);
			return trainingData.classAttribute().value((int) result);
		}
		catch (Exception e) {
            return "UNKNOWN_ERROR";
        }
	}
}
