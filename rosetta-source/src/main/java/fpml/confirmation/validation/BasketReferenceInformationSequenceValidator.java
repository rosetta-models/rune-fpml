package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BasketReferenceInformationSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BasketReferenceInformationSequenceValidator implements Validator<BasketReferenceInformationSequence> {

	private List<ComparisonResult> getComparisonResults(BasketReferenceInformationSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("nthToDefault", (Integer) o.getNthToDefault() != null ? 1 : 0, 1, 1), 
				checkCardinality("mthToDefault", (Integer) o.getMthToDefault() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<BasketReferenceInformationSequence> validate(RosettaPath path, BasketReferenceInformationSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BasketReferenceInformationSequence", ValidationType.CARDINALITY, "BasketReferenceInformationSequence", path, "", error);
		}
		return success("BasketReferenceInformationSequence", ValidationType.CARDINALITY, "BasketReferenceInformationSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketReferenceInformationSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasketReferenceInformationSequence", ValidationType.CARDINALITY, "BasketReferenceInformationSequence", path, "", res.getError());
				}
				return success("BasketReferenceInformationSequence", ValidationType.CARDINALITY, "BasketReferenceInformationSequence", path, "");
			})
			.collect(toList());
	}

}
