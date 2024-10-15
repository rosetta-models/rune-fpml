package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BasketIdentifierModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BasketIdentifierModelTypeFormatValidator implements Validator<BasketIdentifierModel> {

	private List<ComparisonResult> getComparisonResults(BasketIdentifierModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<BasketIdentifierModel> validate(RosettaPath path, BasketIdentifierModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BasketIdentifierModel", ValidationType.TYPE_FORMAT, "BasketIdentifierModel", path, "", error);
		}
		return success("BasketIdentifierModel", ValidationType.TYPE_FORMAT, "BasketIdentifierModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketIdentifierModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasketIdentifierModel", ValidationType.TYPE_FORMAT, "BasketIdentifierModel", path, "", res.getError());
				}
				return success("BasketIdentifierModel", ValidationType.TYPE_FORMAT, "BasketIdentifierModel", path, "");
			})
			.collect(toList());
	}

}
