package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionExpiryBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExpiryBaseTypeFormatValidator implements Validator<OptionExpiryBase> {

	private List<ComparisonResult> getComparisonResults(OptionExpiryBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OptionExpiryBase> validate(RosettaPath path, OptionExpiryBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionExpiryBase", ValidationType.TYPE_FORMAT, "OptionExpiryBase", path, "", error);
		}
		return success("OptionExpiryBase", ValidationType.TYPE_FORMAT, "OptionExpiryBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExpiryBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExpiryBase", ValidationType.TYPE_FORMAT, "OptionExpiryBase", path, "", res.getError());
				}
				return success("OptionExpiryBase", ValidationType.TYPE_FORMAT, "OptionExpiryBase", path, "");
			})
			.collect(toList());
	}

}
