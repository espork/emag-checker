package br.com.checker.emag;

import static br.com.checker.emag.core.Checker.content;
import static br.com.checker.emag.core.Checker.from;
import static br.com.checker.emag.core.Checker.multimedia;
import static org.junit.Assert.*;


import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.checker.emag.Occurrence;
import br.com.checker.emag.OccurrenceClassification;

@RunWith(JUnit4.class)
public class MultimediaEvaluationTest {

	
	@Test
	public void shouldCheckRecommedation33() {
		StringBuilder html = new StringBuilder("<html>");
		html.append("<embed></embed>");
		html.append("<object></object>");
		html.append("<object value=\"teste.mp4\"></object>");
		html.append("<object value=\"teste.avi\"></object>");
		html.append("<object value=\"teste.flv\"></object>");
		html.append("<object value=\"teste.rmvb\"></object>");
		html.append("</html>");
		
		Map<OccurrenceClassification,List<Occurrence>> occurrences = from(html.toString())
				  													.with(multimedia().recommendation33()).check();
		
		assertEquals("Should return 5 occurrences", 5,occurrences.get(OccurrenceClassification.MULTIMEDIA).size());
		
		for(Occurrence occurrence :occurrences.get(OccurrenceClassification.MULTIMEDIA) ) {
			assertEquals("Should return Recommendation 33","33",occurrence.getCode());
			assertFalse("Recommendation 33 should be WARNING",occurrence.isError());
		}
	}
	
	@Test
	public void shouldCheckRecommedation34() {
		StringBuilder html = new StringBuilder("<html>");
		html.append("<object></object>");
		html.append("<object data=\"teste.mp3\"></object>");
		html.append("<object data=\"teste.wma\"></object>");
		html.append("<object data=\"teste.wav\"></object>");
		html.append("</html>");
		
		Map<OccurrenceClassification,List<Occurrence>> occurrences = from(html.toString())
				  													.with(multimedia().recommendation34()).check();
		
		assertEquals("Should return 3 occurrences", 3,occurrences.get(OccurrenceClassification.MULTIMEDIA).size());
		
		for(Occurrence occurrence :occurrences.get(OccurrenceClassification.MULTIMEDIA) ) {
			assertEquals("Should return Recommendation 34","34",occurrence.getCode());
			assertFalse("Recommendation 34 should be WARNING",occurrence.isError());
		}
	}
	
	@Test
	public void shouldCheckRecommedation35() {
		StringBuilder html = new StringBuilder("<html>");
		html.append("<embed></embed>");
		html.append("<embed></embed>");
		html.append("<object></object>");
		html.append("<object value=\"teste.mp4\"></object>");
		html.append("<object value=\"teste.avi\"></object>");
		html.append("<object value=\"teste.flv\"></object>");
		html.append("<object value=\"teste.rmvb\"></object>");
		html.append("</html>");
		
		Map<OccurrenceClassification,List<Occurrence>> occurrences = from(html.toString())
				  													.with(multimedia().recommendation35()).check();
		
		assertEquals("Should return 7 occurrences", 7,occurrences.get(OccurrenceClassification.MULTIMEDIA).size());
		
		for(Occurrence occurrence :occurrences.get(OccurrenceClassification.MULTIMEDIA) ) {
			assertEquals("Should return Recommendation 35","35",occurrence.getCode());
			assertFalse("Recommendation 35 should be WARNING",occurrence.isError());
		}
	}
	
	@Test
	public void shouldAlwaysCheckRecommendation36() {
		StringBuilder html = new StringBuilder("<html></html>");
		
		Map<OccurrenceClassification,List<Occurrence>> occurrences = from(html.toString())
				  													.with(multimedia().recommendation36()).check();
		assertEquals("Should return 1 occurrence", 1,occurrences.get(OccurrenceClassification.MULTIMEDIA).size());
		assertEquals("Should return Recommendation 36 ","36",occurrences.get(OccurrenceClassification.MULTIMEDIA).get(0).getCode());
		assertFalse("Recommendation 36 should be WARNING",occurrences.get(OccurrenceClassification.MULTIMEDIA).get(0).isError());
		
	}
	
	@Test
	public void shouldCheckRecommedation37() {
		StringBuilder html = new StringBuilder("<html>");
		html.append("<object width=\"400\" height=\"50\" data=\"bookmark.swf\"></object> ");
		html.append("</html>");
		
		Map<OccurrenceClassification,List<Occurrence>> occurrences = from(html.toString())
				  													.with(multimedia().recommendation37()).check();
		
		assertEquals("Should return 1 occurrences 1", 1,occurrences.get(OccurrenceClassification.MULTIMEDIA).size());
		assertEquals("Should return Recommendation 37","37",occurrences.get(OccurrenceClassification.MULTIMEDIA).get(0).getCode());
		assertFalse("Recommendation 37 should be WARNING",occurrences.get(OccurrenceClassification.MULTIMEDIA).get(0).isError());
	}
	
	
}
