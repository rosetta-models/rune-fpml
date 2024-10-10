package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementPriceSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPriceSourceValidator implements Validator<SettlementPriceSource> {

	private List<ComparisonResult> getComparisonResults(SettlementPriceSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementPriceSourceScheme", (String) o.getSettlementPriceSourceScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SettlementPriceSource> validate(RosettaPath path, SettlementPriceSource o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPriceSource", ValidationType.CARDINALITY, "SettlementPriceSource", path, "", error);
		}
		return success("SettlementPriceSource", ValidationType.CARDINALITY, "SettlementPriceSource", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPriceSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPriceSource", ValidationType.CARDINALITY, "SettlementPriceSource", path, "", res.getError());
				}
				return success("SettlementPriceSource", ValidationType.CARDINALITY, "SettlementPriceSource", path, "");
			})
			.collect(toList());
	}

}
