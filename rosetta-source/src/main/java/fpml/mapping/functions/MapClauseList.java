package fpml.mapping.functions;

import cdm.legaldocumentation.master.Clause;
import cdm.legaldocumentation.master.Clause.ClauseBuilder;
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


@ImplementedBy(MapClauseList.MapClauseListDefault.class)
public abstract class MapClauseList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected fpml.mapping.functions.MapClauseList mapClauseList;

	/**
	* @param fpmlDataDocument 
	* @return clauseList 
	*/
	public List<? extends Clause> evaluate(DataDocument fpmlDataDocument) {
		List<Clause.ClauseBuilder> clauseListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Clause> clauseList;
		if (clauseListBuilder == null) {
			clauseList = null;
		} else {
			clauseList = clauseListBuilder.stream().map(Clause::build).collect(Collectors.toList());
			objectValidator.validate(Clause.class, clauseList);
		}
		
		return clauseList;
	}

	protected abstract List<Clause.ClauseBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapClauseListDefault extends MapClauseList {
		@Override
		protected List<Clause.ClauseBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Clause.ClauseBuilder> clauseList = new ArrayList<>();
			return assignOutput(clauseList, fpmlDataDocument);
		}
		
		protected List<Clause.ClauseBuilder> assignOutput(List<Clause.ClauseBuilder> clauseList, DataDocument fpmlDataDocument) {
			clauseList.addAll(toBuilder(MapperC.<Clause>of(MapperS.of(Clause.builder()
				.setIdentifier(null)
				.setTerms(null)
				.setSubcomponents(new ArrayList(mapClauseList.evaluate(fpmlDataDocument)))
				.build())).getMulti()));
			
			return Optional.ofNullable(clauseList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
