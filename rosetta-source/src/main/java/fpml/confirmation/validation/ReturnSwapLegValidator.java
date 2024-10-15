package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.ReturnSwapLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnSwapLegValidator implements Validator<ReturnSwapLeg> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReturnSwapLeg> validate(RosettaPath path, ReturnSwapLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnSwapLeg", ValidationType.CARDINALITY, "ReturnSwapLeg", path, "", error);
		}
		return success("ReturnSwapLeg", ValidationType.CARDINALITY, "ReturnSwapLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapLeg", ValidationType.CARDINALITY, "ReturnSwapLeg", path, "", res.getError());
				}
				return success("ReturnSwapLeg", ValidationType.CARDINALITY, "ReturnSwapLeg", path, "");
			})
			.collect(toList());
	}

}
