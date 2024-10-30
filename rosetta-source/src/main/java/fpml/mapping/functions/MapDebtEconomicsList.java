package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.DebtEconomics;
import cdm.base.staticdata.asset.common.DebtEconomics.DebtEconomicsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapDebtEconomicsList.MapDebtEconomicsListDefault.class)
public abstract class MapDebtEconomicsList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return debtEconomicsList 
	*/
	public List<? extends DebtEconomics> evaluate(DataDocument fpmlDataDocument) {
		List<DebtEconomics.DebtEconomicsBuilder> debtEconomicsListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends DebtEconomics> debtEconomicsList;
		if (debtEconomicsListBuilder == null) {
			debtEconomicsList = null;
		} else {
			debtEconomicsList = debtEconomicsListBuilder.stream().map(DebtEconomics::build).collect(Collectors.toList());
			objectValidator.validate(DebtEconomics.class, debtEconomicsList);
		}
		
		return debtEconomicsList;
	}

	protected abstract List<DebtEconomics.DebtEconomicsBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDebtEconomicsListDefault extends MapDebtEconomicsList {
		@Override
		protected List<DebtEconomics.DebtEconomicsBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<DebtEconomics.DebtEconomicsBuilder> debtEconomicsList = new ArrayList<>();
			return assignOutput(debtEconomicsList, fpmlDataDocument);
		}
		
		protected List<DebtEconomics.DebtEconomicsBuilder> assignOutput(List<DebtEconomics.DebtEconomicsBuilder> debtEconomicsList, DataDocument fpmlDataDocument) {
			debtEconomicsList.addAll(toBuilder(MapperC.<DebtEconomics>of(MapperS.of(DebtEconomics.builder()
				.setDebtSeniority(null)
				.setDebtInterest(null)
				.setDebtPrincipal(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(debtEconomicsList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
