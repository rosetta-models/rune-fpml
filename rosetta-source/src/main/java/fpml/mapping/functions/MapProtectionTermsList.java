package fpml.mapping.functions;

import cdm.product.asset.ProtectionTerms;
import cdm.product.asset.ProtectionTerms.ProtectionTermsBuilder;
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


@ImplementedBy(MapProtectionTermsList.MapProtectionTermsListDefault.class)
public abstract class MapProtectionTermsList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditEvents mapCreditEvents;
	@Inject protected MapFloatingAmountEvents mapFloatingAmountEvents;
	@Inject protected MapObligations mapObligations;

	/**
	* @param fpmlDataDocument 
	* @return protectionTermsList 
	*/
	public List<? extends ProtectionTerms> evaluate(DataDocument fpmlDataDocument) {
		List<ProtectionTerms.ProtectionTermsBuilder> protectionTermsListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ProtectionTerms> protectionTermsList;
		if (protectionTermsListBuilder == null) {
			protectionTermsList = null;
		} else {
			protectionTermsList = protectionTermsListBuilder.stream().map(ProtectionTerms::build).collect(Collectors.toList());
			objectValidator.validate(ProtectionTerms.class, protectionTermsList);
		}
		
		return protectionTermsList;
	}

	protected abstract List<ProtectionTerms.ProtectionTermsBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapProtectionTermsListDefault extends MapProtectionTermsList {
		@Override
		protected List<ProtectionTerms.ProtectionTermsBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ProtectionTerms.ProtectionTermsBuilder> protectionTermsList = new ArrayList<>();
			return assignOutput(protectionTermsList, fpmlDataDocument);
		}
		
		protected List<ProtectionTerms.ProtectionTermsBuilder> assignOutput(List<ProtectionTerms.ProtectionTermsBuilder> protectionTermsList, DataDocument fpmlDataDocument) {
			protectionTermsList.addAll(toBuilder(MapperC.<ProtectionTerms>of(MapperS.of(ProtectionTerms.builder()
				.setCreditEvents(mapCreditEvents.evaluate(fpmlDataDocument))
				.setObligations(mapObligations.evaluate(fpmlDataDocument))
				.setFloatingAmountEvents(mapFloatingAmountEvents.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(protectionTermsList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
