package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FixedRecoveryModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FixedRecoveryModelTypeFormatValidator implements Validator<FixedRecoveryModel> {

	private List<ComparisonResult> getComparisonResults(FixedRecoveryModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("recoveryFactor", o.getRecoveryFactor(), empty(), empty(), of(new BigDecimal("0")), of(new BigDecimal("1")))
			);
	}

	@Override
	public ValidationResult<FixedRecoveryModel> validate(RosettaPath path, FixedRecoveryModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedRecoveryModel", ValidationType.TYPE_FORMAT, "FixedRecoveryModel", path, "", error);
		}
		return success("FixedRecoveryModel", ValidationType.TYPE_FORMAT, "FixedRecoveryModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedRecoveryModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedRecoveryModel", ValidationType.TYPE_FORMAT, "FixedRecoveryModel", path, "", res.getError());
				}
				return success("FixedRecoveryModel", ValidationType.TYPE_FORMAT, "FixedRecoveryModel", path, "");
			})
			.collect(toList());
	}

}
