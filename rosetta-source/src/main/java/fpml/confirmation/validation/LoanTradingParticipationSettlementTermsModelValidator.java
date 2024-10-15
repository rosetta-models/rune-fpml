package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingParticipationSettlementTermsModel;
import fpml.confirmation.LoanTradingVotingRightsEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingParticipationSettlementTermsModelValidator implements Validator<LoanTradingParticipationSettlementTermsModel> {

	private List<ComparisonResult> getComparisonResults(LoanTradingParticipationSettlementTermsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateralRequiredFlag", (Boolean) o.getCollateralRequiredFlag() != null ? 1 : 0, 1, 1), 
				checkCardinality("votingRights", (LoanTradingVotingRightsEnum) o.getVotingRights() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LoanTradingParticipationSettlementTermsModel> validate(RosettaPath path, LoanTradingParticipationSettlementTermsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingParticipationSettlementTermsModel", ValidationType.CARDINALITY, "LoanTradingParticipationSettlementTermsModel", path, "", error);
		}
		return success("LoanTradingParticipationSettlementTermsModel", ValidationType.CARDINALITY, "LoanTradingParticipationSettlementTermsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingParticipationSettlementTermsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingParticipationSettlementTermsModel", ValidationType.CARDINALITY, "LoanTradingParticipationSettlementTermsModel", path, "", res.getError());
				}
				return success("LoanTradingParticipationSettlementTermsModel", ValidationType.CARDINALITY, "LoanTradingParticipationSettlementTermsModel", path, "");
			})
			.collect(toList());
	}

}
