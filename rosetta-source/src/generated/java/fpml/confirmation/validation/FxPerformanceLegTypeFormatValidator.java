package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxPerformanceLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxPerformanceLegTypeFormatValidator implements Validator<FxPerformanceLeg> {

	private List<ComparisonResult> getComparisonResults(FxPerformanceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxPerformanceLeg> validate(RosettaPath path, FxPerformanceLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxPerformanceLeg", ValidationType.TYPE_FORMAT, "FxPerformanceLeg", path, "", error);
		}
		return success("FxPerformanceLeg", ValidationType.TYPE_FORMAT, "FxPerformanceLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPerformanceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxPerformanceLeg", ValidationType.TYPE_FORMAT, "FxPerformanceLeg", path, "", res.getError());
				}
				return success("FxPerformanceLeg", ValidationType.TYPE_FORMAT, "FxPerformanceLeg", path, "");
			})
			.collect(toList());
	}

}
