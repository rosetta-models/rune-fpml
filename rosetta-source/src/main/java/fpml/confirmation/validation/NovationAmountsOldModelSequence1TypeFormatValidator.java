package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NovationAmountsOldModelSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NovationAmountsOldModelSequence1TypeFormatValidator implements Validator<NovationAmountsOldModelSequence1> {

	private List<ComparisonResult> getComparisonResults(NovationAmountsOldModelSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NovationAmountsOldModelSequence1> validate(RosettaPath path, NovationAmountsOldModelSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NovationAmountsOldModelSequence1", ValidationType.TYPE_FORMAT, "NovationAmountsOldModelSequence1", path, "", error);
		}
		return success("NovationAmountsOldModelSequence1", ValidationType.TYPE_FORMAT, "NovationAmountsOldModelSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NovationAmountsOldModelSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NovationAmountsOldModelSequence1", ValidationType.TYPE_FORMAT, "NovationAmountsOldModelSequence1", path, "", res.getError());
				}
				return success("NovationAmountsOldModelSequence1", ValidationType.TYPE_FORMAT, "NovationAmountsOldModelSequence1", path, "");
			})
			.collect(toList());
	}

}
