package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityDerivativeBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityDerivativeBaseTypeFormatValidator implements Validator<EquityDerivativeBase> {

	private List<ComparisonResult> getComparisonResults(EquityDerivativeBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EquityDerivativeBase> validate(RosettaPath path, EquityDerivativeBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityDerivativeBase", ValidationType.TYPE_FORMAT, "EquityDerivativeBase", path, "", error);
		}
		return success("EquityDerivativeBase", ValidationType.TYPE_FORMAT, "EquityDerivativeBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityDerivativeBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityDerivativeBase", ValidationType.TYPE_FORMAT, "EquityDerivativeBase", path, "", res.getError());
				}
				return success("EquityDerivativeBase", ValidationType.TYPE_FORMAT, "EquityDerivativeBase", path, "");
			})
			.collect(toList());
	}

}
