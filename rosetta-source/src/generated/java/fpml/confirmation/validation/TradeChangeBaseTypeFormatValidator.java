package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeChangeBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeChangeBaseTypeFormatValidator implements Validator<TradeChangeBase> {

	private List<ComparisonResult> getComparisonResults(TradeChangeBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeChangeBase> validate(RosettaPath path, TradeChangeBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeChangeBase", ValidationType.TYPE_FORMAT, "TradeChangeBase", path, "", error);
		}
		return success("TradeChangeBase", ValidationType.TYPE_FORMAT, "TradeChangeBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeChangeBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeChangeBase", ValidationType.TYPE_FORMAT, "TradeChangeBase", path, "", res.getError());
				}
				return success("TradeChangeBase", ValidationType.TYPE_FORMAT, "TradeChangeBase", path, "");
			})
			.collect(toList());
	}

}
