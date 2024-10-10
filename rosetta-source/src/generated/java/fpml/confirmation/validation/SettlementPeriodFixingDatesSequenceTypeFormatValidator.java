package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementPeriodFixingDatesSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodFixingDatesSequenceTypeFormatValidator implements Validator<SettlementPeriodFixingDatesSequence> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriodFixingDatesSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SettlementPeriodFixingDatesSequence> validate(RosettaPath path, SettlementPeriodFixingDatesSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPeriodFixingDatesSequence", ValidationType.TYPE_FORMAT, "SettlementPeriodFixingDatesSequence", path, "", error);
		}
		return success("SettlementPeriodFixingDatesSequence", ValidationType.TYPE_FORMAT, "SettlementPeriodFixingDatesSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodFixingDatesSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriodFixingDatesSequence", ValidationType.TYPE_FORMAT, "SettlementPeriodFixingDatesSequence", path, "", res.getError());
				}
				return success("SettlementPeriodFixingDatesSequence", ValidationType.TYPE_FORMAT, "SettlementPeriodFixingDatesSequence", path, "");
			})
			.collect(toList());
	}

}
