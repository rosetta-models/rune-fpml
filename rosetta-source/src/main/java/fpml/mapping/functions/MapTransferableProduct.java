package fpml.mapping.functions;

import cdm.product.template.TransferableProduct;
import cdm.product.template.TransferableProduct.TransferableProductBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTransferableProduct.MapTransferableProductDefault.class)
public abstract class MapTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCash mapCash;
	@Inject protected MapCommodity mapCommodity;
	@Inject protected MapDigitalAsset mapDigitalAsset;
	@Inject protected MapEconomicTerms mapEconomicTerms;
	@Inject protected MapInstrument mapInstrument;

	/**
	* @param fpmlDataDocument 
	* @return transferableProduct 
	*/
	public TransferableProduct evaluate(DataDocument fpmlDataDocument) {
		TransferableProduct.TransferableProductBuilder transferableProductBuilder = doEvaluate(fpmlDataDocument);
		
		final TransferableProduct transferableProduct;
		if (transferableProductBuilder == null) {
			transferableProduct = null;
		} else {
			transferableProduct = transferableProductBuilder.build();
			objectValidator.validate(TransferableProduct.class, transferableProduct);
		}
		
		return transferableProduct;
	}

	protected abstract TransferableProduct.TransferableProductBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTransferableProductDefault extends MapTransferableProduct {
		@Override
		protected TransferableProduct.TransferableProductBuilder doEvaluate(DataDocument fpmlDataDocument) {
			TransferableProduct.TransferableProductBuilder transferableProduct = TransferableProduct.builder();
			return assignOutput(transferableProduct, fpmlDataDocument);
		}
		
		protected TransferableProduct.TransferableProductBuilder assignOutput(TransferableProduct.TransferableProductBuilder transferableProduct, DataDocument fpmlDataDocument) {
			transferableProduct = toBuilder(TransferableProduct.builder()
				.setCash(mapCash.evaluate(fpmlDataDocument))
				.setCommodityValue(mapCommodity.evaluate(fpmlDataDocument))
				.setDigitalAsset(mapDigitalAsset.evaluate(fpmlDataDocument))
				.setInstrument(mapInstrument.evaluate(fpmlDataDocument))
				.setEconomicTerms(mapEconomicTerms.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(transferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
