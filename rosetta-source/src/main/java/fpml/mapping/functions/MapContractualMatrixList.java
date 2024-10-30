package fpml.mapping.functions;

import cdm.legaldocumentation.common.ContractualMatrix;
import cdm.legaldocumentation.common.ContractualMatrix.ContractualMatrixBuilder;
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


@ImplementedBy(MapContractualMatrixList.MapContractualMatrixListDefault.class)
public abstract class MapContractualMatrixList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMatrixTermWithScheme mapMatrixTermWithScheme;
	@Inject protected MapMatrixTypeWithScheme mapMatrixTypeWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return contractualMatrixList 
	*/
	public List<? extends ContractualMatrix> evaluate(DataDocument fpmlDataDocument) {
		List<ContractualMatrix.ContractualMatrixBuilder> contractualMatrixListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ContractualMatrix> contractualMatrixList;
		if (contractualMatrixListBuilder == null) {
			contractualMatrixList = null;
		} else {
			contractualMatrixList = contractualMatrixListBuilder.stream().map(ContractualMatrix::build).collect(Collectors.toList());
			objectValidator.validate(ContractualMatrix.class, contractualMatrixList);
		}
		
		return contractualMatrixList;
	}

	protected abstract List<ContractualMatrix.ContractualMatrixBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapContractualMatrixListDefault extends MapContractualMatrixList {
		@Override
		protected List<ContractualMatrix.ContractualMatrixBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ContractualMatrix.ContractualMatrixBuilder> contractualMatrixList = new ArrayList<>();
			return assignOutput(contractualMatrixList, fpmlDataDocument);
		}
		
		protected List<ContractualMatrix.ContractualMatrixBuilder> assignOutput(List<ContractualMatrix.ContractualMatrixBuilder> contractualMatrixList, DataDocument fpmlDataDocument) {
			contractualMatrixList.addAll(toBuilder(MapperC.<ContractualMatrix>of(MapperS.of(ContractualMatrix.builder()
				.setMatrixTypeValue(mapMatrixTypeWithScheme.evaluate(fpmlDataDocument))
				.setMatrixTermValue(mapMatrixTermWithScheme.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(contractualMatrixList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
