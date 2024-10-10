package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.SettlementAmountOrCurrencyModel;
import fpml.confirmation.SettlementTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionSettlementModelValidator implements Validator<OptionSettlementModel> {

	private List<ComparisonResult> getComparisonResults(OptionSettlementModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (AdjustableOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementAmountOrCurrencyModel", (SettlementAmountOrCurrencyModel) o.getSettlementAmountOrCurrencyModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionSettlementModel> validate(RosettaPath path, OptionSettlementModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionSettlementModel", ValidationType.CARDINALITY, "OptionSettlementModel", path, "", error);
		}
		return success("OptionSettlementModel", ValidationType.CARDINALITY, "OptionSettlementModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionSettlementModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionSettlementModel", ValidationType.CARDINALITY, "OptionSettlementModel", path, "", res.getError());
				}
				return success("OptionSettlementModel", ValidationType.CARDINALITY, "OptionSettlementModel", path, "");
			})
			.collect(toList());
	}

}
