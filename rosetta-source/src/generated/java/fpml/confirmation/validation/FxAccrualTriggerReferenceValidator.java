package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualTriggerReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualTriggerReferenceValidator implements Validator<FxAccrualTriggerReference> {

	private List<ComparisonResult> getComparisonResults(FxAccrualTriggerReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualTriggerReference> validate(RosettaPath path, FxAccrualTriggerReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualTriggerReference", ValidationType.CARDINALITY, "FxAccrualTriggerReference", path, "", error);
		}
		return success("FxAccrualTriggerReference", ValidationType.CARDINALITY, "FxAccrualTriggerReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualTriggerReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualTriggerReference", ValidationType.CARDINALITY, "FxAccrualTriggerReference", path, "", res.getError());
				}
				return success("FxAccrualTriggerReference", ValidationType.CARDINALITY, "FxAccrualTriggerReference", path, "");
			})
			.collect(toList());
	}

}
