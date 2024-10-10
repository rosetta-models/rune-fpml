package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.UnderlyerLoanRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UnderlyerLoanRateTypeFormatValidator implements Validator<UnderlyerLoanRate> {

	private List<ComparisonResult> getComparisonResults(UnderlyerLoanRate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<UnderlyerLoanRate> validate(RosettaPath path, UnderlyerLoanRate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("UnderlyerLoanRate", ValidationType.TYPE_FORMAT, "UnderlyerLoanRate", path, "", error);
		}
		return success("UnderlyerLoanRate", ValidationType.TYPE_FORMAT, "UnderlyerLoanRate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnderlyerLoanRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnderlyerLoanRate", ValidationType.TYPE_FORMAT, "UnderlyerLoanRate", path, "", res.getError());
				}
				return success("UnderlyerLoanRate", ValidationType.TYPE_FORMAT, "UnderlyerLoanRate", path, "");
			})
			.collect(toList());
	}

}
