package fpml.confirmation.custom.functions;

import fpml.confirmation.*;
import fpml.confirmation.custom.AssetChoice;

public class ToAssetChoiceImpl extends ToAssetChoice {

    @Override
    protected AssetChoice.AssetChoiceBuilder doEvaluate(Asset asset) {
        AssetChoice.AssetChoiceBuilder builder = AssetChoice.builder();
        if (asset instanceof Commodity) {
            return builder.setCommodity(((Commodity) asset));
        } else if (asset instanceof Security) {
            return builder.setSecurity(((Security) asset));
        } else if (asset instanceof RateIndex) {
            return builder.setRateIndex(((RateIndex) asset));
        } else if (asset instanceof Loan) {
            return builder.setLoan(((Loan) asset));
        } else if (asset instanceof SimpleIRSwap) {
            return builder.setSimpleIRSwap(((SimpleIRSwap) asset));
        } else if (asset instanceof MutualFund) {
            return builder.setMutualFund(((MutualFund) asset));
        } else if (asset instanceof ConvertibleBond) {
            return builder.setConvertibleBond(((ConvertibleBond) asset));
        } else if (asset instanceof Deposit) {
            return builder.setDeposit(((Deposit) asset));
        } else if (asset instanceof Fx) {
            return builder.setFx(((Fx) asset));
        } else if (asset instanceof SimpleCreditDefaultSwap) {
            return builder.setSimpleCreditDefaultSwap(((SimpleCreditDefaultSwap) asset));
        } else if (asset instanceof Mortgage) {
            return builder.setMortgage(((Mortgage) asset));
        } else if (asset instanceof SimpleFra) {
            return builder.setSimpleFra(((SimpleFra) asset));
        } else if (asset instanceof OptionElement) {
            return builder.setOptionElement(((OptionElement) asset));
        } else if (asset instanceof Warrant) {
            return builder.setWarrant(((Warrant) asset));
        } else if (asset instanceof ExchangeTradedFund) {
            return builder.setExchangeTradedFund(((ExchangeTradedFund) asset));
        } else if (asset instanceof Index) {
            return builder.setIndex(((Index) asset));
        } else if (asset instanceof Equity) {
            return builder.setEquity(((Equity) asset));
        } else if (asset instanceof Future) {
            return builder.setFuture(((Future) asset));
        } else if (asset instanceof Cash) {
            return builder.setCash(((Cash) asset));
        } else if (asset instanceof Basket) {
            return builder.setBasket(((Basket) asset));
        } else if (asset instanceof Deal) {
            return builder.setDeal(((Deal) asset));
        } else if (asset instanceof TermLoan) {
            return builder.setTermLoan(((TermLoan) asset));
        } else if (asset instanceof DelayedDraw) {
            return builder.setDelayedDraw(((DelayedDraw) asset));
        } else if (asset instanceof Revolver) {
            return builder.setRevolver(((Revolver) asset));
        } else if (asset instanceof LetterOfCreditFacility) {
            return builder.setLetterOfCreditFacility(((LetterOfCreditFacility) asset));
        }
        return builder;
    }
}
