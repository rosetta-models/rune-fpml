package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FormulaComponent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FormulaComponentTypeFormatValidator implements Validator<FormulaComponent> {

	private List<ComparisonResult> getComparisonResults(FormulaComponent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("componentDescription", o.getComponentDescription(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<FormulaComponent> validate(RosettaPath path, FormulaComponent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FormulaComponent", ValidationType.TYPE_FORMAT, "FormulaComponent", path, "", error);
		}
		return success("FormulaComponent", ValidationType.TYPE_FORMAT, "FormulaComponent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FormulaComponent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FormulaComponent", ValidationType.TYPE_FORMAT, "FormulaComponent", path, "", res.getError());
				}
				return success("FormulaComponent", ValidationType.TYPE_FORMAT, "FormulaComponent", path, "");
			})
			.collect(toList());
	}

}
