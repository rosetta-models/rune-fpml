package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearingResultsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClearingResultsModelTypeFormatValidator implements Validator<ClearingResultsModel> {

	private List<ComparisonResult> getComparisonResults(ClearingResultsModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ClearingResultsModel> validate(RosettaPath path, ClearingResultsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ClearingResultsModel", ValidationType.TYPE_FORMAT, "ClearingResultsModel", path, "", error);
		}
		return success("ClearingResultsModel", ValidationType.TYPE_FORMAT, "ClearingResultsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingResultsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingResultsModel", ValidationType.TYPE_FORMAT, "ClearingResultsModel", path, "", res.getError());
				}
				return success("ClearingResultsModel", ValidationType.TYPE_FORMAT, "ClearingResultsModel", path, "");
			})
			.collect(toList());
	}

}
