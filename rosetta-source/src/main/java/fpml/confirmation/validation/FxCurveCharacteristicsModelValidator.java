package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxCurveCharacteristicsModel;
import fpml.confirmation.QuotedCurrencyPair;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxCurveCharacteristicsModelValidator implements Validator<FxCurveCharacteristicsModel> {

	private List<ComparisonResult> getComparisonResults(FxCurveCharacteristicsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxCurveCharacteristicsModel> validate(RosettaPath path, FxCurveCharacteristicsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxCurveCharacteristicsModel", ValidationType.CARDINALITY, "FxCurveCharacteristicsModel", path, "", error);
		}
		return success("FxCurveCharacteristicsModel", ValidationType.CARDINALITY, "FxCurveCharacteristicsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCurveCharacteristicsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCurveCharacteristicsModel", ValidationType.CARDINALITY, "FxCurveCharacteristicsModel", path, "", res.getError());
				}
				return success("FxCurveCharacteristicsModel", ValidationType.CARDINALITY, "FxCurveCharacteristicsModel", path, "");
			})
			.collect(toList());
	}

}
