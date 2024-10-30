package fpml.mapping.functions;

import cdm.product.template.Strike;
import cdm.product.template.Strike.StrikeBuilder;
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


@ImplementedBy(MapStrikeList.MapStrikeListDefault.class)
public abstract class MapStrikeList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return strikeList 
	*/
	public List<? extends Strike> evaluate(DataDocument fpmlDataDocument) {
		List<Strike.StrikeBuilder> strikeListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Strike> strikeList;
		if (strikeListBuilder == null) {
			strikeList = null;
		} else {
			strikeList = strikeListBuilder.stream().map(Strike::build).collect(Collectors.toList());
			objectValidator.validate(Strike.class, strikeList);
		}
		
		return strikeList;
	}

	protected abstract List<Strike.StrikeBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapStrikeListDefault extends MapStrikeList {
		@Override
		protected List<Strike.StrikeBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Strike.StrikeBuilder> strikeList = new ArrayList<>();
			return assignOutput(strikeList, fpmlDataDocument);
		}
		
		protected List<Strike.StrikeBuilder> assignOutput(List<Strike.StrikeBuilder> strikeList, DataDocument fpmlDataDocument) {
			strikeList.addAll(toBuilder(MapperC.<Strike>of(MapperS.of(Strike.builder()
				.setStrikeRate(null)
				.setBuyer(null)
				.setSeller(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(strikeList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
