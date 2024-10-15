package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PhysicalSwapLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PhysicalSwapLegValidator implements Validator<PhysicalSwapLeg> {

	private List<ComparisonResult> getComparisonResults(PhysicalSwapLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PhysicalSwapLeg> validate(RosettaPath path, PhysicalSwapLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PhysicalSwapLeg", ValidationType.CARDINALITY, "PhysicalSwapLeg", path, "", error);
		}
		return success("PhysicalSwapLeg", ValidationType.CARDINALITY, "PhysicalSwapLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSwapLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PhysicalSwapLeg", ValidationType.CARDINALITY, "PhysicalSwapLeg", path, "", res.getError());
				}
				return success("PhysicalSwapLeg", ValidationType.CARDINALITY, "PhysicalSwapLeg", path, "");
			})
			.collect(toList());
	}

}
