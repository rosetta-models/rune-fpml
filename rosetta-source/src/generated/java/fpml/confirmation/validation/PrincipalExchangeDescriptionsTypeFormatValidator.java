package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PrincipalExchangeDescriptions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangeDescriptionsTypeFormatValidator implements Validator<PrincipalExchangeDescriptions> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchangeDescriptions o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PrincipalExchangeDescriptions> validate(RosettaPath path, PrincipalExchangeDescriptions o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PrincipalExchangeDescriptions", ValidationType.TYPE_FORMAT, "PrincipalExchangeDescriptions", path, "", error);
		}
		return success("PrincipalExchangeDescriptions", ValidationType.TYPE_FORMAT, "PrincipalExchangeDescriptions", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchangeDescriptions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchangeDescriptions", ValidationType.TYPE_FORMAT, "PrincipalExchangeDescriptions", path, "", res.getError());
				}
				return success("PrincipalExchangeDescriptions", ValidationType.TYPE_FORMAT, "PrincipalExchangeDescriptions", path, "");
			})
			.collect(toList());
	}

}
