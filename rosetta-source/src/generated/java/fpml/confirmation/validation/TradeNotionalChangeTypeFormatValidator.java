package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeNotionalChange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeNotionalChangeTypeFormatValidator implements Validator<TradeNotionalChange> {

	private List<ComparisonResult> getComparisonResults(TradeNotionalChange o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeNotionalChange> validate(RosettaPath path, TradeNotionalChange o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeNotionalChange", ValidationType.TYPE_FORMAT, "TradeNotionalChange", path, "", error);
		}
		return success("TradeNotionalChange", ValidationType.TYPE_FORMAT, "TradeNotionalChange", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNotionalChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeNotionalChange", ValidationType.TYPE_FORMAT, "TradeNotionalChange", path, "", res.getError());
				}
				return success("TradeNotionalChange", ValidationType.TYPE_FORMAT, "TradeNotionalChange", path, "");
			})
			.collect(toList());
	}

}
