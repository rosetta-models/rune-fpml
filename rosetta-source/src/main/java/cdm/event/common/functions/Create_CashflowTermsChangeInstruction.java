package cdm.event.common.functions;

import cdm.event.common.TermsChangeInstruction;
import cdm.event.common.TermsChangeInstruction.TermsChangeInstructionBuilder;
import cdm.product.common.settlement.Cashflow;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CashflowTermsChangeInstruction.Create_CashflowTermsChangeInstructionDefault.class)
public abstract class Create_CashflowTermsChangeInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param product 
	* @param cashFlow 
	* @return termsChangeInstruction 
	*/
	public TermsChangeInstruction evaluate(NonTransferableProduct product, Cashflow cashFlow) {
		TermsChangeInstruction.TermsChangeInstructionBuilder termsChangeInstructionBuilder = doEvaluate(product, cashFlow);
		
		final TermsChangeInstruction termsChangeInstruction;
		if (termsChangeInstructionBuilder == null) {
			termsChangeInstruction = null;
		} else {
			termsChangeInstruction = termsChangeInstructionBuilder.build();
			objectValidator.validate(TermsChangeInstruction.class, termsChangeInstruction);
		}
		
		return termsChangeInstruction;
	}

	protected abstract TermsChangeInstruction.TermsChangeInstructionBuilder doEvaluate(NonTransferableProduct product, Cashflow cashFlow);

	public static class Create_CashflowTermsChangeInstructionDefault extends Create_CashflowTermsChangeInstruction {
		@Override
		protected TermsChangeInstruction.TermsChangeInstructionBuilder doEvaluate(NonTransferableProduct product, Cashflow cashFlow) {
			TermsChangeInstruction.TermsChangeInstructionBuilder termsChangeInstruction = TermsChangeInstruction.builder();
			return assignOutput(termsChangeInstruction, product, cashFlow);
		}
		
		protected TermsChangeInstruction.TermsChangeInstructionBuilder assignOutput(TermsChangeInstruction.TermsChangeInstructionBuilder termsChangeInstruction, NonTransferableProduct product, Cashflow cashFlow) {
			termsChangeInstruction
				.setProduct(product);
			
			termsChangeInstruction
				.getOrCreateProduct()
				.getOrCreateEconomicTerms()
				.getOrCreatePayout()
				.addCashflow((cashFlow == null ? Collections.<Cashflow>emptyList() : Collections.singletonList(cashFlow)));
			
			return Optional.ofNullable(termsChangeInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
