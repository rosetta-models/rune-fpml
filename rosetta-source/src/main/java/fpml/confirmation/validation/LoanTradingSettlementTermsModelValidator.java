package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingAssocEnum;
import fpml.confirmation.LoanTradingFormOfPurchaseEnum;
import fpml.confirmation.LoanTradingSettlementTermsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingSettlementTermsModelValidator implements Validator<LoanTradingSettlementTermsModel> {

	private List<ComparisonResult> getComparisonResults(LoanTradingSettlementTermsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradingAssociation", (LoanTradingAssocEnum) o.getTradingAssociation() != null ? 1 : 0, 1, 1), 
				checkCardinality("formOfPurchase", (LoanTradingFormOfPurchaseEnum) o.getFormOfPurchase() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LoanTradingSettlementTermsModel> validate(RosettaPath path, LoanTradingSettlementTermsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingSettlementTermsModel", ValidationType.CARDINALITY, "LoanTradingSettlementTermsModel", path, "", error);
		}
		return success("LoanTradingSettlementTermsModel", ValidationType.CARDINALITY, "LoanTradingSettlementTermsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingSettlementTermsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingSettlementTermsModel", ValidationType.CARDINALITY, "LoanTradingSettlementTermsModel", path, "", res.getError());
				}
				return success("LoanTradingSettlementTermsModel", ValidationType.CARDINALITY, "LoanTradingSettlementTermsModel", path, "");
			})
			.collect(toList());
	}

}
