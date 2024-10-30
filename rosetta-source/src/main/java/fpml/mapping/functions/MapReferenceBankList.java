package fpml.mapping.functions;

import cdm.base.staticdata.party.ReferenceBank;
import cdm.base.staticdata.party.ReferenceBank.ReferenceBankBuilder;
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


@ImplementedBy(MapReferenceBankList.MapReferenceBankListDefault.class)
public abstract class MapReferenceBankList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapReferenceBankIdWithScheme mapReferenceBankIdWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return referenceBankList 
	*/
	public List<? extends ReferenceBank> evaluate(DataDocument fpmlDataDocument) {
		List<ReferenceBank.ReferenceBankBuilder> referenceBankListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ReferenceBank> referenceBankList;
		if (referenceBankListBuilder == null) {
			referenceBankList = null;
		} else {
			referenceBankList = referenceBankListBuilder.stream().map(ReferenceBank::build).collect(Collectors.toList());
			objectValidator.validate(ReferenceBank.class, referenceBankList);
		}
		
		return referenceBankList;
	}

	protected abstract List<ReferenceBank.ReferenceBankBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapReferenceBankListDefault extends MapReferenceBankList {
		@Override
		protected List<ReferenceBank.ReferenceBankBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ReferenceBank.ReferenceBankBuilder> referenceBankList = new ArrayList<>();
			return assignOutput(referenceBankList, fpmlDataDocument);
		}
		
		protected List<ReferenceBank.ReferenceBankBuilder> assignOutput(List<ReferenceBank.ReferenceBankBuilder> referenceBankList, DataDocument fpmlDataDocument) {
			referenceBankList.addAll(toBuilder(MapperC.<ReferenceBank>of(MapperS.of(ReferenceBank.builder()
				.setReferenceBankIdValue(mapReferenceBankIdWithScheme.evaluate(fpmlDataDocument))
				.setReferenceBankName(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(referenceBankList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
