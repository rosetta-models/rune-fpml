package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FloatingRateIndexLoan;
import fpml.confirmation.FloatingRateIndexLoanModel;
import fpml.confirmation.Period;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingRateIndexLoanModelValidator implements Validator<FloatingRateIndexLoanModel> {

	private List<ComparisonResult> getComparisonResults(FloatingRateIndexLoanModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateIndex", (FloatingRateIndexLoan) o.getFloatingRateIndex() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexTenor", (Period) o.getIndexTenor() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FloatingRateIndexLoanModel> validate(RosettaPath path, FloatingRateIndexLoanModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateIndexLoanModel", ValidationType.CARDINALITY, "FloatingRateIndexLoanModel", path, "", error);
		}
		return success("FloatingRateIndexLoanModel", ValidationType.CARDINALITY, "FloatingRateIndexLoanModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndexLoanModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateIndexLoanModel", ValidationType.CARDINALITY, "FloatingRateIndexLoanModel", path, "", res.getError());
				}
				return success("FloatingRateIndexLoanModel", ValidationType.CARDINALITY, "FloatingRateIndexLoanModel", path, "");
			})
			.collect(toList());
	}

}
