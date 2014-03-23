package br.com.checker.emag;

import static br.com.checker.emag.core.Checker.from;
import static br.com.checker.emag.core.Checker.presentation;
import static org.junit.Assert.*;


import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.checker.emag.Occurrence;
import br.com.checker.emag.OccurrenceClassification;

@RunWith(JUnit4.class)
public class PresentationEvaluationTest {
	
	
	@Test
	public void shouldCheckRecomendation28() {
		StringBuilder html = new StringBuilder("<html");
		html.append("<body bgcolor=\"#000\">")
			.append(" <table bgcolor=\"#000\">")
			.append("  <tr bgcolor=\"#000\">")
			.append("   <td bgcolor=\"#000\">")
			.append("   <td>")
			.append("  </tr>")
			.append(" </table>")
			.append("</body>")
			.append("</html>");
		
		Map<OccurrenceClassification,List<Occurrence>> occurrences = from(html.toString())
					.with(presentation().recommendation28()).check();
		
		assertEquals("Should return 4 occurrences",4,occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN).size());
		
		for(Occurrence occurrence : occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN)) {
			assertEquals("Should return Recommendation 28 occurrence","28",occurrence.getCode());
			assertTrue("Recomerndation 28 should be Error", occurrence.isError());
		}
		
	}
	
	@Test
	public void shouldCheckRecomendation28WithWarning() {
		StringBuilder html = new StringBuilder("<html");
		html.append("<body>")
			.append(" <table>")
			.append("  <tr>")
			.append("   <td>")
			.append("   <td>")
			.append("  </tr>")
			.append(" </table>")
			.append("</body>")
			.append("</html>");
		
		Map<OccurrenceClassification,List<Occurrence>> occurrences = from(html.toString())
					.with(presentation().recommendation28()).check();
		
		assertEquals("Should return 1 occurrences",1,occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN).size());
		assertFalse("Recommendation 28 should be WARNING",occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN).get(0).isError());
		
	}
	
	@Test
	public void shouldCheckRecomendation29() {
		StringBuilder html = new StringBuilder("<html");
		html.append("<body bgcolor=\"#000\">")
			.append(" <table bgcolor=\"#000\">")
			.append("  <tr bgcolor=\"#000\">")
			.append("   <td bgcolor=\"#000\">")
			.append("   <td>")
			.append("  </tr>")
			.append(" </table>")
			.append("</body>")
			.append("</html>");
		
		Map<OccurrenceClassification,List<Occurrence>> occurrences = from(html.toString())
					.with(presentation().recommendation29()).check();
		
		assertEquals("Should return 4 occurrences",4,occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN).size());
		
		for(Occurrence occurrence : occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN)) {
			assertEquals("Should return Recommendation 98 occurrence","29",occurrence.getCode());
			assertTrue("Recomerndation 29 should be Error", occurrence.isError());
		}
		
	}
	
	@Test
	public void shouldCheckRecomendation29WithWarning() {
		StringBuilder html = new StringBuilder("<html");
		html.append("<body>")
			.append(" <table>")
			.append("  <tr>")
			.append("   <td>")
			.append("   <td>")
			.append("  </tr>")
			.append(" </table>")
			.append("</body>")
			.append("</html>");
		
		Map<OccurrenceClassification,List<Occurrence>> occurrences = from(html.toString())
					.with(presentation().recommendation29()).check();
		
		assertEquals("Should return 1 occurrences",1,occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN).size());
		assertFalse("Recommendation 29 should be WARNING",occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN).get(0).isError());
		
	}
	
	@Test
	public void shouldAlwaysCheckRecommendation30() {
		StringBuilder html = new StringBuilder("<html></html>");
		
		Map<OccurrenceClassification,List<Occurrence>> occurrences = from(html.toString())
				  													.with(presentation().recommendation30()).check();
		
		assertEquals("Should return Recommendation 30 ","30",occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN).get(0).getCode());
		assertFalse("Recommendation 30 should be WARNING",occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN).get(0).isError());
		
	}
	
	@Test
	public void shouldAlwaysCheckRecommendation31() {
		StringBuilder html = new StringBuilder("<html></html>");
		
		Map<OccurrenceClassification,List<Occurrence>> occurrences = from(html.toString())
				  													.with(presentation().recommendation31()).check();
		
		assertEquals("Should return Recommendation 31 ","31",occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN).get(0).getCode());
		assertFalse("Recommendation 31 should be WARNING",occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN).get(0).isError());
		
	}
	
	@Test
	public void shouldAlwaysCheckRecommendation32() {
		StringBuilder html = new StringBuilder("<html></html>");
		
		Map<OccurrenceClassification,List<Occurrence>> occurrences = from(html.toString())
				  													.with(presentation().recommendation32()).check();
		
		assertEquals("Should return Recommendation 32 ","32",occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN).get(0).getCode());
		assertFalse("Recommendation 32 should be WARNING",occurrences.get(OccurrenceClassification.PRESENTATION_DESIGN).get(0).isError());
		
	}
}
