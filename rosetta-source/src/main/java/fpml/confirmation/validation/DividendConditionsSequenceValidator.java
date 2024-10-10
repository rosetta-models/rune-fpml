package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DateReference;
import fpml.confirmation.DividendConditionsSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DividendConditionsSequenceValidator implements Validator<DividendConditionsSequence> {

	private List<ComparisonResult> getComparisonResults(DividendConditionsSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dividendPeriodEffectiveDate", (DateReference) o.getDividendPeriodEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPeriodEndDate", (DateReference) o.getDividendPeriodEndDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DividendConditionsSequence> validate(RosettaPath path, DividendConditionsSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DividendConditionsSequence", ValidationType.CARDINALITY, "DividendConditionsSequence", path, "", error);
		}
		return success("DividendConditionsSequence", ValidationType.CARDINALITY, "DividendConditionsSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendConditionsSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendConditionsSequence", ValidationType.CARDINALITY, "DividendConditionsSequence", path, "", res.getError());
				}
				return success("DividendConditionsSequence", ValidationType.CARDINALITY, "DividendConditionsSequence", path, "");
			})
			.collect(toList());
	}

}
