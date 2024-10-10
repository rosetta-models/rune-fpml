package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ActualPrice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ActualPriceTypeFormatValidator implements Validator<ActualPrice> {

	private List<ComparisonResult> getComparisonResults(ActualPrice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ActualPrice> validate(RosettaPath path, ActualPrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ActualPrice", ValidationType.TYPE_FORMAT, "ActualPrice", path, "", error);
		}
		return success("ActualPrice", ValidationType.TYPE_FORMAT, "ActualPrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ActualPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ActualPrice", ValidationType.TYPE_FORMAT, "ActualPrice", path, "", res.getError());
				}
				return success("ActualPrice", ValidationType.TYPE_FORMAT, "ActualPrice", path, "");
			})
			.collect(toList());
	}

}
