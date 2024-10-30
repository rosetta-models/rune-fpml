package fpml.mapping.functions;

import cdm.product.asset.AdditionalFixedPayments;
import cdm.product.asset.AdditionalFixedPayments.AdditionalFixedPaymentsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdditionalFixedPayments.MapAdditionalFixedPaymentsDefault.class)
public abstract class MapAdditionalFixedPayments implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return additionalFixedPayments 
	*/
	public AdditionalFixedPayments evaluate(DataDocument fpmlDataDocument) {
		AdditionalFixedPayments.AdditionalFixedPaymentsBuilder additionalFixedPaymentsBuilder = doEvaluate(fpmlDataDocument);
		
		final AdditionalFixedPayments additionalFixedPayments;
		if (additionalFixedPaymentsBuilder == null) {
			additionalFixedPayments = null;
		} else {
			additionalFixedPayments = additionalFixedPaymentsBuilder.build();
			objectValidator.validate(AdditionalFixedPayments.class, additionalFixedPayments);
		}
		
		return additionalFixedPayments;
	}

	protected abstract AdditionalFixedPayments.AdditionalFixedPaymentsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAdditionalFixedPaymentsDefault extends MapAdditionalFixedPayments {
		@Override
		protected AdditionalFixedPayments.AdditionalFixedPaymentsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AdditionalFixedPayments.AdditionalFixedPaymentsBuilder additionalFixedPayments = AdditionalFixedPayments.builder();
			return assignOutput(additionalFixedPayments, fpmlDataDocument);
		}
		
		protected AdditionalFixedPayments.AdditionalFixedPaymentsBuilder assignOutput(AdditionalFixedPayments.AdditionalFixedPaymentsBuilder additionalFixedPayments, DataDocument fpmlDataDocument) {
			additionalFixedPayments = toBuilder(AdditionalFixedPayments.builder()
				.setInterestShortfallReimbursement(null)
				.setPrincipalShortfallReimbursement(null)
				.setWritedownReimbursement(null)
				.build());
			
			return Optional.ofNullable(additionalFixedPayments)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
