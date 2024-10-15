package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PricingInputDatesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingInputDatesModelTypeFormatValidator implements Validator<PricingInputDatesModel> {

	private List<ComparisonResult> getComparisonResults(PricingInputDatesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PricingInputDatesModel> validate(RosettaPath path, PricingInputDatesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingInputDatesModel", ValidationType.TYPE_FORMAT, "PricingInputDatesModel", path, "", error);
		}
		return success("PricingInputDatesModel", ValidationType.TYPE_FORMAT, "PricingInputDatesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingInputDatesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingInputDatesModel", ValidationType.TYPE_FORMAT, "PricingInputDatesModel", path, "", res.getError());
				}
				return success("PricingInputDatesModel", ValidationType.TYPE_FORMAT, "PricingInputDatesModel", path, "");
			})
			.collect(toList());
	}

}
