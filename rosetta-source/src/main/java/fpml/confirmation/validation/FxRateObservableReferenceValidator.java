package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxRateObservableReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxRateObservableReferenceValidator implements Validator<FxRateObservableReference> {

	private List<ComparisonResult> getComparisonResults(FxRateObservableReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxRateObservableReference> validate(RosettaPath path, FxRateObservableReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxRateObservableReference", ValidationType.CARDINALITY, "FxRateObservableReference", path, "", error);
		}
		return success("FxRateObservableReference", ValidationType.CARDINALITY, "FxRateObservableReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxRateObservableReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxRateObservableReference", ValidationType.CARDINALITY, "FxRateObservableReference", path, "", res.getError());
				}
				return success("FxRateObservableReference", ValidationType.CARDINALITY, "FxRateObservableReference", path, "");
			})
			.collect(toList());
	}

}
