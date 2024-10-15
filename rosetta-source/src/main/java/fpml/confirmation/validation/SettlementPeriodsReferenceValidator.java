package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementPeriodsReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodsReferenceValidator implements Validator<SettlementPeriodsReference> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriodsReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<SettlementPeriodsReference> validate(RosettaPath path, SettlementPeriodsReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPeriodsReference", ValidationType.CARDINALITY, "SettlementPeriodsReference", path, "", error);
		}
		return success("SettlementPeriodsReference", ValidationType.CARDINALITY, "SettlementPeriodsReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodsReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriodsReference", ValidationType.CARDINALITY, "SettlementPeriodsReference", path, "", res.getError());
				}
				return success("SettlementPeriodsReference", ValidationType.CARDINALITY, "SettlementPeriodsReference", path, "");
			})
			.collect(toList());
	}

}
