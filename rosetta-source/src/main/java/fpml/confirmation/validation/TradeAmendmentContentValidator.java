package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AgreementAndEffectiveDatesModel;
import fpml.confirmation.ReportingNotionalChangeModel;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeAlterationPaymentModel;
import fpml.confirmation.TradeAmendmentContent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeAmendmentContentValidator implements Validator<TradeAmendmentContent> {

	private List<ComparisonResult> getComparisonResults(TradeAmendmentContent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("trade", (Trade) o.getTrade() != null ? 1 : 0, 1, 1), 
				checkCardinality("agreementAndEffectiveDatesModel", (AgreementAndEffectiveDatesModel) o.getAgreementAndEffectiveDatesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("reportingNotionalChangeModel", (ReportingNotionalChangeModel) o.getReportingNotionalChangeModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeAlterationPaymentModel", (TradeAlterationPaymentModel) o.getTradeAlterationPaymentModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TradeAmendmentContent> validate(RosettaPath path, TradeAmendmentContent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeAmendmentContent", ValidationType.CARDINALITY, "TradeAmendmentContent", path, "", error);
		}
		return success("TradeAmendmentContent", ValidationType.CARDINALITY, "TradeAmendmentContent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeAmendmentContent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeAmendmentContent", ValidationType.CARDINALITY, "TradeAmendmentContent", path, "", res.getError());
				}
				return success("TradeAmendmentContent", ValidationType.CARDINALITY, "TradeAmendmentContent", path, "");
			})
			.collect(toList());
	}

}
