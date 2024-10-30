package cdm.margin.schedule.functions;

import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import cdm.product.template.Underlier.UnderlierBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(UnderlierForProduct.UnderlierForProductDefault.class)
public abstract class UnderlierForProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param product 
	* @return underlier 
	*/
	public Underlier evaluate(NonTransferableProduct product) {
		Underlier.UnderlierBuilder underlierBuilder = doEvaluate(product);
		
		final Underlier underlier;
		if (underlierBuilder == null) {
			underlier = null;
		} else {
			underlier = underlierBuilder.build();
			objectValidator.validate(Underlier.class, underlier);
		}
		
		return underlier;
	}

	protected abstract Underlier.UnderlierBuilder doEvaluate(NonTransferableProduct product);

	public static class UnderlierForProductDefault extends UnderlierForProduct {
		@Override
		protected Underlier.UnderlierBuilder doEvaluate(NonTransferableProduct product) {
			Underlier.UnderlierBuilder underlier = Underlier.builder();
			return assignOutput(underlier, product);
		}
		
		protected Underlier.UnderlierBuilder assignOutput(Underlier.UnderlierBuilder underlier, NonTransferableProduct product) {
			if (exists(MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>map("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout())).getOrDefault(false)) {
				underlier = toBuilder(MapperS.of(MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>map("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).get());
			} else if (exists(MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>map("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>mapC("getSettlementPayout", payout -> payout.getSettlementPayout())).getOrDefault(false)) {
				underlier = toBuilder(MapperS.of(MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>map("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>mapC("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).get());
			} else {
				underlier = null;
			}
			
			return Optional.ofNullable(underlier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
