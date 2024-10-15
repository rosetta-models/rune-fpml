package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CompressionActivitySequence1;
import fpml.confirmation.TradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompressionActivitySequence1Validator implements Validator<CompressionActivitySequence1> {

	private List<ComparisonResult> getComparisonResults(CompressionActivitySequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("replacementTradeId", (TradeId) o.getReplacementTradeId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CompressionActivitySequence1> validate(RosettaPath path, CompressionActivitySequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CompressionActivitySequence1", ValidationType.CARDINALITY, "CompressionActivitySequence1", path, "", error);
		}
		return success("CompressionActivitySequence1", ValidationType.CARDINALITY, "CompressionActivitySequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CompressionActivitySequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CompressionActivitySequence1", ValidationType.CARDINALITY, "CompressionActivitySequence1", path, "", res.getError());
				}
				return success("CompressionActivitySequence1", ValidationType.CARDINALITY, "CompressionActivitySequence1", path, "");
			})
			.collect(toList());
	}

}
