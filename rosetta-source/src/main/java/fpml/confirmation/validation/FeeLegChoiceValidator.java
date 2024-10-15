package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FeeLegChoice;
import fpml.confirmation.FeeLegChoiceSequence0;
import fpml.confirmation.FeeLegChoiceSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FeeLegChoiceValidator implements Validator<FeeLegChoice> {

	private List<ComparisonResult> getComparisonResults(FeeLegChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("feeLegChoiceSequence0", (FeeLegChoiceSequence0) o.getFeeLegChoiceSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("feeLegChoiceSequence1", (FeeLegChoiceSequence1) o.getFeeLegChoiceSequence1() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FeeLegChoice> validate(RosettaPath path, FeeLegChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FeeLegChoice", ValidationType.CARDINALITY, "FeeLegChoice", path, "", error);
		}
		return success("FeeLegChoice", ValidationType.CARDINALITY, "FeeLegChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeeLegChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FeeLegChoice", ValidationType.CARDINALITY, "FeeLegChoice", path, "", res.getError());
				}
				return success("FeeLegChoice", ValidationType.CARDINALITY, "FeeLegChoice", path, "");
			})
			.collect(toList());
	}

}
