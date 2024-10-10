package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DualCurrencyFeature;
import fpml.confirmation.TermDepositFeatures;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TermDepositFeaturesValidator implements Validator<TermDepositFeatures> {

	private List<ComparisonResult> getComparisonResults(TermDepositFeatures o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dualCurrency", (DualCurrencyFeature) o.getDualCurrency() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TermDepositFeatures> validate(RosettaPath path, TermDepositFeatures o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TermDepositFeatures", ValidationType.CARDINALITY, "TermDepositFeatures", path, "", error);
		}
		return success("TermDepositFeatures", ValidationType.CARDINALITY, "TermDepositFeatures", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermDepositFeatures o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TermDepositFeatures", ValidationType.CARDINALITY, "TermDepositFeatures", path, "", res.getError());
				}
				return success("TermDepositFeatures", ValidationType.CARDINALITY, "TermDepositFeatures", path, "");
			})
			.collect(toList());
	}

}
