package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DefaultRateExpiry;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DefaultRateExpiryTypeFormatValidator implements Validator<DefaultRateExpiry> {

	private List<ComparisonResult> getComparisonResults(DefaultRateExpiry o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<DefaultRateExpiry> validate(RosettaPath path, DefaultRateExpiry o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DefaultRateExpiry", ValidationType.TYPE_FORMAT, "DefaultRateExpiry", path, "", error);
		}
		return success("DefaultRateExpiry", ValidationType.TYPE_FORMAT, "DefaultRateExpiry", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DefaultRateExpiry o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DefaultRateExpiry", ValidationType.TYPE_FORMAT, "DefaultRateExpiry", path, "", res.getError());
				}
				return success("DefaultRateExpiry", ValidationType.TYPE_FORMAT, "DefaultRateExpiry", path, "");
			})
			.collect(toList());
	}

}
