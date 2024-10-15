package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityDerivativeLongFormBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityDerivativeLongFormBaseTypeFormatValidator implements Validator<EquityDerivativeLongFormBase> {

	private List<ComparisonResult> getComparisonResults(EquityDerivativeLongFormBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EquityDerivativeLongFormBase> validate(RosettaPath path, EquityDerivativeLongFormBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityDerivativeLongFormBase", ValidationType.TYPE_FORMAT, "EquityDerivativeLongFormBase", path, "", error);
		}
		return success("EquityDerivativeLongFormBase", ValidationType.TYPE_FORMAT, "EquityDerivativeLongFormBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityDerivativeLongFormBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityDerivativeLongFormBase", ValidationType.TYPE_FORMAT, "EquityDerivativeLongFormBase", path, "", res.getError());
				}
				return success("EquityDerivativeLongFormBase", ValidationType.TYPE_FORMAT, "EquityDerivativeLongFormBase", path, "");
			})
			.collect(toList());
	}

}
