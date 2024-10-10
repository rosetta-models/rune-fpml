package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DiscountRateModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DiscountRateModelTypeFormatValidator implements Validator<DiscountRateModel> {

	private List<ComparisonResult> getComparisonResults(DiscountRateModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<DiscountRateModel> validate(RosettaPath path, DiscountRateModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DiscountRateModel", ValidationType.TYPE_FORMAT, "DiscountRateModel", path, "", error);
		}
		return success("DiscountRateModel", ValidationType.TYPE_FORMAT, "DiscountRateModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DiscountRateModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DiscountRateModel", ValidationType.TYPE_FORMAT, "DiscountRateModel", path, "", res.getError());
				}
				return success("DiscountRateModel", ValidationType.TYPE_FORMAT, "DiscountRateModel", path, "");
			})
			.collect(toList());
	}

}
