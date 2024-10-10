package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeIdentifierExtended;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeIdentifierExtendedTypeFormatValidator implements Validator<TradeIdentifierExtended> {

	private List<ComparisonResult> getComparisonResults(TradeIdentifierExtended o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeIdentifierExtended> validate(RosettaPath path, TradeIdentifierExtended o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeIdentifierExtended", ValidationType.TYPE_FORMAT, "TradeIdentifierExtended", path, "", error);
		}
		return success("TradeIdentifierExtended", ValidationType.TYPE_FORMAT, "TradeIdentifierExtended", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeIdentifierExtended o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeIdentifierExtended", ValidationType.TYPE_FORMAT, "TradeIdentifierExtended", path, "", res.getError());
				}
				return success("TradeIdentifierExtended", ValidationType.TYPE_FORMAT, "TradeIdentifierExtended", path, "");
			})
			.collect(toList());
	}

}
