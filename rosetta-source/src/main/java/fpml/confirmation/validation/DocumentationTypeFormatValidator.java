package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Documentation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DocumentationTypeFormatValidator implements Validator<Documentation> {

	private List<ComparisonResult> getComparisonResults(Documentation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Documentation> validate(RosettaPath path, Documentation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Documentation", ValidationType.TYPE_FORMAT, "Documentation", path, "", error);
		}
		return success("Documentation", ValidationType.TYPE_FORMAT, "Documentation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Documentation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Documentation", ValidationType.TYPE_FORMAT, "Documentation", path, "", res.getError());
				}
				return success("Documentation", ValidationType.TYPE_FORMAT, "Documentation", path, "");
			})
			.collect(toList());
	}

}
