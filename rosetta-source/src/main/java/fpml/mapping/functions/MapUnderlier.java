package fpml.mapping.functions;

import cdm.product.template.Underlier;
import cdm.product.template.Underlier.UnderlierBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapUnderlier.MapUnderlierDefault.class)
public abstract class MapUnderlier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapObservable mapObservable;
	@Inject protected MapProduct mapProduct;

	/**
	* @param fpmlDataDocument 
	* @return underlier 
	*/
	public Underlier evaluate(DataDocument fpmlDataDocument) {
		Underlier.UnderlierBuilder underlierBuilder = doEvaluate(fpmlDataDocument);
		
		final Underlier underlier;
		if (underlierBuilder == null) {
			underlier = null;
		} else {
			underlier = underlierBuilder.build();
			objectValidator.validate(Underlier.class, underlier);
		}
		
		return underlier;
	}

	protected abstract Underlier.UnderlierBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapUnderlierDefault extends MapUnderlier {
		@Override
		protected Underlier.UnderlierBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Underlier.UnderlierBuilder underlier = Underlier.builder();
			return assignOutput(underlier, fpmlDataDocument);
		}
		
		protected Underlier.UnderlierBuilder assignOutput(Underlier.UnderlierBuilder underlier, DataDocument fpmlDataDocument) {
			underlier = toBuilder(Underlier.builder()
				.setObservableValue(mapObservable.evaluate(fpmlDataDocument))
				.setProduct(mapProduct.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(underlier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
