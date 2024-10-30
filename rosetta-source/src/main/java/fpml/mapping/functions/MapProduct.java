package fpml.mapping.functions;

import cdm.product.template.Product;
import cdm.product.template.Product.ProductBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapProduct.MapProductDefault.class)
public abstract class MapProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNonTransferableProduct mapNonTransferableProduct;
	@Inject protected MapTransferableProduct mapTransferableProduct;

	/**
	* @param fpmlDataDocument 
	* @return product 
	*/
	public Product evaluate(DataDocument fpmlDataDocument) {
		Product.ProductBuilder productBuilder = doEvaluate(fpmlDataDocument);
		
		final Product product;
		if (productBuilder == null) {
			product = null;
		} else {
			product = productBuilder.build();
			objectValidator.validate(Product.class, product);
		}
		
		return product;
	}

	protected abstract Product.ProductBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapProductDefault extends MapProduct {
		@Override
		protected Product.ProductBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Product.ProductBuilder product = Product.builder();
			return assignOutput(product, fpmlDataDocument);
		}
		
		protected Product.ProductBuilder assignOutput(Product.ProductBuilder product, DataDocument fpmlDataDocument) {
			product = toBuilder(Product.builder()
				.setTransferableProduct(mapTransferableProduct.evaluate(fpmlDataDocument))
				.setNonTransferableProduct(mapNonTransferableProduct.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(product)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
