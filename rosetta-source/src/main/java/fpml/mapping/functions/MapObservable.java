package fpml.mapping.functions;

import cdm.observable.asset.Observable;
import cdm.observable.asset.Observable.ObservableBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapObservable.MapObservableDefault.class)
public abstract class MapObservable implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAsset mapAsset;
	@Inject protected MapBasket mapBasket;
	@Inject protected MapIndex mapIndex;

	/**
	* @param fpmlDataDocument 
	* @return observable 
	*/
	public Observable evaluate(DataDocument fpmlDataDocument) {
		Observable.ObservableBuilder observableBuilder = doEvaluate(fpmlDataDocument);
		
		final Observable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(Observable.class, observable);
		}
		
		return observable;
	}

	protected abstract Observable.ObservableBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapObservableDefault extends MapObservable {
		@Override
		protected Observable.ObservableBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Observable.ObservableBuilder observable = Observable.builder();
			return assignOutput(observable, fpmlDataDocument);
		}
		
		protected Observable.ObservableBuilder assignOutput(Observable.ObservableBuilder observable, DataDocument fpmlDataDocument) {
			observable = toBuilder(Observable.builder()
				.setAsset(mapAsset.evaluate(fpmlDataDocument))
				.setBasket(mapBasket.evaluate(fpmlDataDocument))
				.setIndex(mapIndex.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
