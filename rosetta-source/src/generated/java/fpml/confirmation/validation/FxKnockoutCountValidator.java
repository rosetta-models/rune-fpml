package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxKnockoutCount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxKnockoutCountValidator implements Validator<FxKnockoutCount> {

	private List<ComparisonResult> getComparisonResults(FxKnockoutCount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("conditionalFixings", (Integer) o.getConditionalFixings() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementAtKnockout", (Boolean) o.getSettlementAtKnockout() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxKnockoutCount> validate(RosettaPath path, FxKnockoutCount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxKnockoutCount", ValidationType.CARDINALITY, "FxKnockoutCount", path, "", error);
		}
		return success("FxKnockoutCount", ValidationType.CARDINALITY, "FxKnockoutCount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxKnockoutCount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxKnockoutCount", ValidationType.CARDINALITY, "FxKnockoutCount", path, "", res.getError());
				}
				return success("FxKnockoutCount", ValidationType.CARDINALITY, "FxKnockoutCount", path, "");
			})
			.collect(toList());
	}

}
