package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FallbackReferencePriceType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FallbackReferencePriceTypeTypeFormatValidator implements Validator<FallbackReferencePriceType> {

	private List<ComparisonResult> getComparisonResults(FallbackReferencePriceType o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FallbackReferencePriceType> validate(RosettaPath path, FallbackReferencePriceType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FallbackReferencePriceType", ValidationType.TYPE_FORMAT, "FallbackReferencePriceType", path, "", error);
		}
		return success("FallbackReferencePriceType", ValidationType.TYPE_FORMAT, "FallbackReferencePriceType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FallbackReferencePriceType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FallbackReferencePriceType", ValidationType.TYPE_FORMAT, "FallbackReferencePriceType", path, "", res.getError());
				}
				return success("FallbackReferencePriceType", ValidationType.TYPE_FORMAT, "FallbackReferencePriceType", path, "");
			})
			.collect(toList());
	}

}
