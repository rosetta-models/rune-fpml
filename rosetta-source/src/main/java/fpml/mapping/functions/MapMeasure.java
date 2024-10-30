package fpml.mapping.functions;

import cdm.base.math.Measure;
import cdm.base.math.Measure.MeasureBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMeasure.MapMeasureDefault.class)
public abstract class MapMeasure implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapUnitType mapUnitType;

	/**
	* @param fpmlDataDocument 
	* @return measure 
	*/
	public Measure evaluate(DataDocument fpmlDataDocument) {
		Measure.MeasureBuilder measureBuilder = doEvaluate(fpmlDataDocument);
		
		final Measure measure;
		if (measureBuilder == null) {
			measure = null;
		} else {
			measure = measureBuilder.build();
			objectValidator.validate(Measure.class, measure);
		}
		
		return measure;
	}

	protected abstract Measure.MeasureBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMeasureDefault extends MapMeasure {
		@Override
		protected Measure.MeasureBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Measure.MeasureBuilder measure = Measure.builder();
			return assignOutput(measure, fpmlDataDocument);
		}
		
		protected Measure.MeasureBuilder assignOutput(Measure.MeasureBuilder measure, DataDocument fpmlDataDocument) {
			measure = toBuilder(Measure.builder()
				.setValue(null)
				.setUnit(mapUnitType.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(measure)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
