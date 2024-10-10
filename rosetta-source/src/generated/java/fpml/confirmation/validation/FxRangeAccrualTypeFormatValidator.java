package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxRangeAccrual;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxRangeAccrualTypeFormatValidator implements Validator<FxRangeAccrual> {

	private List<ComparisonResult> getComparisonResults(FxRangeAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxRangeAccrual> validate(RosettaPath path, FxRangeAccrual o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxRangeAccrual", ValidationType.TYPE_FORMAT, "FxRangeAccrual", path, "", error);
		}
		return success("FxRangeAccrual", ValidationType.TYPE_FORMAT, "FxRangeAccrual", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxRangeAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxRangeAccrual", ValidationType.TYPE_FORMAT, "FxRangeAccrual", path, "", res.getError());
				}
				return success("FxRangeAccrual", ValidationType.TYPE_FORMAT, "FxRangeAccrual", path, "");
			})
			.collect(toList());
	}

}
