package fpml.mapping.functions;

import cdm.product.common.settlement.LoanParticipation;
import cdm.product.common.settlement.LoanParticipation.LoanParticipationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapLoanParticipation.MapLoanParticipationDefault.class)
public abstract class MapLoanParticipation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return loanParticipation 
	*/
	public LoanParticipation evaluate(DataDocument fpmlDataDocument) {
		LoanParticipation.LoanParticipationBuilder loanParticipationBuilder = doEvaluate(fpmlDataDocument);
		
		final LoanParticipation loanParticipation;
		if (loanParticipationBuilder == null) {
			loanParticipation = null;
		} else {
			loanParticipation = loanParticipationBuilder.build();
			objectValidator.validate(LoanParticipation.class, loanParticipation);
		}
		
		return loanParticipation;
	}

	protected abstract LoanParticipation.LoanParticipationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapLoanParticipationDefault extends MapLoanParticipation {
		@Override
		protected LoanParticipation.LoanParticipationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			LoanParticipation.LoanParticipationBuilder loanParticipation = LoanParticipation.builder();
			return assignOutput(loanParticipation, fpmlDataDocument);
		}
		
		protected LoanParticipation.LoanParticipationBuilder assignOutput(LoanParticipation.LoanParticipationBuilder loanParticipation, DataDocument fpmlDataDocument) {
			loanParticipation = toBuilder(LoanParticipation.builder()
				.setApplicable(null)
				.setPartialCashSettlement(null)
				.setQualifyingParticipationSeller(null)
				.build());
			
			return Optional.ofNullable(loanParticipation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
