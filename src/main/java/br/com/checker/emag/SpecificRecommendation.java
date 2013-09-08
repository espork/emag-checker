package br.com.checker.emag;

import java.util.List;

import net.htmlparser.jericho.Source;

public abstract class SpecificRecommendation {
	
	protected Source document ;
	
	protected void with(Source document) {this.document = document;}
		
	protected abstract List<Occurrence> check();
	protected abstract OccurrenceClassification type();
	
	protected static abstract class MarkRecommendation extends SpecificRecommendation {
		
		protected MarkEvaluation getEvaluation() { return new MarkEvaluation.MarkEvaluationBuilder().with(document);}
		protected OccurrenceClassification type () { return OccurrenceClassification.MARK;}
	}
	
	protected static abstract class FormRecommendation extends SpecificRecommendation {
		
		protected FormEvaluation getEvaluation() { return new FormEvaluation.FormEvaluationBuilder().with(document);}
		protected OccurrenceClassification type () { return OccurrenceClassification.FORM; }
	}
}
