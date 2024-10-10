package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DividendPayoutSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DividendPayoutSequenceValidator implements Validator<DividendPayoutSequence> {

	private List<ComparisonResult> getComparisonResults(DividendPayoutSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dividendPayoutRatio", (BigDecimal) o.getDividendPayoutRatio() != null ? 1 : 0, 1, 1), 
				checkCardinality("dividendPayoutRatioCash", (BigDecimal) o.getDividendPayoutRatioCash() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPayoutRatioNonCash", (BigDecimal) o.getDividendPayoutRatioNonCash() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DividendPayoutSequence> validate(RosettaPath path, DividendPayoutSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DividendPayoutSequence", ValidationType.CARDINALITY, "DividendPayoutSequence", path, "", error);
		}
		return success("DividendPayoutSequence", ValidationType.CARDINALITY, "DividendPayoutSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPayoutSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPayoutSequence", ValidationType.CARDINALITY, "DividendPayoutSequence", path, "", res.getError());
				}
				return success("DividendPayoutSequence", ValidationType.CARDINALITY, "DividendPayoutSequence", path, "");
			})
			.collect(toList());
	}

}
