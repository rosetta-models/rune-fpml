package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditCurveCharacteristicsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditCurveCharacteristicsModelTypeFormatValidator implements Validator<CreditCurveCharacteristicsModel> {

	private List<ComparisonResult> getComparisonResults(CreditCurveCharacteristicsModel o) {
		return Lists.<ComparisonResult>newArrayList(
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
			return failure("CreditCurveCharacteristicsModel", ValidationType.TYPE_FORMAT, "CreditCurveCharacteristicsModel", path, "", error);
		}
		return success("CreditCurveCharacteristicsModel", ValidationType.TYPE_FORMAT, "CreditCurveCharacteristicsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditCurveCharacteristicsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditCurveCharacteristicsModel", ValidationType.TYPE_FORMAT, "CreditCurveCharacteristicsModel", path, "", res.getError());
				}
				return success("CreditCurveCharacteristicsModel", ValidationType.TYPE_FORMAT, "CreditCurveCharacteristicsModel", path, "");
			})
			.collect(toList());
	}

}
