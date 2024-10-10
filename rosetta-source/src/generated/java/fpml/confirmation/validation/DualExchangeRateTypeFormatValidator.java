package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DualExchangeRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DualExchangeRateTypeFormatValidator implements Validator<DualExchangeRate> {

	private List<ComparisonResult> getComparisonResults(DualExchangeRate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<DualExchangeRate> validate(RosettaPath path, DualExchangeRate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DualExchangeRate", ValidationType.TYPE_FORMAT, "DualExchangeRate", path, "", error);
		}
		return success("DualExchangeRate", ValidationType.TYPE_FORMAT, "DualExchangeRate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DualExchangeRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DualExchangeRate", ValidationType.TYPE_FORMAT, "DualExchangeRate", path, "", res.getError());
				}
				return success("DualExchangeRate", ValidationType.TYPE_FORMAT, "DualExchangeRate", path, "");
			})
			.collect(toList());
	}

}
