package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxFallbackReferencePrice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxFallbackReferencePriceTypeFormatValidator implements Validator<FxFallbackReferencePrice> {

	private List<ComparisonResult> getComparisonResults(FxFallbackReferencePrice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxFallbackReferencePrice> validate(RosettaPath path, FxFallbackReferencePrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxFallbackReferencePrice", ValidationType.TYPE_FORMAT, "FxFallbackReferencePrice", path, "", error);
		}
		return success("FxFallbackReferencePrice", ValidationType.TYPE_FORMAT, "FxFallbackReferencePrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFallbackReferencePrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFallbackReferencePrice", ValidationType.TYPE_FORMAT, "FxFallbackReferencePrice", path, "", res.getError());
				}
				return success("FxFallbackReferencePrice", ValidationType.TYPE_FORMAT, "FxFallbackReferencePrice", path, "");
			})
			.collect(toList());
	}

}
