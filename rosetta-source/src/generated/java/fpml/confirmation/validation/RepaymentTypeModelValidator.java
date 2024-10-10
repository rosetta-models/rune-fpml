package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RepaymentTypeModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepaymentTypeModelValidator implements Validator<RepaymentTypeModel> {

	private List<ComparisonResult> getComparisonResults(RepaymentTypeModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("refusalAllowed", (Boolean) o.getRefusalAllowed() != null ? 1 : 0, 1, 1), 
				checkCardinality("borrowerMandatory", (Boolean) o.getBorrowerMandatory() != null ? 1 : 0, 0, 1), 
				checkCardinality("scheduledRepayment", (Boolean) o.getScheduledRepayment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RepaymentTypeModel> validate(RosettaPath path, RepaymentTypeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RepaymentTypeModel", ValidationType.CARDINALITY, "RepaymentTypeModel", path, "", error);
		}
		return success("RepaymentTypeModel", ValidationType.CARDINALITY, "RepaymentTypeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepaymentTypeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepaymentTypeModel", ValidationType.CARDINALITY, "RepaymentTypeModel", path, "", res.getError());
				}
				return success("RepaymentTypeModel", ValidationType.CARDINALITY, "RepaymentTypeModel", path, "");
			})
			.collect(toList());
	}

}
