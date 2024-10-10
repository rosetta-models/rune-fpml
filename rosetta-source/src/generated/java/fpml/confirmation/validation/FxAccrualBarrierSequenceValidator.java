package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualBarrierSequence;
import fpml.confirmation.QuotedCurrencyPair;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualBarrierSequenceValidator implements Validator<FxAccrualBarrierSequence> {

	private List<ComparisonResult> getComparisonResults(FxAccrualBarrierSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualBarrierSequence> validate(RosettaPath path, FxAccrualBarrierSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualBarrierSequence", ValidationType.CARDINALITY, "FxAccrualBarrierSequence", path, "", error);
		}
		return success("FxAccrualBarrierSequence", ValidationType.CARDINALITY, "FxAccrualBarrierSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualBarrierSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualBarrierSequence", ValidationType.CARDINALITY, "FxAccrualBarrierSequence", path, "", res.getError());
				}
				return success("FxAccrualBarrierSequence", ValidationType.CARDINALITY, "FxAccrualBarrierSequence", path, "");
			})
			.collect(toList());
	}

}
