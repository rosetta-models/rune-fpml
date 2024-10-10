package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PrincipalExchanges;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangesTypeFormatValidator implements Validator<PrincipalExchanges> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchanges o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PrincipalExchanges> validate(RosettaPath path, PrincipalExchanges o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PrincipalExchanges", ValidationType.TYPE_FORMAT, "PrincipalExchanges", path, "", error);
		}
		return success("PrincipalExchanges", ValidationType.TYPE_FORMAT, "PrincipalExchanges", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchanges o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchanges", ValidationType.TYPE_FORMAT, "PrincipalExchanges", path, "", res.getError());
				}
				return success("PrincipalExchanges", ValidationType.TYPE_FORMAT, "PrincipalExchanges", path, "");
			})
			.collect(toList());
	}

}
