package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxSingleLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxSingleLegTypeFormatValidator implements Validator<FxSingleLeg> {

	private List<ComparisonResult> getComparisonResults(FxSingleLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxSingleLeg> validate(RosettaPath path, FxSingleLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxSingleLeg", ValidationType.TYPE_FORMAT, "FxSingleLeg", path, "", error);
		}
		return success("FxSingleLeg", ValidationType.TYPE_FORMAT, "FxSingleLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSingleLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxSingleLeg", ValidationType.TYPE_FORMAT, "FxSingleLeg", path, "", res.getError());
				}
				return success("FxSingleLeg", ValidationType.TYPE_FORMAT, "FxSingleLeg", path, "");
			})
			.collect(toList());
	}

}
