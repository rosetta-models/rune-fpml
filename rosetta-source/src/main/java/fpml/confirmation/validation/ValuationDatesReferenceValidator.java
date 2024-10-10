package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ValuationDatesReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ValuationDatesReferenceValidator implements Validator<ValuationDatesReference> {

	private List<ComparisonResult> getComparisonResults(ValuationDatesReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ValuationDatesReference> validate(RosettaPath path, ValuationDatesReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ValuationDatesReference", ValidationType.CARDINALITY, "ValuationDatesReference", path, "", error);
		}
		return success("ValuationDatesReference", ValidationType.CARDINALITY, "ValuationDatesReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationDatesReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationDatesReference", ValidationType.CARDINALITY, "ValuationDatesReference", path, "", res.getError());
				}
				return success("ValuationDatesReference", ValidationType.CARDINALITY, "ValuationDatesReference", path, "");
			})
			.collect(toList());
	}

}
