package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DividendPayout;
import fpml.confirmation.DividendPayoutSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DividendPayoutValidator implements Validator<DividendPayout> {

	private List<ComparisonResult> getComparisonResults(DividendPayout o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dividendPayoutSequence", (DividendPayoutSequence) o.getDividendPayoutSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPayoutConditions", (String) o.getDividendPayoutConditions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DividendPayout> validate(RosettaPath path, DividendPayout o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DividendPayout", ValidationType.CARDINALITY, "DividendPayout", path, "", error);
		}
		return success("DividendPayout", ValidationType.CARDINALITY, "DividendPayout", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPayout o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPayout", ValidationType.CARDINALITY, "DividendPayout", path, "", res.getError());
				}
				return success("DividendPayout", ValidationType.CARDINALITY, "DividendPayout", path, "");
			})
			.collect(toList());
	}

}
