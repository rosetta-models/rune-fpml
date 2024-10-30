package fpml.mapping.functions;

import cdm.product.asset.ReferencePool;
import cdm.product.asset.ReferencePool.ReferencePoolBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReferencePool.MapReferencePoolDefault.class)
public abstract class MapReferencePool implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapReferencePoolItemList mapReferencePoolItemList;

	/**
	* @param fpmlDataDocument 
	* @return referencePool 
	*/
	public ReferencePool evaluate(DataDocument fpmlDataDocument) {
		ReferencePool.ReferencePoolBuilder referencePoolBuilder = doEvaluate(fpmlDataDocument);
		
		final ReferencePool referencePool;
		if (referencePoolBuilder == null) {
			referencePool = null;
		} else {
			referencePool = referencePoolBuilder.build();
			objectValidator.validate(ReferencePool.class, referencePool);
		}
		
		return referencePool;
	}

	protected abstract ReferencePool.ReferencePoolBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapReferencePoolDefault extends MapReferencePool {
		@Override
		protected ReferencePool.ReferencePoolBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ReferencePool.ReferencePoolBuilder referencePool = ReferencePool.builder();
			return assignOutput(referencePool, fpmlDataDocument);
		}
		
		protected ReferencePool.ReferencePoolBuilder assignOutput(ReferencePool.ReferencePoolBuilder referencePool, DataDocument fpmlDataDocument) {
			referencePool = toBuilder(ReferencePool.builder()
				.setReferencePoolItem(new ArrayList(mapReferencePoolItemList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(referencePool)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
