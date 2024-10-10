package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PrincipalExchange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangeTypeFormatValidator implements Validator<PrincipalExchange> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchange o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PrincipalExchange> validate(RosettaPath path, PrincipalExchange o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PrincipalExchange", ValidationType.TYPE_FORMAT, "PrincipalExchange", path, "", error);
		}
		return success("PrincipalExchange", ValidationType.TYPE_FORMAT, "PrincipalExchange", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchange", ValidationType.TYPE_FORMAT, "PrincipalExchange", path, "", res.getError());
				}
				return success("PrincipalExchange", ValidationType.TYPE_FORMAT, "PrincipalExchange", path, "");
			})
			.collect(toList());
	}

}
