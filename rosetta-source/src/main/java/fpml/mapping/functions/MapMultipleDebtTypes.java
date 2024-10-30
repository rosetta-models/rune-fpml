package fpml.mapping.functions;

import cdm.observable.asset.MultipleDebtTypes;
import cdm.observable.asset.MultipleDebtTypes.MultipleDebtTypesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMultipleDebtTypes.MapMultipleDebtTypesDefault.class)
public abstract class MapMultipleDebtTypes implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDebtTypeWithSchemeList mapDebtTypeWithSchemeList;

	/**
	* @param fpmlDataDocument 
	* @return multipleDebtTypes 
	*/
	public MultipleDebtTypes evaluate(DataDocument fpmlDataDocument) {
		MultipleDebtTypes.MultipleDebtTypesBuilder multipleDebtTypesBuilder = doEvaluate(fpmlDataDocument);
		
		final MultipleDebtTypes multipleDebtTypes;
		if (multipleDebtTypesBuilder == null) {
			multipleDebtTypes = null;
		} else {
			multipleDebtTypes = multipleDebtTypesBuilder.build();
			objectValidator.validate(MultipleDebtTypes.class, multipleDebtTypes);
		}
		
		return multipleDebtTypes;
	}

	protected abstract MultipleDebtTypes.MultipleDebtTypesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMultipleDebtTypesDefault extends MapMultipleDebtTypes {
		@Override
		protected MultipleDebtTypes.MultipleDebtTypesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			MultipleDebtTypes.MultipleDebtTypesBuilder multipleDebtTypes = MultipleDebtTypes.builder();
			return assignOutput(multipleDebtTypes, fpmlDataDocument);
		}
		
		protected MultipleDebtTypes.MultipleDebtTypesBuilder assignOutput(MultipleDebtTypes.MultipleDebtTypesBuilder multipleDebtTypes, DataDocument fpmlDataDocument) {
			multipleDebtTypes = toBuilder(MultipleDebtTypes.builder()
				.setCondition(null)
				.setDebtTypeValue(mapDebtTypeWithSchemeList.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(multipleDebtTypes)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
