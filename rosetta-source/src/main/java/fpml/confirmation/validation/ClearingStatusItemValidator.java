package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearingStatusItem;
import fpml.confirmation.ClearingStatusValue;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Trade;
import fpml.confirmation.TradePackage;
import fpml.confirmation.TradeReferenceInformationModel;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClearingStatusItemValidator implements Validator<ClearingStatusItem> {

	private List<ComparisonResult> getComparisonResults(ClearingStatusItem o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeReferenceInformationModel", (TradeReferenceInformationModel) o.getTradeReferenceInformationModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("trade", (Trade) o.getTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradePackage", (TradePackage) o.getTradePackage() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingStatusValue", (ClearingStatusValue) o.getClearingStatusValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("updatedDateTime", (ZonedDateTime) o.getUpdatedDateTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("statusAppliesTo", (List<? extends PartyReference>) o.getStatusAppliesTo() == null ? 0 : ((List<? extends PartyReference>) o.getStatusAppliesTo()).size(), 0, 2)
			);
	}

	@Override
	public ValidationResult<ClearingStatusItem> validate(RosettaPath path, ClearingStatusItem o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ClearingStatusItem", ValidationType.CARDINALITY, "ClearingStatusItem", path, "", error);
		}
		return success("ClearingStatusItem", ValidationType.CARDINALITY, "ClearingStatusItem", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingStatusItem o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingStatusItem", ValidationType.CARDINALITY, "ClearingStatusItem", path, "", res.getError());
				}
				return success("ClearingStatusItem", ValidationType.CARDINALITY, "ClearingStatusItem", path, "");
			})
			.collect(toList());
	}

}
