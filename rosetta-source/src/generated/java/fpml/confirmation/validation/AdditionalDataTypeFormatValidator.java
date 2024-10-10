package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdditionalData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AdditionalDataTypeFormatValidator implements Validator<AdditionalData> {

	private List<ComparisonResult> getComparisonResults(AdditionalData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("string", o.getString(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<AdditionalData> validate(RosettaPath path, AdditionalData o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AdditionalData", ValidationType.TYPE_FORMAT, "AdditionalData", path, "", error);
		}
		return success("AdditionalData", ValidationType.TYPE_FORMAT, "AdditionalData", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdditionalData", ValidationType.TYPE_FORMAT, "AdditionalData", path, "", res.getError());
				}
				return success("AdditionalData", ValidationType.TYPE_FORMAT, "AdditionalData", path, "");
			})
			.collect(toList());
	}

}
