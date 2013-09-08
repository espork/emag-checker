package br.com.checker.emag;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.htmlparser.jericho.Source;
import br.com.checker.emag.Evaluation.EvaluationBuilder;
import br.com.checker.emag.FormEvaluation.FormEvaluationBuilder;
import br.com.checker.emag.MarkEvaluation.MarkEvaluationBuilder;



public class Checker {
	
	private Source document;
	private Map<OccurrenceClassification,List<Occurrence>> occurrencesMap = new HashMap<OccurrenceClassification, List<Occurrence>>();;
	
	private Checker(String html) { 
		this.document = new Source(html);
		this.document.fullSequentialParse();
	}
	
	public static Checker from(String html) { return new Checker(html); }
	
	public static Checker from(BufferedReader reader) {
		//TODO ler arquivo e gerar string html;
		String html = "html gerado do reader";
		return new Checker(html);
	}
		
	
	public static MarkEvaluationBuilder marking() { return new MarkEvaluationBuilder(); }
	public static FormEvaluationBuilder form() { return new FormEvaluationBuilder(); }
	
	public Checker with(EvaluationBuilder builder) {
		Evaluation evaluation = builder.with(this.document);
		occurrencesMap.put(evaluation.type(), evaluation.check());
		return this;
	}
	
	public Checker with(SpecificRecommendation evaluation){
		evaluation.with(document);
		
		if(occurrencesMap.get(evaluation.type())!=null)
			occurrencesMap.get(evaluation.type()).addAll(evaluation.check());
		else
			occurrencesMap.put(evaluation.type(), evaluation.check());
		
		return this;
	}
	
	public Map<OccurrenceClassification,List<Occurrence>> check() { return this.occurrencesMap; }

}
