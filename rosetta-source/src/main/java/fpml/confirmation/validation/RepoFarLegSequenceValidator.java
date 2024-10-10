package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CollateralValuation;
import fpml.confirmation.DeliveryMethod;
import fpml.confirmation.RepoFarLegSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepoFarLegSequenceValidator implements Validator<RepoFarLegSequence> {

	private List<ComparisonResult> getComparisonResults(RepoFarLegSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryMethod", (DeliveryMethod) o.getDeliveryMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryDate", (AdjustableOrRelativeDate) o.getDeliveryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateral", (List<? extends CollateralValuation>) o.getCollateral() == null ? 0 : ((List<? extends CollateralValuation>) o.getCollateral()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<RepoFarLegSequence> validate(RosettaPath path, RepoFarLegSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RepoFarLegSequence", ValidationType.CARDINALITY, "RepoFarLegSequence", path, "", error);
		}
		return success("RepoFarLegSequence", ValidationType.CARDINALITY, "RepoFarLegSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoFarLegSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepoFarLegSequence", ValidationType.CARDINALITY, "RepoFarLegSequence", path, "", res.getError());
				}
				return success("RepoFarLegSequence", ValidationType.CARDINALITY, "RepoFarLegSequence", path, "");
			})
			.collect(toList());
	}

}
