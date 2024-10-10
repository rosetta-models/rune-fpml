package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FixedRateOptionChange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FixedRateOptionChangeTypeFormatValidator implements Validator<FixedRateOptionChange> {

	private List<ComparisonResult> getComparisonResults(FixedRateOptionChange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<FixedRateOptionChange> validate(RosettaPath path, FixedRateOptionChange o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedRateOptionChange", ValidationType.TYPE_FORMAT, "FixedRateOptionChange", path, "", error);
		}
		return success("FixedRateOptionChange", ValidationType.TYPE_FORMAT, "FixedRateOptionChange", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedRateOptionChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedRateOptionChange", ValidationType.TYPE_FORMAT, "FixedRateOptionChange", path, "", res.getError());
				}
				return success("FixedRateOptionChange", ValidationType.TYPE_FORMAT, "FixedRateOptionChange", path, "");
			})
			.collect(toList());
	}

}
