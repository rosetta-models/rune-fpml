package fpml.mapping.functions;

import cdm.base.math.DatedValue;
import cdm.base.math.DatedValue.DatedValueBuilder;
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


@ImplementedBy(MapDatedValueList.MapDatedValueListDefault.class)
public abstract class MapDatedValueList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return datedValueList 
	*/
	public List<? extends DatedValue> evaluate(DataDocument fpmlDataDocument) {
		List<DatedValue.DatedValueBuilder> datedValueListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends DatedValue> datedValueList;
		if (datedValueListBuilder == null) {
			datedValueList = null;
		} else {
			datedValueList = datedValueListBuilder.stream().map(DatedValue::build).collect(Collectors.toList());
			objectValidator.validate(DatedValue.class, datedValueList);
		}
		
		return datedValueList;
	}

	protected abstract List<DatedValue.DatedValueBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDatedValueListDefault extends MapDatedValueList {
		@Override
		protected List<DatedValue.DatedValueBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<DatedValue.DatedValueBuilder> datedValueList = new ArrayList<>();
			return assignOutput(datedValueList, fpmlDataDocument);
		}
		
		protected List<DatedValue.DatedValueBuilder> assignOutput(List<DatedValue.DatedValueBuilder> datedValueList, DataDocument fpmlDataDocument) {
			datedValueList.addAll(toBuilder(MapperC.<DatedValue>of(MapperS.of(DatedValue.builder()
				.setDate(null)
				.setValue(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(datedValueList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
