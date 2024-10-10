package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityRatesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityRatesModelTypeFormatValidator implements Validator<FacilityRatesModel> {

	private List<ComparisonResult> getComparisonResults(FacilityRatesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FacilityRatesModel> validate(RosettaPath path, FacilityRatesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityRatesModel", ValidationType.TYPE_FORMAT, "FacilityRatesModel", path, "", error);
		}
		return success("FacilityRatesModel", ValidationType.TYPE_FORMAT, "FacilityRatesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityRatesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityRatesModel", ValidationType.TYPE_FORMAT, "FacilityRatesModel", path, "", res.getError());
				}
				return success("FacilityRatesModel", ValidationType.TYPE_FORMAT, "FacilityRatesModel", path, "");
			})
			.collect(toList());
	}

}
