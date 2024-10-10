package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTenorModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTenorModelTypeFormatValidator implements Validator<FxTenorModel> {

	private List<ComparisonResult> getComparisonResults(FxTenorModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTenorModel> validate(RosettaPath path, FxTenorModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTenorModel", ValidationType.TYPE_FORMAT, "FxTenorModel", path, "", error);
		}
		return success("FxTenorModel", ValidationType.TYPE_FORMAT, "FxTenorModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTenorModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTenorModel", ValidationType.TYPE_FORMAT, "FxTenorModel", path, "", res.getError());
				}
				return success("FxTenorModel", ValidationType.TYPE_FORMAT, "FxTenorModel", path, "");
			})
			.collect(toList());
	}

}
