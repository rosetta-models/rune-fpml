package fpml.mapping.functions;

import cdm.product.asset.SettledEntityMatrix;
import cdm.product.asset.SettledEntityMatrix.SettledEntityMatrixBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSettledEntityMatrix.MapSettledEntityMatrixDefault.class)
public abstract class MapSettledEntityMatrix implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMatrixSourceWithScheme mapMatrixSourceWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return settledEntityMatrix 
	*/
	public SettledEntityMatrix evaluate(DataDocument fpmlDataDocument) {
		SettledEntityMatrix.SettledEntityMatrixBuilder settledEntityMatrixBuilder = doEvaluate(fpmlDataDocument);
		
		final SettledEntityMatrix settledEntityMatrix;
		if (settledEntityMatrixBuilder == null) {
			settledEntityMatrix = null;
		} else {
			settledEntityMatrix = settledEntityMatrixBuilder.build();
			objectValidator.validate(SettledEntityMatrix.class, settledEntityMatrix);
		}
		
		return settledEntityMatrix;
	}

	protected abstract SettledEntityMatrix.SettledEntityMatrixBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSettledEntityMatrixDefault extends MapSettledEntityMatrix {
		@Override
		protected SettledEntityMatrix.SettledEntityMatrixBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SettledEntityMatrix.SettledEntityMatrixBuilder settledEntityMatrix = SettledEntityMatrix.builder();
			return assignOutput(settledEntityMatrix, fpmlDataDocument);
		}
		
		protected SettledEntityMatrix.SettledEntityMatrixBuilder assignOutput(SettledEntityMatrix.SettledEntityMatrixBuilder settledEntityMatrix, DataDocument fpmlDataDocument) {
			settledEntityMatrix = toBuilder(SettledEntityMatrix.builder()
				.setMatrixSourceValue(mapMatrixSourceWithScheme.evaluate(fpmlDataDocument))
				.setPublicationDate(null)
				.build());
			
			return Optional.ofNullable(settledEntityMatrix)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
