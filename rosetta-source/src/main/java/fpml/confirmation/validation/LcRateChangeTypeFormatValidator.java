package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LcRateChange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LcRateChangeTypeFormatValidator implements Validator<LcRateChange> {

	private List<ComparisonResult> getComparisonResults(LcRateChange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<LcRateChange> validate(RosettaPath path, LcRateChange o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LcRateChange", ValidationType.TYPE_FORMAT, "LcRateChange", path, "", error);
		}
		return success("LcRateChange", ValidationType.TYPE_FORMAT, "LcRateChange", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LcRateChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LcRateChange", ValidationType.TYPE_FORMAT, "LcRateChange", path, "", res.getError());
				}
				return success("LcRateChange", ValidationType.TYPE_FORMAT, "LcRateChange", path, "");
			})
			.collect(toList());
	}

}
