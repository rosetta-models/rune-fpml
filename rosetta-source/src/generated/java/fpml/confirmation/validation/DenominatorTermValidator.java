package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DenominatorTerm;
import fpml.confirmation.WeightedPartialDerivative;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DenominatorTermValidator implements Validator<DenominatorTerm> {

	private List<ComparisonResult> getComparisonResults(DenominatorTerm o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("weightedPartial", (WeightedPartialDerivative) o.getWeightedPartial() != null ? 1 : 0, 1, 1), 
				checkCardinality("power", (Integer) o.getPower() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<DenominatorTerm> validate(RosettaPath path, DenominatorTerm o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DenominatorTerm", ValidationType.CARDINALITY, "DenominatorTerm", path, "", error);
		}
		return success("DenominatorTerm", ValidationType.CARDINALITY, "DenominatorTerm", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DenominatorTerm o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DenominatorTerm", ValidationType.CARDINALITY, "DenominatorTerm", path, "", res.getError());
				}
				return success("DenominatorTerm", ValidationType.CARDINALITY, "DenominatorTerm", path, "");
			})
			.collect(toList());
	}

}
