package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementPeriods;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodsTypeFormatValidator implements Validator<SettlementPeriods> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriods o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SettlementPeriods> validate(RosettaPath path, SettlementPeriods o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPeriods", ValidationType.TYPE_FORMAT, "SettlementPeriods", path, "", error);
		}
		return success("SettlementPeriods", ValidationType.TYPE_FORMAT, "SettlementPeriods", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriods o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriods", ValidationType.TYPE_FORMAT, "SettlementPeriods", path, "", res.getError());
				}
				return success("SettlementPeriods", ValidationType.TYPE_FORMAT, "SettlementPeriods", path, "");
			})
			.collect(toList());
	}

}
