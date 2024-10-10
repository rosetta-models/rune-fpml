package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FloatingStrikePrice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingStrikePriceTypeFormatValidator implements Validator<FloatingStrikePrice> {

	private List<ComparisonResult> getComparisonResults(FloatingStrikePrice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FloatingStrikePrice> validate(RosettaPath path, FloatingStrikePrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingStrikePrice", ValidationType.TYPE_FORMAT, "FloatingStrikePrice", path, "", error);
		}
		return success("FloatingStrikePrice", ValidationType.TYPE_FORMAT, "FloatingStrikePrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingStrikePrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingStrikePrice", ValidationType.TYPE_FORMAT, "FloatingStrikePrice", path, "", res.getError());
				}
				return success("FloatingStrikePrice", ValidationType.TYPE_FORMAT, "FloatingStrikePrice", path, "");
			})
			.collect(toList());
	}

}
