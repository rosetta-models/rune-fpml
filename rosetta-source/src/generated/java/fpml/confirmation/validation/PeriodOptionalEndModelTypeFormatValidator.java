package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PeriodOptionalEndModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PeriodOptionalEndModelTypeFormatValidator implements Validator<PeriodOptionalEndModel> {

	private List<ComparisonResult> getComparisonResults(PeriodOptionalEndModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PeriodOptionalEndModel> validate(RosettaPath path, PeriodOptionalEndModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PeriodOptionalEndModel", ValidationType.TYPE_FORMAT, "PeriodOptionalEndModel", path, "", error);
		}
		return success("PeriodOptionalEndModel", ValidationType.TYPE_FORMAT, "PeriodOptionalEndModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PeriodOptionalEndModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PeriodOptionalEndModel", ValidationType.TYPE_FORMAT, "PeriodOptionalEndModel", path, "", res.getError());
				}
				return success("PeriodOptionalEndModel", ValidationType.TYPE_FORMAT, "PeriodOptionalEndModel", path, "");
			})
			.collect(toList());
	}

}
