package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeNovationContent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeNovationContentTypeFormatValidator implements Validator<TradeNovationContent> {

	private List<ComparisonResult> getComparisonResults(TradeNovationContent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeNovationContent> validate(RosettaPath path, TradeNovationContent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeNovationContent", ValidationType.TYPE_FORMAT, "TradeNovationContent", path, "", error);
		}
		return success("TradeNovationContent", ValidationType.TYPE_FORMAT, "TradeNovationContent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNovationContent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeNovationContent", ValidationType.TYPE_FORMAT, "TradeNovationContent", path, "", res.getError());
				}
				return success("TradeNovationContent", ValidationType.TYPE_FORMAT, "TradeNovationContent", path, "");
			})
			.collect(toList());
	}

}
