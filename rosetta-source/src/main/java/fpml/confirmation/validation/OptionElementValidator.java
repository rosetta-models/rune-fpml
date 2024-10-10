package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.ExchangeIdentifierModel;
import fpml.confirmation.ExchangeTradedContractUnderlyer;
import fpml.confirmation.ExchangeTradedOptionSequence;
import fpml.confirmation.ExerciseStyleEnum;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.OptionElement;
import fpml.confirmation.ProductReference;
import fpml.confirmation.PutCallEnum;
import fpml.confirmation.SettlementTypeEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionElementValidator implements Validator<OptionElement> {

	private List<ComparisonResult> getComparisonResults(OptionElement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : ((List<? extends InstrumentId>) o.getInstrumentId()).size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeId", (ExchangeId) o.getExchangeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearanceSystem", (ClearanceSystem) o.getClearanceSystem() != null ? 1 : 0, 0, 1), 
				checkCardinality("definition", (ProductReference) o.getDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeIdentifierModel", (ExchangeIdentifierModel) o.getExchangeIdentifierModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("multiplier", (BigDecimal) o.getMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("contractReference", (String) o.getContractReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeTradedOptionSequence", (ExchangeTradedOptionSequence) o.getExchangeTradedOptionSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionType", (PutCallEnum) o.getOptionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseStyle", (ExerciseStyleEnum) o.getExerciseStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (ExchangeTradedContractUnderlyer) o.getUnderlyer() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionElement> validate(RosettaPath path, OptionElement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionElement", ValidationType.CARDINALITY, "OptionElement", path, "", error);
		}
		return success("OptionElement", ValidationType.CARDINALITY, "OptionElement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionElement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionElement", ValidationType.CARDINALITY, "OptionElement", path, "", res.getError());
				}
				return success("OptionElement", ValidationType.CARDINALITY, "OptionElement", path, "");
			})
			.collect(toList());
	}

}
