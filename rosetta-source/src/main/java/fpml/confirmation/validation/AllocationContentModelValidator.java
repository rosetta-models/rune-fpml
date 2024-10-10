package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AllocationContentModel;
import fpml.confirmation.Approvals;
import fpml.confirmation.Collateral;
import fpml.confirmation.Money;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AllocationContentModelValidator implements Validator<AllocationContentModel> {

	private List<ComparisonResult> getComparisonResults(AllocationContentModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateral", (Collateral) o.getCollateral() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditChargeAmount", (Money) o.getCreditChargeAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvals", (Approvals) o.getApprovals() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterConfirmationDate", (Date) o.getMasterConfirmationDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AllocationContentModel> validate(RosettaPath path, AllocationContentModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AllocationContentModel", ValidationType.CARDINALITY, "AllocationContentModel", path, "", error);
		}
		return success("AllocationContentModel", ValidationType.CARDINALITY, "AllocationContentModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AllocationContentModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AllocationContentModel", ValidationType.CARDINALITY, "AllocationContentModel", path, "", res.getError());
				}
				return success("AllocationContentModel", ValidationType.CARDINALITY, "AllocationContentModel", path, "");
			})
			.collect(toList());
	}

}
