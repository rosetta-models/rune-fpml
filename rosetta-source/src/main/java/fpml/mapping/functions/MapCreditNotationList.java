package fpml.mapping.functions;

import cdm.observable.asset.CreditNotation;
import cdm.observable.asset.CreditNotation.CreditNotationBuilder;
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


@ImplementedBy(MapCreditNotationList.MapCreditNotationListDefault.class)
public abstract class MapCreditNotationList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditRatingDebt mapCreditRatingDebt;
	@Inject protected MapNotationWithScheme mapNotationWithScheme;
	@Inject protected MapScaleWithScheme mapScaleWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return creditNotationList 
	*/
	public List<? extends CreditNotation> evaluate(DataDocument fpmlDataDocument) {
		List<CreditNotation.CreditNotationBuilder> creditNotationListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends CreditNotation> creditNotationList;
		if (creditNotationListBuilder == null) {
			creditNotationList = null;
		} else {
			creditNotationList = creditNotationListBuilder.stream().map(CreditNotation::build).collect(Collectors.toList());
			objectValidator.validate(CreditNotation.class, creditNotationList);
		}
		
		return creditNotationList;
	}

	protected abstract List<CreditNotation.CreditNotationBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCreditNotationListDefault extends MapCreditNotationList {
		@Override
		protected List<CreditNotation.CreditNotationBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<CreditNotation.CreditNotationBuilder> creditNotationList = new ArrayList<>();
			return assignOutput(creditNotationList, fpmlDataDocument);
		}
		
		protected List<CreditNotation.CreditNotationBuilder> assignOutput(List<CreditNotation.CreditNotationBuilder> creditNotationList, DataDocument fpmlDataDocument) {
			creditNotationList.addAll(toBuilder(MapperC.<CreditNotation>of(MapperS.of(CreditNotation.builder()
				.setAgency(null)
				.setNotationValue(mapNotationWithScheme.evaluate(fpmlDataDocument))
				.setScaleValue(mapScaleWithScheme.evaluate(fpmlDataDocument))
				.setDebt(mapCreditRatingDebt.evaluate(fpmlDataDocument))
				.setOutlook(null)
				.setCreditWatch(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(creditNotationList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
