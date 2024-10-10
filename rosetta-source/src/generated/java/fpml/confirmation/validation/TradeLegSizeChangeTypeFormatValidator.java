package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeLegSizeChange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeLegSizeChangeTypeFormatValidator implements Validator<TradeLegSizeChange> {

	private List<ComparisonResult> getComparisonResults(TradeLegSizeChange o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeLegSizeChange> validate(RosettaPath path, TradeLegSizeChange o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeLegSizeChange", ValidationType.TYPE_FORMAT, "TradeLegSizeChange", path, "", error);
		}
		return success("TradeLegSizeChange", ValidationType.TYPE_FORMAT, "TradeLegSizeChange", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeLegSizeChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeLegSizeChange", ValidationType.TYPE_FORMAT, "TradeLegSizeChange", path, "", res.getError());
				}
				return success("TradeLegSizeChange", ValidationType.TYPE_FORMAT, "TradeLegSizeChange", path, "");
			})
			.collect(toList());
	}

}
