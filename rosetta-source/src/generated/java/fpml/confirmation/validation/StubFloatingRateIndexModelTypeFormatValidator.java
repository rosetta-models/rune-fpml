package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.StubFloatingRateIndexModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StubFloatingRateIndexModelTypeFormatValidator implements Validator<StubFloatingRateIndexModel> {

	private List<ComparisonResult> getComparisonResults(StubFloatingRateIndexModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<StubFloatingRateIndexModel> validate(RosettaPath path, StubFloatingRateIndexModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StubFloatingRateIndexModel", ValidationType.TYPE_FORMAT, "StubFloatingRateIndexModel", path, "", error);
		}
		return success("StubFloatingRateIndexModel", ValidationType.TYPE_FORMAT, "StubFloatingRateIndexModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StubFloatingRateIndexModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StubFloatingRateIndexModel", ValidationType.TYPE_FORMAT, "StubFloatingRateIndexModel", path, "", res.getError());
				}
				return success("StubFloatingRateIndexModel", ValidationType.TYPE_FORMAT, "StubFloatingRateIndexModel", path, "");
			})
			.collect(toList());
	}

}
