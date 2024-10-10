package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Formula;
import fpml.confirmation.Math;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FormulaValidator implements Validator<Formula> {

	private List<ComparisonResult> getComparisonResults(Formula o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("formulaDescription", (String) o.getFormulaDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("math", (Math) o.getMath() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Formula> validate(RosettaPath path, Formula o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Formula", ValidationType.CARDINALITY, "Formula", path, "", error);
		}
		return success("Formula", ValidationType.CARDINALITY, "Formula", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Formula o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Formula", ValidationType.CARDINALITY, "Formula", path, "", res.getError());
				}
				return success("Formula", ValidationType.CARDINALITY, "Formula", path, "");
			})
			.collect(toList());
	}

}
