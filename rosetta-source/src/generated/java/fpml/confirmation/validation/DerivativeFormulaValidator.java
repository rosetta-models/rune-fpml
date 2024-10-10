package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DenominatorTerm;
import fpml.confirmation.DerivativeFormula;
import fpml.confirmation.FormulaTerm;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DerivativeFormulaValidator implements Validator<DerivativeFormula> {

	private List<ComparisonResult> getComparisonResults(DerivativeFormula o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("term", (FormulaTerm) o.getTerm() != null ? 1 : 0, 1, 1), 
				checkCardinality("denominatorTerm", (DenominatorTerm) o.getDenominatorTerm() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<DerivativeFormula> validate(RosettaPath path, DerivativeFormula o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DerivativeFormula", ValidationType.CARDINALITY, "DerivativeFormula", path, "", error);
		}
		return success("DerivativeFormula", ValidationType.CARDINALITY, "DerivativeFormula", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativeFormula o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativeFormula", ValidationType.CARDINALITY, "DerivativeFormula", path, "", res.getError());
				}
				return success("DerivativeFormula", ValidationType.CARDINALITY, "DerivativeFormula", path, "");
			})
			.collect(toList());
	}

}
