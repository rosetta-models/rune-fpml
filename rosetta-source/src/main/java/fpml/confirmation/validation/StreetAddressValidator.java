package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.StreetAddress;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StreetAddressValidator implements Validator<StreetAddress> {

	private List<ComparisonResult> getComparisonResults(StreetAddress o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("streetLine", (List<String>) o.getStreetLine() == null ? 0 : ((List<String>) o.getStreetLine()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<StreetAddress> validate(RosettaPath path, StreetAddress o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StreetAddress", ValidationType.CARDINALITY, "StreetAddress", path, "", error);
		}
		return success("StreetAddress", ValidationType.CARDINALITY, "StreetAddress", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StreetAddress o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StreetAddress", ValidationType.CARDINALITY, "StreetAddress", path, "", res.getError());
				}
				return success("StreetAddress", ValidationType.CARDINALITY, "StreetAddress", path, "");
			})
			.collect(toList());
	}

}
