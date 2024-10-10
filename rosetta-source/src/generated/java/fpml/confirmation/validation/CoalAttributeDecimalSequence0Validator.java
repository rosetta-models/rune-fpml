package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalAttributeDecimalSequence0;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalAttributeDecimalSequence0Validator implements Validator<CoalAttributeDecimalSequence0> {

	private List<ComparisonResult> getComparisonResults(CoalAttributeDecimalSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("standardContent", (BigDecimal) o.getStandardContent() != null ? 1 : 0, 1, 1), 
				checkCardinality("rejectionLimit", (BigDecimal) o.getRejectionLimit() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CoalAttributeDecimalSequence0> validate(RosettaPath path, CoalAttributeDecimalSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalAttributeDecimalSequence0", ValidationType.CARDINALITY, "CoalAttributeDecimalSequence0", path, "", error);
		}
		return success("CoalAttributeDecimalSequence0", ValidationType.CARDINALITY, "CoalAttributeDecimalSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalAttributeDecimalSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalAttributeDecimalSequence0", ValidationType.CARDINALITY, "CoalAttributeDecimalSequence0", path, "", res.getError());
				}
				return success("CoalAttributeDecimalSequence0", ValidationType.CARDINALITY, "CoalAttributeDecimalSequence0", path, "");
			})
			.collect(toList());
	}

}
