package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExchangeRestrictions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExchangeRestrictionsTypeFormatValidator implements Validator<ExchangeRestrictions> {

	private List<ComparisonResult> getComparisonResults(ExchangeRestrictions o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ExchangeRestrictions> validate(RosettaPath path, ExchangeRestrictions o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExchangeRestrictions", ValidationType.TYPE_FORMAT, "ExchangeRestrictions", path, "", error);
		}
		return success("ExchangeRestrictions", ValidationType.TYPE_FORMAT, "ExchangeRestrictions", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeRestrictions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeRestrictions", ValidationType.TYPE_FORMAT, "ExchangeRestrictions", path, "", res.getError());
				}
				return success("ExchangeRestrictions", ValidationType.TYPE_FORMAT, "ExchangeRestrictions", path, "");
			})
			.collect(toList());
	}

}
