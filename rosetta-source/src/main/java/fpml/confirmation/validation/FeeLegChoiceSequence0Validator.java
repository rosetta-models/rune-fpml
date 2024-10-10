package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FeeLegChoiceSequence0;
import fpml.confirmation.InitialPayment;
import fpml.confirmation.PeriodicPayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FeeLegChoiceSequence0Validator implements Validator<FeeLegChoiceSequence0> {

	private List<ComparisonResult> getComparisonResults(FeeLegChoiceSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialPayment", (InitialPayment) o.getInitialPayment() != null ? 1 : 0, 1, 1), 
				checkCardinality("periodicPayment", (PeriodicPayment) o.getPeriodicPayment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FeeLegChoiceSequence0> validate(RosettaPath path, FeeLegChoiceSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FeeLegChoiceSequence0", ValidationType.CARDINALITY, "FeeLegChoiceSequence0", path, "", error);
		}
		return success("FeeLegChoiceSequence0", ValidationType.CARDINALITY, "FeeLegChoiceSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeeLegChoiceSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FeeLegChoiceSequence0", ValidationType.CARDINALITY, "FeeLegChoiceSequence0", path, "", res.getError());
				}
				return success("FeeLegChoiceSequence0", ValidationType.CARDINALITY, "FeeLegChoiceSequence0", path, "");
			})
			.collect(toList());
	}

}
