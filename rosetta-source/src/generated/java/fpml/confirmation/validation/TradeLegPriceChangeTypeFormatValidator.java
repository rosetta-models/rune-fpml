package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeLegPriceChange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeLegPriceChangeTypeFormatValidator implements Validator<TradeLegPriceChange> {

	private List<ComparisonResult> getComparisonResults(TradeLegPriceChange o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeLegPriceChange> validate(RosettaPath path, TradeLegPriceChange o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeLegPriceChange", ValidationType.TYPE_FORMAT, "TradeLegPriceChange", path, "", error);
		}
		return success("TradeLegPriceChange", ValidationType.TYPE_FORMAT, "TradeLegPriceChange", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeLegPriceChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeLegPriceChange", ValidationType.TYPE_FORMAT, "TradeLegPriceChange", path, "", res.getError());
				}
				return success("TradeLegPriceChange", ValidationType.TYPE_FORMAT, "TradeLegPriceChange", path, "");
			})
			.collect(toList());
	}

}
