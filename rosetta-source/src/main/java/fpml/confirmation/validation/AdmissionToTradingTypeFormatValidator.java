package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdmissionToTrading;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AdmissionToTradingTypeFormatValidator implements Validator<AdmissionToTrading> {

	private List<ComparisonResult> getComparisonResults(AdmissionToTrading o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AdmissionToTrading> validate(RosettaPath path, AdmissionToTrading o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AdmissionToTrading", ValidationType.TYPE_FORMAT, "AdmissionToTrading", path, "", error);
		}
		return success("AdmissionToTrading", ValidationType.TYPE_FORMAT, "AdmissionToTrading", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdmissionToTrading o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdmissionToTrading", ValidationType.TYPE_FORMAT, "AdmissionToTrading", path, "", res.getError());
				}
				return success("AdmissionToTrading", ValidationType.TYPE_FORMAT, "AdmissionToTrading", path, "");
			})
			.collect(toList());
	}

}
