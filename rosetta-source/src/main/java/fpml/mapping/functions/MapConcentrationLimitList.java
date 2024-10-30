package fpml.mapping.functions;

import cdm.product.collateral.ConcentrationLimit;
import cdm.product.collateral.ConcentrationLimit.ConcentrationLimitBuilder;
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


@ImplementedBy(MapConcentrationLimitList.MapConcentrationLimitListDefault.class)
public abstract class MapConcentrationLimitList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapConcentrationLimitCriteriaList mapConcentrationLimitCriteriaList;
	@Inject protected MapMoneyRange mapMoneyRange;
	@Inject protected MapNumberRange mapNumberRange;

	/**
	* @param fpmlDataDocument 
	* @return concentrationLimitList 
	*/
	public List<? extends ConcentrationLimit> evaluate(DataDocument fpmlDataDocument) {
		List<ConcentrationLimit.ConcentrationLimitBuilder> concentrationLimitListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ConcentrationLimit> concentrationLimitList;
		if (concentrationLimitListBuilder == null) {
			concentrationLimitList = null;
		} else {
			concentrationLimitList = concentrationLimitListBuilder.stream().map(ConcentrationLimit::build).collect(Collectors.toList());
			objectValidator.validate(ConcentrationLimit.class, concentrationLimitList);
		}
		
		return concentrationLimitList;
	}

	protected abstract List<ConcentrationLimit.ConcentrationLimitBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapConcentrationLimitListDefault extends MapConcentrationLimitList {
		@Override
		protected List<ConcentrationLimit.ConcentrationLimitBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ConcentrationLimit.ConcentrationLimitBuilder> concentrationLimitList = new ArrayList<>();
			return assignOutput(concentrationLimitList, fpmlDataDocument);
		}
		
		protected List<ConcentrationLimit.ConcentrationLimitBuilder> assignOutput(List<ConcentrationLimit.ConcentrationLimitBuilder> concentrationLimitList, DataDocument fpmlDataDocument) {
			concentrationLimitList.addAll(toBuilder(MapperC.<ConcentrationLimit>of(MapperS.of(ConcentrationLimit.builder()
				.setConcentrationLimitCriteria(new ArrayList(mapConcentrationLimitCriteriaList.evaluate(fpmlDataDocument)))
				.setValueLimit(mapMoneyRange.evaluate(fpmlDataDocument))
				.setPercentageLimit(mapNumberRange.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(concentrationLimitList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
