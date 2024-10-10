package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeWrapper;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeWrapperTypeFormatValidator implements Validator<TradeWrapper> {

	private List<ComparisonResult> getComparisonResults(TradeWrapper o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeWrapper> validate(RosettaPath path, TradeWrapper o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeWrapper", ValidationType.TYPE_FORMAT, "TradeWrapper", path, "", error);
		}
		return success("TradeWrapper", ValidationType.TYPE_FORMAT, "TradeWrapper", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeWrapper o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeWrapper", ValidationType.TYPE_FORMAT, "TradeWrapper", path, "", res.getError());
				}
				return success("TradeWrapper", ValidationType.TYPE_FORMAT, "TradeWrapper", path, "");
			})
			.collect(toList());
	}

}
