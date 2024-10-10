package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxPerformanceFloatingLeg;
import fpml.confirmation.PayerModel;
import fpml.confirmation.ReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxPerformanceFloatingLegValidator implements Validator<FxPerformanceFloatingLeg> {

	private List<ComparisonResult> getComparisonResults(FxPerformanceFloatingLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payerModel", (PayerModel) o.getPayerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("receiverModel", (ReceiverModel) o.getReceiverModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxPerformanceFloatingLeg> validate(RosettaPath path, FxPerformanceFloatingLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxPerformanceFloatingLeg", ValidationType.CARDINALITY, "FxPerformanceFloatingLeg", path, "", error);
		}
		return success("FxPerformanceFloatingLeg", ValidationType.CARDINALITY, "FxPerformanceFloatingLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPerformanceFloatingLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxPerformanceFloatingLeg", ValidationType.CARDINALITY, "FxPerformanceFloatingLeg", path, "", res.getError());
				}
				return success("FxPerformanceFloatingLeg", ValidationType.CARDINALITY, "FxPerformanceFloatingLeg", path, "");
			})
			.collect(toList());
	}

}
