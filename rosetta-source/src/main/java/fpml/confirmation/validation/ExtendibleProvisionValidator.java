package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseNotice;
import fpml.confirmation.ExtendibleProvision;
import fpml.confirmation.ExtendibleProvisionAdjustedDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExtendibleProvisionValidator implements Validator<ExtendibleProvision> {

	private List<ComparisonResult> getComparisonResults(ExtendibleProvision o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("exercise", (Exercise) o.getExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("exerciseNotice", (ExerciseNotice) o.getExerciseNotice() != null ? 1 : 0, 0, 1), 
				checkCardinality("followUpConfirmation", (Boolean) o.getFollowUpConfirmation() != null ? 1 : 0, 1, 1), 
				checkCardinality("extendibleProvisionAdjustedDates", (ExtendibleProvisionAdjustedDates) o.getExtendibleProvisionAdjustedDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ExtendibleProvision> validate(RosettaPath path, ExtendibleProvision o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExtendibleProvision", ValidationType.CARDINALITY, "ExtendibleProvision", path, "", error);
		}
		return success("ExtendibleProvision", ValidationType.CARDINALITY, "ExtendibleProvision", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExtendibleProvision o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExtendibleProvision", ValidationType.CARDINALITY, "ExtendibleProvision", path, "", res.getError());
				}
				return success("ExtendibleProvision", ValidationType.CARDINALITY, "ExtendibleProvision", path, "");
			})
			.collect(toList());
	}

}
