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
import fpml.confirmation.RepoFarLeg;
import fpml.confirmation.RepoFarLegSequence;
import fpml.confirmation.SettlementAmountOrCurrencyModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepoFarLegValidator implements Validator<RepoFarLeg> {

	private List<ComparisonResult> getComparisonResults(RepoFarLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDate", (AdjustableOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementAmountOrCurrencyModel", (SettlementAmountOrCurrencyModel) o.getSettlementAmountOrCurrencyModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxRate", (FxRate) o.getFxRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("repoFarLegSequence", (RepoFarLegSequence) o.getRepoFarLegSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("repoInterest", (BigDecimal) o.getRepoInterest() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RepoFarLeg> validate(RosettaPath path, RepoFarLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RepoFarLeg", ValidationType.CARDINALITY, "RepoFarLeg", path, "", error);
		}
		return success("RepoFarLeg", ValidationType.CARDINALITY, "RepoFarLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoFarLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepoFarLeg", ValidationType.CARDINALITY, "RepoFarLeg", path, "", res.getError());
				}
				return success("RepoFarLeg", ValidationType.CARDINALITY, "RepoFarLeg", path, "");
			})
			.collect(toList());
	}

}
