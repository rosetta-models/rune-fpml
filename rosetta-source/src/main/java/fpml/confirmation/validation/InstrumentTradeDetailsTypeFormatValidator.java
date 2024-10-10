package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InstrumentTradeDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InstrumentTradeDetailsTypeFormatValidator implements Validator<InstrumentTradeDetails> {

	private List<ComparisonResult> getComparisonResults(InstrumentTradeDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InstrumentTradeDetails> validate(RosettaPath path, InstrumentTradeDetails o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InstrumentTradeDetails", ValidationType.TYPE_FORMAT, "InstrumentTradeDetails", path, "", error);
		}
		return success("InstrumentTradeDetails", ValidationType.TYPE_FORMAT, "InstrumentTradeDetails", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentTradeDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentTradeDetails", ValidationType.TYPE_FORMAT, "InstrumentTradeDetails", path, "", res.getError());
				}
				return success("InstrumentTradeDetails", ValidationType.TYPE_FORMAT, "InstrumentTradeDetails", path, "");
			})
			.collect(toList());
	}

}
