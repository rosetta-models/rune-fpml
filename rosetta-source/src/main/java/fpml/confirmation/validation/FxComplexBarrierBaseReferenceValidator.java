package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxComplexBarrierBaseReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxComplexBarrierBaseReferenceValidator implements Validator<FxComplexBarrierBaseReference> {

	private List<ComparisonResult> getComparisonResults(FxComplexBarrierBaseReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxComplexBarrierBaseReference> validate(RosettaPath path, FxComplexBarrierBaseReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxComplexBarrierBaseReference", ValidationType.CARDINALITY, "FxComplexBarrierBaseReference", path, "", error);
		}
		return success("FxComplexBarrierBaseReference", ValidationType.CARDINALITY, "FxComplexBarrierBaseReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxComplexBarrierBaseReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxComplexBarrierBaseReference", ValidationType.CARDINALITY, "FxComplexBarrierBaseReference", path, "", res.getError());
				}
				return success("FxComplexBarrierBaseReference", ValidationType.CARDINALITY, "FxComplexBarrierBaseReference", path, "");
			})
			.collect(toList());
	}

}
