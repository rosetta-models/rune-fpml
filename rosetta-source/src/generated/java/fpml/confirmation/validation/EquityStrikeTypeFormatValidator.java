package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityStrike;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityStrikeTypeFormatValidator implements Validator<EquityStrike> {

	private List<ComparisonResult> getComparisonResults(EquityStrike o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EquityStrike> validate(RosettaPath path, EquityStrike o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityStrike", ValidationType.TYPE_FORMAT, "EquityStrike", path, "", error);
		}
		return success("EquityStrike", ValidationType.TYPE_FORMAT, "EquityStrike", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityStrike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityStrike", ValidationType.TYPE_FORMAT, "EquityStrike", path, "", res.getError());
				}
				return success("EquityStrike", ValidationType.TYPE_FORMAT, "EquityStrike", path, "");
			})
			.collect(toList());
	}

}
