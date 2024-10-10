package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PrincipalExchangeAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangeAmountTypeFormatValidator implements Validator<PrincipalExchangeAmount> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchangeAmount o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PrincipalExchangeAmount> validate(RosettaPath path, PrincipalExchangeAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PrincipalExchangeAmount", ValidationType.TYPE_FORMAT, "PrincipalExchangeAmount", path, "", error);
		}
		return success("PrincipalExchangeAmount", ValidationType.TYPE_FORMAT, "PrincipalExchangeAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchangeAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchangeAmount", ValidationType.TYPE_FORMAT, "PrincipalExchangeAmount", path, "", res.getError());
				}
				return success("PrincipalExchangeAmount", ValidationType.TYPE_FORMAT, "PrincipalExchangeAmount", path, "");
			})
			.collect(toList());
	}

}
