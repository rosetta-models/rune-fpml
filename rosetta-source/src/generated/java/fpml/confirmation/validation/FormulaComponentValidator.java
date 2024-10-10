package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Formula;
import fpml.confirmation.FormulaComponent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FormulaComponentValidator implements Validator<FormulaComponent> {

	private List<ComparisonResult> getComparisonResults(FormulaComponent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("componentDescription", (String) o.getComponentDescription() != null ? 1 : 0, 1, 1), 
				checkCardinality("formula", (Formula) o.getFormula() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1)
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
			return failure("FormulaComponent", ValidationType.CARDINALITY, "FormulaComponent", path, "", error);
		}
		return success("FormulaComponent", ValidationType.CARDINALITY, "FormulaComponent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FormulaComponent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FormulaComponent", ValidationType.CARDINALITY, "FormulaComponent", path, "", res.getError());
				}
				return success("FormulaComponent", ValidationType.CARDINALITY, "FormulaComponent", path, "");
			})
			.collect(toList());
	}

}
