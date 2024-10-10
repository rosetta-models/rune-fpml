package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CollateralValuation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CollateralValuationTypeFormatValidator implements Validator<CollateralValuation> {

	private List<ComparisonResult> getComparisonResults(CollateralValuation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CollateralValuation> validate(RosettaPath path, CollateralValuation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CollateralValuation", ValidationType.TYPE_FORMAT, "CollateralValuation", path, "", error);
		}
		return success("CollateralValuation", ValidationType.TYPE_FORMAT, "CollateralValuation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralValuation", ValidationType.TYPE_FORMAT, "CollateralValuation", path, "", res.getError());
				}
				return success("CollateralValuation", ValidationType.TYPE_FORMAT, "CollateralValuation", path, "");
			})
			.collect(toList());
	}

}
