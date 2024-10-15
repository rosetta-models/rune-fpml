package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxCoreDetailsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxCoreDetailsModelTypeFormatValidator implements Validator<FxCoreDetailsModel> {

	private List<ComparisonResult> getComparisonResults(FxCoreDetailsModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxCoreDetailsModel> validate(RosettaPath path, FxCoreDetailsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxCoreDetailsModel", ValidationType.TYPE_FORMAT, "FxCoreDetailsModel", path, "", error);
		}
		return success("FxCoreDetailsModel", ValidationType.TYPE_FORMAT, "FxCoreDetailsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCoreDetailsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCoreDetailsModel", ValidationType.TYPE_FORMAT, "FxCoreDetailsModel", path, "", res.getError());
				}
				return success("FxCoreDetailsModel", ValidationType.TYPE_FORMAT, "FxCoreDetailsModel", path, "");
			})
			.collect(toList());
	}

}
