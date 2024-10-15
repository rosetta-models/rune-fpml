package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Notional;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NotionalTypeFormatValidator implements Validator<Notional> {

	private List<ComparisonResult> getComparisonResults(Notional o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Notional> validate(RosettaPath path, Notional o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Notional", ValidationType.TYPE_FORMAT, "Notional", path, "", error);
		}
		return success("Notional", ValidationType.TYPE_FORMAT, "Notional", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Notional o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Notional", ValidationType.TYPE_FORMAT, "Notional", path, "", res.getError());
				}
				return success("Notional", ValidationType.TYPE_FORMAT, "Notional", path, "");
			})
			.collect(toList());
	}

}
