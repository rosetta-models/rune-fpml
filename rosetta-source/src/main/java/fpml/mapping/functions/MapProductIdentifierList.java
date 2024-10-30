package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.ProductIdentifier.ProductIdentifierBuilder;
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


@ImplementedBy(MapProductIdentifierList.MapProductIdentifierListDefault.class)
public abstract class MapProductIdentifierList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapIdentifierWithScheme mapIdentifierWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return productIdentifierList 
	*/
	public List<? extends ProductIdentifier> evaluate(DataDocument fpmlDataDocument) {
		List<ProductIdentifier.ProductIdentifierBuilder> productIdentifierListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ProductIdentifier> productIdentifierList;
		if (productIdentifierListBuilder == null) {
			productIdentifierList = null;
		} else {
			productIdentifierList = productIdentifierListBuilder.stream().map(ProductIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(ProductIdentifier.class, productIdentifierList);
		}
		
		return productIdentifierList;
	}

	protected abstract List<ProductIdentifier.ProductIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapProductIdentifierListDefault extends MapProductIdentifierList {
		@Override
		protected List<ProductIdentifier.ProductIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ProductIdentifier.ProductIdentifierBuilder> productIdentifierList = new ArrayList<>();
			return assignOutput(productIdentifierList, fpmlDataDocument);
		}
		
		protected List<ProductIdentifier.ProductIdentifierBuilder> assignOutput(List<ProductIdentifier.ProductIdentifierBuilder> productIdentifierList, DataDocument fpmlDataDocument) {
			productIdentifierList.addAll(toBuilder(MapperC.<ProductIdentifier>of(MapperS.of(ProductIdentifier.builder()
				.setIdentifierValue(mapIdentifierWithScheme.evaluate(fpmlDataDocument))
				.setSource(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(productIdentifierList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
