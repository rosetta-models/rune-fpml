package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractEventRequireId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractEventRequireIdTypeFormatValidator implements Validator<AbstractEventRequireId> {

	private List<ComparisonResult> getComparisonResults(AbstractEventRequireId o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AbstractEventRequireId> validate(RosettaPath path, AbstractEventRequireId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractEventRequireId", ValidationType.TYPE_FORMAT, "AbstractEventRequireId", path, "", error);
		}
		return success("AbstractEventRequireId", ValidationType.TYPE_FORMAT, "AbstractEventRequireId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractEventRequireId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractEventRequireId", ValidationType.TYPE_FORMAT, "AbstractEventRequireId", path, "", res.getError());
				}
				return success("AbstractEventRequireId", ValidationType.TYPE_FORMAT, "AbstractEventRequireId", path, "");
			})
			.collect(toList());
	}

}
