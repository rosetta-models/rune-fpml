package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DeclaredCashAndCashEquivalentDividendPercentageModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DeclaredCashAndCashEquivalentDividendPercentageModelValidator implements Validator<DeclaredCashAndCashEquivalentDividendPercentageModel> {

	private List<ComparisonResult> getComparisonResults(DeclaredCashAndCashEquivalentDividendPercentageModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("declaredCashDividendPercentage", (BigDecimal) o.getDeclaredCashDividendPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("declaredCashEquivalentDividendPercentage", (BigDecimal) o.getDeclaredCashEquivalentDividendPercentage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DeclaredCashAndCashEquivalentDividendPercentageModel> validate(RosettaPath path, DeclaredCashAndCashEquivalentDividendPercentageModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DeclaredCashAndCashEquivalentDividendPercentageModel", ValidationType.CARDINALITY, "DeclaredCashAndCashEquivalentDividendPercentageModel", path, "", error);
		}
		return success("DeclaredCashAndCashEquivalentDividendPercentageModel", ValidationType.CARDINALITY, "DeclaredCashAndCashEquivalentDividendPercentageModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeclaredCashAndCashEquivalentDividendPercentageModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DeclaredCashAndCashEquivalentDividendPercentageModel", ValidationType.CARDINALITY, "DeclaredCashAndCashEquivalentDividendPercentageModel", path, "", res.getError());
				}
				return success("DeclaredCashAndCashEquivalentDividendPercentageModel", ValidationType.CARDINALITY, "DeclaredCashAndCashEquivalentDividendPercentageModel", path, "");
			})
			.collect(toList());
	}

}
