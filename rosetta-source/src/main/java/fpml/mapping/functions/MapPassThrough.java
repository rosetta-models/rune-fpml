package fpml.mapping.functions;

import cdm.product.template.PassThrough;
import cdm.product.template.PassThrough.PassThroughBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPassThrough.MapPassThroughDefault.class)
public abstract class MapPassThrough implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPassThroughItemList mapPassThroughItemList;

	/**
	* @param fpmlDataDocument 
	* @return passThrough 
	*/
	public PassThrough evaluate(DataDocument fpmlDataDocument) {
		PassThrough.PassThroughBuilder passThroughBuilder = doEvaluate(fpmlDataDocument);
		
		final PassThrough passThrough;
		if (passThroughBuilder == null) {
			passThrough = null;
		} else {
			passThrough = passThroughBuilder.build();
			objectValidator.validate(PassThrough.class, passThrough);
		}
		
		return passThrough;
	}

	protected abstract PassThrough.PassThroughBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPassThroughDefault extends MapPassThrough {
		@Override
		protected PassThrough.PassThroughBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PassThrough.PassThroughBuilder passThrough = PassThrough.builder();
			return assignOutput(passThrough, fpmlDataDocument);
		}
		
		protected PassThrough.PassThroughBuilder assignOutput(PassThrough.PassThroughBuilder passThrough, DataDocument fpmlDataDocument) {
			passThrough = toBuilder(PassThrough.builder()
				.setPassThroughItem(new ArrayList(mapPassThroughItemList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(passThrough)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
