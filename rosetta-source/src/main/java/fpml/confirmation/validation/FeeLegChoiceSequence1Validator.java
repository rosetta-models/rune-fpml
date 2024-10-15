package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FeeLegChoiceSequence1;
import fpml.confirmation.PeriodicPayment;
import fpml.confirmation.SinglePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FeeLegChoiceSequence1Validator implements Validator<FeeLegChoiceSequence1> {

	private List<ComparisonResult> getComparisonResults(FeeLegChoiceSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("singlePayment", (List<? extends SinglePayment>) o.getSinglePayment() == null ? 0 : ((List<? extends SinglePayment>) o.getSinglePayment()).size(), 1, 0), 
				checkCardinality("periodicPayment", (PeriodicPayment) o.getPeriodicPayment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FeeLegChoiceSequence1> validate(RosettaPath path, FeeLegChoiceSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FeeLegChoiceSequence1", ValidationType.CARDINALITY, "FeeLegChoiceSequence1", path, "", error);
		}
		return success("FeeLegChoiceSequence1", ValidationType.CARDINALITY, "FeeLegChoiceSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeeLegChoiceSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FeeLegChoiceSequence1", ValidationType.CARDINALITY, "FeeLegChoiceSequence1", path, "", res.getError());
				}
				return success("FeeLegChoiceSequence1", ValidationType.CARDINALITY, "FeeLegChoiceSequence1", path, "");
			})
			.collect(toList());
	}

}
