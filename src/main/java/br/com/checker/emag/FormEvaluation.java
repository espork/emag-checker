package br.com.checker.emag;

import java.util.List;

import net.htmlparser.jericho.Source;
import br.com.checker.emag.SpecificRecommendation.FormRecommendation;

public class FormEvaluation extends Evaluation{

	private FormEvaluation(Source document) { super(document); }
	
	public static class FormEvaluationBuilder extends EvaluationBuilder {
		
		@Override
		protected FormEvaluation with(Source document) { return new FormEvaluation(document); }
		
		public SpecificRecommendation prioridade1() { return new AvaliacaoPrioridade1();}
	}
	
	
	protected static class AvaliacaoPrioridade1 extends FormRecommendation{
		protected List<Occurrence> check() { return getEvaluation().prioridade1();}
	}
	
	
	public List<Occurrence> check() {
		getOccurrences().clear();
		getOccurrences().addAll(prioridade1());
		
		return getOccurrences();
	}
	
	private List<Occurrence> prioridade1() {
		
		return null;
	}
	
	public OccurrenceClassification type () { return OccurrenceClassification.FORM;}
}
