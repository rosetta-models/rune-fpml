package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxRateObservationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxRateObservationModelTypeFormatValidator implements Validator<FxRateObservationModel> {

	private List<ComparisonResult> getComparisonResults(FxRateObservationModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxRateObservationModel> validate(RosettaPath path, FxRateObservationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxRateObservationModel", ValidationType.TYPE_FORMAT, "FxRateObservationModel", path, "", error);
		}
		return success("FxRateObservationModel", ValidationType.TYPE_FORMAT, "FxRateObservationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxRateObservationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxRateObservationModel", ValidationType.TYPE_FORMAT, "FxRateObservationModel", path, "", res.getError());
				}
				return success("FxRateObservationModel", ValidationType.TYPE_FORMAT, "FxRateObservationModel", path, "");
			})
			.collect(toList());
	}

}
