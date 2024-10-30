package fpml.mapping.functions;

import cdm.event.common.TransferState;
import cdm.event.common.TransferState.TransferStateBuilder;
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


@ImplementedBy(MapTransferStateList.MapTransferStateListDefault.class)
public abstract class MapTransferStateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapTransfer mapTransfer;

	/**
	* @param fpmlDataDocument 
	* @return transferStateList 
	*/
	public List<? extends TransferState> evaluate(DataDocument fpmlDataDocument) {
		List<TransferState.TransferStateBuilder> transferStateListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends TransferState> transferStateList;
		if (transferStateListBuilder == null) {
			transferStateList = null;
		} else {
			transferStateList = transferStateListBuilder.stream().map(TransferState::build).collect(Collectors.toList());
			objectValidator.validate(TransferState.class, transferStateList);
		}
		
		return transferStateList;
	}

	protected abstract List<TransferState.TransferStateBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTransferStateListDefault extends MapTransferStateList {
		@Override
		protected List<TransferState.TransferStateBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<TransferState.TransferStateBuilder> transferStateList = new ArrayList<>();
			return assignOutput(transferStateList, fpmlDataDocument);
		}
		
		protected List<TransferState.TransferStateBuilder> assignOutput(List<TransferState.TransferStateBuilder> transferStateList, DataDocument fpmlDataDocument) {
			transferStateList.addAll(toBuilder(MapperC.<TransferState>of(MapperS.of(TransferState.builder()
				.setTransfer(mapTransfer.evaluate(fpmlDataDocument))
				.setTransferStatus(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(transferStateList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
