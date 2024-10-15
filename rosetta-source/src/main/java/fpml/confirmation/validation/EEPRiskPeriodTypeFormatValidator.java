package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EEPRiskPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EEPRiskPeriodTypeFormatValidator implements Validator<EEPRiskPeriod> {

	private List<ComparisonResult> getComparisonResults(EEPRiskPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EEPRiskPeriod> validate(RosettaPath path, EEPRiskPeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EEPRiskPeriod", ValidationType.TYPE_FORMAT, "EEPRiskPeriod", path, "", error);
		}
		return success("EEPRiskPeriod", ValidationType.TYPE_FORMAT, "EEPRiskPeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EEPRiskPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EEPRiskPeriod", ValidationType.TYPE_FORMAT, "EEPRiskPeriod", path, "", res.getError());
				}
				return success("EEPRiskPeriod", ValidationType.TYPE_FORMAT, "EEPRiskPeriod", path, "");
			})
			.collect(toList());
	}

}
