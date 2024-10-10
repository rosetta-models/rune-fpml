package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementMethodValidator implements Validator<SettlementMethod> {

	private List<ComparisonResult> getComparisonResults(SettlementMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementMethodScheme", (String) o.getSettlementMethodScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SettlementMethod> validate(RosettaPath path, SettlementMethod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementMethod", ValidationType.CARDINALITY, "SettlementMethod", path, "", error);
		}
		return success("SettlementMethod", ValidationType.CARDINALITY, "SettlementMethod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementMethod", ValidationType.CARDINALITY, "SettlementMethod", path, "", res.getError());
				}
				return success("SettlementMethod", ValidationType.CARDINALITY, "SettlementMethod", path, "");
			})
			.collect(toList());
	}

}
