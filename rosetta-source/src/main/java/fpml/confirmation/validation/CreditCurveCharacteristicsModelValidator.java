package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditCurveCharacteristicsModel;
import fpml.confirmation.CreditEntityModel;
import fpml.confirmation.CreditEvents;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.Currency;
import fpml.confirmation.DeliverableObligations;
import fpml.confirmation.Obligations;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditCurveCharacteristicsModelValidator implements Validator<CreditCurveCharacteristicsModel> {

	private List<ComparisonResult> getComparisonResults(CreditCurveCharacteristicsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("creditEntityModel", (CreditEntityModel) o.getCreditEntityModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditEvents", (CreditEvents) o.getCreditEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 1, 1), 
				checkCardinality("secured", (Boolean) o.getSecured() != null ? 1 : 0, 1, 1), 
				checkCardinality("obligationCurrency", (Currency) o.getObligationCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("obligations", (Obligations) o.getObligations() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliverableObligations", (DeliverableObligations) o.getDeliverableObligations() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CreditCurveCharacteristicsModel> validate(RosettaPath path, CreditCurveCharacteristicsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditCurveCharacteristicsModel", ValidationType.CARDINALITY, "CreditCurveCharacteristicsModel", path, "", error);
		}
		return success("CreditCurveCharacteristicsModel", ValidationType.CARDINALITY, "CreditCurveCharacteristicsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditCurveCharacteristicsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditCurveCharacteristicsModel", ValidationType.CARDINALITY, "CreditCurveCharacteristicsModel", path, "", res.getError());
				}
				return success("CreditCurveCharacteristicsModel", ValidationType.CARDINALITY, "CreditCurveCharacteristicsModel", path, "");
			})
			.collect(toList());
	}

}
