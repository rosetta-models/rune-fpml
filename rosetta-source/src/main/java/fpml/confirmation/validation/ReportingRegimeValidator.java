package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ActionType;
import fpml.confirmation.CurrencyPairClassification;
import fpml.confirmation.EntityClassification;
import fpml.confirmation.NotionalReportingType;
import fpml.confirmation.PartyRelationshipType;
import fpml.confirmation.ReportingBoolean;
import fpml.confirmation.ReportingRegime;
import fpml.confirmation.ReportingRegimeSequence0;
import fpml.confirmation.ReportingRegimeSequence1;
import fpml.confirmation.ReportingRole;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReportingRegimeValidator implements Validator<ReportingRegime> {

	private List<ComparisonResult> getComparisonResults(ReportingRegime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingRegimeSequence0", (ReportingRegimeSequence0) o.getReportingRegimeSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatorilyClearable", (ReportingBoolean) o.getMandatorilyClearable() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingRegimeSequence1", (ReportingRegimeSequence1) o.getReportingRegimeSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("exceedsClearingThreshold", (Boolean) o.getExceedsClearingThreshold() != null ? 1 : 0, 0, 1), 
				checkCardinality("entityClassification", (EntityClassification) o.getEntityClassification() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradePartyRelationshipType", (PartyRelationshipType) o.getTradePartyRelationshipType() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionType", (ActionType) o.getActionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("preEnactmentTrade", (Boolean) o.getPreEnactmentTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalType", (NotionalReportingType) o.getNotionalType() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyPairClassification", (CurrencyPairClassification) o.getCurrencyPairClassification() != null ? 1 : 0, 0, 1), 
				checkCardinality("transmissionOfOrder", (Boolean) o.getTransmissionOfOrder() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReportingRegime> validate(RosettaPath path, ReportingRegime o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReportingRegime", ValidationType.CARDINALITY, "ReportingRegime", path, "", error);
		}
		return success("ReportingRegime", ValidationType.CARDINALITY, "ReportingRegime", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingRegime", ValidationType.CARDINALITY, "ReportingRegime", path, "", res.getError());
				}
				return success("ReportingRegime", ValidationType.CARDINALITY, "ReportingRegime", path, "");
			})
			.collect(toList());
	}

}
