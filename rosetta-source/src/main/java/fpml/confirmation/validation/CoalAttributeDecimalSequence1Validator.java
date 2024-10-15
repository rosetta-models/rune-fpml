package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalAttributeDecimalSequence1;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalAttributeDecimalSequence1Validator implements Validator<CoalAttributeDecimalSequence1> {

	private List<ComparisonResult> getComparisonResults(CoalAttributeDecimalSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rejectionLimit", (BigDecimal) o.getRejectionLimit() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CoalAttributeDecimalSequence1> validate(RosettaPath path, CoalAttributeDecimalSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalAttributeDecimalSequence1", ValidationType.CARDINALITY, "CoalAttributeDecimalSequence1", path, "", error);
		}
		return success("CoalAttributeDecimalSequence1", ValidationType.CARDINALITY, "CoalAttributeDecimalSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalAttributeDecimalSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalAttributeDecimalSequence1", ValidationType.CARDINALITY, "CoalAttributeDecimalSequence1", path, "", res.getError());
				}
				return success("CoalAttributeDecimalSequence1", ValidationType.CARDINALITY, "CoalAttributeDecimalSequence1", path, "");
			})
			.collect(toList());
	}

}
