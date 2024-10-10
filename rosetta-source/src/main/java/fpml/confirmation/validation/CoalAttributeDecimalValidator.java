package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalAttributeDecimal;
import fpml.confirmation.CoalAttributeDecimalSequence0;
import fpml.confirmation.CoalAttributeDecimalSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalAttributeDecimalValidator implements Validator<CoalAttributeDecimal> {

	private List<ComparisonResult> getComparisonResults(CoalAttributeDecimal o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("coalAttributeDecimalSequence0", (CoalAttributeDecimalSequence0) o.getCoalAttributeDecimalSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("coalAttributeDecimalSequence1", (CoalAttributeDecimalSequence1) o.getCoalAttributeDecimalSequence1() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CoalAttributeDecimal> validate(RosettaPath path, CoalAttributeDecimal o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalAttributeDecimal", ValidationType.CARDINALITY, "CoalAttributeDecimal", path, "", error);
		}
		return success("CoalAttributeDecimal", ValidationType.CARDINALITY, "CoalAttributeDecimal", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalAttributeDecimal o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalAttributeDecimal", ValidationType.CARDINALITY, "CoalAttributeDecimal", path, "", res.getError());
				}
				return success("CoalAttributeDecimal", ValidationType.CARDINALITY, "CoalAttributeDecimal", path, "");
			})
			.collect(toList());
	}

}
