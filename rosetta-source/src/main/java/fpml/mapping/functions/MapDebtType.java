package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.DebtType;
import cdm.base.staticdata.asset.common.DebtType.DebtTypeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDebtType.MapDebtTypeDefault.class)
public abstract class MapDebtType implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDebtEconomicsList mapDebtEconomicsList;

	/**
	* @param fpmlDataDocument 
	* @return debtType 
	*/
	public DebtType evaluate(DataDocument fpmlDataDocument) {
		DebtType.DebtTypeBuilder debtTypeBuilder = doEvaluate(fpmlDataDocument);
		
		final DebtType debtType;
		if (debtTypeBuilder == null) {
			debtType = null;
		} else {
			debtType = debtTypeBuilder.build();
			objectValidator.validate(DebtType.class, debtType);
		}
		
		return debtType;
	}

	protected abstract DebtType.DebtTypeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDebtTypeDefault extends MapDebtType {
		@Override
		protected DebtType.DebtTypeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DebtType.DebtTypeBuilder debtType = DebtType.builder();
			return assignOutput(debtType, fpmlDataDocument);
		}
		
		protected DebtType.DebtTypeBuilder assignOutput(DebtType.DebtTypeBuilder debtType, DataDocument fpmlDataDocument) {
			debtType = toBuilder(DebtType.builder()
				.setDebtClass(null)
				.setDebtEconomics(new ArrayList(mapDebtEconomicsList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(debtType)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
