package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorporateActionEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CorporateActionEventTypeFormatValidator implements Validator<CorporateActionEvent> {

	private List<ComparisonResult> getComparisonResults(CorporateActionEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CorporateActionEvent> validate(RosettaPath path, CorporateActionEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CorporateActionEvent", ValidationType.TYPE_FORMAT, "CorporateActionEvent", path, "", error);
		}
		return success("CorporateActionEvent", ValidationType.TYPE_FORMAT, "CorporateActionEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorporateActionEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorporateActionEvent", ValidationType.TYPE_FORMAT, "CorporateActionEvent", path, "", res.getError());
				}
				return success("CorporateActionEvent", ValidationType.TYPE_FORMAT, "CorporateActionEvent", path, "");
			})
			.collect(toList());
	}

}
