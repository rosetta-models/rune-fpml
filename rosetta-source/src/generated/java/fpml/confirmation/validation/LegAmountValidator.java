package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates;
import fpml.confirmation.CurrencyAndDeterminationMethodModel;
import fpml.confirmation.Formula;
import fpml.confirmation.LegAmount;
import fpml.confirmation.ReferenceAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LegAmountValidator implements Validator<LegAmount> {

	private List<ComparisonResult> getComparisonResults(LegAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("currencyAndDeterminationMethodModel", (CurrencyAndDeterminationMethodModel) o.getCurrencyAndDeterminationMethodModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceAmount", (ReferenceAmount) o.getReferenceAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("formula", (Formula) o.getFormula() != null ? 1 : 0, 0, 1), 
				checkCardinality("encodedDescription", (String) o.getEncodedDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationDates", (AdjustableRelativeOrPeriodicDates) o.getCalculationDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LegAmount> validate(RosettaPath path, LegAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LegAmount", ValidationType.CARDINALITY, "LegAmount", path, "", error);
		}
		return success("LegAmount", ValidationType.CARDINALITY, "LegAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegAmount", ValidationType.CARDINALITY, "LegAmount", path, "", res.getError());
				}
				return success("LegAmount", ValidationType.CARDINALITY, "LegAmount", path, "");
			})
			.collect(toList());
	}

}
