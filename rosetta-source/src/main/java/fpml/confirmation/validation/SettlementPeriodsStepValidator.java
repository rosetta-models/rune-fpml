package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementPeriodsReference;
import fpml.confirmation.SettlementPeriodsStep;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodsStepValidator implements Validator<SettlementPeriodsStep> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriodsStep o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementPeriodsReference", (List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference() == null ? 0 : ((List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<SettlementPeriodsStep> validate(RosettaPath path, SettlementPeriodsStep o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPeriodsStep", ValidationType.CARDINALITY, "SettlementPeriodsStep", path, "", error);
		}
		return success("SettlementPeriodsStep", ValidationType.CARDINALITY, "SettlementPeriodsStep", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodsStep o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriodsStep", ValidationType.CARDINALITY, "SettlementPeriodsStep", path, "", res.getError());
				}
				return success("SettlementPeriodsStep", ValidationType.CARDINALITY, "SettlementPeriodsStep", path, "");
			})
			.collect(toList());
	}

}
