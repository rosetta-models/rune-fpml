package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.StrikePriceUnderlyingReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StrikePriceUnderlyingReferenceTypeFormatValidator implements Validator<StrikePriceUnderlyingReference> {

	private List<ComparisonResult> getComparisonResults(StrikePriceUnderlyingReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<StrikePriceUnderlyingReference> validate(RosettaPath path, StrikePriceUnderlyingReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StrikePriceUnderlyingReference", ValidationType.TYPE_FORMAT, "StrikePriceUnderlyingReference", path, "", error);
		}
		return success("StrikePriceUnderlyingReference", ValidationType.TYPE_FORMAT, "StrikePriceUnderlyingReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StrikePriceUnderlyingReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StrikePriceUnderlyingReference", ValidationType.TYPE_FORMAT, "StrikePriceUnderlyingReference", path, "", res.getError());
				}
				return success("StrikePriceUnderlyingReference", ValidationType.TYPE_FORMAT, "StrikePriceUnderlyingReference", path, "");
			})
			.collect(toList());
	}

}
