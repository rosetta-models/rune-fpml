package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeProcessingTimestamps;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeProcessingTimestampsTypeFormatValidator implements Validator<TradeProcessingTimestamps> {

	private List<ComparisonResult> getComparisonResults(TradeProcessingTimestamps o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeProcessingTimestamps> validate(RosettaPath path, TradeProcessingTimestamps o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeProcessingTimestamps", ValidationType.TYPE_FORMAT, "TradeProcessingTimestamps", path, "", error);
		}
		return success("TradeProcessingTimestamps", ValidationType.TYPE_FORMAT, "TradeProcessingTimestamps", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeProcessingTimestamps o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeProcessingTimestamps", ValidationType.TYPE_FORMAT, "TradeProcessingTimestamps", path, "", res.getError());
				}
				return success("TradeProcessingTimestamps", ValidationType.TYPE_FORMAT, "TradeProcessingTimestamps", path, "");
			})
			.collect(toList());
	}

}
