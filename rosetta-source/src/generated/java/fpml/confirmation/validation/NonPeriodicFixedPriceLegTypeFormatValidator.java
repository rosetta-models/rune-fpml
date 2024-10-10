package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NonPeriodicFixedPriceLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NonPeriodicFixedPriceLegTypeFormatValidator implements Validator<NonPeriodicFixedPriceLeg> {

	private List<ComparisonResult> getComparisonResults(NonPeriodicFixedPriceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NonPeriodicFixedPriceLeg> validate(RosettaPath path, NonPeriodicFixedPriceLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NonPeriodicFixedPriceLeg", ValidationType.TYPE_FORMAT, "NonPeriodicFixedPriceLeg", path, "", error);
		}
		return success("NonPeriodicFixedPriceLeg", ValidationType.TYPE_FORMAT, "NonPeriodicFixedPriceLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonPeriodicFixedPriceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonPeriodicFixedPriceLeg", ValidationType.TYPE_FORMAT, "NonPeriodicFixedPriceLeg", path, "", res.getError());
				}
				return success("NonPeriodicFixedPriceLeg", ValidationType.TYPE_FORMAT, "NonPeriodicFixedPriceLeg", path, "");
			})
			.collect(toList());
	}

}
