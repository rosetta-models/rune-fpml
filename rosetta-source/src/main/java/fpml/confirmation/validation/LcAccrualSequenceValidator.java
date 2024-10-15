package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import fpml.confirmation.FxTerms;
import fpml.confirmation.LcAccrualSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LcAccrualSequenceValidator implements Validator<LcAccrualSequence> {

	private List<ComparisonResult> getComparisonResults(LcAccrualSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("lcFxRate", (FxTerms) o.getLcFxRate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LcAccrualSequence> validate(RosettaPath path, LcAccrualSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LcAccrualSequence", ValidationType.CARDINALITY, "LcAccrualSequence", path, "", error);
		}
		return success("LcAccrualSequence", ValidationType.CARDINALITY, "LcAccrualSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LcAccrualSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LcAccrualSequence", ValidationType.CARDINALITY, "LcAccrualSequence", path, "", res.getError());
				}
				return success("LcAccrualSequence", ValidationType.CARDINALITY, "LcAccrualSequence", path, "");
			})
			.collect(toList());
	}

}
