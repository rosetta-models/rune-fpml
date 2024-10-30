package fpml.mapping.functions;

import cdm.legaldocumentation.common.ContractualTermsSupplement;
import cdm.legaldocumentation.common.ContractualTermsSupplement.ContractualTermsSupplementBuilder;
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


@ImplementedBy(MapContractualTermsSupplementList.MapContractualTermsSupplementListDefault.class)
public abstract class MapContractualTermsSupplementList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapContractualTermsSupplementTypeWithScheme mapContractualTermsSupplementTypeWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return contractualTermsSupplementList 
	*/
	public List<? extends ContractualTermsSupplement> evaluate(DataDocument fpmlDataDocument) {
		List<ContractualTermsSupplement.ContractualTermsSupplementBuilder> contractualTermsSupplementListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ContractualTermsSupplement> contractualTermsSupplementList;
		if (contractualTermsSupplementListBuilder == null) {
			contractualTermsSupplementList = null;
		} else {
			contractualTermsSupplementList = contractualTermsSupplementListBuilder.stream().map(ContractualTermsSupplement::build).collect(Collectors.toList());
			objectValidator.validate(ContractualTermsSupplement.class, contractualTermsSupplementList);
		}
		
		return contractualTermsSupplementList;
	}

	protected abstract List<ContractualTermsSupplement.ContractualTermsSupplementBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapContractualTermsSupplementListDefault extends MapContractualTermsSupplementList {
		@Override
		protected List<ContractualTermsSupplement.ContractualTermsSupplementBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ContractualTermsSupplement.ContractualTermsSupplementBuilder> contractualTermsSupplementList = new ArrayList<>();
			return assignOutput(contractualTermsSupplementList, fpmlDataDocument);
		}
		
		protected List<ContractualTermsSupplement.ContractualTermsSupplementBuilder> assignOutput(List<ContractualTermsSupplement.ContractualTermsSupplementBuilder> contractualTermsSupplementList, DataDocument fpmlDataDocument) {
			contractualTermsSupplementList.addAll(toBuilder(MapperC.<ContractualTermsSupplement>of(MapperS.of(ContractualTermsSupplement.builder()
				.setContractualTermsSupplementTypeValue(mapContractualTermsSupplementTypeWithScheme.evaluate(fpmlDataDocument))
				.setPublicationDate(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(contractualTermsSupplementList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
