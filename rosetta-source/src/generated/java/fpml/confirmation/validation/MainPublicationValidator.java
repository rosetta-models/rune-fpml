package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MainPublication;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MainPublicationValidator implements Validator<MainPublication> {

	private List<ComparisonResult> getComparisonResults(MainPublication o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("mainPublicationScheme", (String) o.getMainPublicationScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MainPublication> validate(RosettaPath path, MainPublication o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MainPublication", ValidationType.CARDINALITY, "MainPublication", path, "", error);
		}
		return success("MainPublication", ValidationType.CARDINALITY, "MainPublication", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MainPublication o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MainPublication", ValidationType.CARDINALITY, "MainPublication", path, "", res.getError());
				}
				return success("MainPublication", ValidationType.CARDINALITY, "MainPublication", path, "");
			})
			.collect(toList());
	}

}
