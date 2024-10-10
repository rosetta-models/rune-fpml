package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ValuationScenarioReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ValuationScenarioReferenceTypeFormatValidator implements Validator<ValuationScenarioReference> {

	private List<ComparisonResult> getComparisonResults(ValuationScenarioReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ValuationScenarioReference> validate(RosettaPath path, ValuationScenarioReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ValuationScenarioReference", ValidationType.TYPE_FORMAT, "ValuationScenarioReference", path, "", error);
		}
		return success("ValuationScenarioReference", ValidationType.TYPE_FORMAT, "ValuationScenarioReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationScenarioReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationScenarioReference", ValidationType.TYPE_FORMAT, "ValuationScenarioReference", path, "", res.getError());
				}
				return success("ValuationScenarioReference", ValidationType.TYPE_FORMAT, "ValuationScenarioReference", path, "");
			})
			.collect(toList());
	}

}
