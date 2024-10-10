package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditCurve;
import fpml.confirmation.CreditCurveCharacteristicsModel;
import fpml.confirmation.Currency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditCurveValidator implements Validator<CreditCurve> {

	private List<ComparisonResult> getComparisonResults(CreditCurve o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditCurveCharacteristicsModel", (CreditCurveCharacteristicsModel) o.getCreditCurveCharacteristicsModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CreditCurve> validate(RosettaPath path, CreditCurve o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditCurve", ValidationType.CARDINALITY, "CreditCurve", path, "", error);
		}
		return success("CreditCurve", ValidationType.CARDINALITY, "CreditCurve", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditCurve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditCurve", ValidationType.CARDINALITY, "CreditCurve", path, "", res.getError());
				}
				return success("CreditCurve", ValidationType.CARDINALITY, "CreditCurve", path, "");
			})
			.collect(toList());
	}

}
