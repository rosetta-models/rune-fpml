package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RecoveryRateModel;
import fpml.confirmation.TermCurve;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RecoveryRateModelValidator implements Validator<RecoveryRateModel> {

	private List<ComparisonResult> getComparisonResults(RecoveryRateModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("recoveryRate", (BigDecimal) o.getRecoveryRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("recoveryRateCurve", (TermCurve) o.getRecoveryRateCurve() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RecoveryRateModel> validate(RosettaPath path, RecoveryRateModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RecoveryRateModel", ValidationType.CARDINALITY, "RecoveryRateModel", path, "", error);
		}
		return success("RecoveryRateModel", ValidationType.CARDINALITY, "RecoveryRateModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RecoveryRateModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RecoveryRateModel", ValidationType.CARDINALITY, "RecoveryRateModel", path, "", res.getError());
				}
				return success("RecoveryRateModel", ValidationType.CARDINALITY, "RecoveryRateModel", path, "");
			})
			.collect(toList());
	}

}
