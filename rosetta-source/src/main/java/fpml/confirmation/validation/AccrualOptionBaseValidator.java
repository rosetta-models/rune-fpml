package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualOptionBase;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.Period;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccrualOptionBaseValidator implements Validator<AccrualOptionBase> {

	private List<ComparisonResult> getComparisonResults(AccrualOptionBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accrualOptionId", (AccrualTypeId) o.getAccrualOptionId() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentFrequency", (Period) o.getPaymentFrequency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AccrualOptionBase> validate(RosettaPath path, AccrualOptionBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccrualOptionBase", ValidationType.CARDINALITY, "AccrualOptionBase", path, "", error);
		}
		return success("AccrualOptionBase", ValidationType.CARDINALITY, "AccrualOptionBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccrualOptionBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccrualOptionBase", ValidationType.CARDINALITY, "AccrualOptionBase", path, "", res.getError());
				}
				return success("AccrualOptionBase", ValidationType.CARDINALITY, "AccrualOptionBase", path, "");
			})
			.collect(toList());
	}

}
