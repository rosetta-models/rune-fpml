package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DealRulesModel;
import fpml.confirmation.TransferFeeDefinition;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DealRulesModelValidator implements Validator<DealRulesModel> {

	private List<ComparisonResult> getComparisonResults(DealRulesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("transferFee", (TransferFeeDefinition) o.getTransferFee() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DealRulesModel> validate(RosettaPath path, DealRulesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DealRulesModel", ValidationType.CARDINALITY, "DealRulesModel", path, "", error);
		}
		return success("DealRulesModel", ValidationType.CARDINALITY, "DealRulesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealRulesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DealRulesModel", ValidationType.CARDINALITY, "DealRulesModel", path, "", res.getError());
				}
				return success("DealRulesModel", ValidationType.CARDINALITY, "DealRulesModel", path, "");
			})
			.collect(toList());
	}

}
