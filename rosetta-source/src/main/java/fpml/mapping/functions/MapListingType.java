package fpml.mapping.functions;

import cdm.product.collateral.ListingType;
import cdm.product.collateral.ListingType.ListingTypeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapListingType.MapListingTypeDefault.class)
public abstract class MapListingType implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapExchangeWithScheme mapExchangeWithScheme;
	@Inject protected MapIndex mapIndex;
	@Inject protected MapSectorWithScheme mapSectorWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return listingType 
	*/
	public ListingType evaluate(DataDocument fpmlDataDocument) {
		ListingType.ListingTypeBuilder listingTypeBuilder = doEvaluate(fpmlDataDocument);
		
		final ListingType listingType;
		if (listingTypeBuilder == null) {
			listingType = null;
		} else {
			listingType = listingTypeBuilder.build();
			objectValidator.validate(ListingType.class, listingType);
		}
		
		return listingType;
	}

	protected abstract ListingType.ListingTypeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapListingTypeDefault extends MapListingType {
		@Override
		protected ListingType.ListingTypeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ListingType.ListingTypeBuilder listingType = ListingType.builder();
			return assignOutput(listingType, fpmlDataDocument);
		}
		
		protected ListingType.ListingTypeBuilder assignOutput(ListingType.ListingTypeBuilder listingType, DataDocument fpmlDataDocument) {
			listingType = toBuilder(ListingType.builder()
				.setExchangeValue(mapExchangeWithScheme.evaluate(fpmlDataDocument))
				.setSectorValue(mapSectorWithScheme.evaluate(fpmlDataDocument))
				.setIndex(mapIndex.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(listingType)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
