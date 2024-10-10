package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxCrossRateObservable;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxCrossRateObservableTypeFormatValidator implements Validator<FxCrossRateObservable> {

	private List<ComparisonResult> getComparisonResults(FxCrossRateObservable o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxCrossRateObservable> validate(RosettaPath path, FxCrossRateObservable o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxCrossRateObservable", ValidationType.TYPE_FORMAT, "FxCrossRateObservable", path, "", error);
		}
		return success("FxCrossRateObservable", ValidationType.TYPE_FORMAT, "FxCrossRateObservable", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCrossRateObservable o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCrossRateObservable", ValidationType.TYPE_FORMAT, "FxCrossRateObservable", path, "", res.getError());
				}
				return success("FxCrossRateObservable", ValidationType.TYPE_FORMAT, "FxCrossRateObservable", path, "");
			})
			.collect(toList());
	}

}
