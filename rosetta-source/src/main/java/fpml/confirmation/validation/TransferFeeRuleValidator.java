package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TransferFeeRule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TransferFeeRuleValidator implements Validator<TransferFeeRule> {

	private List<ComparisonResult> getComparisonResults(TransferFeeRule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("transferFeeRuleScheme", (String) o.getTransferFeeRuleScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TransferFeeRule> validate(RosettaPath path, TransferFeeRule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TransferFeeRule", ValidationType.CARDINALITY, "TransferFeeRule", path, "", error);
		}
		return success("TransferFeeRule", ValidationType.CARDINALITY, "TransferFeeRule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransferFeeRule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransferFeeRule", ValidationType.CARDINALITY, "TransferFeeRule", path, "", res.getError());
				}
				return success("TransferFeeRule", ValidationType.CARDINALITY, "TransferFeeRule", path, "");
			})
			.collect(toList());
	}

}
