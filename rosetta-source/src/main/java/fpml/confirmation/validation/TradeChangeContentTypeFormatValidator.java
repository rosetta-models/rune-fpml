package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeChangeContent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeChangeContentTypeFormatValidator implements Validator<TradeChangeContent> {

	private List<ComparisonResult> getComparisonResults(TradeChangeContent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeChangeContent> validate(RosettaPath path, TradeChangeContent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeChangeContent", ValidationType.TYPE_FORMAT, "TradeChangeContent", path, "", error);
		}
		return success("TradeChangeContent", ValidationType.TYPE_FORMAT, "TradeChangeContent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeChangeContent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeChangeContent", ValidationType.TYPE_FORMAT, "TradeChangeContent", path, "", res.getError());
				}
				return success("TradeChangeContent", ValidationType.TYPE_FORMAT, "TradeChangeContent", path, "");
			})
			.collect(toList());
	}

}
