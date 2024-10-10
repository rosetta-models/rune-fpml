package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FinancialSwapLeg;
import fpml.confirmation.PayerReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FinancialSwapLegValidator implements Validator<FinancialSwapLeg> {

	private List<ComparisonResult> getComparisonResults(FinancialSwapLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FinancialSwapLeg> validate(RosettaPath path, FinancialSwapLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FinancialSwapLeg", ValidationType.CARDINALITY, "FinancialSwapLeg", path, "", error);
		}
		return success("FinancialSwapLeg", ValidationType.CARDINALITY, "FinancialSwapLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinancialSwapLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FinancialSwapLeg", ValidationType.CARDINALITY, "FinancialSwapLeg", path, "", res.getError());
				}
				return success("FinancialSwapLeg", ValidationType.CARDINALITY, "FinancialSwapLeg", path, "");
			})
			.collect(toList());
	}

}
