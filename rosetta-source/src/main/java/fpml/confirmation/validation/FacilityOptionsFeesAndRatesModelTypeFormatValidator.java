package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityOptionsFeesAndRatesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityOptionsFeesAndRatesModelTypeFormatValidator implements Validator<FacilityOptionsFeesAndRatesModel> {

	private List<ComparisonResult> getComparisonResults(FacilityOptionsFeesAndRatesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FacilityOptionsFeesAndRatesModel> validate(RosettaPath path, FacilityOptionsFeesAndRatesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityOptionsFeesAndRatesModel", ValidationType.TYPE_FORMAT, "FacilityOptionsFeesAndRatesModel", path, "", error);
		}
		return success("FacilityOptionsFeesAndRatesModel", ValidationType.TYPE_FORMAT, "FacilityOptionsFeesAndRatesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityOptionsFeesAndRatesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityOptionsFeesAndRatesModel", ValidationType.TYPE_FORMAT, "FacilityOptionsFeesAndRatesModel", path, "", res.getError());
				}
				return success("FacilityOptionsFeesAndRatesModel", ValidationType.TYPE_FORMAT, "FacilityOptionsFeesAndRatesModel", path, "");
			})
			.collect(toList());
	}

}
