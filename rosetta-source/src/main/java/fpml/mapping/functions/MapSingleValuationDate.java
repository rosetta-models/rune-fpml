package fpml.mapping.functions;

import cdm.observable.asset.SingleValuationDate;
import cdm.observable.asset.SingleValuationDate.SingleValuationDateBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSingleValuationDate.MapSingleValuationDateDefault.class)
public abstract class MapSingleValuationDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return singleValuationDate 
	*/
	public SingleValuationDate evaluate(DataDocument fpmlDataDocument) {
		SingleValuationDate.SingleValuationDateBuilder singleValuationDateBuilder = doEvaluate(fpmlDataDocument);
		
		final SingleValuationDate singleValuationDate;
		if (singleValuationDateBuilder == null) {
			singleValuationDate = null;
		} else {
			singleValuationDate = singleValuationDateBuilder.build();
			objectValidator.validate(SingleValuationDate.class, singleValuationDate);
		}
		
		return singleValuationDate;
	}

	protected abstract SingleValuationDate.SingleValuationDateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSingleValuationDateDefault extends MapSingleValuationDate {
		@Override
		protected SingleValuationDate.SingleValuationDateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SingleValuationDate.SingleValuationDateBuilder singleValuationDate = SingleValuationDate.builder();
			return assignOutput(singleValuationDate, fpmlDataDocument);
		}
		
		protected SingleValuationDate.SingleValuationDateBuilder assignOutput(SingleValuationDate.SingleValuationDateBuilder singleValuationDate, DataDocument fpmlDataDocument) {
			singleValuationDate = toBuilder(SingleValuationDate.builder()
				.setBusinessDays(null)
				.build());
			
			return Optional.ofNullable(singleValuationDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
