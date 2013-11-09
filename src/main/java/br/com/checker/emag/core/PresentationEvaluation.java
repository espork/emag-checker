package br.com.checker.emag.core;

import java.util.ArrayList;
import java.util.List;

import net.htmlparser.jericho.Attribute;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;
import br.com.checker.emag.Occurrence;
import br.com.checker.emag.OccurrenceClassification;
import br.com.checker.emag.core.BehaviorEvaluation.EvaluationRecommendation11;
import br.com.checker.emag.core.BehaviorEvaluation.EvaluationRecommendation12;
import br.com.checker.emag.core.BehaviorEvaluation.EvaluationRecommendation13;
import br.com.checker.emag.core.BehaviorEvaluation.EvaluationRecommendation14;
import br.com.checker.emag.core.BehaviorEvaluation.EvaluationRecommendation15;
import br.com.checker.emag.core.SpecificRecommendation.PresentationRecommendation;

public class PresentationEvaluation extends Evaluation{

	private PresentationEvaluation(Source document) { super(document); }
	
	public static class PresentationEvaluationBuilder extends EvaluationBuilder {
		
		@Override
		protected PresentationEvaluation with(Source document) { return new PresentationEvaluation(document); }
		
		public SpecificRecommendation recommendation28() { return new EvaluationRecommendation28();}
		public SpecificRecommendation recommendation11() { return new EvaluationRecommendation11();}
		public SpecificRecommendation recommendation12() { return new EvaluationRecommendation12();}
		public SpecificRecommendation recommendation13() { return new EvaluationRecommendation13();}
		public SpecificRecommendation recommendation14() { return new EvaluationRecommendation14();}
		public SpecificRecommendation recommendation15() { return new EvaluationRecommendation15();}
	}
	
	protected static class EvaluationRecommendation28 extends PresentationRecommendation{
		protected List<Occurrence> check() { return getEvaluation().checkRecommendation28();}
	}
	
	public List<Occurrence> check() {
		getOccurrences().clear();
		getOccurrences().addAll(checkRecommendation28());
		getOccurrences().addAll(checkRecommendation29());
		getOccurrences().addAll(checkRecommendation30());
		getOccurrences().addAll(checkRecommendation31());
		getOccurrences().addAll(checkRecommendation32());
		
		return getOccurrences();
	}
	
	
	
	private List<Occurrence> checkRecommendation28() {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();
		
		boolean temBgcolor = false;
		for (Element bgcolor : getDocument().getAllElements("body")) {
			Attribute bgc = bgcolor.getAttributes().get("bgcolor");
			if(bgc != null){
				occurrences.add(buildOccurrence("28", true, bgcolor.toString(), bgcolor));
				temBgcolor = true;
			}
		}
		for (Element bgcolor : getDocument().getAllElements("table")) {
			Attribute bgc = bgcolor.getAttributes().get("bgcolor");
			if(bgc != null){
				occurrences.add(buildOccurrence("28", true, bgcolor.toString(), bgcolor));
				temBgcolor = true;
			}
		}
		for (Element bgcolor : getDocument().getAllElements("td")) {
			Attribute bgc = bgcolor.getAttributes().get("bgcolor");
			if(bgc != null){
				occurrences.add(buildOccurrence("28", true, bgcolor.toString(), bgcolor));
				temBgcolor = true;
			}
		}
		for (Element bgcolor : getDocument().getAllElements("tr")) {
			Attribute bgc = bgcolor.getAttributes().get("bgcolor");
			if(bgc != null){
				occurrences.add(buildOccurrence("28", true, bgcolor.toString(), bgcolor));
				temBgcolor = true;
			}
		}
		
		if(!temBgcolor)
			occurrences.add(new Occurrence("28", false, getDocument().getFirstElement().toString(),OccurrenceClassification.PRESENTATION_DESIGN));
		
		return occurrences;
	}
	
	private List<Occurrence> checkRecommendation29() {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();
		
		boolean temBgcolor = false;
		for (Element bgcolor : getDocument().getAllElements("body")) {
			Attribute bgc = bgcolor.getAttributes().get("bgcolor");
			if(bgc != null){
				occurrences.add(buildOccurrence("29", true, bgcolor.toString(), bgcolor));
				temBgcolor = true;
			}
		}
		for (Element bgcolor : getDocument().getAllElements("table")) {
			Attribute bgc = bgcolor.getAttributes().get("bgcolor");
			if(bgc != null){
				occurrences.add(buildOccurrence("29", true, bgcolor.toString(), bgcolor));
				temBgcolor = true;
			}
		}
		for (Element bgcolor : getDocument().getAllElements("td")) {
			Attribute bgc = bgcolor.getAttributes().get("bgcolor");
			if(bgc != null){
				occurrences.add(buildOccurrence("29", true, bgcolor.toString(), bgcolor));
				temBgcolor = true;
			}
		}
		for (Element bgcolor : getDocument().getAllElements("tr")) {
			Attribute bgc = bgcolor.getAttributes().get("bgcolor");
			if(bgc != null){
				occurrences.add(buildOccurrence("29", true, bgcolor.toString(), bgcolor));
				temBgcolor = true;
			}
		}	
		
		if(!temBgcolor)
			occurrences.add(new Occurrence("29", false, getDocument().getFirstElement().toString(),OccurrenceClassification.PRESENTATION_DESIGN));
		
		return occurrences;
	}
	
	private List<Occurrence> checkRecommendation30() {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();
		occurrences.add(new Occurrence("30", false, getDocument().getFirstElement().toString(),OccurrenceClassification.PRESENTATION_DESIGN));
		return occurrences;
	}
	
	private List<Occurrence> checkRecommendation31() {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();
		occurrences.add(new Occurrence("31", false, getDocument().getFirstElement().toString(),OccurrenceClassification.PRESENTATION_DESIGN));
		
		return occurrences;
	}
	
	private List<Occurrence> checkRecommendation32() {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();
		occurrences.add(new Occurrence("32", false, getDocument().getFirstElement().toString(),OccurrenceClassification.PRESENTATION_DESIGN));
		
		return occurrences;
	}
	
	
	
	
	private Occurrence buildOccurrence(String code, boolean error,
			String tag, Element element) {
		return super.buildOccurrence(code, error, tag, element, OccurrenceClassification.PRESENTATION_DESIGN);
	}
	
	public OccurrenceClassification type () { return OccurrenceClassification.PRESENTATION_DESIGN;}
}
