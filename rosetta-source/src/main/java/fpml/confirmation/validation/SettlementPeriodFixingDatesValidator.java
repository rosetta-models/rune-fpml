package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementPeriodFixingDates;
import fpml.confirmation.SettlementPeriodFixingDatesSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodFixingDatesValidator implements Validator<SettlementPeriodFixingDates> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriodFixingDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementPeriodFixingDatesSequence", (SettlementPeriodFixingDatesSequence) o.getSettlementPeriodFixingDatesSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfFixings", (Integer) o.getNumberOfFixings() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SettlementPeriodFixingDates> validate(RosettaPath path, SettlementPeriodFixingDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPeriodFixingDates", ValidationType.CARDINALITY, "SettlementPeriodFixingDates", path, "", error);
		}
		return success("SettlementPeriodFixingDates", ValidationType.CARDINALITY, "SettlementPeriodFixingDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodFixingDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriodFixingDates", ValidationType.CARDINALITY, "SettlementPeriodFixingDates", path, "", res.getError());
				}
				return success("SettlementPeriodFixingDates", ValidationType.CARDINALITY, "SettlementPeriodFixingDates", path, "");
			})
			.collect(toList());
	}

}
