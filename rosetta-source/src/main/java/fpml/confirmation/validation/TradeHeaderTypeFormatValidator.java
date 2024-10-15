package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeHeader;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeHeaderTypeFormatValidator implements Validator<TradeHeader> {

	private List<ComparisonResult> getComparisonResults(TradeHeader o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeHeader> validate(RosettaPath path, TradeHeader o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeHeader", ValidationType.TYPE_FORMAT, "TradeHeader", path, "", error);
		}
		return success("TradeHeader", ValidationType.TYPE_FORMAT, "TradeHeader", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeHeader", ValidationType.TYPE_FORMAT, "TradeHeader", path, "", res.getError());
				}
				return success("TradeHeader", ValidationType.TYPE_FORMAT, "TradeHeader", path, "");
			})
			.collect(toList());
	}

}
