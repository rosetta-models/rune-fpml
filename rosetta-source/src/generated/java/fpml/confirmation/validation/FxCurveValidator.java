package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import fpml.confirmation.FxCurve;
import fpml.confirmation.FxCurveCharacteristicsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxCurveValidator implements Validator<FxCurve> {

	private List<ComparisonResult> getComparisonResults(FxCurve o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxCurveCharacteristicsModel", (FxCurveCharacteristicsModel) o.getFxCurveCharacteristicsModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxCurve> validate(RosettaPath path, FxCurve o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxCurve", ValidationType.CARDINALITY, "FxCurve", path, "", error);
		}
		return success("FxCurve", ValidationType.CARDINALITY, "FxCurve", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCurve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCurve", ValidationType.CARDINALITY, "FxCurve", path, "", res.getError());
				}
				return success("FxCurve", ValidationType.CARDINALITY, "FxCurve", path, "");
			})
			.collect(toList());
	}

}
