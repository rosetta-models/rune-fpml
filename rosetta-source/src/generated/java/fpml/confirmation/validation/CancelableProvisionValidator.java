package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CancelableProvision;
import fpml.confirmation.CancelableProvisionAdjustedDates;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseNotice;
import fpml.confirmation.SimplePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CancelableProvisionValidator implements Validator<CancelableProvision> {

	private List<ComparisonResult> getComparisonResults(CancelableProvision o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("exercise", (Exercise) o.getExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("exerciseNotice", (ExerciseNotice) o.getExerciseNotice() != null ? 1 : 0, 0, 1), 
				checkCardinality("followUpConfirmation", (Boolean) o.getFollowUpConfirmation() != null ? 1 : 0, 1, 1), 
				checkCardinality("cancelableProvisionAdjustedDates", (CancelableProvisionAdjustedDates) o.getCancelableProvisionAdjustedDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialFee", (SimplePayment) o.getInitialFee() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CancelableProvision> validate(RosettaPath path, CancelableProvision o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CancelableProvision", ValidationType.CARDINALITY, "CancelableProvision", path, "", error);
		}
		return success("CancelableProvision", ValidationType.CARDINALITY, "CancelableProvision", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CancelableProvision o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CancelableProvision", ValidationType.CARDINALITY, "CancelableProvision", path, "", res.getError());
				}
				return success("CancelableProvision", ValidationType.CARDINALITY, "CancelableProvision", path, "");
			})
			.collect(toList());
	}

}
