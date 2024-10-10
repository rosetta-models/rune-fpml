package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NewTradeModel;
import fpml.confirmation.NovationAmountsModel;
import fpml.confirmation.NovationDatesModel;
import fpml.confirmation.NovationRolesModel;
import fpml.confirmation.NovationTermsModel;
import fpml.confirmation.Payment;
import fpml.confirmation.TradeNovationContent;
import fpml.confirmation.TradeNovationContentSequence0;
import fpml.confirmation.TradeNovationContentSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeNovationContentValidator implements Validator<TradeNovationContent> {

	private List<ComparisonResult> getComparisonResults(TradeNovationContent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("newTradeModel", (NewTradeModel) o.getNewTradeModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeNovationContentSequence0", (TradeNovationContentSequence0) o.getTradeNovationContentSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeNovationContentSequence1", (TradeNovationContentSequence1) o.getTradeNovationContentSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("novationRolesModel", (NovationRolesModel) o.getNovationRolesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("novationDatesModel", (NovationDatesModel) o.getNovationDatesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("novationAmountsModel", (NovationAmountsModel) o.getNovationAmountsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("novationTermsModel", (NovationTermsModel) o.getNovationTermsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("payment", (Payment) o.getPayment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradeNovationContent> validate(RosettaPath path, TradeNovationContent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeNovationContent", ValidationType.CARDINALITY, "TradeNovationContent", path, "", error);
		}
		return success("TradeNovationContent", ValidationType.CARDINALITY, "TradeNovationContent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNovationContent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeNovationContent", ValidationType.CARDINALITY, "TradeNovationContent", path, "", res.getError());
				}
				return success("TradeNovationContent", ValidationType.CARDINALITY, "TradeNovationContent", path, "");
			})
			.collect(toList());
	}

}
