package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FxRate;
import fpml.confirmation.Money;
import fpml.confirmation.RepoNearLeg;
import fpml.confirmation.RepoNearLegSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepoNearLegValidator implements Validator<RepoNearLeg> {

	private List<ComparisonResult> getComparisonResults(RepoNearLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDate", (AdjustableOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementAmount", (Money) o.getSettlementAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxRate", (FxRate) o.getFxRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("repoNearLegSequence", (RepoNearLegSequence) o.getRepoNearLegSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RepoNearLeg> validate(RosettaPath path, RepoNearLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RepoNearLeg", ValidationType.CARDINALITY, "RepoNearLeg", path, "", error);
		}
		return success("RepoNearLeg", ValidationType.CARDINALITY, "RepoNearLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoNearLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepoNearLeg", ValidationType.CARDINALITY, "RepoNearLeg", path, "", res.getError());
				}
				return success("RepoNearLeg", ValidationType.CARDINALITY, "RepoNearLeg", path, "");
			})
			.collect(toList());
	}

}
